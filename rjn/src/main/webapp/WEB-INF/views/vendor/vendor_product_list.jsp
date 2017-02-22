<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="vendorProductListCtrl">
	<div ng-if="displayAddForm"></br></br></br></br></br>
				<%-- <form action="${rc.getContextPath()}/vendor/product/register-product" method="POST"> --%>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td><span>Category</span></td>
							<td>
								<div class='form-group'>
									<select ng-model="thisProduct.productCategoryId" class="form-control" name="productCategoryId">
										<c:forEach items="${categoryList}" var="thisCategory" varStatus="status">
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
									<select ng-model="thisProduct.branchId" class="form-control" name="branchId">
										<c:forEach items="${branchList}" var="thisCategory" varStatus="status">
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
									<input ng-model="thisProduct.keyWord" type='text' name='keyWord' value="${thisVendor.keyWord}"
										class='form-control' />
								</div>
							</td>
						</tr>
						<tr>
							<td><span>Name</span></td>
							<td>
								<div class='form-group'>
									<input ng-model="thisProduct.name" type='text' name='name' value="${thisVendor.name}"
										class='form-control' />
								</div>
							</td>
						</tr> 
						<tr>
							<td><span>Description</span></td>
							<td colspan='3'><textarea style='resize: none;'
									ng-model="thisProduct.description"class="form-control" name="description" required />${thisVendor.description}</textarea>
							</td>
						</tr>
						<tr>
							<td colspan='3'><input value="Save"
								ng-click="saveProduct(thisProduct);" class="form-control btn-primary" type="button"></td>
								<input ng-click="closeForm();" class="form-control btn-primary" value="Close" />
						</tr>
					</tbody>
				</table>
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
						<td><td><div ng-click="editForm(thisProduct.uniqueId);">edit</div></td></td>
					</tr>
			</tbody>
		</table>
	</div>
	

</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor_product_list.js"></script>

