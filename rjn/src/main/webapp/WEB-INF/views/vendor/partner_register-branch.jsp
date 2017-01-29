<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>New Branch| Creation</title>
<meta name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head><%@include file="../header/vendor_header.jsp"%>

<body>
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
</body>
