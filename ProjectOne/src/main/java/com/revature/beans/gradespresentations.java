package com.revature.beans;

import java.util.Arrays;

public class gradespresentations {
	protected int requestid;
	protected String format;
	protected String docname;
	protected byte[] file;
	protected String extensions;
	
	
	
	public gradespresentations(int requestid, String format, String docname, byte[] file, String extensions) {
		super();
		this.requestid = requestid;
		this.format = format;
		this.docname = docname;
		this.file = file;
		this.extensions = extensions;
	}
	public String getExtensions() {
		return extensions;
	}
	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}
	public gradespresentations(int requestid, String format) {
		super();
		this.requestid = requestid;
		this.format = format;
	}
	public gradespresentations(int requestid, String format, String docname) {
		super();
		this.requestid = requestid;
		this.format = format;
		this.docname = docname;
	}
	public gradespresentations(int requestid, String format, String docname, byte[] file) {
		super();
		this.requestid = requestid;
		this.format = format;
		this.docname = docname;
		this.file = file;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((docname == null) ? 0 : docname.hashCode());
		result = prime * result + Arrays.hashCode(file);
		result = prime * result + ((format == null) ? 0 : format.hashCode());
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
		gradespresentations other = (gradespresentations) obj;
		if (docname == null) {
			if (other.docname != null)
				return false;
		} else if (!docname.equals(other.docname))
			return false;
		if (!Arrays.equals(file, other.file))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (requestid != other.requestid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "gradespresentations [requestid=" + requestid + ", format=" + format + ", docname=" + docname + ", file="
				+ Arrays.toString(file) + "]";
	}
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	} 
	
	
}
