package com.phone.dao.impl;

import java.util.ArrayList;

import java.util.List;
import com.phone.dao.DBHelper;
import com.phone.dao.IVivoGoodsDao;
import com.phone.entity.VivoType;
import com.phone.entity.Vivoinfo;
import com.phone.util.StringUtil;



public class VivoGoodsDaoImpl implements IVivoGoodsDao{

	@Override
	public List<Vivoinfo> findAll(int page,int rows) {//分页查询
		DBHelper db = new DBHelper();
		String sql ="select pno,pname,t.tname,price,pics,pintro,inventory,capacity,color from phoneinfo p,phonetype t "
				+ "where p.tno = t.tno order by pno desc limit ?,?";
		return db.finds(Vivoinfo.class, sql,(page-1)*rows,rows);
	}
	
	public int add(String pname,String tname,double price,String pics,String pintro,int inventory,String capacity,String color) {
		DBHelper db = new DBHelper();
		String sql="insert into phoneinfo values(0,?,?,?,?,?,?,?,?,1)";
		return db.update(sql, pname,tname,price,pics,pintro,inventory,capacity,color);
	}

	@Override
	public List<Vivoinfo> findByCondition(String tno, String pname, int page, int rows) {
		
		DBHelper db = new DBHelper();
		String sql ="select pno,pname,p.tno,pname,price,pics,pintro,inventory,capacity,color,gnum from phoneinfo p,phonetype t "
				+ "where p.tno=t.tno";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(tno)) {
			sql +=" and p.tno = ?";
			params.add(tno);
		}
		if(!StringUtil.checkNull(pname)) {
			sql +=" and pname like concat('%',?,'%')";
			
			params.add(pname);
		}
		sql +=" order by pno desc limit ?, ?";
		params.add((page-1) * rows);
		params.add(rows);
		
		return db.finds(Vivoinfo.class,sql,params);
	}

	@Override
	public int total() {
		DBHelper db = new DBHelper();
		String sql ="select count(pno) from phoneinfo";
		return db.total(sql);
	}

	@Override
	public List<Vivoinfo> findIndex() {
		DBHelper db = new DBHelper();
		String sql ="select pno,pname,price,tno,pics from phoneinfo p1 where 4>(select count(pno) from "
				+"phoneinfo p2 where p1.tno=p2.tno and p1.pno< p2.pno) order by p1.tno asc,p1.pno desc";
		
		return db.finds(Vivoinfo.class,sql);
		
	}

	@Override
	public Vivoinfo findByPno(String pno) {
		DBHelper db = new DBHelper();
		String sql="select pno,pname,tno,price,pics,pintro,inventory,capacity,color,gnum from phoneinfo where pno=?";
		return db.find(Vivoinfo.class, sql, pno);
	}
}
