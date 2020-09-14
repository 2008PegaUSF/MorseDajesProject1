  
package com.revature.beans;

import java.util.Arrays;

public class requestfiles {
protected int requestid;
protected String docname;
protected byte[] file;
protected String extension;


public requestfiles(int requestid, String docname, byte[] file, String extension) {
	super();
	this.requestid = requestid;
	this.docname = docname;
	this.file = file;
	this.extension = extension;
}
public String getExtension() {
	return extension;
}
public void setExtension(String extension) {
	this.extension = extension;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((docname == null) ? 0 : docname.hashCode());
	result = prime * result + Arrays.hashCode(file);
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
	requestfiles other = (requestfiles) obj;
	if (docname == null) {
		if (other.docname != null)
			return false;
	} else if (!docname.equals(other.docname))
		return false;
	if (!Arrays.equals(file, other.file))
		return false;
	if (requestid != other.requestid)
		return false;
	return true;
}
@Override
public String toString() {
	return "requestfiles [requestid=" + requestid + ", docname=" + docname + ", file=" + Arrays.toString(file) + "]";
}
public int getRequestid() {
	return requestid;
}
public void setRequestid(int requestid) {
	this.requestid = requestid;
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