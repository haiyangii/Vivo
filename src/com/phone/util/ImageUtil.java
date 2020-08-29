package com.phone.util;
/**
 * 添加水印
 * @author 易海洋
 * @date   2020年8月15日
 */
import java.awt.*; 

import java.awt.event.*; 

import java.io.*; 

import java.awt.image.*; 

import org.w3c.dom.*; 

import com.sun.image.codec.jpeg.*; 

import javax.imageio.*; 

/****

 * 

 * 添加水印

 * @author Administrator

 *

 */

public class ImageUtil {

public void ImgYin(String s,String ImgName){ 

try{ 

File _file = new File(ImgName); 

Image src = ImageIO.read(_file); 

int wideth=src.getWidth(null); 

int height=src.getHeight(null); 

BufferedImage image=new BufferedImage(wideth,height,BufferedImage.TYPE_INT_RGB); 

Graphics g=image.createGraphics(); 

g.drawImage(src,0,0,wideth,height,null); 

g.setColor(new Color(33,160,253)); 

g.setFont(new Font("黑体",Font.PLAIN,32)); 

Font aa=new Font("黑体",Font.PLAIN,32); 

g.drawString(s,wideth-150,height-10); 

g.dispose(); 

FileOutputStream out=new FileOutputStream(ImgName); 

JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 

encoder.encode(image); 

out.close(); 

} 

catch(Exception e){ 

System.out.println(e); 

} 

} 

public static void main(String[] args){

ImageUtil ib = new ImageUtil();

ib.ImgYin("vivo商城", "C:\\Users\\星海王子\\Desktop\\手机商城\\images\\loginbg.jpg");

}

}
