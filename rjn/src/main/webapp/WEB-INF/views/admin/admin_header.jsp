<script type="text/javascript">
	var _context = '${rc.getContextPath()}';
</script>
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/theme.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/jquery.jqplot.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/angular-wizard.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/corpyogi.css">
<body ng-app="RJN">
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button data-target="#bs-example-navbar-collapse-9"
				data-toggle="collapse" class="navbar-toggle collapsed" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<img src="${rc.getContextPath()}/resources/img/CorpYogiLogo.png"
				alt="Corp Yogi" style="cursor: pointer;"></img>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" style="margin-left: 103px;">
				<li><a href="${rc.getContextPath()}/admin/home"><i
						class="fa fa-home"></i><span> Home</span></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="dropdown-toggle">Welcome  <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-shopping-cart"></i> <span>My
									Account</span></a></li>
						<li><a href="#"><i class="fa fa-cog"></i><span>
									Application Settings</span></a></li>
						<li><a
							href="${rc.getContextPath()}/corpyogi/administration/userinfo"><i
								class="fa fa-users"></i> <span>User Administration</span></a></li>
						<li class="divider"></li>
						<li><a href="${rc.getContextPath()}/logout"><i
								class="fa fa-sign-out"></i> <span>Log Out</span></a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /.container-fluid -->
</nav>
<div class="sidebar-nav">
	<a data-toggle="collapse" class="nav-header collapsed"
		href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
	<ul class="nav nav-list collapse in" id="dashboard-menu"
		style="height: 246px;" aria-expanded="true">
		<li><a href="${rc.getContextPath()}/admin/product-category-list">Category</a></li>
		<li><a
			href="${rc.getContextPath()}/admin/vendor-list">Vendors</a></li>
		<li><a href="${rc.getContextPath()}/admin/branch-list">Branches</a></li>
		<li><a href="#">Profile</a></li>
		<li><a href="${rc.getContextPath()}/admin/change-password">Change Password</a></li>
	</ul>
</div>
<div class="sidebar-nav">
	<a data-toggle="collapse" class="nav-header collapsed"
		href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
	<ul class="nav nav-list collapse" id="dashboard-menu"
		style="height: 0px;">
		<li><a href="${rc.getContextPath()}/corpyogi/kv/test">Start
				Test</a></li>
	</ul>
</div>





