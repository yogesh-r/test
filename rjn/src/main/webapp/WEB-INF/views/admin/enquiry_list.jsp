<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="enquiryListCtrl">
	<div>
		  <input type="hidden" ng-model="enquiryListCount"
			ng-init="init('${enquiryListCount}')" />
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Contact Person</th>
					<th>Property Name</th>
					<th>Contact No</th>
					<th>Email</th>
			</thead>
			<tbody id="ResultArea">
				<tr ng-repeat="thisEnquiry in enquiryList">
					<td>{{thisEnquiry.enquiryId}}</td>
					<td>{{thisEnquiry.venueManagerName}}</td>
					<td>{{thisEnquiry.mobileNo}}</td>
					<td>{{thisEnquiry.email}}</td>
					
				</tr>
			</tbody>
		</table>
		
		<c:if test="${enquiryListCount gt 2}">
			<input ng-show="isLoadMore" type="button" value="Load More"
				ng-click="loadMore();" />
		</c:if>


	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/enquiry-list.js"></script>