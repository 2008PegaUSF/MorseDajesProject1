package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Awarded;
import com.revature.beans.BencoApproved;
import com.revature.beans.Denied;
import com.revature.beans.DepartheadApproved;
import com.revature.beans.Pending;
import com.revature.beans.Requests;
import com.revature.beans.SupervisorApproved;

public interface RequestsDao {
public List<Requests> getRequests()throws SQLException;
	public List<Pending> getPendings() throws SQLException;
	public List<SupervisorApproved> getSuperApproveds() throws SQLException;
	public List<DepartheadApproved> getDepartheadApproveds() throws SQLException;
	public List<BencoApproved> getBencoApproved() throws SQLException;
	public List<Denied> getDenieds() throws SQLException;
	public List<Awarded>getAwarded() throws SQLException;
	public Requests getRequestByReqId(int id) throws SQLException;
	public List<Requests> getRequestsById(int id) throws SQLException;
	public void createRequest(String requestDate, String location, String description, double cost,
			String gradingFormat, String eventType, int userId, String requestTime, String justification,
			String eventTime, String eventDate)throws SQLException;
	public void createAwarded(int id) throws SQLException;
	public void createDenied(int id) throws SQLException;
	public void createPending(int id) throws SQLException;
	public void createSupervisorApproved(int id) throws SQLException;
	public void createBencoApproved(int id) throws SQLException;
	public void deletePending(int id) throws SQLException;
}
