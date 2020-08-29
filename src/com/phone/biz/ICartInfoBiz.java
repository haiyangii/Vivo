package com.phone.biz;

import java.util.List;
import java.util.Map;

import com.phone.entity.CartInfo;

public interface ICartInfoBiz {
	
	public int add(CartInfo cartInfo);

	public List<Map<String, Object>> findCart(String mno);
	
	public List<CartInfo> finds(String pno);
	
	public int updateNum(String cno, int num);
	
	public List<CartInfo> findByCnos(String cnos);
}
