<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCdrHIPbEWvJF1K_BCTfKS9Aupm54Q9KGk&libraries=places&callback=initAutocomplete"
	async defer></script>

<div class="panel panel-success">
	<div class="panel-heading">
		<center>New Branch Registration</center>
	</div>
	<div class="panel panel-success">
		<div class="panel-body">
			<div class="row">
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-6">
							<span>Vendor<label></label></span>
							<c:choose>
								<c:when test="${allVendors ne null}">
									<select name="branchOwner" class="form-control"
										id="branch_owner">
										<c:forEach items="${vendorDetails}" var="thisVendor">
											<option value="${thisVendor.id}">${thisVendor.id}</option>
										</c:forEach>
									</select>
								</c:when>
								<c:otherwise>
									<select name="branchOwner" class="form-control"
										id="branch_owner">
										<option value="${vendorDetails.id}">${vendorDetails.id}</option>
									</select>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-6">
							<span>Branch Name* </span> <input type="text"
								value="${thisBranch.branchName}" id="branchName"
								name="branchName" ng-model="event_name" class="form-control"
								onblur="notnull();" required /> <span id="isE"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<span>Start Date <label></label>
							</span>
							<div class='input-group date col-md-12' data-date="12-02-2012"
								data-date-format="dd-mm-yyyy">
								<input value="${thisBranch.startDate}" type='text'
									class="form-control" name="startDate" id="duedate"
									placeholder="Start Date" required />
							</div>

						</div>
						<div class="col-md-6">
							<span>Branch Type <label></label>
							</span> <select name="specialization" class="form-control">
								<option value="P">Plug & Play</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-5">
					<span>Description <label></label>
					</span>
					<TEXTAREA name="description" class="form-control" rows="4"
						maxlength="500" required>${thisBranch.description}</TEXTAREA>
				</div>
			</div>
			<div class="row" hidden>
				<div class="col-sm-4 ">
					<span>Book Through Enquiry Only <label></label>
					</span> <select name="enq" class="form-control" style="width: 21.5em">
						<option value="Yes">Yes</option>
						<option value="No">No</option>
					</select>
				</div>
				<div class="col-sm-8"></div>
			</div>
		</div>
	</div>
	<div class="panel panel-success" style="display: none;">
		<div class="panel-heading" align="center">
			<a href="javascript:toggleDiv('amenit');">Amenities <i
				class="glyphicon glyphicon-plus"></i>&nbsp; <i
				class="glyphicon glyphicon-minus"></i>
			</a>
		</div>
		<div class="panel-body">
			<div class="box" id="amenit">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Amenities</th>
							<th>Available</th>
							<th>Complementary</th>
							<th>Comment</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${aminitiesList}" var="thisValue"
							varStatus="status">
							<tr>
								<input type="hidden"
									name="aminitiesList[${status.index}].featureId"
									value="${thisValue.lookupCode}" />
								<td><label
									name="aminitiesList[${status.index}].lookupValues"
									value="${thisValue.lookupValues}">${thisValue.lookupValues}</label>
								</td>
								<td><select
									name="aminitiesList[${status.index}].chargeable">
										<option value="No">No</option>
										<option value="Yes" selected>Yes</option>
								</select></td>
								<td><select>
										<option value="No">No</option>
										<option value="Yes">Yes</option>
								</select></td>
								<td><input type='text' id='rupee'
									name="aminitiesList[${status.index}].comment" value=''></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="panel panel-success">
		<div class="panel-heading">
			<center>Branch Address Information</center>
		</div>
		<div class="panel-body">
			<div class="row" style="margin-bottom: 10px">
				<div id="locationField">
					<div style="margin-right: 70px" class="col-sm-8 pull-right">
						<input name="address" value="${thisBranch.address}"
							id="autocomplete" placeholder="Enter your address" type="text"
							class="form-control"></input>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<span>Address Line 1 <label></label>
					</span> <input class="field form-control" id="street_number" name="addr"
						placeholder="Enter Your Door No." required></input>
				</div>
				<div class="col-sm-3">
					<span>Address Line 2 <label></label>
					</span> <input class="field form-control" id="route" name="route"
						placeholder="Enter Your Street No." required></input>
				</div>
				<div class="col-sm-3">
					<span>Location</span> <input value="${thisBranch.location}"
						class="field form-control" id="sublocality_level_1"
						name="location" readOnly required></input>
				</div>
				<div class="col-sm-3">
					<span>City <label></label>
					</span> <input value="${thisBranch.city}" class="field form-control"
						id="locality" name="city" readOnly required></input>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<span>State <label></label>
					</span> <input value="${thisBranch.state}" type="state"
						class="field form-control" name="stat"
						id="administrative_area_level_1" readOnly></input>
				</div>
				<div class="col-sm-3">
					<span>Country <label></label>
					</span> <input value="${thisBranch.country}" class="field form-control"
						name="country" id="country" readOnly></input>
				</div>
				<div class="col-sm-3">
					<span>ZipCode* <label></label>
					</span> <input value="${thisBranch.zipcode}" type="text" name="zipcode"
						id="postal_code" ng-model="event_name" class="field form-control"
						readOnly>
				</div>
				<div class="col-sm-3">
					<span>Status <label></label>
					</span> <select name="status" class="form-control">
						<option value='Active'>Active</option>
						<option value='Inactive'>Inactive</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<input type="hidden" class="field form-control" id="latitude"
						name="latitude" required></input> <input type="hidden"
						value="${thisBranch.id}" name="id"></input>
				</div>
				<div class="col-sm-3">
					<input type="hidden" class="field form-control" id="longitude"
						name="longitude" required></input>
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-success">
		<div class="panel-heading">
			<center>Branch Manager Information</center>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-3">
					<span>Manager Name* <label></label>
					</span> <input value="${thisBranch.managerName}" type="text"
						name="managerName" ng-model="event_name" class="form-control"
						required>
				</div>
				<div class="col-sm-3">
					<span>Email-ID* <label></label>
					</span> <input value="${thisBranch.managerEmail}" type="email"
						name="managerEmail" ng-model="event_name" class="form-control"
						required>
				</div>
				<div class="col-sm-3">
					<span>Contact No* <label></label>
					</span> <input value="${thisBranch.managerMobile}" type="text"
						name="managerMobile" ng-model="event_name" class="form-control"
						required pattern=[7-9][0-9]{9} maxlength="10"
						title="please enter your 10 digit phone number(Ex:9749692397)">
				</div>
				<div class="col-sm-3">
					<span>Landline No <label></label>
					</span> <input type="text" name="landLine" ng-model="event_name"
						class="form-control" placeholder="optional">
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-success" style="display: none">
		<div class="panel-heading">
			<center>License Details</center>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-3">
					<span>License Name <label></label>
					</span> <select class="form-control" name="license_name" id="license_name">
						<option value="">Select License</option>
					</select>
				</div>
				<div class="col-sm-3">
					<span>License Key <label></label>
					</span> <select name="license_key" id="license_key" class="form-control"
						onblur="check();">
						<option value="">Select License Key</option>
					</select>
				</div>
				<div class="col-sm-3">
					<span>Valid From <label></label>
					</span> <input type="text" name="valid_from" id="valid_from"
						class="form-control" readOnly>
				</div>
				<div class="col-sm-3">
					<span>Valid To <label></label>
					</span> <input type="text" name="valid_to" id="valid_to"
						class="form-control" readOnly>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<span>License Type <label></label>
					</span> <input type="text" name="license_type" id="license_type"
						class="form-control">
				</div>
				<div class="col-sm-3">
					<span>Billing Frequency <label></label>
					</span> <input type="text" name="billing_frequency" id="billing_frequency"
						class="form-control">
				</div>
				<div class="col-sm-3">
					<span>User Price <label></label>
					</span> <input type="text" name="user_price" id="user_price"
						class="form-control" onblur="submitForm();">
				</div>
			</div>
		</div>
	</div>
	<center>
		<input type="submit" id="button" value="Submit"
			class="btn btn-primary btn-md js-submit-button"
			ng-disabled="myForm.user.$dirty && myForm.user.$invalid ||  myForm.email.$dirty && myForm.email.$invalid">
	</center>
	<br>

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
				navigator.geolocation
						.getCurrentPosition(function(position) {
							var geolocation = new google.maps.LatLng(
									position.coords.latitude,
									position.coords.longitude);

							var latitude = position.coords.latitude;
							var longitude = position.coords.longitude;
							document.getElementById("latitude").value = latitude;
							document.getElementById("longitude").value = longitude;

							autocomplete
									.setBounds(new google.maps.LatLngBounds(
											geolocation, geolocation));
						});
			}
		}
		initAutocomplete();
	</script>