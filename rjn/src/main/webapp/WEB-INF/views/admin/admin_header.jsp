<script type="text/javascript">
	var _context = '${rc.getContextPath()}';
</script>
<body ng-app="RJN">
	<div class="container">
		<div class="pull-right">&nbsp;&nbsp;Welcome,
			${sessionScope.uname}</div>
	</div>
	<div class="container">
		<div>
			<img src="${rc.getContextPath()}/resources/images/logo/logo.png"
				class="img-resposive" alt="Not found">
		</div>
		<div class="navbar-collapse collapse pull-right">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a
					href="${rc.getContextPath()}/admin/home" class="dropdown-toggle"><i
						class="fa fa-home"></i> Home </a></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="dropdown-toggle"><i class="fa fa-tasks"></i>Registration</a>
					<ul class="dropdown-menu">
						<li><a href="${rc.getContextPath()}/admin/register-vendor">Register
								Vendor</a></li>
						<li><a href="${rc.getContextPath()}/admin/register-branch">Register
								Branch</a></li>
						<li><a href="${rc.getContextPath()}/admin/register-category">Register
								Category</a></li>
						<li><a href="${rc.getContextPath()}/admin/map">Demo</a></li>

					</ul></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="dropdown-toggle"><i class="fa fa-book"></i> List </a>
					<ul class="dropdown-menu">
						<li><a href="${rc.getContextPath()}/admin/vendor-list">Vendor
								List</a></li>
						<li><a href="${rc.getContextPath()}/admin/branch-list">Branch
								List</a></li>
						<li><a href="${rc.getContextPath()}/admin/vendor-enquiry">Vendor
								Enquiry</a></li>
						<li><a
							href="${rc.getContextPath()}/admin/product-category-list">Product
								category list</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="dropdown-toggle"><i class="fa fa-cog fa-spin"></i>My
						Account</a>
					<ul class="dropdown-menu">
						<li><a href="${rc.getContextPath()}/admin/change-password">Change
								Password</a></li>
						<li><a href="${rc.getContextPath()}/admin/home">Edit
								Profile</a></li>
						<li><a href="${rc.getContextPath()}/logout">Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</body>
<%@include file="../include/js_include.jsp"%>