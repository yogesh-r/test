<%@ include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="vendorBranchListCtrl">
	<div class="col-md-1">
		<button ng-click="addForm();"
			class="form-control btn-primary pull-left">Add</button>
	</div>
	<div ng-if="displayAddForm">
		</br> </br> </br>
		<div class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">Vendor:</label>
				<div class="col-sm-10">
					<select ng-model="thisBranch.branchOwner" name="branchOwner"
						class="form-control" id="branch_owner">
						<option value="${vendorDetails.id}">${vendorDetails.id}</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Name:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.branchName" type="text"
						value="{{thisBranch.branchName}}" id="branchName"
						name="branchName" class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Start Date:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.startDate"
						value="{{thisBranch.startDate}}" type='text' class="form-control"
						name="startDate" id="duedate" placeholder="Start Date" required />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">contact No:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.contactNo"
						value="{{thisBranch.contactNo}}" type='text' class="form-control"
						name="contactNo" placeholder="Contact No" required />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Description:</label>
				<div class="col-sm-10">
					<TEXTAREA ng-model="thisBranch.description" name="description"
						class="form-control" rows="4" maxlength="500" required>{{thisBranch.description}}</TEXTAREA>
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
			
				<%@include file="../auto-complete-branch.jsp"%>
				
				
			<input ng-model="thisBranch.latitude" type="hidden"
				class="field form-control" id="latitude"
				value="{{thisBranch.latitude}}" name="latitude"></input> <input
				ng-model="thisBranch.longitude" type="hidden"
				class="field form-control" id="longitude"
				value="{{thisBranch.longitude}}" name="longitude"></input> <input
				ng-model="thisBranch.id" type="hidden" class="field form-control"
				value="{{thisBranch.id}}" name="id"></input>
		</div>
		<div class="row">
			<div class="col-md-1">
				<button ng-click="saveBranch(thisBranch)"
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
					<th>Branch Code</th>
					<th>Branch Name</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="thisBranch in branchList">
					<td>{{thisBranch.id}}</td>
					<td>{{thisBranch.branchName}}</td>
					<td>{{thisBranch.contactNo}}</td>
					<td>{{thisBranch.address}}</td>
					<td><div ng-click="editForm(thisBranch.uniqueId);"><a style="cursor:pointer;">edit</a></div></td>
				</tr>
			</tbody>
			<input type="hidden" name="id" value="{{thisBranch.id}}" />
		</table>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-branch-list.js"></script>
