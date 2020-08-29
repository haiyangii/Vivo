package com.phone.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.biz.IAddrInfoBiz;
import com.phone.biz.ICartInfoBiz;
import com.phone.biz.impl.AddrInfoBizImpl;
import com.phone.biz.impl.CartInfoBizImpl;
import com.phone.entity.AddrInfo;
import com.phone.entity.CartInfo;
import com.phone.entity.UserInfo;
import com.phone.util.RequestParamUtil;

@WebServlet("/addr")
public class AddrController extends BasicServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op.equals("finds")) {
			finds(request,response);
		}else if(op.equals("add")) {
			add(request,response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			this.send(response, 400,"",null);
			return;
		}
		//查数据库
		UserInfo uf = (UserInfo) obj;
		IAddrInfoBiz addrInfoBiz = new AddrInfoBizImpl();
		
		String ano = UUID.randomUUID().toString().replace("-", "");
		AddrInfo addrInfo = RequestParamUtil.getParams(AddrInfo.class, request);
		addrInfo.setUid(uf.getUid());
		addrInfo.setAno(ano);
		
		int result = addrInfoBiz.add(addrInfo);
		if(result>0) {
			this.send(response, 200, ano, null);
		}else {
			this.send(response, 500,"",null);
		}
		
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			this.send(response, 400,"",null);
			return;
		}
		
		//查数据库
		
		UserInfo uf = (UserInfo) obj;
		
		IAddrInfoBiz addrInfoBiz = new AddrInfoBizImpl();
		List<AddrInfo> addrs = addrInfoBiz.finds(String.valueOf(uf.getUid()));
		if(addrs !=null && !addrs.isEmpty()) {
			this.send(response, 200,null,addrs);
		}else {
			this.send(response, 500,null,null);
		}
	}

}
