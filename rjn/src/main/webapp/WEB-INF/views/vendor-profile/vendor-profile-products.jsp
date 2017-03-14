<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body onload="initialize()">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button data-target="#bs-example-navbar-collapse-9"
					data-toggle="collapse" class="navbar-toggle collapsed"
					type="button">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img src="${rc.getContextPath()}/resources/img/" alt="Corp Yogi"
					style="cursor: pointer;"></img>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="margin-left: 103px;">
					<li><a href="${rc.getContextPath()}/admin/home"><i
							class="fa fa-home"></i><span> Home</span></a></li>
				</ul>

				<div class="pull-right" style="color: white;">
					Welcome, ${sessionScope.uname}: <a
						href="${rc.getContextPath()}/logout">Logout</a>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="sidebar-nav" style="margin-top: 200px;">
		<a data-toggle="collapse" class="nav-header collapsed"><i
			class="icon-dashboard"></i>Menu</a>
		<ul class="nav nav-list collapse in" id="dashboard-menu"
			style="height: 246px;" aria-expanded="true">
			<li><a
				href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/branch-list">Branches</a></li>
			<li><a
				href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/product-list">Products</a></li>
			<li><a href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/map">Map</a></li>
		</ul>
	</div>
	<div class="row page"
		style="background-color: lightcyan; height: 200px;">
		<div class="container">
			Shop kepper name : ${thisVendor.vendorFirstName}<br> Shop kepper
			address : ${thisVendor.address}
		</div>
	</div>
	<div class="content">
		<table>
			<thead>
				<td></td>
			</thead>
			<c:forEach items="${product}" var="product">
				<tbody>
					<td>${product.name}</a></td>

				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
<script>
	var profileLatitude = "${thisVendor.latitude}";
	var profileLongitude = "${thisVendor.longitude}";
	console.log(profileLatitude);
	console.log(profileLongitude);
	var contentString = 'Description here';
	function initialize() {
		var myLatLng = new google.maps.LatLng(profileLatitude, profileLongitude);
		var map = new google.maps.Map(document.getElementById("map"), {
			zoom : 17,
			center : myLatLng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		var marker = new google.maps.Marker({
			position : myLatLng,
			map : map,
			title : 'Rajya Sabha'
		});

		var infowindow = new google.maps.InfoWindow({
			content : contentString
		});

		marker.addListener('click', function() {
			infowindow.open(map, marker);
		});
	}
</script>
<%-- <%@include file="../google-api/google-api-key.jsp"%> --%>
