<title>Category List</title>
<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div style="overflow-x: scroll; height: 450px; width: 100%;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryList}" var="thisCategory"
					varStatus="status">
					<tr>
						<td>${thisCategory.name}</td>
						<td>${thisCategory.description}</td>
						<td><a
							href="${rc.getContextPath()}/admin/register-category/${thisCategory.id}">edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
