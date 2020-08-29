package com.phone.biz;

import java.util.List;
import java.util.Map;

import com.phone.entity.Vivoinfo;

public interface IVivoGoodsBiz {
	
	public List<Vivoinfo> findAll(int page,int rows);
	
	public int add(String pname,String tname,double price,String pics,String pintro,int inventory,String capacity,String color);
	
	public List<Vivoinfo> findByCondition(String tno, String pname, int page, int rows);
	
	public int total();

	public Map<String,Object>findIndex();
	
	public Vivoinfo findByPno(String pno);
}
