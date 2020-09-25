package com.revature.beans;

public class Requests {
	protected int requestid;
	protected String requestDate;
	protected String location;
	protected String description;
	protected double cost;
	protected String gradingFormat;
	protected String eventType;
	protected int UserId;
	protected String  requestTime;
	protected String  justification;
	protected String  eventTime;
	protected String eventDate;
<<<<<<< HEAD
=======
	protected String firstName;
	protected String lastName;
	protected double projectedamount;
	protected double awardedamount;
	
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
<<<<<<< HEAD
	@Override
	public String toString() {
		return "Requests [requestid=" + requestid + ", requestDate=" + requestDate + ", location=" + location
				+ ", description=" + description + ", cost=" + cost + ", gradingFormat=" + gradingFormat
				+ ", eventType=" + eventType + ", UserId=" + UserId + ", requestTime=" + requestTime
				+ ", justification=" + justification + ", eventTime=" + eventTime + ", eventDate=" + eventDate
				+ ", getRequestid()=" + getRequestid() + ", getRequestDate()=" + getRequestDate() + ", getLocation()="
				+ getLocation() + ", getDescription()=" + getDescription() + ", getCost()=" + getCost()
				+ ", getGradingFormat()=" + getGradingFormat() + ", getEventType()=" + getEventType() + ", getUserId()="
				+ getUserId() + ", getRequestTime()=" + getRequestTime() + ", getJustification()=" + getJustification()
				+ ", getEventTime()=" + getEventTime() + ", getEventDate()=" + getEventDate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
=======
	public double getProjectedamount() {
		return projectedamount;
	}
	public void setProjectedamount(double projectedamount) {
		this.projectedamount = projectedamount;
	}
	public double getAwardedamount() {
		return awardedamount;
	}
	public void setAwardedamount(double awardedamount) {
		this.awardedamount = awardedamount;
	}
	
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserId;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventTime == null) ? 0 : eventTime.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((requestTime == null) ? 0 : requestTime.hashCode());
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
		Requests other = (Requests) obj;
		if (UserId != other.UserId)
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventTime == null) {
			if (other.eventTime != null)
				return false;
		} else if (!eventTime.equals(other.eventTime))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestTime == null) {
			if (other.requestTime != null)
				return false;
		} else if (!requestTime.equals(other.requestTime))
			return false;
		if (requestid != other.requestid)
			return false;
		return true;
	}
<<<<<<< HEAD
	public Requests(int requestid,String requestDate, String location, String description, double cost,
			String gradingFormat, String eventType, int userId, String requestTime, String justification,
			String eventTime, String eventDate) {
=======
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Requests() {
		super();
	}
	public Requests(int requestid, String requestDate, String location, String description, double cost,
			String gradingFormat, String eventType, int userId, String requestTime, String justification,
			String eventTime, String eventDate, String firstName, String lastName) {
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		super();
		this.requestid = requestid;
		this.requestDate = requestDate;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		UserId = userId;
		this.requestTime = requestTime;
		this.justification = justification;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
<<<<<<< HEAD
	}
	public Requests() {
		// TODO Auto-generated constructor stub
=======
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Requests(int requestid, String description, String gradingFormat, String eventTime, String eventDate) {
		super();
		this.requestid = requestid;
		this.description = description;
		this.gradingFormat = gradingFormat;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
	}
	
	public Requests(int requestid, String description, String gradingFormat, String eventType, String eventDate,
		double projectedamount, double awardedamount) {
		super();
		this.requestid = requestid;
		this.description = description;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.projectedamount = projectedamount;
		this.awardedamount = awardedamount;
	}
	
	public Requests(int requestid, String requestDate, String location, String description, double cost,
			String gradingFormat, String eventType, int userId, String requestTime, String justification,
			String eventTime, String eventDate, String firstname, String lastname, double projectedamount) {
		super();
		this.requestid = requestid;
		this.requestDate = requestDate;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.UserId = userId;
		this.requestTime = requestTime;
		this.justification = justification;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
		this.firstName = firstname;
		this.lastName = lastname;
		this.projectedamount = projectedamount;
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
	}
}
