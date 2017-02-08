<body>
	<div class="container">
		<div class="pull-right">welcome, ${sessionScope.uname}</div>
	</div>
	<div class="container">
		<!-- Logo -->
		<div class="logo">
			<a href="${rc.getContextPath()}/member/home"> <img
				src="${rc.getContextPath()}/resources/images/logo/logo.png"
				class="img-resposive" width="80%" height="" border="0"
				alt="Not found">
			</a>
		</div>
		<div class="container">
			<div id="navbar-collapse-1"
				class="navbar-collapse collapse pull-right">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a
						href="${rc.getContextPath()}/member/home" class="dropdown-toggle"><i
							class="fa fa-home"></i> Home</a></li>

					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>Search</a>
						<ul class="dropdown-menu">
							<li><a href="${rc.getContextPath()}/member/search">Search</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>My
							Account</a>
						<ul class="dropdown-menu">
							<li><a href="${rc.getContextPath()}/member/change-password">Change
									Password</a></li>
							<li><a href="${rc.getContextPath()}/member/edit-profile">Edit
									Profile</a></li>
							<li><a href="${rc.getContextPath()}/logout">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="../include/js_include.jsp"%>