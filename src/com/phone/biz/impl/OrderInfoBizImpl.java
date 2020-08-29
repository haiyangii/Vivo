package com.phone.biz.impl;

import java.util.List;
import java.util.Map;

import com.phone.biz.IOrderInfoBiz;
import com.phone.dao.IOrderInfoDao;
import com.phone.dao.impl.OrderInfoDaoImpl;
import com.phone.entity.OrderInfo;
import com.phone.util.StringUtil;

public class OrderInfoBizImpl implements IOrderInfoBiz{

	@Override
	public int add(String ono,String cnos, double totalPrice, String ano) {
		
		if(StringUtil.checkNull(cnos,ano)) {
			return -1;
		}
		
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(ono,cnos, totalPrice,ano);
	}

	@Override
	public List<Map<String, String>> finds(Integer uid) {
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.finds(uid);
	}

	@Override
	public OrderInfo findByOno(String ono) {
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.findByOno(ono);
	}

	@Override
	public int update(String ono) {
		if(StringUtil.checkNull(ono)) {
			return -1;
		}
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl(); 
		return orderInfoDao.update(ono);
	}
	
	

}
