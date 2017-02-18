<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body onload="initialize()">
	<main class="main-contents">
	<div class="container">
		<div class="row page">Shop owners / vendor Profile
			=====================${thisVendor.vendorFirstName}</div>
	</div><br>
	<a
		href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/branch-list">Branch
		List</a><br>
	<table>
		<thead>
			<td></td>
		</thead>
		<c:forEach items="${branch}" var="branch">
			<tbody>
				<td><a
					href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/${branch.uniqueId}">${branch.branchName }</a></td>
			</tbody>
		</c:forEach>
<br>
		<c:if test="${showVerifyButton}">
			<a href="${rc.getContextPath()}/vendor/verify">Verify</a><br>please give following link to your customer <b>"${rc.getContextPath()}/vendor-profile/${vendorDetails.id}"</b>
   		</c:if><br>
	</table>
	Branch name:======================${branchName.branchOwner} </br><a
		href="${rc.getContextPath()}/vendor-profile/${thisVendor.id}/product-list">Product
		List</a>
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
	</br></br>
	<div id="map" style="height: 50%; width: 70%;"></div>
	</main>
</body>
<script>
	var profileLatitude = "${thisVendor.latitude}";
	var profileLongitude = "${thisVendor.longitude}";
	console.log(profileLatitude);
	console.log(profileLongitude);
     var contentString = 'Description here';
     function initialize() {
         var myLatLng = new google.maps.LatLng(profileLatitude,profileLongitude);
         var map = new google.maps.Map(document.getElementById("map"),
         {
             zoom: 17,
             center: myLatLng,
             mapTypeId: google.maps.MapTypeId.ROADMAP
         });

         var marker = new google.maps.Marker(
         {
             position: myLatLng,
             map: map,
             title: 'Rajya Sabha'
         });
         
         var infowindow = new google.maps.InfoWindow({
             content: contentString
         });
         
         marker.addListener('click', function() {
             infowindow.open(map, marker);
           });
     }
   </script>
   <%@include file="google-api/google-api-key.jsp"%>

