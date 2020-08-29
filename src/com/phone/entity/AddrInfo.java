package com.phone.entity;

import java.io.Serializable;

public class AddrInfo implements Serializable{

	private static final long serialVersionUID = 8639881091989920943L;
	
	private String ano;
	private int uid;  
	private String aname;
	private String tel;
	private String province;
	private String city;
	private String area; 
	private String addr;
	private int flag;//判断有没有选中
	@Override
	public String toString() {
		return "AddrInfo [ano=" + ano + ", uid=" + uid + ", aname=" + aname + ", tel=" + tel + ", province=" + province
				+ ", city=" + city + ", area=" + area + ", addr=" + addr + ", flag=" + flag + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + flag;
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		AddrInfo other = (AddrInfo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (flag != other.flag)
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AddrInfo(String ano, int uid, String aname, String tel, String province, String city, String area,
			String addr, int flag) {
		super();
		this.ano = ano;
		this.uid = uid;
		this.aname = aname;
		this.tel = tel;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.flag = flag;
	}
	public AddrInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
