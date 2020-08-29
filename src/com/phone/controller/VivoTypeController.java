package com.phone.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.phone.biz.IVivoGoodsBiz;
import com.phone.biz.IVivoTypeBiz;
import com.phone.biz.impl.VivoGoodsBizImpl;
import com.phone.biz.impl.VivoTypeBizImpl;
import com.phone.entity.VivoType;
import com.phone.util.FileUploadUtil;
import com.phone.util.RequestParamUtil;


@WebServlet("/type")
public class VivoTypeController extends BasicServlet{
	private static final long serialVersionUID = 7991747593627694727L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("findAll")) {
			findAll(request,response);
		}else if(op.equals("add")) {
			add(request,response);
		}else if(op.equals("update")) {
			update(request,response);
		}else if(op.equals("delete")) {
			delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno=request.getParameter("tno");
		IVivoTypeBiz vivoTypeBiz = new VivoTypeBizImpl();
		this.send(response,vivoTypeBiz.delete(tno));
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		VivoType type = RequestParamUtil.getParams(VivoType.class, request);
		IVivoTypeBiz vivoTypeBiz = new VivoTypeBizImpl();
		this.send(response,vivoTypeBiz.update(type));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		FileUploadUtil fu =new FileUploadUtil();
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		int result=-1;
		try {
			Map<String,String>map = fu.upload(pagecontext);
			
			IVivoTypeBiz vivoTypeBiz = new VivoTypeBizImpl();
			
			result = vivoTypeBiz.add(map.get("tname"),map.get("atpics"),Integer.parseInt(map.get("astatus"))); 	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.send(response, result);
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IVivoTypeBiz vivoTypeBiz = new VivoTypeBizImpl();
		this.send(response, vivoTypeBiz.findAll());
	}

}
