<%@include file="../admin/admin_header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="main">
		<div class="container">
			<div class="col-md-10">
				<c:choose>
					<c:when test="${not empty errorMessage}">
		      ${errorMessage}
		    </c:when>
					<c:otherwise>
						<form action="${rc.getContextPath()}/admin/register-branch"
							method="post" class="form-horizontal">
							<%@include file="../common-jsp/add_branch.jsp"%>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>