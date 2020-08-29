package com.phone.util;

import java.lang.reflect.Method;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class FileUploadUtil {
	public static String PATH = "../pics";// 上传文件保存路径
	private static final int MAXFILESIZE = 10 * 1024 * 1024;
	private static final int TOTALMAXSIZE = 100 * 1024 * 1024;// 单个文件最大大小
	private static final String ALLOWEDLIST = "gif,jpg,png,jpeg,doc,docx,xls,xlsx,txt";// 允许上传文件的后缀
	private String basePath;

	public Map<String, String> upload(PageContext pagecontext) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
	

		// 实例化上传组件
		SmartUpload su = new SmartUpload();
		su.initialize(pagecontext);// 初始上传化组件

		// 设置参数
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWEDLIST);
		su.setCharset("utf-8");
		su.upload();// 开始上传

		// 获取非文件参数
		Request req = su.getRequest();
		Enumeration<String> enums = req.getParameterNames();

		String name = null;
		while (enums.hasMoreElements()) {
			name = enums.nextElement();
			map.put(name, req.getParameter(name));
		}

		// 处理上传的文件
		Files files = su.getFiles();
		if (files == null || files.getCount() <= 0) {
			return map;
		}
		Collection<File> fls = files.getCollection();

		// 获取得文件夹的绝对路径
		// 第一种方式获取文件的路径，返回上级目录
		// basePath = new
		// java.io.File(pagecontext.getRequest().getRealPath("/")).getParent()+"/";
		basePath = pagecontext.getRequest().getRealPath("/");
		// System.out.println(basePath);

		String fieldName = null;
		String fileName = null;
		String temp = null;
		String pathStr = "";
		for (File fl : fls) {
			if (!fl.isMissing()) {
				temp = fl.getFieldName();// photo myfile
				if (StringUtil.checkNull(fieldName)) {// 说明是第一个要上传的文件
					fieldName = temp;
				} else {// 说明是第二个文件文本框的内容
					if (!temp.equals(fieldName)) {
						// 首先需要将第一个文件文本框中的内容存到map中
						map.put(fieldName, pathStr);
						pathStr = "";// 初始化一下，准备存放下一个文件文本框中的文件上传路径
						fieldName = temp;
					}
				}

				fileName = PATH + "/" + new Date().getTime() + "_" + fl.getFileName();
				if (StringUtil.checkNull(pathStr)) {// 说明是第一个要上传的文件
					pathStr = fileName;
				} else {
					pathStr += "," + fileName;
				}

				// 保存到服务区
				fl.saveAs(basePath + fileName, SmartUpload.SAVE_PHYSICAL);
				ImageUtil image= new ImageUtil();
				image.ImgYin("vivo商城", basePath +fileName);
			}

		}
		map.put(fieldName, pathStr);
		return map;
	}
	
	/**
	 * 只针对单个文本框文件的上传
	 * @param pagecontext
	 * @return
	 * @throws Exception
	 */
	public Map<String,String>uploadPic (PageContext pagecontext) throws Exception{
		Map<String, String> map = new HashMap<String, String>();

		// 实例化上传组件
		SmartUpload su = new SmartUpload();
		su.initialize(pagecontext);// 初始上传化组件

		// 设置参数
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWEDLIST);
		su.setCharset("utf-8");
		su.upload();// 开始上传
		

		// 处理上传的文件
		Files files = su.getFiles();
		if (files == null || files.getCount() <= 0) {
			return map;
		}
		Collection<File> fls = files.getCollection();

		// 获取得文件夹的绝对路径
		// 第一种方式获取文件的路径，返回上级目录
		// basePath = new
		// java.io.File(pagecontext.getRequest().getRealPath("/")).getParent()+"/";
		basePath = pagecontext.getRequest().getRealPath("/");
		// System.out.println(basePath);

		String fieldName = null;
		String fileName = null;
		String uploadPath = null;
		for (File fl : fls) {
			if (!fl.isMissing()) {
				fieldName = fl.getFieldName();// photo myfile
				fileName = fl.getFileName();
				//存到服务器中，获取tomcat在服务器的绝对路径
				uploadPath=PATH+"/"+new Date().getTime()+"_"+fileName;
				// 保存到服务区
				fl.saveAs(basePath + uploadPath, SmartUpload.SAVE_PHYSICAL);
				
				ImageUtil image= new ImageUtil();
				image.ImgYin("vivo商城", basePath +uploadPath);
			}
		}
		map.put(fieldName,uploadPath);
		map.put("fileName", fileName);
		System.out.println(map);
		return map;
	}
	
	/**
	 * 基于实体类对象
	 * @param <T>
	 * @param clazz
	 * @param pagecontext
	 * @return
	 * @throws Exception
	 */
	public <T> T upload(Class<T> clazz,PageContext pagecontext) throws Exception{
		T t =clazz.newInstance();
		
		//实例化上传组件
		SmartUpload su = new SmartUpload();
		su.initialize(pagecontext);//初始化上传组件
		
		//设置参数
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWEDLIST);
		su.setCharset("utf-8");
		su.upload();// 开始上传
		
		// 获取非文件参数
		Request req = su.getRequest();
		Enumeration<String> enums = req.getParameterNames();
		
		//获取指定类中的所有方法
		Method[] methods =clazz.getMethods();
		Map<String,Method >setters = new HashMap<String,Method>();
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
		
		while(enums.hasMoreElements()){
			name = enums.nextElement();//属性名
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
				method.invoke(t, Integer.valueOf(req.getParameter(name)));//反向激活一个方法，相当于t.setSid(value)
			}else if(Double.TYPE == type || Double.class==type) {
				method.invoke(t, Double.valueOf(req.getParameter(name)));
			}else if(Float.TYPE == type || Float.class==type) {
				method.invoke(t, Float.valueOf(req.getParameter(name)));
			}else if(Boolean.TYPE == type || Boolean.class==type) {
				method.invoke(t, Boolean.valueOf(req.getParameter(name)));
			}else if(Long.TYPE == type || Long.class==type) {
				method.invoke(t, Long.valueOf(req.getParameter(name)));
			}else if(Short.TYPE == type || Short.class==type) {
				method.invoke(t, Short.valueOf(req.getParameter(name)));
			}else if(Byte.TYPE == type || Byte.class==type) {
				method.invoke(t,Byte.valueOf(req.getParameter(name)));
			}else {
				method.invoke(t, req.getParameter(name));
			}
		}
		
		// 处理上传的文件
				Files files = su.getFiles();
				if (files == null || files.getCount() <= 0 || files.getSize()<=0 || files.getFile(0).getSize()<=0) {
					return t;
				}
				Collection<File> fls = files.getCollection();

				// 获取得文件夹的绝对路径
				// 第一种方式获取文件的路径，返回上级目录
				// basePath = new
				// java.io.File(pagecontext.getRequest().getRealPath("/")).getParent()+"/";
				basePath = pagecontext.getRequest().getRealPath("/");
				// System.out.println(basePath);

				String fieldName = null;
				String fileName = null;
				String temp = null;
				String pathStr = "";
				for (File fl : fls) {
					if (!fl.isMissing()) {
						temp = fl.getFieldName();// photo myfile
						if (StringUtil.checkNull(fieldName)) {// 说明是第一个要上传的文件
							fieldName = temp;
						} else {// 说明是第二个文件文本框的内容
							if (!temp.equals(fieldName)) {//说明是另一个文件
								// 首先需要将第一个文件文本框中的内容存到map中
								methodName = "set" +fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);//将属性名第一个字母大写并加上set
								method = setters.get(methodName);
								if(method == null) {
									continue;
								}
								
								types = method.getParameterTypes();
								if( types ==null) {
									continue;
								}
								
								method.invoke(t, pathStr);
								pathStr="";//初始化，准备存放下个文件
								fileName= temp;
							}
						}

						//存到服务器中 ->获取tomcat在服务器中的绝对路径
						fileName = PATH + "/" + new Date().getTime() + "_" + fl.getFileName();
						if (StringUtil.checkNull(pathStr)) {// 说明是第一个要上传的文件
							pathStr = fileName;
						} else {
							pathStr += "," + fileName;
						}

						// 保存到服务区
						fl.saveAs(basePath + fileName, SmartUpload.SAVE_PHYSICAL);
						//添加水印
						ImageUtil image= new ImageUtil();
						image.ImgYin("vivo商城", basePath + fileName);
					}

				}
 				methodName = "set" +fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);//将属性名第一个字母大写并加上set
                method = setters.get(methodName);
                if(method == null) {
                	return t;
                }
                types = method.getParameterTypes();
				if( types ==null) {
					return t;
				}
				
				method.invoke(t, pathStr);
				
				return t;
	}
}
