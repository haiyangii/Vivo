package com.phone.biz.impl;

import com.phone.biz.IAdminInfoBiz;
import com.phone.dao.IAdminInfoDao;
import com.phone.dao.impl.AdminInfoDaoImpl;
import com.phone.entity.AdminInfo;
import com.phone.util.StringUtil;

public class AdminInfoBizImpl implements IAdminInfoBiz{

	@Override
	public AdminInfo login(String account, String pwd) {
		if(StringUtil.checkNull(account,pwd)){
			return null;
		}
		
		IAdminInfoDao adminInfoDao =new AdminInfoDaoImpl();
		return adminInfoDao.login(account, pwd);
	}

}
