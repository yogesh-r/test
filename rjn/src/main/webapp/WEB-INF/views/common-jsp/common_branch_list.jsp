<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content">
	<form name="form1" id="form1"
		action="p_update_branch_master_details.jsp" method="GET">
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Branch Code</th>
					<th>Branch Name</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="ResultArea">
				<c:forEach items="${branchList}" var="thisBranch" varStatus="status">
					<tr>
						<td>${thisBranch.id}</td>
						<td>${thisBranch.branchName}</td>
						<td>${thisBranch.contactNo}</td>
						<td>${thisBranch.address}</td>
						<td><a
							href="${rc.getContextPath()}/vendor/register-branch/${thisBranch.uniqueId}">edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
