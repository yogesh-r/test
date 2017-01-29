<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product List</title>
<meta name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body id="body">
	<br>
	<div class="main">
		<div class="container">
			<div style="height: 20px; line-height: 20px;">
				<label>Select Branch</label>
				<select>
					<c:forEach items="${branchList}" var="thisBranch" varStatus="status">
						<option value="${thisBranch.id}">${thisBranch.branchName}</option>
					</c:forEach>
				</select>
				
<%-- 				<label>Select Product</label>
				<select>
					<c:forEach items="${productList}" var="thisProduct" varStatus="status">
						<option value="${thisProduct.id}">${thisProduct.name}</option>
					</c:forEach>
				</select> --%>
			</div>
			<div style="overflow-x: scroll; height: 450px; width: 100%;">
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
		</div>
	</div>
</body>
</html>