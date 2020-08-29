package com.phone.dao;

import com.phone.entity.UserInfo;

public interface IUserInfoDao {

	public int add(UserInfo userInfo);
	
	public UserInfo login(String account,String pwd);
}
