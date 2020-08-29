package com.phone.biz.impl;

import com.phone.biz.IUserInfoBiz;
import com.phone.dao.IUserInfoDao;
import com.phone.dao.impl.UserInfoDaoImpl;
import com.phone.entity.UserInfo;

public class UserInfoBizImpl implements IUserInfoBiz{

	@Override
	public int add(UserInfo userInfo) {
		
		IUserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.add(userInfo);
	}

	@Override
	public UserInfo login(String account, String pwd) {
		
		IUserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.login(account, pwd);
	}
      
}
