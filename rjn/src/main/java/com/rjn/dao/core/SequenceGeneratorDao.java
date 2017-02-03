package com.rjn.dao.core;

import com.rjn.model.SeqId;

public interface SequenceGeneratorDao {
	public SeqId getSeqId(String sequenceName);
}
