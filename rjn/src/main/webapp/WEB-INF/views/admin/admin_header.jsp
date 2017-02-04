<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/admin/reset.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/admin/menu.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/admin/admin_style.css">
</head>
<body ng-app="RJN">
	<header id="header">
		<div id="topHeader1">
			<div class="wrapper">
				<div class="top_nav">
					<div class="container">
						<div class="right">
							<ul>
								<li>&nbsp;&nbsp; Login ID: ${sessionScope.uname}
								<li><a href="${rc.getContextPath()}/logout">Logout&nbsp;&nbsp;
										<i class="fa fa-sign-out"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="topHeader">
			<div class="wrapper">
				<div class="top_nav">
					<div class="container">
						<!-- Logo -->
						<div class="logo">
							<img src="${rc.getContextPath()}/resources/images/logo/logo.png"
								class="img-resposive" width="80%" height="" border="0"
								alt="Not found">
							<div class="logo">
								<a href="index.html" id="logo"></a>
							</div>
						</div>
						<div class="menu_main">
							<div class="navbar yamm navbar-default">
								<div class="navbar-header">
									<div class="navbar-toggle navbar-collapse pull-right"
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
										<li class="dropdown"><a
											href="${rc.getContextPath()}/admin/home"
											class="dropdown-toggle"><i class="fa fa-home"></i> Home </a>
										</li>
										<li class="dropdown"><a href="#" data-toggle="dropdown"
											class="dropdown-toggle"><i class="fa fa-tasks"></i>Registration</a>
											<ul class="dropdown-menu" role="menu">
												<li><a
													href="${rc.getContextPath()}/admin/register-vendor">Register
														Vendor</a></li>
												<li><a
													href="${rc.getContextPath()}/admin/register-branch">Register Branch</a></li>
												<li><a
													href="${rc.getContextPath()}/admin/register-category">Register
														Category</a></li>

											</ul></li>
										<li class="dropdown"><a href="#" data-toggle="dropdown"
											class="dropdown-toggle"><i class="fa fa-book"></i>
												List </a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="${rc.getContextPath()}/admin/vendor-list">Vendor
														List</a></li>
												<li><a href="${rc.getContextPath()}/admin/branch-list">Branch
														List</a></li>
												<li><a
													href="${rc.getContextPath()}/admin/vendor-enquiry">Vendor
														Enquiry</a></li>
												<li><a
													href="${rc.getContextPath()}/admin/product-category-list">Product
														category list</a></li>
											</ul></li>
										<li class="dropdown"><a href="#" data-toggle="dropdown"
											class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>My
												Account</a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="${rc.getContextPath()}/admin/change-password">Change Password</a></li>
												<li><a href="${rc.getContextPath()}/admin/home">Edit Profile</a></li>
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
	</header>
</body>
<%@include file="../include/js_include.jsp"%>