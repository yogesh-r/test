<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" ng-controller="vendorsListCtrl">
	<div class="panel panel-default">
		<div class="panel-heading">
			<center>Vendors</center>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-3">
					<span>Search<label></label></span> 
						<input name="branch_owner" class="form-control"></input>
				</div>
			</div>
		</div>
	</div>
	<div style="overflow-x: scroll; height: 450px; width: 100%;">
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
					<c:forEach items="${vendorList}" var="thisVendor"
						varStatus="status">
						<tr>
							<td>${thisVendor.id}</td>
							<td>${thisVendor.partFName}</td>
							<td>${thisVendor.addr}</td>
							<td>${thisVendor.city}</td>
							<td><a href="${rc.getContextPath()}/admin/register-vendor/${thisVendor.id}">edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</div>
<script src="${rc.getContextPath()}/resources/js/developerJs/vendor-list.js"></script>