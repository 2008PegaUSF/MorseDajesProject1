package com.revature.beans;


public class Awarded {
	protected int requestid;
	
	public Awarded(int int1) {
		this.requestid=int1;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + requestid;
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
		Awarded other = (Awarded) obj;
		if (requestid != other.requestid)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Awarded [requestid=" + requestid + "]";
	}
	
	public int getRequestid() {
		return requestid;
	}
	
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
}
