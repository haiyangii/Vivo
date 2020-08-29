package com.phone.biz;

import java.util.List;
import java.util.Map;

import com.phone.entity.OrderInfo;

public interface IOrderInfoBiz {
	
	public int add(String ono,String cnos,double totalPrice,String ano);
	
	/**
	 * 根据会员编号查询所有订单
	 * @param mno
	 * @return
	 */
	public List<Map<String,String>> finds(Integer uid);
	/**
	 * 通过订单编号查询一条订单
	 * @param ono
	 * @return
	 */
	public OrderInfo findByOno(String ono);
	
	public int update(String ono);

}
