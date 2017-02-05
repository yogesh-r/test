package com.rjn.dao;

import java.util.List;

import com.rjn.model.CustomerProfile;

public interface AssignedToDao {
	List<CustomerProfile> getAssignedTo(String assignedTo,String vendorID);
}
