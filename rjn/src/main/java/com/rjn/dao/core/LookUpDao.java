package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.LookupMaster;

public interface LookUpDao {
	public List<LookupMaster> getLookUpValuesData(String lookUpValue);
	public List<LookupMaster> getLookupData(String lookupType );
}
