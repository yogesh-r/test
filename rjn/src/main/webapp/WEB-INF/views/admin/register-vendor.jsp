<%@include file="admin_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCdrHIPbEWvJF1K_BCTfKS9Aupm54Q9KGk&libraries=places&callback=initAutocomplete"
	async defer></script>

<div class="main" ng-controller="registerVendorCtrl">
	<div class="container">
		<div class="col-md-10">
			<form class="form-horizontal"
				action="${rc.getContextPath()}/admin/register-vendor" method="POST"
				enctype="multipart/form-data">
				<div class="form-group">
					<label class="control-label col-sm-2">First Name:</label>
					<div class="col-sm-10">
						<input type="text" name="vendorFirstName" class="form-control"
							value="${thisVendor.vendorFirstName}" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Last Name:</label>
					<div class="col-sm-10">
						<input type="text" name="vendorSurname" class="form-control"
							value="${thisVendor.vendorSurname}" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Email Id:</label>
					<div class="col-sm-10">
						<input type="text" name="email" value="${thisVendor.email}"
							class="form-control" required />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Contact Number:</label>
					<div class="col-sm-10">
						<input type="text" name="pContact" class="form-control" required
							pattern=[0-9]{10} maxlength="10" value="${thisVendor.pContact}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Company Logo:</label>
					<div class="col-sm-10">
						<input type="file" name="vendorLogo">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Address:</label>
					<div class="col-sm-10">
						<input id="autocomplete" name="add1"
							placeholder="Enter your address" value="${thisVendor.address}"
							type="text" class="form-control"></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Address Line 1:</label>
					<div class="col-sm-10">
						<input value="${thisVendor.address}" class="field form-control"
							id="street_number" name="addr" placeholder="Enter Your Door No."
							required></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Address Line 2:</label>
					<div class="col-sm-10">
						<input value="${thisVendor.address}" class="field form-control"
							id="route" name="route"></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Location:</label>
					<div class="col-sm-10">
						<input class="field form-control" value="${thisVendor.location}"
							id="sublocality_level_1" name="location" readOnly required></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">City:</label>
					<div class="col-sm-10">
						<input class="field form-control" id="locality"
							value="${thisVendor.city}" name="city" required readOnly></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">State:</label>
					<div class="col-sm-10">
						<input class="field form-control" name="state"
							value="${thisVendor.state}" id="administrative_area_level_1"
							readOnly></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Country:</label>
					<div class="col-sm-10">
						<input value="${thisVendor.country}" class="field form-control"
							name="country" id="country" readOnly></input>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">ZipCode:</label>
					<div class="col-sm-10">
						<input type="text" name="zipCode" id="postal_code"
							value="${thisVendor.zipCode}" class="field form-control" readOnly>
					</div>
				</div>

				<input type="hidden" class="field form-control" id="latitude"
					value="${thisVendor.latitude}" name="latitude"></input> <input
					type="hidden" class="field form-control" id="longitude"
					value="${thisVendor.longitude}" name="longitude"></input> <input
					type="hidden" class="field form-control" value="${thisVendor.id}"
					name="id"></input>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<c:if test="${thisVendor.vendorFirstName eq null}">
							<input type="submit" id="submit" value="Create Vendor"
								class="form-control btn-primary">
						</c:if>
						<c:if test="${thisVendor.vendorFirstName ne null}">
							<input type="submit" id="submit" value="Update vendor"
								class="form-control btn-primary">
						</c:if>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
</div>

<script src="${rc.getContextPath()}/resources/develoepr-js/register-vendor.js"></script> 
<script type="text/javascript">
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