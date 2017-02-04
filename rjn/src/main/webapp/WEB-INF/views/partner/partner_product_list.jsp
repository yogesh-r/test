<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main">
	<div class="container">
		<div style="height: 20px; line-height: 20px; font-size: 10px;"></div>
		<div style="overflow-x: scroll; height: 450px; width: 100%;">
			<table id="myTable" class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="thisProduct"
						varStatus="status">
						<tr>
							<td>${thisProduct.name}</td>
							<td>${thisProduct.description}</td>
							<td><a
								href="${rc.getContextPath()}/vendor/product/register-product/${thisProduct.uniqueId}">edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
