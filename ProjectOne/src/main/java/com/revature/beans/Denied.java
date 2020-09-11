package com.revature.beans;

public class Denied {
	protected int requestid;

	public Denied(int int1) {
		this.requestid=int1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Denied [requestid=" + requestid + "]";
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
		Denied other = (Denied) obj;
		if (requestid != other.requestid)
			return false;
		return true;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
}
