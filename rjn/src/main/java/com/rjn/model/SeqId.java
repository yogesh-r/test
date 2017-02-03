package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tx_seq_id")
public class SeqId {
	
	@Id
	@Column(name = "Seq_name", nullable = false)
	private String seqName;
	
	@Column(name = "Seq_Num", nullable = false)
	private int  seqNum;

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
}
