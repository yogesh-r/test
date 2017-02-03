<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCdrHIPbEWvJF1K_BCTfKS9Aupm54Q9KGk&libraries=places&callback=initAutocomplete"
	async defer></script>
<div class="main">
	<div class="container">
		<form action="${rc.getContextPath()}/admin/register-vendor" method="POST" id="myform" enctype="multipart/form-data">
			<div class="panel panel-default">
				<div class="panel-heading">
					<center>
						<h4>
							<font color="brown">Vendor Registration </font>
						</h4>
					</center>
				</div>
				<!-- class="panel-heading" -->
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-3">
							<span class="mem_reg">First Name <label>*</label></span> 
							<input
								type="text" id="fname" name="partFName" class="form-control" value="${thisVendor.partFName}"
								required>
						</div>
						<div class="col-sm-3">
							<span>Last Name <label>*</label></span> 
							<input type="text"
								id="lnam" name="partSurname" class="form-control" value="${thisVendor.partSurname}" required>
						</div>
				<%-- 		<div class="col-sm-3">
							<span>Company Registration Date</span> 
								<input type='text' value="${thisVendor.DOB}"
								class="form-control" id="inputField" name="DOB" required />
						</div> --%>
					</div>
					<!--  row end -->
					<div class="row">
						<div class="col-sm-2"></div>
					<%-- 	<div class="col-sm-3">
							<span>Company name<label>*</label></span> <input type="text"
								name="compName" value="${thisVendor.compName}" class="form-control" required />
						</div> --%>
						<div class="col-sm-3">
							<span>Email Id<label>*</label></span> <input type="text"
								name="email" value="${thisVendor.email}" class="form-control"
								id="contact_email_id" required />
						</div>
						
						<c:if test="${thisVendor.id eq null}">
							<div class="col-sm-3">
								<span>Password<label>*</label></span> <input type="password"
									name="password" class="form-control" required />
							</div>
						</c:if>
						
					</div>
					<!--  row end -->
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-3">
							<span>Contact Number<label>*</label></span> <input type="text"
								name="pContact" id="text" class="form-control" required
								pattern=[0-9]{10} maxlength="10" value="${thisVendor.pContact}"
								title="contact no should be 10 digits(Ex:9749692397)">
						</div>
						<div class="col-sm-3">
							<span>Category Type<label>*</label></span> <select
								name="category" class="form-control">
								<option value="Retail Partner">Retail Partner</option>
								<option value="Channel Partner">Channel Partner</option>
								<option value="Sales Partner">Sales Partner</option>
							</select>
						</div>
<%-- 						<div class="col-sm-3"> 
							<span>License Type<label>*</label></span> 
								<select name="LicensePack" id="licen" class="form-control">
									 <c:forEach items="${licenceList}" var="thisValue">
										<option value="${thisValue.lookupType}">${thisValue.lookupCode}</option>
									</c:forEach>									
								</select>
						</div> --%>
					</div>
					<!-- row end -->
					<div class="row">
						<div class="col-sm-2"></div>
						<%-- <div class="col-sm-3">
							<span>Enter Company URL<label>*</label></span> <input
								type="text" name="url" id="compURL" class="form-control"
								value="${thisVendor.url}" required />
						</div> --%>
						
						<div class="col-sm-3">
							<span>Enter Company Logo<label>*</label></span>
							<input type="file" name="vendorLogo">
						</div>
						
					</div>
					<!-- Div Row Complted -->
				</div>
				<!-- panel body end -->
			</div>
			<!-- panel end -->

			<div class="panel panel-default">
				<div class="panel-heading">
					<center>Vendor Address Information</center>
				</div>
				<!-- class="panel-heading" -->
				<div class="panel-body">
					<div class="row">
						<div class="col-md-2"></div>
						<div id="locationField">
							<div class="col-sm-8">
								<input id="autocomplete" name = "add1" placeholder="Enter your address"
									value="${thisVendor.add1}" type="text" class="form-control"></input>
							</div>
						</div>
					</div>
					<!-- row end -->
					<br>
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-sm-3">
							<span>Address Line 1<label></label></span> <input
								value="${thisVendor.addr}" class="field form-control" id="street_number" name="addr"
								placeholder="Enter Your Door No." required></input>
						</div>
						<div class="col-sm-3">
							<span>Address Line 2<label></label></span> <input
								value="${thisVendor.addr}" class="field form-control" id="route" name="route"></input>
						</div>
						<div class="col-sm-3">
							<span>Location</span> <input class="field form-control"
								value="${thisVendor.location}" id="sublocality_level_1" name="location" readOnly required></input>
						</div>
					</div>
					<!--  row end -->
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-sm-3">
							<span>City<label></label></span> <input
								class="field form-control" id="locality" id="locality"
								value="${thisVendor.city}" name="city" required readOnly></input>
						</div>
						<div class="col-sm-3">
							<span>State<label></label></span> <input
								class="field form-control" name="state"
								value="${thisVendor.state}" id="administrative_area_level_1" readOnly></input>
						</div>
						<div class="col-sm-3">
							<span>Country<label></label></span> <input
								value="${thisVendor.country}" class="field form-control" name="country" id="country" readOnly></input>
						</div>
					</div>
					<!--  row end -->
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-sm-3">
							<span>ZipCode*<label></label></span> <input type="text"
								name="zipCode" id="postal_code" ng-model="event_name"
								value="${thisVendor.zipCode}" class="field form-control" readOnly>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<input type="hidden" class="field form-control" id="latitude"
								value="${thisVendor.latitude}"name="latitude"></input>
						</div>
						<div class="col-sm-3">
							<input type="hidden" class="field form-control" id="longitude"
								value="${thisVendor.longitude}" name="longitude"></input>
								<input type="hidden" class="field form-control"
								value="${thisVendor.id}" name="id"></input>
						</div>
					</div>
				</div>
			</div>
			<!-- panel end -->
			<div class="row" align="center">
				<div class="col-sm-2"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">
					<c:if test="${thisVendor.partFName eq null}">
						<input type="submit" id="submit" value="Create Vendor" class="form-control btn-primary">
					</c:if>
					<c:if test="${thisVendor.partFName ne null}">
						<input type="submit" id="submit" value="Update vendor" class="form-control btn-primary">
					</c:if>
				</div>
			</div>
			<!-- padding -->
			<div style="height: 10px; line-height: 40px; font-size: 40px;"></div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('body').on('focus', "#duedate", function() {
			$(this).datetimepicker({
				format : 'DD-MM-YYYY',
				pickTime : false,
				autoclose : true
			});
		});
	});

	var placeSearch, autocomplete;
	var componentForm = {
		street_number : 'long_name',
		route : 'long_name',
		sublocality_level_1 : 'long_name',
		locality : 'long_name',
		administrative_area_level_1 : 'long_name',
		country : 'long_name',
		postal_code : 'short_name'
	};

	function initAutocomplete() {
		// Create the autocomplete object, restricting the search
		// to geographical location types.
		autocomplete = new google.maps.places.Autocomplete(
		/** @type {HTMLInputElement} */
		(document.getElementById('autocomplete')), {
			types : [ 'geocode' ]
		});
		// When the user selects an address from the dropdown,
		// populate the address fields in the form.
		google.maps.event.addListener(autocomplete, 'place_changed',
				function() {
					fillInAddress();
				});
	}

	// [START region_fillform]
	function fillInAddress() {
		// Get the place details from the autocomplete object.
		var place = autocomplete.getPlace();

		document.getElementById("latitude").value = place.geometry.location
				.lat();
		document.getElementById("longitude").value = place.geometry.location
				.lng();

		for ( var component in componentForm) {
			document.getElementById(component).value = '';
			document.getElementById(component).disabled = false;
		}

		// Get each component of the address from the place details
		// and fill the corresponding field on the form.
		for (var i = 0; i < place.address_components.length; i++) {
			var addressType = place.address_components[i].types[0];
			if (componentForm[addressType]) {
				var val = place.address_components[i][componentForm[addressType]];
				document.getElementById(addressType).value = val;
			}
		}
	}
	// [END region_fillform]
	// [START region_geolocation]
	// Bias the autocomplete object to the user's geographical location,
	// as supplied by the browser's 'navigator.geolocation' object.
	function geolocate() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var geolocation = new google.maps.LatLng(
						position.coords.latitude, position.coords.longitude);

				var latitude = position.coords.latitude;
				var longitude = position.coords.longitude;
				document.getElementById("latitude").value = latitude;
				document.getElementById("longitude").value = longitude;

				autocomplete.setBounds(new google.maps.LatLngBounds(
						geolocation, geolocation));
			});
		}
	}
	initAutocomplete();
</script>