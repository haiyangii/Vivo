package com.phone.biz.impl;

import java.util.List;

import com.phone.biz.IVivoTypeBiz;
import com.phone.dao.IVivoTypeDao;
import com.phone.dao.impl.VivoTypeDaoImpl;
import com.phone.entity.VivoType;
import com.phone.util.StringUtil;

public class VivoTypeBizImpl implements IVivoTypeBiz{

	@Override
	public List<VivoType> findAll() {
		IVivoTypeDao vivoTypeDao = new VivoTypeDaoImpl();
		return vivoTypeDao.findAll();
	}

	@Override
	public int add(VivoType type) {
		if(StringUtil.checkNull(type.getTname(),type.getPic())) {
			return -1;
		}
		IVivoTypeDao vivoTypeDao = new VivoTypeDaoImpl();
		return vivoTypeDao.add(type);
	}

	@Override
	public int update(VivoType type) {
		if(StringUtil.checkNull(type.getTname(),type.getPic())) {
			return -1;
		}
		IVivoTypeDao vivoTypeDao = new VivoTypeDaoImpl();
		return vivoTypeDao.update(type);
	}

	@Override
	public int delete(String tno) {
		if(StringUtil.checkNull(tno)){
			return -1;
		}
		IVivoTypeDao vivoTypeDao = new VivoTypeDaoImpl();
		return vivoTypeDao.delete(tno);
	}

	@Override
	public int add(String tname, String pics, int status) {
		if(StringUtil.checkNull(tname,pics)) {
			return -1;
		};
		IVivoTypeDao vivoTypeDao = new VivoTypeDaoImpl();
		return vivoTypeDao.add(tname, pics, status);
	}

}
