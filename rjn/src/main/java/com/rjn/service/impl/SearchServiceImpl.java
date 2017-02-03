package com.rjn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.bean.SearchBean;
import com.rjn.dao.SearchDao;
import com.rjn.service.SearchService;

@Service("searchService")
@Transactional
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao dao;

	@Override
	public List<SearchBean> findBranches(SearchBean searchBean) {
		return dao.findBranches(searchBean); 
	}

	@Override
	public List<SearchBean> findVendors(SearchBean bean) {
		return dao.findVendors(bean); 
	}
}
