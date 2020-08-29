package com.phone.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/code")
public class CreateCodeController extends HttpServlet{
	private static final long serialVersionUID = 6265385251642736968L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "no-cache");//不缓存
		response.setHeader("Cache-Control", "no-cahce");//不缓存
		response.setDateHeader("Expires",0);//过期时间，立马过期
		
		//获取验证码
		String code = getRandomCode();
		
		//将生成的验证码存到session中
		HttpSession session = request.getSession();
		session.setAttribute("validatecode", code);
		
		//创建验证码图片并返回
		BufferedImage image = getCodeImage(code,110,28);
		ImageIO.write(image,"JPEG",response.getOutputStream());
	}
	
	private String getRandomCode() {
		Random rd = new Random();
		StringBuffer sbf = new StringBuffer();
		int flag = 0;
		for (int i=0; i<4; i++) {
			flag=rd.nextInt(3);
			switch(flag) {
		    case 0:sbf.append(rd.nextInt(10));break;
		    case 1:sbf.append((char)(rd.nextInt(26)+65)); break;
		    case 2:sbf.append((char)(rd.nextInt(26)+97)); break;
			}
		}
		return sbf.toString();
	}

	/**
	 * 获取指定范围的指定颜色
	 * @param start
	 * @param bound
	 * @return
	 */
	private Color getRandomColor(int start,int bound) {
		Random rd = new Random();
		int r = start + rd.nextInt(bound);
		int g = start + rd.nextInt(bound);
		int b = start + rd.nextInt(bound);
		return new Color(r,g,b);
	}
	private BufferedImage getCodeImage(String code, int width, int height) {
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//获取对图片的绘制对象
		Graphics g = image.getGraphics();
		
		//绘制背景色
		g.setColor(getRandomColor(225,30));//225~255之间的颜色
		
		//设置绘制的边界
		g.fillRect(0, 0, width, height);//左上角坐标到右下角，即全部
		
		//绘制验证码
		//设置验证码的字体
		g.setFont(new Font("Couriew New",Font.ITALIC,20));
		
		//绘制验证码
		char[] codes = code.toCharArray();
		for(int i = 0, len = codes.length; i< len; i++) {
			//设置字体颜色
			g.setColor(getRandomColor(40,70));
			g.drawString(String.valueOf(codes[i]), 10 + 24 * i, 20);
		}
		
		//绘制干扰线
		int x1,y1,x2,y2;
		Random rd = new Random();
		for(int i =0 ; i<30; i++) {
			//设置干扰线颜色
			g.setColor(getRandomColor(180,50));
			x1 = rd.nextInt(width);
			y1 = rd.nextInt(height);
			x2 = rd.nextInt(width);
			y2 = rd.nextInt(height);
			g.drawLine(x1,y1,x2,y2);
		}
		
	
		
		g.dispose();
		return image;
	}

	

	

}
