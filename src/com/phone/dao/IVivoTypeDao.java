package com.phone.dao;

import java.util.List;
import com.phone.entity.VivoType;


public interface IVivoTypeDao {
	
	public List<VivoType> findAll();

	public int add(VivoType type);
	
	public int add(String tname,String pics,int status);
	
    public int update(VivoType type);
	
	public int delete(String tno);
}
