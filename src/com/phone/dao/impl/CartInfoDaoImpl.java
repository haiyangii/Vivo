package com.phone.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.phone.dao.DBHelper;
import com.phone.dao.ICartInfoDao;
import com.phone.entity.CartInfo;

public class CartInfoDaoImpl implements ICartInfoDao{

	@Override
	public int add(CartInfo ct) {
		DBHelper db = new DBHelper();
		String sql="insert into cartinfo values(?,?,?,?)";
		return db.update(sql, ct.getCno(),ct.getUid(),ct.getPno(),ct.getNum());
	}

	@Override
	public List<Map<String, Object>> findCart(String mno) {
		DBHelper db = new DBHelper();
		String sql = "select cno, pno from cartinfo where uid=?";
		return db.finds(sql, mno);
	}

	@Override
	public List<CartInfo> finds(String uid) {
		DBHelper db = new DBHelper();
		
		String sql = "select cno, c.pno, num, price, pics, pname from cartinfo c, phoneinfo p where c.pno=p.pno and uid=?";
		return db.finds(CartInfo.class, sql,uid);
	}

	@Override
	public int updateNum(String cno, int num) {
		DBHelper db = new DBHelper();
		String sql = "update cartinfo set num = num + ? where cno=?";
		return db.update(sql, num,cno);
	}

	@Override
	public List<CartInfo> findByCnos(String[] cnos) {
		DBHelper db = new DBHelper();
		String sql = "select cno, c.pno, num,price,pics, pname from cartinfo c, phoneinfo p where c.pno = p.pno and cno in(";
		List<Object> params = new ArrayList<Object>();
		for(String cno : cnos) {
			sql +="?,";
			params.add(cno);
		}
		sql = sql.substring(0,sql.lastIndexOf(",")) +")";
		//System.out.println(sql);
		return db.finds(CartInfo.class ,sql,params);
	}

}
