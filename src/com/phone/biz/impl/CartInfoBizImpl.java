package com.phone.biz.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.phone.biz.ICartInfoBiz;
import com.phone.dao.ICartInfoDao;
import com.phone.dao.impl.CartInfoDaoImpl;
import com.phone.entity.CartInfo;
import com.phone.util.StringUtil;

public class CartInfoBizImpl implements ICartInfoBiz{

	@Override
	public int add(CartInfo ct) {
		if(StringUtil.checkNull(ct.getCno())) {
			return -1;
		};
		
		ICartInfoDao cartInfo = new CartInfoDaoImpl();
		
		return cartInfo.add(ct);
	}

	@Override
	public List<Map<String, Object>> findCart(String pno) {
		ICartInfoDao cartInfo = new CartInfoDaoImpl();
		return cartInfo.findCart(pno);
	}

	@Override
	public List<CartInfo> finds(String uid) {
		if(StringUtil.checkNull(uid)) {
			return null;
		}
		
		ICartInfoDao cartInfo = new CartInfoDaoImpl(); 
		return cartInfo.finds(uid);
	}

	@Override
	public int updateNum(String cno, int num) {
		if(StringUtil.checkNull(cno)) {
			return -1;
		}
		ICartInfoDao cartInfoDao = new CartInfoDaoImpl();
		return cartInfoDao.updateNum(cno,num);
	}

	@Override
	public List<CartInfo> findByCnos(String cnos) {
		if(StringUtil.checkNull(cnos)) {
			return Collections.emptyList();
		}
		
		ICartInfoDao cartInfoDao = new CartInfoDaoImpl();
		String[] temp = cnos.split(",");
		return cartInfoDao.findByCnos(temp);
	}

}
