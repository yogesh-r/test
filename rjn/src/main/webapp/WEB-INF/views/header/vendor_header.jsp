<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<body onunload="bodyUnload();" Onclick="clicked=true;" ng-app="RJN">
	<header id="header">
		<div id="topHeader1">
			<div class="wrapper">
				<div class="top_nav">
					<div class="container">
						<div class="pull-right"> welcome ${sessionScope.uname}</div>
					</div>
				</div>
			</div>
		</div>
		<div id="topHeader">
			<div class="wrapper">
				<div class="top_nav  ">
					<div class="container">
						<!-- Logo -->
						<div class="logo">
							<a href="#"> <img
								src="${rc.getContextPath()}/resources/images/logo/logo.png"
								class="img-resposive" width="60%" height="" border="0" alt=""></a>
						</div>
						<!-- Menu -->
						<div class="menu_main">
							<div class="navbar yamm navbar-default">
								<div class="container">
									<div class="navbar-header">
										<div class="navbar-toggle .navbar-collapse .pull-right "
											data-toggle="collapse" data-target="#navbar-collapse-1">
											<span>Menu</span>
											<button type="button">
												<i class="fa fa-bars"></i>
											</button>
										</div>
									</div>
									<div id="navbar-collapse-1" class="navbar-collapse collapse ">
										<ul class="nav navbar-nav">
											<li class="dropdown"><a href="#" class="dropdown-toggle"></a></li>
											<li class="dropdown"><a href="#" class="dropdown-toggle"></a></li>
											<li class="dropdown"><a href="#" class="dropdown-toggle"></a></li>
											<li class="dropdown"><a href="${rc.getContextPath()}/vendor/home"
												class="dropdown-toggle"><i class="fa fa-home"></i> Home</a></li>
											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle"><i class="fa fa-tasks"></i>Registration</a>
												<ul class="dropdown-menu" role="menu">
													<li><a
														href="${rc.getContextPath()}/vendor/register-branch"
														class="my-class" id="branch001">Register Branch</a></li>
													<li><a
														href="${rc.getContextPath()}/vendor/product/register-product"
														class="my-class" id="branch001">Register Product</a></li>
												</ul></li>
											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle"><i class="fa fa-book"></i>
													List </a>
												<ul class="dropdown-menu" role="menu">
													<li><a href="${rc.getContextPath()}/vendor/branch-list">Branch List</a></li>
													<li><a href="${rc.getContextPath()}/vendor/product/product-list">Product List</a></li>
													<li><a href="${rc.getContextPath()}/vendor/product/leads">Leads</a></li>
												</ul></li>
											<cc:if test="${vendorDetails ne null}">
												<li class="dropdown"><a href="#" data-toggle="dropdown"
													class="dropdown-toggle"><i class="fa fa-book"></i>
														View </a>
													<ul class="dropdown-menu" role="menu">
														<li><a href="${rc.getContextPath()}/vendor/${vendorDetails.id}">My Profile</a></li>
													</ul>
												</li>
											</cc:if>
											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>My
													Account</a>
												<ul class="dropdown-menu" role="menu">
													<li><a href="${rc.getContextPath()}/vendor/change-password">Change Password</a></li>
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
				</div>
			</div>
		</div>
	</header>
</body>
</html>
<%@include file="../include/js_include.jsp"%>