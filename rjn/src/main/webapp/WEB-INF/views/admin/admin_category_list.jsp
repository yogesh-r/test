<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="categoryListCtrl">
	<div ng-if="!displayAddForm" class="col-md-1">
		<button ng-click="addForm();"
			class="form-control btn-primary pull-left">Add</button>
	</div>

	<div ng-if="!displayAddForm" class="col-md-7 input-group">
		<input type="file" file-model="myFile" />
		<button ng-click="uploadFile()">upload me</button>
	</div>

	<div ng-if="displayAddForm">
		<div class="row">
			</br>
			<div class="text-center">
				<b>Register Category<b>
			</div>
		</div>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td><span>Name</span></td>
					<td>
						<div class='form-group'>
							<input type='text' name='name' ng-model="editCategory.name"
								value="{{editCategory.name}}" class='form-control' />
						</div>
					</td>
				</tr>
				<tr>
					<td><span>Description</span></td>
					<td colspan='3'><textarea ng-model="editCategory.description"
							style='resize: none;' class="form-control" name="description"
							required>{{editCategory.description}}</textarea></td>
				</tr>
				<input type="hidden" name="id" value="{{editCategory.id}}" />
			</tbody>
		</table>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-1">
				<button ng-click="saveCategory(editCategory)"
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Action</th>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="thisCategory in categoryList">
					<td><div ng-click="editForm(thisCategory.id);">
							<a style="cursor: pointer;">edit</a>
						</div></td>
					<td>{{thisCategory.name}}</td>
					<td>{{thisCategory.description}}</td>
					<td><a href="#" ng-click="deleteCategory(thisCategory.id)"> Delete</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/category-list.js"></script>
