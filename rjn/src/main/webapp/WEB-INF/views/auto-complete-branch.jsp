			<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCdrHIPbEWvJF1K_BCTfKS9Aupm54Q9KGk&libraries=places&callback=initAutocomplete"
	async defer></script>

<div class="form-group">
	<label class="control-label col-sm-2">Address:</label>
	<div class="col-sm-10">
		<input id="autocomplete" name="address" placeholder="Enter your address"
			ng-model="thisBranch.address" value="{{thisBranch.address}}" type="text" class="form-control"></input>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-2">Latitude:</label>
	<div class="col-sm-10">
		<input id="latitude" disabled
			ng-model="thisBranch.latitude" value="{{thisBranch.latitude}}" type="text" class="form-control"></input>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-2">Longitude:</label>
	<div class="col-sm-10">
		<input id="longitude" disabled
			ng-model="thisBranch.longitude" value="{{thisBranch.longitude}}" type="text" class="form-control"></input>
	</div>
</div>

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