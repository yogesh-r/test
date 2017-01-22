<!doctype html>
<html lang="en-gb" class="no-js">
<!--<![endif]-->
<head>
<title>RJN</title>
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
<!-- Favicon -->
<link rel="shortcut icon" href="images/favicon.ico">
<!-- this styles only adds some repairs on idevices  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- ######### CSS STYLES ######### -->
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/partner/reset.css">
<link rel="stylesheet"
	href="${rc.getContextPath()}/resources/css/partner/partner_style.css"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/css/font-awesome.min.css">
<!-- responsive devices styles -->
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/responsive-leyouts.css">
<!-- mega menu -->
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/sticky.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/menu.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/demo.css">
</head>
<body onunload="bodyUnload();" Onclick="clicked=true;" ng-app="RJN">
	<header id="header">
		<div id="topHeader1">
			<div class="wrapper">
				<div class="top_nav">
					<div class="container">
						<div class="right">
							<ul>
								<li>Partner/Panel &nbsp;&nbsp; Login ID: <a
									class="action-btn" href="#"> <font color="white"> <!--Welcome,&nbsp;-->
									</font> <font color="red">${sessionScope.uname}</font>
								</a> <a href="${rc.getContextPath()}/logout">&nbsp;Logout&nbsp;&nbsp;
										<i class="fa fa-sign-out"></i>
								</a>
								</li>
							</ul>
						</div>
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