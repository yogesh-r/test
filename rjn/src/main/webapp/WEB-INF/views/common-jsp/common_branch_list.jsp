<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main">
	<div class="container">
		<input type='hidden' id='user_id' value=''>
		<div class="panel panel-info">
			<div class="panel-heading">Registered Branch Details</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
					
							<span>Vendor<label></label></span>
							<c:choose>
								<c:when test="${allPartners ne null}">
									<select
										name="branchOwner" class="form-control" id="branch_owner">
										<c:forEach items="${PartnerDetails}" var="thisVendor" >
											<option value="${thisVendor.id}">${thisVendor.id}</option>
										</c:forEach>
									</select>
								</c:when>
								<c:otherwise>
									<select
										name="branchOwner" class="form-control" id="branch_owner">
										<option value="${PartnerDetails.id}">${PartnerDetails.id}</option>
									</select>
								</c:otherwise>
							</c:choose>
					</div>
				</div>
			</div>
		</div>
		<div style="overflow-x: scroll; height: 450px; width: 100%;">
			<form name="form1" id="form1"
				action="p_update_branch_master_details.jsp" method="GET">
				<table id="myTable" class="table table-striped">
					<thead>
						<tr>
							<th>Branch Code</th>
							<th>Branch Name</th>
							<th>Contact No</th>
							<th>Address</th>
							<th>Book Through Enquiry</th>
						</tr>
					</thead>
					<tbody id="ResultArea">
						<c:forEach items="${branchList}" var="thisBranch"
							varStatus="status">
							<tr>
								<td>${thisBranch.id}</td>
								<td>${thisBranch.branchName}</td>
								<td>${thisBranch.contactno}</td>
								<td>${thisBranch.address}</td>
								<td><a
									href="${rc.getContextPath()}/vendor/register-branch/${thisBranch.uniqueId}">edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</div>