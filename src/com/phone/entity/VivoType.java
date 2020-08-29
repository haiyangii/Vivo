package com.phone.entity;

import java.io.Serializable;

public class VivoType implements Serializable{
	private static final long serialVersionUID = -1997782733011038015L;
	
	private int tno;//
    private String tname;//系列名称
    private String pic;
    private int status;
	@Override
	public String toString() {
		return "VivoType [tno=" + tno + ", tname=" + tname + ", pic=" + pic + ", status=" + status + "]";
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + status;
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
		VivoType other = (VivoType) obj;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (status != other.status)
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
	public VivoType(int tno, String tname, String pic, int status) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.pic = pic;
		this.status = status;
	}
	public VivoType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
