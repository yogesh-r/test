<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="categoryListCtrl">
	<div class="col-md-1">
		<input ng-click="addForm();" class="form-control btn-primary pull-left" value="Add" />
	</div>
	<div ng-if="displayAddForm">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td colspan="6">
						<h5
							style="text-align: center; margin-bottom: 5px; margin-top: 5px">Register
							Category</h5>
					</td>
				</tr>
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
				<tr>
					<td colspan='3'><input value="Save Category"
						ng-click="saveCategory(editCategory)"
						class="form-control btn-primary" type="button">
						</td>
						<input ng-click="closeForm();" class="form-control btn-primary" value="Close" />
				</tr>
				<input type="hidden" name="id" value="{{editCategory.id}}" />
			</tbody>
		</table>
	</div>
	<div ng-if="!displayAddForm">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Action</th>
					<th>Name</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="thisCategory in categoryList">
					<td><div ng-click="editForm(thisCategory.id);">edit</div></td>
					<td>{{thisCategory.name}}</td>
					<td>{{thisCategory.description}}</td>

				</tr>
			</tbody>
		</table>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/category-list.js"></script>
