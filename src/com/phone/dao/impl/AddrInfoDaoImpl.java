package com.phone.dao.impl;

import java.util.List;

import com.phone.dao.DBHelper;
import com.phone.dao.IAddrInfoDao;
import com.phone.entity.AddrInfo;

public class AddrInfoDaoImpl implements IAddrInfoDao{

	@Override
	public List<AddrInfo> finds(String uid) {
		DBHelper db = new DBHelper();
		String sql="select ano,uid,aname,tel,province,city,area,addr,flag from addrinfo where uid=?";
		return db.finds(AddrInfo.class, sql, uid);
	}

	@Override
	public int add(AddrInfo addrInfo) {
		DBHelper db = new DBHelper();
		String sql="insert into addrinfo values(?,?,?,?,?,?,?,?,0)";
		return db.update(sql, addrInfo.getAno(),addrInfo.getUid(),addrInfo.getAname(),addrInfo.getTel(),addrInfo.getProvince(),addrInfo.getCity(),addrInfo.getArea(),addrInfo.getAddr());
	}

}
