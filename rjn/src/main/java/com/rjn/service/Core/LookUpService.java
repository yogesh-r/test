package com.rjn.service.Core;

import java.util.List;

import com.rjn.model.core.LookupMaster;

public interface LookUpService {
	
	List<LookupMaster> getLookUpValuesData(String lookUpValue);

}
