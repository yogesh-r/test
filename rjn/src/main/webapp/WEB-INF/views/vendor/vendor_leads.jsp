<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<div class="content">
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Phone no</th>
					<th>Hits</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leads}" var="thisLeads" varStatus="status">
					<tr>
						<td>${thisLeads.name}</td>
						<td>${thisLeads.mobileNo}</td>
						<td>${thisLeads.visitCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>