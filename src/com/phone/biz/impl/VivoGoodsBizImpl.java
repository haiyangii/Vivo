package com.phone.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.phone.biz.IVivoGoodsBiz;
import com.phone.dao.IVivoGoodsDao;
import com.phone.dao.IVivoTypeDao;
import com.phone.dao.impl.VivoGoodsDaoImpl;
import com.phone.dao.impl.VivoTypeDaoImpl;
import com.phone.entity.Vivoinfo;
import com.phone.util.StringUtil;

public class VivoGoodsBizImpl implements IVivoGoodsBiz{

	@Override
	public List<Vivoinfo> findAll(int page,int rows) {
		IVivoGoodsDao vivoGoodsDao = new VivoGoodsDaoImpl();
		return vivoGoodsDao.findAll(page,rows);
	}

	@Override
	public int add(String pname,String tname,double price,String pics,String pintro,int inventory,String capacity,String color) {
		if(StringUtil.checkNull( pname, tname, pics, pintro, capacity, color)) {
			return -1;
		}
		IVivoGoodsDao vivoGoods = new VivoGoodsDaoImpl();
		return vivoGoods.add(pname, tname,price, pics, pintro, inventory,capacity, color);
	}

	@Override
	public List<Vivoinfo> findByCondition(String tno, String pname, int page, int rows) {
		
		IVivoGoodsDao vivoGoodsDao = new VivoGoodsDaoImpl();
		return vivoGoodsDao.findByCondition(tno, pname, page, rows);
	}

	@Override
	public int total() {
		IVivoGoodsDao vivoGoodsDao = new VivoGoodsDaoImpl();
		return vivoGoodsDao.total();
	}
	
	@Override
	public Map<String,Object> findIndex() {
		Map<String,Object> map = new HashMap<String,Object>();
		IVivoTypeDao typeDao = new VivoTypeDaoImpl();
		IVivoGoodsDao vivoGoodsDao = new VivoGoodsDaoImpl();
		map.put("types", typeDao.findAll());
		map.put("phones", vivoGoodsDao.findIndex());
		return map;
	}

	@Override
	public Vivoinfo findByPno(String pno) {
		
		IVivoGoodsDao vivoGoods = new VivoGoodsDaoImpl();
		return vivoGoods.findByPno(pno);
	}
}
