package com.phone.entity;

import java.io.Serializable;

public class CartInfo implements Serializable{
	private static final long serialVersionUID = -9215791783241817109L;
	
	private String cno;
	private int uid;
	private int pno;
	private int num;
	private double price;
	private String pics;
	private String pname;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cno == null) ? 0 : cno.hashCode());
		result = prime * result + num;
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + pno;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + uid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartInfo other = (CartInfo) obj;
		if (cno == null) {
			if (other.cno != null)
				return false;
		} else if (!cno.equals(other.cno))
			return false;
		if (num != other.num)
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (pno != other.pno)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CartInfo [cno=" + cno + ", uid=" + uid + ", pno=" + pno + ", num=" + num + ", price=" + price
				+ ", pics=" + pics + ", pname=" + pname + "]";
	}
	public CartInfo(String cno, int uid, int pno, int num, double price, String pics, String pname) {
		super();
		this.cno = cno;
		this.uid = uid;
		this.pno = pno;
		this.num = num;
		this.price = price;
		this.pics = pics;
		this.pname = pname;
	}
	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
