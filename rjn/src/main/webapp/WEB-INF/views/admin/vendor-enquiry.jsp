<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="admin_header.jsp"%>
<div class="main" ng-controller="vendorEnquiryCtrl"> ==={{yogesh}}=={{cc11}}
	<div class="container">
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>Enquiry Number</th>
						<th>Manager Name</th>
						<th>Shop Name</th>
						<th>Mobile No.</th>
						<th>Email</th>
						<th>Address</th>
						<th>Email Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vendorEnquirys}" var="thisEnquiry">
						<tr>
							<td><c:out value="${thisEnquiry.id}" /></td>
							<td><c:out value="${thisEnquiry.enquiryId}" /></td>
							<td><c:out value="${thisEnquiry.venueManagerName}" /></td>
							<td><c:out value="${thisEnquiry.propertyName}" /></td>
							<td><c:out value="${thisEnquiry.mobileNo}" /></td>
							<td><c:out value="${thisEnquiry.email}" /></td>
							<td><c:out value="${thisEnquiry.address}" /></td>
							<td><c:out value="${thisEnquiry.emailStatus}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-enquiry.js"></script>