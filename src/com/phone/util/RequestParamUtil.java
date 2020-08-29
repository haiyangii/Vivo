package com.phone.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestParamUtil {
	
	public static<T> T getParams(Class<T>clazz,HttpServletRequest request) {
		T t = null;
		
		try {
			t =clazz.newInstance();
			
			//获取请求中的参数参数名
			Enumeration<String> names = request.getParameterNames();
			
			//
			Method[] methods =clazz.getMethods();
			Map<String,Method>setters = new HashMap<String,Method>();
			String methodName = null;
			
			for(Method md : methods) {
				methodName = md.getName();
				if(methodName.startsWith("set")) {
					setters.put(methodName, md);
				}
			}
			
			
			String name=null;
			Class<?>[] types =null;
			Class<?> type = null;
			Method method = null;
			
			while(names.hasMoreElements()){
				name = names.nextElement();//属性名
				methodName = "set" +name.substring(0,1).toUpperCase() + name.substring(1);//将属性名第一个字母大写并加上set
				
				method = setters.get(methodName);//通过方法名获取方法
				if(method==null) {
					continue;
				}
				
				types=method.getParameterTypes();
				
				if(types==null) {
					continue;
				}
				type=types[0];
				
				if(Integer.TYPE == type || Integer.class==type) {
					method.invoke(t, Integer.valueOf(request.getParameter(name)));//反向激活一个方法，相当于t.setSid(value)
				}else if(Double.TYPE == type || Double.class==type) {
					method.invoke(t, Double.valueOf(request.getParameter(name)));
				}else if(Float.TYPE == type || Float.class==type) {
					method.invoke(t, Float.valueOf(request.getParameter(name)));
				}else if(Boolean.TYPE == type || Boolean.class==type) {
					method.invoke(t, Boolean.valueOf(request.getParameter(name)));
				}else if(Long.TYPE == type || Long.class==type) {
					method.invoke(t, Long.valueOf(request.getParameter(name)));
				}else if(Short.TYPE == type || Short.class==type) {
					method.invoke(t, Short.valueOf(request.getParameter(name)));
				}else if(Byte.TYPE == type || Byte.class==type) {
					method.invoke(t, Byte.valueOf(request.getParameter(name)));
				}else {
					method.invoke(t, request.getParameter(name));
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public Map<String,String> upload(HttpServletRequest request) throws Exception{
		Map<String,String> map =new HashMap<String,String>();
		Enumeration<String> enums = request.getParameterNames();
		
		String name = null;
		while(enums.hasMoreElements()) {
			name=enums.nextElement();
			map.put(name, request.getParameter(name));
		}
		return map;
		
	}

}
