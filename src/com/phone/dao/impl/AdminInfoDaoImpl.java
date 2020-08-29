package com.phone.dao.impl;

import com.phone.dao.DBHelper;
import com.phone.dao.IAdminInfoDao;
import com.phone.entity.AdminInfo;

public class AdminInfoDaoImpl implements IAdminInfoDao{

	@Override
	public AdminInfo login(String account, String pwd) {
		DBHelper db=new DBHelper();
		String sql="select aid,aname,pwd,tel,status from admininfo where (aname =? or tel=?) and pwd=md5(?)";
		return db.find(AdminInfo.class,sql, account,account,pwd);
	}

}
