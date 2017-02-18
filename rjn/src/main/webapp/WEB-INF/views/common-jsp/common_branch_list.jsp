<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="branchListCtrl">
	<div class="col-md-1">
		<input ng-click="addForm();" class="form-control btn-primary pull-left" value="Add" />
	</div>
	<div ng-if="displayAddForm">	
		<div class="form-group">
		<label class="control-label col-sm-2">Vendor:</label>
		<div class="col-sm-10">
			<c:choose>
				<c:when test="${allVendors ne null}">
					<select name="branchOwner" ng-model="editbranch.branchOwner" class="form-control" id="branch_owner">
						<option value="{{editbranch.branchOwner}}">{{editbranch.branchOwner}}</option>
						
					</select>
				</c:when>
			</c:choose>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Name:</label>
			<div class="col-sm-10">
				<input type="text" ng-model="editbranch.branchName" value="{{editbranch.branchName}}" id="branchName"
					name="branchName" class="form-control" required />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Start Date:</label>
			<div class="col-sm-10">
				<input ng-model="editbranch.startDate" value="{{editbranch.startDate}}"  type='text'
					class="form-control" name="startDate" id="duedate"
					placeholder="Start Date" required />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">contact No:</label>
			<div class="col-sm-10">
				<input ng-model="editbranch.contactNo" value="{{editbranch.contactNo}}" type='text'
					class="form-control" name="contactNo"
					placeholder="Contact No" required />
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-sm-2">Description:</label>
			<div class="col-sm-10">
				<TEXTAREA name="description" class="form-control" rows="4"
					maxlength="500" ng-model="editbranch.description" required>{{editbranch.description}}</TEXTAREA>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Address:</label>
			<div class="col-sm-10">
				<input id="autocomplete" ng-model="editbranch.address" name="address" placeholder="Enter your address"
					value="{{editbranch.address}}" type="text" class="form-control"></input>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Location:</label>
			<div class="col-sm-10">
				<input class="field form-control" ng-model="editbranch.location" value="{{editbranch.location}}"
					id="sublocality_level_1" name="location" readOnly required></input>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">City:</label>
			<div class="col-sm-10">
				<input class="field form-control" ng-model="editbranch.city" id="locality"
					value="{{editbranch.city}}" name="city" required readOnly></input>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Country:</label>
			<div class="col-sm-10">
				<input value="{{editbranch.country}}" ng-model="editbranch.country" class="field form-control"
					name="country" id="country" readOnly></input>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">ZipCode:</label>
			<div class="col-sm-10">
				<input type="text" name="zipcode" id="postal_code"
					value="{{editbranch.zipcode}}" ng-model="editbranch.zipcode" class="field form-control" readOnly>
			</div>
		</div>
		<div class="form-group">
			<input value="Save Category"
						ng-click="saveBranch(editbranch)"
						class="form-control btn-primary" type="button">
		</div>
		
	</div>
	</div>
	<div  ng-if="!displayAddForm">
	<form name="form1" id="form1"
		action="p_update_branch_master_details.jsp" method="GET">
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
			<tbody id="ResultArea">
				
					<tr ng-repeat="thisBranch in branchList">
						
						<td>
							{{thisBranch.id}}
						</td>
						<td>{{thisBranch.branchName}}</td>
						<td>{{thisBranch.contactNo}}</td>
						<td>{{thisBranch.address}}</td>
						<td><div ng-click="editForm(thisBranch.id);">edit</div></td>
					</tr>
				
			</tbody>
		</table>
	</form>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/branch-list.js"></script>
