package com.phone.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.biz.IAdminInfoBiz;
import com.phone.biz.IUserInfoBiz;
import com.phone.biz.impl.AdminInfoBizImpl;
import com.phone.biz.impl.UserInfoBizImpl;
import com.phone.entity.AdminInfo;
import com.phone.entity.UserInfo;
import com.phone.util.RequestParamUtil;
import com.phone.util.SendmailUtil;

@WebServlet("/user")
public class UserInfoController extends BasicServlet{
	private static final long serialVersionUID = -8971407021303274330L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("register")) {
			register(request,response);
		}else if(op.equals("send")) {
			Send(request,response);
		}else if(op.equals("info")) {
			info(request,response);
		}else if(op.equals("login")) {
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
		IUserInfoBiz userInfoBiz = new UserInfoBizImpl();
		UserInfo userInfo= userInfoBiz.login(account, pwd);
		if(userInfo == null) {
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
		
		session.setAttribute("currentLoginMember", userInfo);
		this.send(response, 200,"",null);
		
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj==null) {
			this.send(response, 500,"",null);
			return;
		}
		this.send(response, 200,"",obj);
	}

	private void Send(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SendmailUtil sendmailutil= new  SendmailUtil();
		String mailaddr=request.getParameter("mail");
		String yzm="";
		try {
			yzm = sendmailutil.sendEmail(mailaddr);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.send(response, yzm);
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserInfo userinfo = RequestParamUtil.getParams(UserInfo.class, request);
		
		
		
		IUserInfoBiz userInfoBiz = new UserInfoBizImpl();
		this.send(response, userInfoBiz.add(userinfo));
	}

}
