package com.phone.entity;

import java.io.Serializable;

public class OrderItemInfo implements Serializable{
	private static final long serialVersionUID = -4945085595484034385L;

	private int ino;
    private String ono;
    private int pno;
    private int nums;
    private int price;
    private int status;
    
    
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ino;
		result = prime * result + nums;
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		result = prime * result + pno;
		result = prime * result + price;
		result = prime * result + status;
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
		OrderItemInfo other = (OrderItemInfo) obj;
		if (ino != other.ino)
			return false;
		if (nums != other.nums)
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (pno != other.pno)
			return false;
		if (price != other.price)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItemInfo [ino=" + ino + ", ono=" + ono + ", pno=" + pno + ", nums=" + nums + ", price=" + price
				+ ", status=" + status + "]";
	}
	public OrderItemInfo(int ino, String ono, int pno, int nums, int price, int status) {
		super();
		this.ino = ino;
		this.ono = ono;
		this.pno = pno;
		this.nums = nums;
		this.price = price;
		this.status = status;
	}
	public OrderItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
