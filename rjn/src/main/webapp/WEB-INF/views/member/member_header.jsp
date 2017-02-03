<!doctype html>
<html lang="en-gb" class="no-js">
<head>
<title>Office</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/member_style.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/responsive-leyouts.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/sticky.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/menu.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/member/demo.css">
<style>
.navbar-default {
	background-color: #ffffff !important;
	border-color: #ffffff !important;
}

.navbar {
	margin-bottom: 0px !important;
	box-shadow: none !important;
}
</style>
<!-- Favicon -->
<link rel="shortcut icon" href="images/favicon.ico">
<!-- this styles only adds some repairs on idevices  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body ng-app="RJN">
	<header id="header">
		<div id="topHeader1">
			<div class="wrapper">
				<div class="top_nav">
					<div class="container">
						<div class="right">
							<ul>
								<li>Member/Panel &nbsp;&nbsp; Login ID: <a
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
							<a href="member_home.jsp"> <img
								src="${rc.getContextPath()}/resources/images/logo/logo.png"
								class="img-resposive" width="80%" height="" border="0"
								alt="Not found">
							</a>
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
									<div id="navbar-collapse-1"
										class="navbar-collapse collapse pull-right">
										<ul class="nav navbar-nav">
											<li class="dropdown"><a href="member_home.jsp"
												class="dropdown-toggle"><i class="fa fa-home"></i> Home</a>
											</li>
											<li class="dropdown"><a href="" class="dropdown-toggle">
													<i class="fa fa-gift" aria-hidden="true"></i>List
											</a>
												<ul class="dropdown-menu" role="menu">
													<li><a
														href="${rc.getContextPath()}/member/search">Search</a></li>
															
												</ul></li>
											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>My
													Account</a>
												<ul class="dropdown-menu" role="menu">
													<li><a href="${rc.getContextPath()}/member/change-password">Change Password</a></li>
													<li><a href="${rc.getContextPath()}/member/edit-profile">Edit
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