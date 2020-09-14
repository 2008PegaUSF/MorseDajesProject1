package com.revature.beans;

import java.util.Arrays;

public class PendingGrades {
protected int requestid;
protected String gradeformat;
protected String extension;




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(file);
	result = prime * result + ((filename == null) ? 0 : filename.hashCode());
	result = prime * result + ((gradeformat == null) ? 0 : gradeformat.hashCode());
	result = prime * result + ((extension == null) ? 0 : extension.hashCode());
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
	if (extension == null) {
		if (other.extension != null)
			return false;
	} else if (!extension.equals(other.extension))
		return false;
	if (requestid != other.requestid)
		return false;
	return true;
}


@Override
public String toString() {
	return "PendingGrades [requestid=" + requestid + ", gradeformat=" + gradeformat + ", filename=" + filename
			+ ", file=" + Arrays.toString(file) + ", extension=" + extension + "]";
}
protected String filename;
protected byte[] file;


public PendingGrades(String format,String fname,byte[] files, String extension) {
	this.gradeformat=format;
	this.filename=fname;
	this.file=files;
	this.extension=extension;
}



public PendingGrades(int int1, String string, String string2, byte[] array, String extension) {
this.requestid=int1;
this.gradeformat=string;
this.filename=string2;
this.file=array;
this.extension=extension;
	// TODO Auto-generated constructor stub
}



public PendingGrades(int int1, String string, String string2, String extension) {
	this.requestid=int1;
	this.gradeformat=string;
	this.filename=string2;
	this.extension=extension;
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

public String getExtension() {
	return extension;
}

public void setExtension(String extension) {
	this.extension = extension;
}



}
