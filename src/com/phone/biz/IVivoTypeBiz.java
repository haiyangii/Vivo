package com.phone.biz;

import java.util.List;

import com.phone.entity.VivoType;

public interface IVivoTypeBiz {

	public List<VivoType> findAll();
	
   public int add(VivoType type);
	
    public int update(VivoType type);
	
	public int delete(String tno);
	
	public int add(String tname, String pics, int status);
}
