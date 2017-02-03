<%@include file="../admin/admin_header.jsp"%>
<%@include file="../include/date_include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty errorMessage}">
      ${errorMessage}
    </c:when>
			<c:otherwise>
				<form action="${rc.getContextPath()}/admin/register-branch"
					method="post">
						<%@include file="../common-jsp/add_branch.jsp"%>

				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>

