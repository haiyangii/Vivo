package com.phone.biz;

import com.phone.entity.UserInfo;

public interface IUserInfoBiz {
	
	public int add(UserInfo userInfo);

	public UserInfo login(String account, String pwd);
}
