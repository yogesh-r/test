<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="vendorProductListCtrl">
	<div ng-if="!displayAddForm" class="col-md-1">
		<button ng-click="addForm();"
			class="form-control btn-primary pull-left">Add</button>
	</div>
	<div ng-if="displayAddForm">
		</br> </br> </br> </br> </br>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td><span>Category</span></td>
					<td>
						<div class='form-group'>
							<select ng-model="thisProduct.productCategoryId"
								class="form-control" name="productCategoryId">
								<c:forEach items="${categoryList}" var="thisCategory"
									varStatus="status">
									<option value="${thisCategory.id}">${thisCategory.name}</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td><span>Branch</span></td>
					<td>
						<div class='form-group'>
							<select ng-model="thisProduct.branchId" class="form-control"
								name="branchId">
								<c:forEach items="${branchList}" var="thisCategory"
									varStatus="status">
									<option value="${thisCategory.id}">${thisCategory.branchName}</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td><span>Key word</span></td>
					<td>
						<div class='form-group'>
							<input ng-model="thisProduct.keyWord" type='text' name='keyWord'
								value="${thisVendor.keyWord}" class='form-control' />
						</div>
					</td>
				</tr>
				<tr>
					<td><span>Name</span></td>
					<td>
						<div class='form-group'>
							<input ng-model="thisProduct.name" type='text' name='name'
								value="${thisVendor.name}" class='form-control' />
						</div>
					</td>
				</tr>
				<tr>
					<td><span>Description</span></td>
					<td colspan='3'><textarea style='resize: none;'
							ng-model="thisProduct.description" class="form-control"
							name="description" required />${thisVendor.description}</textarea></td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col-md-1">
				<button ng-click="saveProduct(thisProduct);"
					class="form-control btn-primary">Save</button>
			</div>
			<div class="col-md-1">
				<button ng-click="closeForm();" class="form-control btn-primary" />
				Close
				</button>
			</div>
		</div>
	</div>
	<div ng-if="!displayAddForm">
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="thisProduct in productList">
					<td>{{thisProduct.name}}</td>
					<td>{{thisProduct.description}}</td>
					<td><div style="cursor: pointer;"
							ng-click="editForm(thisProduct.uniqueId);">
							<a>edit</a>
						</div></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor_product_list.js"></script>