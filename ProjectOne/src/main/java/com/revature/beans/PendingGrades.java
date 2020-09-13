package com.revature.beans;

import java.sql.Array;
import java.util.Arrays;

public class PendingGrades {
protected int requestid;
protected String gradeformat;
protected byte[] files;




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(file);
	result = prime * result + ((filename == null) ? 0 : filename.hashCode());
	result = prime * result + ((gradeformat == null) ? 0 : gradeformat.hashCode());
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
	PendingGrades other = (PendingGrades) obj;
	if (!Arrays.equals(file, other.file))
		return false;
	if (filename == null) {
		if (other.filename != null)
			return false;
	} else if (!filename.equals(other.filename))
		return false;
	if (gradeformat == null) {
		if (other.gradeformat != null)
			return false;
	} else if (!gradeformat.equals(other.gradeformat))
		return false;
	if (requestid != other.requestid)
		return false;
	return true;
}


@Override
public String toString() {
	return "PendingGrades [requestid=" + requestid + ", gradeformat=" + gradeformat + ", filename=" + filename
			+ ", file=" + Arrays.toString(file) + "]";
}
protected String filename;
protected byte[] file;


public PendingGrades(String format,String fname,byte[] files) {
	this.gradeformat=format;
	this.filename=fname;
	this.file=files;
}



public PendingGrades(int int1, String string, String string2, byte[] array) {
this.requestid=int1;
this.gradeformat=string;
this.filename=string2;
this.file=array;
	// TODO Auto-generated constructor stub
}



public PendingGrades(int int1, String string, String string2) {
	this.requestid=int1;
	this.gradeformat=string;
	this.filename=string2;
	// TODO Auto-generated constructor stub
}



public int getRequestid() {
	return requestid;
}
public void setRequestid(int requestid) {
	this.requestid = requestid;
}
public String getGradeformat() {
	return gradeformat;
}
public void setGradeformat(String gradeformat) {
	this.gradeformat = gradeformat;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public byte[] getFile() {
	return file;
}
public void setFile(byte[] file) {
	this.file = file;
}



}
