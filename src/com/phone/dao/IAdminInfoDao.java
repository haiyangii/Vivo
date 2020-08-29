package com.phone.dao;

import com.phone.entity.AdminInfo;

public interface IAdminInfoDao {
	public AdminInfo login(String account,String pwd);

}
