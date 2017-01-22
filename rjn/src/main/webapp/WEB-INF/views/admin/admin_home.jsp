<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:forEach items="${thisUserMenu}" var="current">
   <tr>
     <td><c:out value="${current.menuName}" /><td>
   </tr>
 </c:forEach>
Admin home --%>
<%@include file="admin_header.jsp"%>