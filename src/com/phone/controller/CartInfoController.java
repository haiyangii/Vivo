package com.phone.controller;

import java.io.IOException;


import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.phone.biz.ICartInfoBiz;
import com.phone.biz.impl.CartInfoBizImpl;
import com.phone.entity.CartInfo;
import com.phone.entity.UserInfo;
import com.phone.util.RequestParamUtil;



@WebServlet("/cart")
public class CartInfoController extends BasicServlet{

	private static final long serialVersionUID = 1378031644186299885L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("add")) {
			add(request,response);
		}else if(op.equals("info")) {
			info(request,response);
		}else if(op.equals("find")) {
			find(request,response);
		}else if(op.equals("update")) {
			update(request,response);
		}else if(op.equals("findByCnos")) {
			findByCnos(request,response);
		}
	}

	private void findByCnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		ICartInfoBiz cartInfoBiz= new CartInfoBizImpl();
		this.send(response, 200,"",cartInfoBiz.findByCnos(cnos));
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		int num = Integer.parseInt(request.getParameter("num"));
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		int result = cartInfoBiz.updateNum(cno, num);
		if(result > 0) {
			this.send(response,200,"",null);
		}else {
			this.send(response, 500,"",null);
		}
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			this.send(response, 500,"",null);
			return;
		}
		
		//查数据库
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		UserInfo uf = (UserInfo) obj;
		this.send(response, 200,"",cartInfoBiz.finds(String.valueOf(uf.getUid())));
		
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			this.send(response, 500,"",null);
			return;
		}
		
		//查数据库
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		UserInfo uf = (UserInfo) obj;
		this.send(response, 200,"",cartInfoBiz.findCart(String.valueOf(uf.getUid())));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CartInfo cf = RequestParamUtil.getParams(CartInfo.class, request);
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		String cno = UUID.randomUUID().toString().replace("-", "");
		cf.setCno(cno);
		
		int result = cartInfoBiz.add(cf);
		if(result>0) {
			this.send(response, 200, cno, null);
		}else {
			this.send(response, 500,"",null);
		}
	}

}
