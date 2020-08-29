package com.phone.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import com.google.gson.Gson;
import com.phone.biz.IVivoGoodsBiz;
import com.phone.biz.impl.VivoGoodsBizImpl;
import com.phone.entity.Vivoinfo;
import com.phone.util.FileUploadUtil;
import com.phone.util.RequestParamUtil;



@WebServlet("/goods")
public class VivoGoodsController extends BasicServlet{
	private static final long serialVersionUID = 3987619439819215363L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("findAll")) {
			findAll(request,response);
		}else if(op.equals("add")) {
			add(request,response);
			
		}else if(op.equals("findByCondition")) {
			findByCondition(request,response);
		}else if(op.equals("findIndex")) {
			findIndex(request,response);
		}else if(op.equals("findByPno")) {
			findByPno(request,response);
		}
	}

	private void findByPno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pno=request.getParameter("pno");
		IVivoGoodsBiz vivoGoodsBiz = new VivoGoodsBizImpl();
		this.send(response, 200,"",vivoGoodsBiz.findByPno(pno));
	}

	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IVivoGoodsBiz vivoGoodsBiz = new VivoGoodsBizImpl();
		this.send(response, 200,"",vivoGoodsBiz.findIndex());
	}

	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		String tno = request.getParameter("tno");
		String pname = request.getParameter("pname");
		IVivoGoodsBiz goodsInfoBiz = new VivoGoodsBizImpl();
		this.send(response,goodsInfoBiz.findByCondition(tno, pname, page, rows));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		FileUploadUtil fu =new FileUploadUtil();
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		int result=-1;
		try {
			Map<String,String>map = fu.upload(pagecontext);
			
			IVivoGoodsBiz vivoGoodsBiz = new VivoGoodsBizImpl();
			result = vivoGoodsBiz.add(map.get("pname"), map.get("tname"), Double.parseDouble(map.get("price")), 
					map.get("apics"), map.get("pintro"),Integer.parseInt(map.get("inventory")), map.get("capacity"),map.get("color"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.send(response, result);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {//分页查询
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IVivoGoodsBiz vivoGoodsBiz = new VivoGoodsBizImpl();

		int count = vivoGoodsBiz.total();//得到数据的总行数(分页效果图上为23)
		HashMap<String, Object> map = new HashMap<String, Object>();//由于在easyui中分页gson转json中有特定格式,为适应格式而加map
		map.put("total", count);//为迎合特定格式
		map.put("rows", vivoGoodsBiz.findAll(page,rows));//为迎合特定格式
		Gson gson = new Gson();
		String x = gson.toJson(map);//将分页数据转化为easyui中分页所需的json
		this.send(response, x);
		
	}

}
