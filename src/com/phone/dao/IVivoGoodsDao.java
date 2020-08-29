package com.phone.dao;

import java.util.List;
import com.phone.entity.Vivoinfo;



public interface IVivoGoodsDao {

	public List<Vivoinfo> findAll(int page,int rows);
	
	public int add(String pname,String tname,double price,String pics,String pintro,int inventory,String capacity,String color);
	
	public List<Vivoinfo> findByCondition(String tno, String pname, int page, int rows);
	
	public int total();
	
	public List<Vivoinfo> findIndex();
	
	public Vivoinfo findByPno(String pno);
}
