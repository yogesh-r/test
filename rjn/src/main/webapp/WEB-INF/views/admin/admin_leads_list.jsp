<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<div class="content" ng-controller="adminLeadsCtrl">
	<!--  <div class="col-md-3" ng-click="readLead(read);">
		<a style="cursor:pointer;">Read lead</a>
	</div>
	
	<div class="col-md-2" ng-click="allLead();">
		<a style="cursor:pointer;">All leads</a>
	</div>-->
	<div class="col-md-3" >
		<select name="change" id="change" ng-model="change" ng-change="readLead(change)">
			<option value="read">read</option>
			<option value="unread">unread</option>
			<option value="all">all</option>
		</select>
	</div>
	<table id="myTable" class="table table-striped">
		<thead>
			<tr>
				<th>Customer name</th>
				<th>Vendor name</th>
				<th>Phone no</th>
				<th>Hits</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="thisLeads in leadList">
				<td>{{thisLeads.name}}</td>
				<td>{{thisLeads.vendorName}}</td>
				<td>{{thisLeads.mobileNo}}</td>
				<td>{{thisLeads.visitCount}}</td>
				<td>{{thisLeads.adminStatus}}</td>
				<td ng-if="thisLeads.adminStatus == 'read'">
				Read Lead
				</td>
				<td ng-if="thisLeads.adminStatus == 'unread'">
				<button ng-click="markRead(thisLeads.id,thisLeads.adminStatus)">Mark as Read</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/admin_leads.js"></script>