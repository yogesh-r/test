<style>
.card {
	position: relative;
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-webkit-flex-direction: column;
	-ms-flex-direction: column;
	flex-direction: column;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-block {
	-webkit-box-flex: 1;
	-webkit-flex: 1 1 auto;
	-ms-flex: 1 1 auto;
	flex: 1 1 auto;
	padding: 1.25rem;
}
</style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:choose>
	<c:when test="${headerType eq  'ROLE_ADMIN'}">
		<c:set var="searchUrl" value="${rc.getContextPath()}/admin/search" />
		<%@include file="../admin/admin_header.jsp"%>
	</c:when>
	<c:when test="${headerType eq  'ROLE_VENDOR'}">
		<c:set var="searchUrl" value="${rc.getContextPath()}/vendor/search" />
		<%@include file="../header/vendor_header.jsp"%>
	</c:when>
	<c:when test="${headerType eq  'ROLE_MEMBER'}">
		<c:set var="searchUrl" value="${rc.getContextPath()}/member/search" />
		<%@include file="../member/member_header.jsp"%>
	</c:when>
	<c:otherwise>
		<c:set var="searchUrl" value="${rc.getContextPath()}/search" />
		<br>
		<br>
		<br>
		<br><%@include file="../header/application_header.jsp"%>
	</c:otherwise>
</c:choose>
<div class="content">
	<main class="main-contents">
	<div id="sticky-anchor">
		<div class="reservation_banner" id="sticky">
			<div class="container search-continer">
				<div class="row">
					<div class="col-xs-4">
						<form action="${searchUrl}" class="row form-horizontal">
							<di v class="col-xs-12 col-md-4"> <select name="cityId"
								class="form-control">
								<c:forEach items="${cityList}" var="thisCity">
									<option <c:if test="${thisCity.id eq cityId}">selected</c:if>
										value="${thisCity.id}">${thisCity.city}</option>
								</c:forEach>
							</select>
					</div>
					<div class="col-xs-12 col-md-4">
						<input class="form-control" name="thisProduct" />
					</div>
					<div class="col-xs-12 col-md-2">
						<button type="submit" class="btn btn-primary">
							<i class="fa fa-search"></i> Search
						</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="blog">
	<div class="container search-continer">
		<div class="row">
			<c:forEach items="${results}" var="thisResult">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">${thisResult.vendorName}</h3>
							<p class="card-text">With supporting text below as a natural
								lead-in to additional content.</p>
							<c:choose>
								<c:when
									test="${headerType eq 'ROLE_ADMIN' || headerType eq 'ROLE_VENDOR' || headerType eq 'ROLE_MEMBER'}">
									<a class="btn btn-primary"
										href="${rc.getContextPath()}/vendor-profile/${thisResult.vendorId}">Details</a>
								</c:when>
								<c:otherwise>
									<a href="" class="btn btn-primary" data-toggle="modal"
										data-target="#myModal">Details</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
	<div class="clearfix"></div>
	</main>
</div>

<%@include file="../footer/application_footer.jsp"%>
