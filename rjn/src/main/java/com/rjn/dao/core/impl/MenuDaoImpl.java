package com.rjn.dao.core.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.MenuDao;
import com.rjn.model.core.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends AbstractDao<Integer, Menu> implements MenuDao {

	@Override
	public List<Menu> getMenu(String role) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("role", role));
		return (List<Menu>) criteria.list();
	}
}
