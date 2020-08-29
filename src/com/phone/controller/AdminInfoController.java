package com.phone.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.biz.IAdminInfoBiz;
import com.phone.biz.impl.AdminInfoBizImpl;
import com.phone.dao.IAdminInfoDao;
import com.phone.dao.impl.AdminInfoDaoImpl;
import com.phone.entity.AdminInfo;


@WebServlet("/admin")
public class AdminInfoController extends BasicServlet{
	private static final long serialVersionUID = 3617526016305153898L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op.equals("login")) {
			login(request,response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		String remember=request.getParameter("remember");
		HttpSession session = request.getSession();
		String vcode = String.valueOf(session.getAttribute("validatecode"));
		if(!code.equalsIgnoreCase(vcode)) {
			this.send(response, 500,"",null);
			return;
		}
		IAdminInfoBiz admininfobiz = new AdminInfoBizImpl();
		AdminInfo admininfo= admininfobiz.login(account, pwd);
		if(admininfo == null) {
			this.send(response, 501,"",null);
			return;
		}
		
		if(remember != null) {
			
			Cookie myCookie[]=request.getCookies();
			for (Cookie cookie : myCookie) {
				String acc = cookie.getValue().split("-")[0];
				if(!("account".equals(cookie.getName()) && acc.equals(cookie.getValue()))) {
					//存到cookie
					Cookie ck = new Cookie("account", account + "-" + pwd);
					ck.setMaxAge(7 * 24 * 60 * 60);//单位为秒，默认是浏览器关闭失效
					
					response.addCookie(ck);//通过response的对象将cookie数据写入客户端
				}
			}
		}
		
		session.setAttribute("currentLoginMember", admininfo);
		this.send(response, 200,"",null);
	}
}
