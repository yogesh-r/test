package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.LookupMaster;

public interface LookUpDao {
	List<LookupMaster> getLookUpValuesData(String lookUpValue);
	List<LookupMaster> getLookupData(String lookupType );
}
