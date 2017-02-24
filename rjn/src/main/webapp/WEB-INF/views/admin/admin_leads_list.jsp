<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<div class="content" ng-controller="adminLeadsCtrl">
	<table id="myTable" class="table table-striped">
		<thead>
			<tr>
				<th>Customer name</th>
				<th>Vendor name</th>
				<th>Phone no</th>
				<th>Hits</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
				<tr ng-repeat="thisLeads in leadList">
					<td>{{thisLeads.name}}</td>
					<td>{{thisLeads.vendorName}}</td>
					<td>{{thisLeads.mobileNo}}</td>
					<td>{{thisLeads.visitCount}}</td>
					<td>{{thisLeads.adminStatus}}</td>
					
				</tr>
		</tbody>
	</table>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/admin_leads.js"></script>