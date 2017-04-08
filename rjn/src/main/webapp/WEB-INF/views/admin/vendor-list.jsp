<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="vendorListCtrl">
	<div ng-if="!displayAddForm" class="col-md-1">
		<button ng-click="addForm();" class="form-control btn-primary pull-left">Add</button>
	</div>
	<div ng-if="displayAddForm">
		<div class="row"></br>
			<div class="text-center"><b>Register Vendor<b></div>
		</div>
		<div class="col-md-10">
			<div class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2">First Name:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="editVendor.vendorFirstName"
							class="form-control" value="{{editVendor.vendorFirstName}}"
							required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Last Name:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="editVendor.vendorSurname"
							name="vendorSurname" class="form-control"
							value="{{editVendor.vendorSurname}}" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Email Id:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="editVendor.email" name="email"
							value="{{editVendor.email}}" class="form-control" required />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Contact Number:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="editVendor.pContact" name="pContact"
							class="form-control" required pattern=[0-9]{10} maxlength="10"
							value="{{editVendor.pContact}}">
					</div>
				</div>
 	
 				<div class="form-group">
					<label class="control-label col-sm-2">City:</label>
					<div class="col-sm-10">
						<select name="cityId" class="form-control">
							<c:forEach items="${cityList}" var="thisCity">
							    <option value="${thisCity.id}">${thisCity.city}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<%@include file="../auto-complete.jsp"%>

				<div class="form-group">
					<div class="col-md-2">
						<button ng-click="saveVendor(editVendor)" class="form-control btn-primary">Save</button>
					</div>
					<div class="col-md-2">
						<button ng-click="closeForm();" class="form-control btn-primary">Close</button>
					</div>
				</div>

				<input type="hidden" ng-model="editVendor.latitude"
					class="field form-control" id="latitude"
					value="{{editVendor.latitude}" name="latitude"></input> <input
					ng-model="editVendor.longitude" type="hidden"
					class="field form-control" id="longitude"
					value="{{editVendor.longitude}" name="longitude"></input> <input
					ng-model="editVendor.id" type="hidden" class="field form-control"
					value="{{editVendor.id}}" name="id"></input>
				<div class="form-group">
				</div>
			</div>
		</div>
	</div>

	<div ng-if="!displayAddForm">
		<input type="hidden" ng-model="vendorProfileRowCount"
			ng-init="init('${vendorProfileRowCount}')" />
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
					<td><div ng-click="editForm(thisVendor.id);"><a style="cursor:pointer;">edit</a></div></td>
				</tr>
			</tbody>
		</table>
		<c:if test="${vendorProfileRowCount gt 2}">
			<input ng-show="isLoadMore" type="button" value="Load More"
				ng-click="loadMore();" />
		</c:if>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-list.js"></script>	