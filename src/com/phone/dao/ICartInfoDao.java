package com.phone.dao;

import java.util.List;
import java.util.Map;

import com.phone.entity.CartInfo;

public interface ICartInfoDao {
	/**
	 * 添加购物车
	 * @param cartInfo
	 * @return
	 */
	public int add(CartInfo cartInfo);
	/**
	 * 只查购物车和商品编号
	 * @param pno
	 * @return
	 */
	public List<Map<String, Object>> findCart(String pno);
	/**
	 * 根据用户编号查询购物车信息
	 * @param pno
	 * @return
	 */
	public List<CartInfo> finds(String pno); 
	/**
	 * 修改数量
	 * @param cno
	 * @param num
	 * @return
	 */
	public int updateNum(String cno, int num);
	/**
	 * 通过多个购物车编号查到多个商品
	 * @param cnos
	 * @return
	 */
	public List<CartInfo> findByCnos(String[] cnos);
}
