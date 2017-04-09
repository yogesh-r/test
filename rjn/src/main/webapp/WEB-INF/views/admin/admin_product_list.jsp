<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="adminProductDetails">
	<div class="main">
		<div class="container">
			<div class="row">
			<div class="col-md-2" >
				<label>Vendor</label>
				<br>
				<select class="form-control" name="branchOwner" id="branchOwner" ng-model="branchOwner" 
						ng-change="loadBranch(branchOwner)">
					<c:forEach items="${vendorProfile}" var="vendorProfile">
						<option value="">Select Vendor</option>
						<option value="${vendorProfile.id}">${vendorProfile.id}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<label>Branch Name</label><br>
				<select class="form-control" ng-repeat="thisBranch in branchName" ng-model="branchName">
					<option value="">Select Branch</option>
					<option value="{{thisBranch.branchName}}">{{thisBranch.branchName}}</option>
				</select>	
			</div>
			<div class="col-md-2">
			<br>
				<button ng-model="input" ng-click="getData()" class="btn btn-primary">Show</button>
			</div>
			</div>
			<br>
			<div ng-if="displayAddForm">
					<table class="table table-bordered" style="width:75%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
						</tr>
					</thead>
						<tbody>
							<tr ng-repeat="thisProduct in productData">
								<td>{{thisProduct.name}}</td>
								<td>{{thisProduct.description}}</td>
							</tr>
						</tbody>
					</table>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/admin_product_list.js"></script>