package com.rjn.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.rjn.bean.SearchBean;
import com.rjn.dao.TestQueryDao;
import com.rjn.dao.core.AbstractDao;

@Repository("testQueryDao")
public class TestQueryDaoImpl extends AbstractDao<Integer, SearchBean> implements TestQueryDao {
 
	@Override 
	public List findAll() {
		String hql = "SELECT DISTINCT a.BranchCode, substring(a.BranchName,1, 35) BranchName,"+
				"a.BranchOwner, a.Description, a.zipcode, CONVERT(min(fp.standard_price), SIGNED INTEGER) price , "+
				" fp.category, a.specialization, a.contactno, a.emailid, a.address, a.city,  a.managername, a.manager_email,"+
				"a.manager_mobile, a.land_line, a.location,b.img1,b.img2,b.img3,b.img4,b.img5,   "+
				" a.verify ,a.latitude,a.longitude, "+
				" ROUND((p.distance_unit"+
				"   * DEGREES(ACOS(COS(RADIANS(p.latpoint))"+
				"    * COS(RADIANS(a.latitude))"+
				"   * COS(RADIANS(p.longpoint) - RADIANS(a.longitude))"+
				"   + SIN(RADIANS(p.latpoint))"+
				"   * SIN(RADIANS(a.latitude))))),2) distance "+
				"  FROM branch_profile a , tx_branch_images b, tx_facility_master fm, tx_facility_price fp"+ 
				"  JOIN (   /* these are the query parameters */"+
				"   SELECT  '' AS latpoint,  '' AS longpoint,"+
				"         50.0 AS radius,      111.045 AS distance_unit"+
				" ) AS p ON 1=1"+
				" WHERE a.BranchCode=b.branch_id"+
				" AND a.BranchCode=fm.branch_id"+
				" AND a.branchCode=fp.branch_id"+
				" AND fm.fac_id = fp.facility_id "+
				"  AND a.branchowner = if('PREG-00-0000-000'  = 'PREG-00-0000-000',a.branchowner,'PREG-00-0000-000' )"+
				" AND a.specialization = 'P'  " +
				" AND fm.fac_type = 'Open Seats' " +
				" AND fp.category = 'Monthly' " +
				" AND fp.standard_price> 0 "+
				" AND fp.standard_price<= 100000 " +
				" AND ( p.distance_unit"+
				"      * DEGREES(ACOS(COS(RADIANS(p.latpoint))"+
				"      * COS(RADIANS(a.latitude))"+
				"       * COS(RADIANS(p.longpoint) - RADIANS(a.longitude))"+
				"       + SIN(RADIANS(p.latpoint))"+
				"       * SIN(RADIANS(a.latitude))))) between 0 and 15 " +
				"  AND a.latitude"+
				" BETWEEN p.latpoint  - (p.radius / p.distance_unit)"+
				"     AND p.latpoint  + (p.radius / p.distance_unit)"+
				" AND a.longitude"+
				" BETWEEN p.longpoint - (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))"+
				"     AND p.longpoint + (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))"+
				" GROUP BY a.BranchCode, a.BranchName, a.BranchOwner, a.Description, "+
				" a.zipcode, fp.category, a.specialization, a.contactno,  a.emailid, "+
				" a.address, a.city,  a.managername, a.manager_email, a.manager_mobile,"+
				" a.land_line, a.location,b.img1,b.img2,b.img3,b.img4,b.img5"+
				" ORDER BY distance ";
		
		
		Query query = getSession().createSQLQuery(hql);
		List results = query.list();
		
/*		for (Object o : result) {
				
			((SearchBean)o).getBranchCode();
			
		}*/
		
		
		
		//Iterator iterator= query.list().iterator();
		SearchBean thisSearchBean;
		ArrayList<SearchBean> searchBeanList = new ArrayList<>();
		Iterator iterator= query.list().iterator();
		    while(iterator.hasNext()){
		        Object[] tuple= (Object[]) iterator.next();
		        thisSearchBean= new SearchBean();
/*		        
		        thisSearchBean.setBranchCode((String)tuple[0]);
		        thisSearchBean.setBranchName((String)tuple[1]);
		        thisSearchBean.setBranchOwner((String)tuple[2]);
		        thisSearchBean.setDescription((String)tuple[3]);
		        thisSearchBean.setZipcode((String)tuple[4]);
		        //thisSearchBean.setPrice((long)tuple[5]);
		        thisSearchBean.setCategory((String)tuple[6]);
		        thisSearchBean.setSpecialization((String)tuple[7]);
		        thisSearchBean.setContactNo((String)tuple[8]);
		        thisSearchBean.setEmailId((String)tuple[9]);
		        thisSearchBean.setAddress((String)tuple[10]);
		        thisSearchBean.setCity((String)tuple[11]);
		        thisSearchBean.setManagerName((String)tuple[12]);
		        thisSearchBean.setEmailId((String)tuple[13]);
		        thisSearchBean.setManagerMobile((String)tuple[14]);
		        thisSearchBean.setLandLine((String)tuple[15]);
		        thisSearchBean.setImg1((String)tuple[16]);
		        thisSearchBean.setImg2((String)tuple[17]);
		        thisSearchBean.setImg3((String)tuple[18]);
		        thisSearchBean.setImg4((String)tuple[19]);
		        thisSearchBean.setImg5((String)tuple[20]);
		        thisSearchBean.setVerify((String)tuple[21]);
		        thisSearchBean.setLongitude((String)tuple[22]);
		        thisSearchBean.setDistance((String)tuple[23]);*/
		        searchBeanList.add(thisSearchBean);
		    }
		return null;
	}
}