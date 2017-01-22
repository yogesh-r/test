<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-10 col-md-offset-1">
	<form action="${rc.getContextPath()}/admin/register-category"
		method="post">
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
							<input type='text' name='name' value="${thisCategory.name}"
								class='form-control' />
						</div>
					</td>
				</tr>
				<tr>
					<td><span>Description</span></td>
					<td colspan='3'><textarea style='resize: none;'
							class="form-control" name="description" required >${thisCategory.description}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan='3'><input value="Save Category"
						class="form-control btn-primary" type="submit"></td>
				</tr>
				<input type="hidden" name="id" value="${thisCategory.id}" />
			</tbody>
		</table>
	</form>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<form action="${rc.getContextPath()}/admin/bulk-register-category" method="POST" enctype="multipart/form-data">
				<label>upload excel</label> <input type="file" name="excelfile" /> 
				<input type="submit" value="Upload" />
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>

