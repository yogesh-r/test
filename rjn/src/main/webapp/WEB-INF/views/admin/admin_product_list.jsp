<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="adminProductDetails">
	<div ng-if="!displayAdd" class="col-md-1">
		<button ng-click="addForm();"
			class="form-control btn-primary pull-left">Add</button>
	</div>
	<br> <br>
	<div ng-if="displayAdd">
		<div class="row">
			</br>
			<div class="text-center">
				<b>Register Product<b>
			</div>
		</div>
		<div class="col-md-10">
			<div class="form-horizontal">

				<div class="form-group">
					<label class="control-label col-sm-2">Vendor Id:</label>
					<div class="col-sm-10">
						<select class="form-control" name="vendor_id" id="vendor_id"
							ng-model="editProduct.vendorId"
							ng-change="loadBranch(editProduct.vendorId)">
							<c:forEach items="${vendorProfile}" var="vendorProfile">
								<option value="${vendorProfile.id}">${vendorProfile.id}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Branch:</label>
					<div class="col-sm-10">
						<select class="form-control" ng-repeat="thisBranch in branchName"
							name="branch" id="branch" ng-model="editProduct.branchId">
							<option value="{{thisBranch.id}}">{{thisBranch.branchName}}</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2">Keyword:</label>
					<div class="col-sm-10">
						<input type="text" name="keyWord" class="form-control"
							ng-model="editProduct.keyWord" value="{{editProduct.keyWord}}"
							required>
					</div>
				</div>
				
								
				<div class="form-group">
					<label class="control-label col-sm-2">Product Name:</label>
					<div class="col-sm-10">
						<input type="text" name="productName" class="form-control"
							ng-model="editProduct.name" value="{{editProduct.productName}}"
							required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Description:</label>
					<div class="col-sm-10">
						<input type="text" name="desc" class="form-control"
							ng-model="editProduct.description" value="{{editProduct.desc}}"
							required>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">
						<button ng-click="saveProduct(editProduct);"
							class="form-control btn-primary">Save</button>
					</div>
					<div class="col-md-2">
						<button ng-click="closeForm();" class="form-control btn-primary">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div ng-if="!displayAdd">
		<div class="row">
			<div class="col-md-2">
				<label>Vendor</label> <br> <select class="form-control"
					name="branchOwner" id="branchOwner" ng-model="branchOwner"
					ng-change="loadBranch(branchOwner)">
					<c:forEach items="${vendorProfile}" var="vendorProfile">
						<option value="${vendorProfile.id}">${vendorProfile.id}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<label>Branch Name</label><br> <select class="form-control"
					ng-repeat="thisBranch in branchName" ng-model="branchName">
					<option value="{{thisBranch.id}}">{{thisBranch.branchName}}</option>
				</select>
			</div>
			<div class="col-md-2">
				<br>
				<button ng-model="input" ng-click="getData(branchOwner,branchName)"
					class="btn btn-primary">Show</button>
			</div>
		</div>
		<br>
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="thisProduct in productData">
					<td>{{thisProduct.name}}</td>
					<td>{{thisProduct.description}}</td>
					<td>
						<div>
							<a style="cursor: pointer;"
								ng-click="editForm(thisProduct.uniqueId);">edit</a>, <a
								style="cursor: pointer;"
								ng-click="deleteProduct(thisProduct.uniqueId);">delete</a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/admin_product_list.js"></script>