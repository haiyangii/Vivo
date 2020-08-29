package com.phone.dao.impl;

import com.phone.dao.DBHelper;
import com.phone.dao.IUserInfoDao;
import com.phone.entity.UserInfo;

public class UserInfoDaoImpl implements IUserInfoDao{

	@Override
	public int add(UserInfo userInfo) {
		DBHelper db=new DBHelper();
		String sql="insert into userinfo values(0,?,md5(?),?)";
		return db.update(sql,userInfo.getUname(),userInfo.getPwd(),userInfo.getMail());
	}

	@Override
	public UserInfo login(String account, String pwd) {
		DBHelper db=new DBHelper();
		String sql="select uid,uname,pwd,mail from userinfo where (uname=? or mail=?) and pwd=md5(?)";
		return db.find(UserInfo.class, sql, account,account,pwd);
	}

}
