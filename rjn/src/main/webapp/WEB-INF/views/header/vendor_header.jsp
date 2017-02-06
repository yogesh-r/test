<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<body onunload="bodyUnload();" Onclick="clicked=true;" ng-app="RJN">
	<div class="container">
		<div class="pull-right">welcome ${sessionScope.uname}</div>
	</div>
	<div class="wrapper">
		<div class="top_nav ">
			<div class="container">
				<!-- Logo -->
				<div class="logo">
					<a href="#"> <img
						src="${rc.getContextPath()}/resources/images/logo/logo.png"
						class="img-resposive" alt="not found"></a>
				</div>
				<div class="container">
					<div id="navbar-collapse-1"
						class="navbar-collapse collapse pull-right">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"></a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"></a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"></a></li>
							<li class="dropdown"><a
								href="${rc.getContextPath()}/vendor/home"
								class="dropdown-toggle"><i class="fa fa-home"></i> Home</a></li>
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle"><i class="fa fa-tasks"></i>Registration</a>
								<ul class="dropdown-menu">
									<li><a
										href="${rc.getContextPath()}/vendor/register-branch"
										class="my-class" id="branch001">Register Branch</a></li>
									<li><a
										href="${rc.getContextPath()}/vendor/product/register-product"
										class="my-class" id="branch001">Register Product</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle"><i class="fa fa-book"></i> List </a>
								<ul class="dropdown-menu">
									<li><a href="${rc.getContextPath()}/vendor/branch-list">Branch
											List</a></li>
									<li><a
										href="${rc.getContextPath()}/vendor/product/product-list">Product
											List</a></li>
									<li><a href="${rc.getContextPath()}/vendor/product/leads">Leads</a></li>
								</ul></li>
							<cc:if test="${vendorDetails ne null}">
								<li class="dropdown"><a href="#" data-toggle="dropdown"
									class="dropdown-toggle"><i class="fa fa-book"></i> View </a>
									<ul class="dropdown-menu">
										<li><a
											href="${rc.getContextPath()}/vendor/${vendorDetails.id}">My
												Profile</a></li>
									</ul></li>
							</cc:if>
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>My
									Account</a>
								<ul class="dropdown-menu">
									<li><a
										href="${rc.getContextPath()}/vendor/change-password">Change
											Password</a></li>
									<li><a href="${rc.getContextPath()}/vendor/edit-profile">Edit
											Profile</a></li>
									<li><a href="${rc.getContextPath()}/logout">Logout</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="../include/js_include.jsp"%>