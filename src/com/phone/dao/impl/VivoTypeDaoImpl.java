package com.phone.dao.impl;

import java.util.List;

import com.phone.dao.DBHelper;
import com.phone.dao.IVivoTypeDao;
import com.phone.entity.VivoType;

public class VivoTypeDaoImpl implements IVivoTypeDao{

	@Override
	public List<VivoType> findAll() {
		DBHelper db = new DBHelper();
		
		String sql = "select tno,tname,pic,status from phonetype";
		return db.finds(VivoType.class,sql);
	}

	@Override
	public int add(VivoType type) {
		DBHelper db = new DBHelper();
		String sql ="insert into phonetype values(0,?,?,?)";
		return db.update(sql, type.getTname(),type.getPic(),type.getStatus());
	}

	@Override
	public int update(VivoType type) {
		DBHelper db = new DBHelper();
		String sql="update phonetype set tname=?,pic=?,status=? where tno=?";
		return db.update(sql, type.getTname(),type.getPic(),type.getStatus(),type.getTno());
	}

	@Override
	public int delete(String tno) {
		DBHelper db = new DBHelper();
		String sql="delete from phonetype where tno=?";
		return db.update(sql,tno);
	}

	@Override
	public int add(String tname, String pics, int status) {
		DBHelper db = new DBHelper();
		String sql ="insert into phonetype values(0,?,?,?)";
		return db.update(sql, tname,pics,status);
	}

}
