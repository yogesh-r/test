package com.rjn.dao.core;

import com.rjn.model.SeqId;

public interface SequenceGeneratorDao {
	
	SeqId getSeqId(String sequenceName);
}
