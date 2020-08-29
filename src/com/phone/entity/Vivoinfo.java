package com.phone.entity;

import java.io.Serializable;

public class Vivoinfo implements Serializable{

	private static final long serialVersionUID = -3690300846395760788L;
	
	private int pno;
    private String pname;
    private int tno;
    private double price;
    private String pics;
    private String pintro;
    private int inventory ;
    private String capacity;
    private String color;
    private String gnum;
    
    private String tname;

	@Override
	public String toString() {
		return "Vivoinfo [pno=" + pno + ", pname=" + pname + ", tno=" + tno + ", price=" + price + ", pics=" + pics
				+ ", pintro=" + pintro + ", inventory=" + inventory + ", capacity=" + capacity + ", color=" + color
				+ ", gnum=" + gnum + ", tname=" + tname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((gnum == null) ? 0 : gnum.hashCode());
		result = prime * result + inventory;
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		result = prime * result + ((pintro == null) ? 0 : pintro.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + pno;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + tno;
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
		Vivoinfo other = (Vivoinfo) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (gnum == null) {
			if (other.gnum != null)
				return false;
		} else if (!gnum.equals(other.gnum))
			return false;
		if (inventory != other.inventory)
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (pintro == null) {
			if (other.pintro != null)
				return false;
		} else if (!pintro.equals(other.pintro))
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
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno != other.tno)
			return false;
		return true;
	}

	public Vivoinfo(int pno, String pname, int tno, double price, String pics, String pintro, int inventory,
			String capacity, String color, String gnum, String tname) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.tno = tno;
		this.price = price;
		this.pics = pics;
		this.pintro = pintro;
		this.inventory = inventory;
		this.capacity = capacity;
		this.color = color;
		this.gnum = gnum;
		this.tname = tname;
	}

	public Vivoinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
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

	public String getPintro() {
		return pintro;
	}

	public void setPintro(String pintro) {
		this.pintro = pintro;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGnum() {
		return gnum;
	}

	public void setGnum(String gnum) {
		this.gnum = gnum;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
	
	
}
