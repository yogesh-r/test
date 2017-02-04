<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../header/vendor_header.jsp"%>
<div class="container">
	<c:choose>
		<c:when test="${not empty errorMessage}">
      ${errorMessage}
    </c:when>
		<c:otherwise>
			<form action="${rc.getContextPath()}/vendor/register-branch"
				method="post">
				<%@include file="../common-jsp/add_branch.jsp"%>
			</form>
		</c:otherwise>
	</c:choose>
</div>
