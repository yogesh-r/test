<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${headerType eq  'ROLE_ADMIN'}">
	<c:set var="searchUrl" value="${rc.getContextPath()}/admin/search"/>
		<%@include file="../admin/admin_header.jsp"%>
	</c:when>
	<c:when test="${headerType eq  'ROLE_PARTNER'}">
	<c:set var="searchUrl" value="${rc.getContextPath()}/vendor/search"/>
		<%@include file="../header/vendor_header.jsp"%>
	</c:when>
	<c:when test="${headerType eq  'ROLE_MEMBER'}">
		<c:set var="searchUrl" value="${rc.getContextPath()}/member/search"/>
		<%@include file="../member/member_header.jsp"%>
	</c:when>
	<c:otherwise>
		<c:set var="searchUrl" value="${rc.getContextPath()}/search"/>
		<%@include file="../header/application_header.jsp"%>
	</c:otherwise>
</c:choose>

<main class="main-contents">
<div id="sticky-anchor">
	<div class="reservation_banner" id="sticky">
		<div class="container search-continer">
			<div class="row">
				<div class="col-xs-4">
				    <form action="${searchUrl}" class="row form-horizontal">
						<div class="col-xs-12 col-md-4 col-md-offset-2">
                          <input class="form-control" name="thisProduct" />
						</div>
						<div class="col-xs-12 col-md-2">
                            <button type="submit" class="btn btn-default" ><i class="fa fa-search"></i> Search</button>
                        </div>
                    </form>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>
<div class="blog">
	<div class="container search-continer">
		<div class="col-md-3 blog-sidebar panel panel-success"
			style="height: auto">
			<div class="blog-list1" style="height: 350px">
				<h4 class="text-center">
					<font size="2" style="text-decoration: blink;">Popular
						Vendors</font>
				</h4>
				<marquee direction="down" height="350px"
					onMouseOver="this.setAttribute('scrollamount', 0, 0);"
					onload="this.stop();"> </marquee>
			</div>
		</div>
		<div class="col-md-9 blog-head panel panel-default">
			<ul class='list-unstyled list-inline'>
				<c:forEach items="${results}" var="thisResult">
					<c:choose>
						<c:when test="${headerType eq 'ROLE_ADMIN' || headerType eq 'ROLE_PARTNER' || headerType eq 'ROLE_MEMBER'}">
							<li><a href="${rc.getContextPath()}/vendor-profile/${thisResult.vendorId}">${thisResult.vendorName}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="" data-toggle="modal" data-target="#myModal">${thisResult.vendorName}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
</main>

<c:choose>
	<c:when test="${headerType eq 'ROLE_ADMIN' || headerType eq 'ROLE_PARTNER' || headerType eq 'ROLE_MEMBER'}"></c:when>
	<c:otherwise>
		<%@include file="../footer/application_footer.jsp"%>
	</c:otherwise>
</c:choose>