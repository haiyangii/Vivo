package com.phone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.biz.IOrderInfoBiz;
import com.phone.biz.impl.OrderInfoBizImpl;
import com.phone.entity.UserInfo;



@WebServlet("/order")
public class OrderInfoController extends BasicServlet{

	private static final long serialVersionUID = 773454424946974276L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("add")) {
			add(request,response);
		}else if(op.equals("find")) {
			find(request,response);
		}else if(op.equals("findByOno")) {
			findByOno(request,response);
		}else if(op.equals("update")) {
			update(request,response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ono =request.getParameter("ono");
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		int result=orderInfoBiz.update(ono);
		if(result==-1) {
			this.send(response, 300,"","");
		}else if(result>0) {
			this.send(response, 200,"","");
		}else {
			this.send(response,500,"","");
		}
	}

	private void findByOno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ono = request.getParameter("ono");
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		this.send(response,200,"",orderInfoBiz.findByOno(ono));
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session  = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			this.send(response, 500,"",null);
			return;
		}
		UserInfo uf = (UserInfo) obj;
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		List<Map<String,String>>list = orderInfoBiz.finds(uf.getUid());
		
		if(list == null || list.isEmpty()) {
			this.send(response, 200,null,null);
			return;
		}
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> goods = null;
		
		String preOno=list.get(0).get("ono");
		String curOno =preOno;
		Map<String,Object> map = new HashMap<String,Object>();//存放一个订单数据
		List<Map<String,Object>> temp = new ArrayList<Map<String,Object>>();//存放一个订单下的所有商品信息
		
		//第一个订单数据
		map.put("ono", list.get(0).get("ono"));
		map.put("odate", list.get(0).get("odate"));
		map.put("totalprice", list.get(0).get("totalprice"));
		map.put("status", list.get(0).get("status"));
		
		
		for(Map<String,String> rt:list) {
			curOno = rt.get("ono");
			
			if(!preOno.equals(curOno)) {//说明是另一个订单了
				preOno = curOno;
				map.put("goods",temp);
				result.add(map);
				
				map = new HashMap<String,Object>();
				temp = new ArrayList<Map<String,Object>>();
				map.put("ono", rt.get("ono"));
				map.put("odate", rt.get("odate"));
				map.put("totalprice", rt.get("totalprice"));
				
				map.put("status", rt.get("status"));
			}
			goods = new HashMap<String,Object>();
			goods.put("pname", rt.get("pname"));
			goods.put("pics", rt.get("pics").split(";")[0]);
			goods.put("nums", rt.get("nums"));
			goods.put("price", rt.get("price"));
			temp.add(goods);
		}

		map.put("goods",temp);
		result.add(map);
		this.send(response, 200,null,result);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		String ano = request.getParameter("ano");
		String ono = request.getParameter("ono");
		
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		int result = orderInfoBiz.add(ono,cnos, totalPrice,ano);
		if(result>0) {
			this.send(response, 200,null,null);
			return;
		}
		this.send(response,500,null,null);
	}

}
