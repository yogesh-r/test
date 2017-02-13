<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" ng-controller="vendorListCtrl">
	<input type="hidden" ng-model="vendorProfileRowCount"  ng-init="init('${vendorProfileRowCount}')" />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Vendor ID</th>
				<th>First Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Action</th>
		</thead>
		<tbody id="ResultArea">
			<tr ng-repeat="thisVendor in vendorList">
				<td>{{thisVendor.id}}</td>
				<td>{{thisVendor.vendorFirstName}}</td>
				<td>{{thisVendor.address}}</td>
				<td>{{thisVendor.city}}</td>
				<td><a
					href="${rc.getContextPath()}/admin/register-vendor/{{thisVendor.id}}">edit</a></td>
			</tr>
		</tbody>
	</table>
	<c:if test="${vendorProfileRowCount gt 2}">
		<input ng-show="isLoadMore" type="button" value="Load More" ng-click="loadMore();" />	
	</c:if>
</div>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-list.js"></script>