<body ng-app="RJN">
	<header id="header">
		<div id="topHeader1">
			<div class="wrapper">
				<div class="top_nav">
					<div class="container">
						<div class="pull-right"> welcome, ${sessionScope.uname}</div>
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
											<li class="dropdown"><a href="${rc.getContextPath()}/member/home"
												class="dropdown-toggle"><i class="fa fa-home"></i> Home</a>
											</li>
											
											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>Search</a>
												<ul class="dropdown-menu" role="menu">
													<li><a
														href="${rc.getContextPath()}/member/search">Search</a></li>
												</ul>
											</li>
												
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