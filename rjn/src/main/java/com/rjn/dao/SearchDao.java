package com.rjn.dao;

import java.util.List;

import com.rjn.bean.SearchBean;

public interface SearchDao {
	List<SearchBean> findBranches(SearchBean bean);
	List<SearchBean> findVendors(SearchBean bean);
}
