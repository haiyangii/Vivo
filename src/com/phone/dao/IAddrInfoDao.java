package com.phone.dao;

import java.util.List;

import com.phone.entity.AddrInfo;

public interface IAddrInfoDao {
     
	public List<AddrInfo> finds(String uid);
	
	public int add(AddrInfo addrInfo);
}
