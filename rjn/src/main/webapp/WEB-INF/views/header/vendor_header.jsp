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
	href="${rc.getContextPath()}/resources/css/application.css">
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
			<img src="${rc.getContextPath()}/resources/img/"
				alt="Corp Yogi" style="cursor: pointer;"></img>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" style="margin-left: 103px;">
				<li><a href="${rc.getContextPath()}/vendor/home"><i
						class="fa fa-home"></i><span> Home</span></a></li>
			</ul>
			
			<div class="pull-right" style="color:white;">
				Welcome, ${sessionScope.uname}: <a href="${rc.getContextPath()}/logout">Logout</a>
				</div>
		</div>
	</div>
</nav>
<div class="sidebar-nav">
	<a data-toggle="collapse" class="nav-header collapsed"
		href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
	<ul class="nav nav-list collapse in" id="dashboard-menu"
		style="height: 246px;" aria-expanded="true">
		<li><a href="${rc.getContextPath()}/vendor/branch-list">Branches</a></li>
		<li><a href="${rc.getContextPath()}/vendor/product/product-list">Products</a></li>
		<li><a href="${rc.getContextPath()}/vendor/edit-profile">My Profile</a></li>
		<li><a href="${rc.getContextPath()}/vendor/product/leads">Leads</a></li>
		<li><a href="${rc.getContextPath()}/vendor/change-password">Change Password</a></li>
		<li><a href="${rc.getContextPath()}/vendor/${vendorDetails.id}" target="_blank">Verify Profile</a></li>
		<li><a href="">Analyze</a></li>
	</ul>
</div>
