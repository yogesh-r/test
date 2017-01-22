package com.rjn.dao.core.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.SequenceGeneratorDao;
import com.rjn.model.SeqId;

@Repository("sequenceGeneratorDao")
public class SequenceGeneratorDaoImpl extends AbstractDao<Integer, SeqId> implements SequenceGeneratorDao {

	@Override
	public SeqId getSeqId(String sequenceName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("seqName", sequenceName));
		SeqId sid = (SeqId) criteria.uniqueResult();
		
		
		SeqId sidNew = sid;
		sidNew.setSeqNum(sid.getSeqNum() + 1);
		persist(sidNew);
		
		return sid;
	}
}
