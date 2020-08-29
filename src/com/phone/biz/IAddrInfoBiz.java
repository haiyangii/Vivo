package com.phone.biz;

import java.util.List;

import com.phone.entity.AddrInfo;

public interface IAddrInfoBiz {
	
	public List<AddrInfo> finds(String uid);
	
	public int add(AddrInfo addrInfo);

}
