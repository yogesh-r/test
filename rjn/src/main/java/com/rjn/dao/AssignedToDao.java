package com.rjn.dao;

import java.util.List;

import com.rjn.model.ProfileMaster;

public interface AssignedToDao {
	List<ProfileMaster> getAssignedTo(String assignedTo,String partnerID);
}
