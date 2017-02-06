<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div style="overflow-x: scroll; height: 450px; width: 100%;">
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
					<c:forEach items="${vendorList}" var="thisVendor"
						varStatus="status">
						<tr>
							<td>${thisVendor.id}</td>
							<td>${thisVendor.vendorFirstName}</td>
							<td>${thisVendor.address}</td>
							<td>${thisVendor.city}</td>
							<td><a href="${rc.getContextPath()}/admin/register-vendor/${thisVendor.id}">edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</div>