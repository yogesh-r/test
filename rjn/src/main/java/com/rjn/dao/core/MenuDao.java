package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.Menu;

public interface MenuDao {
	public List<Menu> getMenu(String role);
}
