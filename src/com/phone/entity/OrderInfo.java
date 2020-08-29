package com.phone.entity;

import java.io.Serializable;

public class OrderInfo implements Serializable{
	private static final long serialVersionUID = 3698865868706983648L;

	String ono;
    private int uid;
    private String otime;
    private String sdate;
    private String rdate;
    private double totalprice;
    private int invoce;
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getInvoce() {
		return invoce;
	}
	public void setInvoce(int invoce) {
		this.invoce = invoce;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invoce;
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		result = prime * result + ((otime == null) ? 0 : otime.hashCode());
		result = prime * result + ((rdate == null) ? 0 : rdate.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalprice);
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
		OrderInfo other = (OrderInfo) obj;
		if (invoce != other.invoce)
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (otime == null) {
			if (other.otime != null)
				return false;
		} else if (!otime.equals(other.otime))
			return false;
		if (rdate == null) {
			if (other.rdate != null)
				return false;
		} else if (!rdate.equals(other.rdate))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (Double.doubleToLongBits(totalprice) != Double.doubleToLongBits(other.totalprice))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", uid=" + uid + ", otime=" + otime + ", sdate=" + sdate + ", rdate=" + rdate
				+ ", totalprice=" + totalprice + ", invoce=" + invoce + "]";
	}
	public OrderInfo(String ono, int uid, String otime, String sdate, String rdate, double totalprice, int invoce) {
		super();
		this.ono = ono;
		this.uid = uid;
		this.otime = otime;
		this.sdate = sdate;
		this.rdate = rdate;
		this.totalprice = totalprice;
		this.invoce = invoce;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
