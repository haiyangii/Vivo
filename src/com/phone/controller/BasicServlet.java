package com.phone.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicServlet  extends HttpServlet{
	private static final long serialVersionUID = 2041956126258242284L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		super.service(req, resp);
	}
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	/**
	 * 回送数据的方法
	 * @param response
	 * @param str
	 * @throws IOException
	 */
	protected void send( HttpServletResponse response,String str) throws IOException {
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
	}
	
	protected void send(HttpServletResponse response,int code) throws IOException {
		PrintWriter out = response.getWriter();
		out.println(code);
		out.flush();
	}
	
	protected void send(HttpServletResponse response,Object obj) throws IOException {
		Gson gson = new GsonBuilder().serializeNulls().create();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(obj));
		out.flush();
	}
	
	protected void send(HttpServletResponse response,int total,Object obj) throws IOException {
		//分页的封装
		Map<String, Object>map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows",obj);
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
	}
	
	protected void send(HttpServletResponse response,int code,String msg,Object obj) throws IOException {
		//分页的封装
		Map<String, Object>map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("msg",msg);
		map.put("data",obj);
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
	}
}
