package com.rjn.service.Core;

import com.rjn.model.SeqId;

public interface SequenceGeneratorService {
	SeqId getSeqId(String sequenceName);
}
