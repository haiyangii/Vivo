package com.phone.biz.impl;

import java.util.Collections;
import java.util.List;

import com.phone.biz.IAddrInfoBiz;
import com.phone.dao.IAddrInfoDao;
import com.phone.dao.impl.AddrInfoDaoImpl;
import com.phone.entity.AddrInfo;
import com.phone.util.StringUtil;

public class AddrInfoBizImpl implements IAddrInfoBiz{

	@Override
	public List<AddrInfo> finds(String uid) {
		if(StringUtil.checkNull(uid)) {
			return Collections.emptyList();
		}
		IAddrInfoDao addrInfoDao = new AddrInfoDaoImpl();
		return addrInfoDao.finds(uid);
	}

	@Override
	public int add(AddrInfo addrInfo) {
		if(StringUtil.checkNull(addrInfo.getAno(),addrInfo.getAname(),addrInfo.getTel(),
				addrInfo.getProvince(),addrInfo.getCity(),addrInfo.getArea(),addrInfo.getAddr())) {
			return -1;
		}
		IAddrInfoDao addrInfoDao = new AddrInfoDaoImpl();
		return addrInfoDao.add(addrInfo);
	}
	
	

}
