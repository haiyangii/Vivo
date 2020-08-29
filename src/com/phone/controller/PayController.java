package com.phone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phone.util.AlipayUtil;

@WebServlet("/pay")
public class PayController extends BasicServlet{

	private static final long serialVersionUID = -1666556648737357116L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		///商户订单号，商户网站订单系统中唯一订单号，必填
		String orderId = new String(request.getParameter("ono").getBytes("ISO-8859-1"),"UTF-8");
		//付款金额，必填
		String money = new String(request.getParameter("totalPrice").getBytes("ISO-8859-1"),"UTF-8");
		//订单名称，必填
		String name = new String("手机商城".getBytes("ISO-8859-1"),"UTF-8");
		//商品描述，可空
		String info = new String("".getBytes("ISO-8859-1"),"UTF-8");
		
		try {
			String result = AlipayUtil.pay(response, money, info, name, orderId);
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/hello.jsp").forward(request,response);
}

}
