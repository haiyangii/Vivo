package com.phone.dao;

import java.util.List;
import java.util.Map;

import com.phone.entity.OrderInfo;

public interface IOrderInfoDao {
	
		public int add(String ono,String cnos,double totalPrice,String ano);
			
			/**
			 * 根据会员编号查询所有订单
			 * @param mno
			 * @return
			 */
		public List<Map<String,String>> finds(Integer mno);
		
		public OrderInfo findByOno(String ono);
		
		public int update(String ono);

}
