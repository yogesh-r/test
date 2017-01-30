<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
</head>
<body>
<c:choose>
	<c:when test="${headerType eq  'ROLE_ADMIN'}">
	<c:set var="searchUrl" value="${rc.getContextPath()}/admin/search"/>
		<%@include file="admin/admin_header.jsp"%>
	</c:when>
	<c:when test="${headerType eq  'ROLE_PARTNER'}">
	<c:set var="searchUrl" value="${rc.getContextPath()}/vendor/search"/>
		<%@include file="header/vendor_header.jsp"%>
	</c:when>
	<c:when test="${headerType eq  'ROLE_MEMBER'}">
		<c:set var="searchUrl" value="${rc.getContextPath()}/member/search"/>
		<%@include file="member/member_header.jsp"%>
	</c:when>
	<c:otherwise>
		<c:set var="searchUrl" value="${rc.getContextPath()}/search"/>
		<%@include file="header/application_header.jsp"%>
	</c:otherwise>
</c:choose>
<main class="main-contents">
    <div class="container">
        <div class="row page">
				Shop owners / vendor Profile =====================${thisVendor.partFName}
        </div>
    </div>
    <a href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/branch-list">Branch List</a>
   	<table>
   		<thead>
   			<td></td>
   		</thead>
   		<c:forEach items="${branch}" var="branch">
   		<tbody>
   				<td><a href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/${branch.uniqueId}">${branch.branchName }</a></td>
   			
   		</tbody>
   		</c:forEach>
   	</table>
   	
   	Branch name:======================${branchName.branchOwner}
   	
   	<a href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/product-list">Product List</a>
   	
   	<table>
   		<thead>
   			<td></td>
   		</thead>
   		<c:forEach items="${product}" var="product">
   		<tbody>
   				<td>${product.name}</a></td>
   			
   		</tbody>
   		</c:forEach>
   	</table>
   	
</main>
<c:choose>
	<c:when test="${headerType eq 'ROLE_ADMIN' || headerType eq 'ROLE_PARTNER' || headerType eq 'ROLE_MEMBER'}"></c:when>
	<c:otherwise>
		<%@include file="footer/application_footer.jsp"%>
	</c:otherwise>
</c:choose>
</body>
</html>