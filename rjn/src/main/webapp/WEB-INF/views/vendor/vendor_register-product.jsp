<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header/vendor_header.jsp"%>
<div class="page-header" style="margin: 0px;"></div>
	<div class="col-md-10 col-md-offset-1">${errorMessage}
		<div class="table-responsive" style="overflow: hidden">
			<form action="${rc.getContextPath()}/vendor/product/register-product" method="POST">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td colspan="6">
								<h5
									style="text-align: center; margin-bottom: 5px; margin-top: 5px">Register
									Product</h5>
							</td>
						</tr>
						
						<tr>
							<td><span>Category</span></td>
							<td>
								<div class='form-group'>
									<select class="form-control" name="productCategoryId">
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
									<select class="form-control" name="branchId">
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
									<input type='text' name='keyWord' value="${thisVendor.keyWord}"
										class='form-control' />
								</div>
							</td>
						</tr>
						<tr>
							<td><span>Name</span></td>
							<td>
								<div class='form-group'>
									<input type='text' name='name' value="${thisVendor.name}"
										class='form-control' />
								</div>
							</td>
						</tr> 
						<tr>
							<td><span>Description</span></td>
							<td colspan='3'><textarea style='resize: none;'
									class="form-control" name="description" required />${thisVendor.description}</textarea>
							</td>
						</tr>
						<tr>
							<td colspan='3'><input value="Save Product"
								class="form-control btn-primary" type="submit"></td>
						</tr>
						<input type="hidden" name="id" value="${thisVendor.id}" />
						<input type="hidden" name="id" value="${thisVendor.id}" />
					</tbody>
				</table>
			</form>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					 <label>upload excel</label>  
					<input type="file" />
					<input type="button" value="Upload"/>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
