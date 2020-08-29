package com.phone.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.phone.dao.DBHelper;
import com.phone.dao.IOrderInfoDao;
import com.phone.entity.OrderInfo;

public class OrderInfoDaoImpl implements IOrderInfoDao{

	@Override
	public int add(String ono,String cnos, double totalPrice, String ano) {
		// 添加一条数据到订单表中(订单编号、总价)
		String sql1="insert into orderinfo values(?,now(),?,null,null,0,?,0)";
		List<Object> param1 = new ArrayList<Object>();
		param1.add(ono);
		param1.add(ano);
		param1.add(totalPrice);
		
		//添加多条记录到订单详细表 ono gno nums price
		String sql2 = "insert into orderiteminfo select 0, ?, c.pno, c.num, price, 1 from cartinfo c, phoneinfo p where c.pno=p.pno and cno in(";
		List<Object> param2 = new ArrayList<Object>();
		param2.add(ono);
		String[] temp = cnos.split(",");
		for(String cno : temp) {
			sql2 +="?,";
			param2.add(cno);
		}
		sql2 = sql2.substring(0, sql2.lastIndexOf(",")) + ")";
		
		List<String> sqls = new ArrayList<String>();
		List<List<Object>> params = new ArrayList<List<Object>>();
		sqls.add(sql1);
		params.add(param1);
		
		sqls.add(sql2);
		params.add(param2);
		
		//修改商品的库存 gno nums
		String sql3 = null;
		List<Object> param = null;
		for(String cno : temp) {
			param = new ArrayList<Object>();
			sql3 ="update phoneinfo set inventory = inventory - (select num from cartinfo where cno=?) where pno = (select pno from cartinfo where cno=?)";
			param.add(cno);
			param.add(cno);
			
			sqls.add(sql3);
			params.add(param);
		}
		
		//删除购物车表cno
		String sql4 = "delete from cartinfo where cno in(";
		List<Object> param4 = new ArrayList<Object>();
		for(String cno : temp) {
			sql4 +="?,";
			param4.add(cno);
		}
		sql4 = sql4.substring(0,sql4.lastIndexOf(",")) + ")";
		sqls.add(sql4);
		params.add(param4);
		
		DBHelper db = new DBHelper();
		return db.updates(sqls, params);
	}

	@Override
	public List<Map<String, String>> finds(Integer uid) {
		DBHelper db = new DBHelper();
		String sql = "select o.ono, date_format(odate,'%Y-%m-%d %H:%i:%s') odate,o.totalprice, o.status, i.pno, nums, i.price, pname, pics"
				+ " from orderinfo o,orderiteminfo i,addrinfo a, phoneinfo p where o.ono=i.ono and i.pno=p.pno and a.ano=o.ano and a.uid=? order by odate desc";
		return db.gets(sql, uid);
	}

	@Override
	public OrderInfo findByOno(String ono) {
		DBHelper db = new DBHelper();
		String sql="select ono,totalPrice from orderinfo where ono=?";
		return db.find(OrderInfo.class, sql, ono);
	}

	@Override
	public int update(String ono) {
		DBHelper db = new DBHelper();
		String sql="update orderinfo set status=1 where ono=?";
		return db.update(sql, ono);
	}
	


}
