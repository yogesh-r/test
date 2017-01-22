<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Customer Register</title>
<!-- Scripts For Bootstrap DateTimePicker---->
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
</head>
<body>
	<%@include file="../header/vendor_header.jsp"%>
	<div class="main">
		<div class="container">
			<form action="${rc.getContextPath()}/partner/customer_register " method="post" id="form1"
				name="form1" onsubmit="return validateForm()">
				<div class="panel panel-default">
					<div class="panel-heading">
						<center>
							<h4>Customer Registration</h4>
						</center>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-1"></div>
							<div class="col-sm-3">
								<input type="hidden" name="myUserId" value="" /> <input
									type="hidden" value="" name="partner_id" id="partner_id" /> <span>Partner<label></label></span>
								<select name="branch_owner" class="form-control" id="branch_owner">
								
								
								 <c:forEach items="${partnerList}" var="thisPartner">
								    <option value=""> <c:out value="${thisPartner.id}" /></option>
								 </c:forEach>
									
								</select>
							</div>
							
							<div class="col-sm-3">
								<span>Branch<label></label></span> 
								<select id="branch"
									name="branch_name" class="form-control">
									
								 <c:forEach items="${branchList}" var="thisBranch">
								    <option value=""> <c:out value="${thisBranch.branchName}" /></option>
								 </c:forEach>
									<option value=""></option>
								</select>
							</div>
							<div class="col-sm-3">
								<span>Profile Type<label></label></span> <select
									name="profile_type" class="form-control" id="profile_type">
									<option value="Individual">Individual</option>
									<option value="Company">Company</option>
								</select>
							</div>
						</div>
						<div class="row" style="display: none">
							<div class="col-sm-1"></div>
							<div class="col-sm-3">
								<span> Customer No. <label></label></span> <input type="text"
									id="profile_number" name="profile_number" class="form-control"
									disabled="disabled" />
							</div>
							<div class="col-sm-3">
								<span>Contact Type<label></label></span> <select
									name="relationship" class="form-control">
									<option>Customer</option>
									<option>Prospect</option>
									<option>Employee</option>
								</select>
							</div>
							<div class="col-sm-3">
								<span>How do you know us ?<label></label></span> <select
									name="know_us_source" id="know_us_source" class="form-control"
									onchange="showTextBox()">
									<option value='Facebook'>Facebook</option>
									<option value='Linked In'>Linked In</option>
									<option value='Google'>Google</option>
									<option value='News Paper'>News Paper</option>
									<option value='Radio'>Radio</option>
									<option value='Friend Reference'>Friend Reference</option>
									<option value='Word of Mouth'>Word of Mouth</option>
									<option value='Other'>Other</option>
								</select>
							</div>
							<div class="col-sm-2">
								<div id="Other" class="showother" style="display: none">
									<span>Please Specify<label></label></span> <input name="Other"
										id="textbox" type="text" class="form-control" />
								</div>
							</div>
						</div>
						<div class="Individual box ">
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>First Name <label></label></span> <input type="text"
										id="first_name" name="first_name" class="form-control" />
								</div>
								<div class="col-sm-3">
									<span>Last Name <label></label></span> <input type="text"
										id="last_name" name="last_name" class="form-control" />
								</div>
								<div class="col-sm-3">
									<span>Company Name <label></label></span> <select
										id="cust_company_name" name="cust_company_name"
										class="form-control">
											
								 <c:forEach items="${allCompanyList}" var="thisCompany">
								    <option value=""> <c:out value="${thisCompany.custCompanyName}" /></option>
								 </c:forEach>
								</select>
										
									</select>
								</div>
								<div class="col-sm-2">
									<div id="cust_Others" class="cust_showothers"
										style="display: none">
										<span>Please Specify<label></label></span> <input
											name="cust_company" id="cust_company" type="text"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>Gender<label></label></span> <select name="gender"
										class="form-control" id="gender">
										<option value="Male">Male</option>
										<option value="Female">Female</option>
										<option value="NA">NA</option>
									</select>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<div>DOB</div>
										<div class='input-group date col-md-12'>
											<input type='text' class="form-control" id='dob_date'
												name="dob_date" />
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<span> ID Type<label></label></span> <select name="Id_Type"
										class="form-control" id="ID_Type">
										<option value="">Select Id Type</option>
										<option value="Aadhar Card">Aadhar Card</option>
										<option value="PAN Card">PAN Card</option>
										<option value="Voter Card">Voter Card</option>
										<option value="Driving License">Driving License</option>
										<option value="Others">Others</option>
									</select>
								</div>
								<div class="col-sm-2">
									<div id="Others" class="showothers" style="display: none">
										<span>Please Specify<label></label></span> <input
											name="Individual_Other" id="textbox" type="text"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span> ID Number<label></label></span> <input type="text"
										id="Id_Number" name="Id_number" class="form-control" />
								</div>
								<div class="col-sm-3">
									<span>Email ID<label></label></span> <input
										name="contact_email_id" id="contact_email_id" value=""
										class="form-control" onblur="checkExist();" /><span id="isE"></span>
								</div>
								<div class="col-sm-3">
									<div id="Other" class="Mem_showother">
										<span>Set Default Password </span> <input name="Mem_Password"
											id="Mem_textbox" type="password" class="form-control" />
									</div>
								</div>
							</div>
						</div>
						<div class="Company box ">
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>Company name<label></label></span> <input type="text"
										name="company_name" value="" class="form-control" />
								</div>
								<div class="col-sm-3">
									<span>Contact Name <label></label></span> <input type="text"
										id="company_contact_name" name="company_contact_name"
										class="form-control" />
								</div>
								<div class="col-sm-3">
									<span> ID Type<label></label></span> <select name="Alt_Id_Type"
										class="form-control" id="Alt_Id_Type">
										<option value="">Select Id Type</option>
										<option value="Aadhar Card">Aadhar Card</option>
										<option value="PAN Card">PAN Card</option>
										<option value="Voter Card">Voter Card</option>
										<option value="Driving License">Driving License</option>
										<option value="Others">Others</option>
									</select>
								</div>
								<div class="col-sm-2">
									<div id="C_Others" class="C_showothers" style="display: none">
										<span>Please Specify<label></label></span> <input
											name="C_Id_Name" id="C_Id_Name" type="text"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span> ID Number<label></label></span> <input type="text"
										id="C_ID_Number" name="C_ID_Number" class="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-1"></div>
							<div class="col-sm-3">
								<span>Profile Category<label></label></span> <select
									name="profile_category" class="form-control">
									 <c:forEach items="${profileCatagory}" var="thisProfileCat">
								    <option value=""> <c:out value="${thisProfileCat.lookupValues}" /></option>
								 </c:forEach>
								</select>
							</div>
							<div class="col-sm-3">
								<span>Price List<label></label></span> <select name="price_list"
									class="form-control">
									<option>Standard</option>
									<option>Corporate</option>
								</select>
							</div>
							<div class="col-sm-3">
								<span>Discount Type<label></label></span> <select
									name="discount_type" class="form-control">
									<option>Standard</option>
									<option>Corporate</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-1"></div>
							<div class="col-sm-3" style="display: none">
								<span>Flat Discount (%)<label></label></span> <input
									name="flat_discount_percent" value="0" class="form-control" />
							</div>
							<div class="col-sm-3" style="display: none">
								<span>Membership<label></label></span> <select name="Membership"
									id="Membership" class="form-control" onchange="showTextBox()">
									<option value='YES' selected="selected">YES</option>
									<option value='NO'>NO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<center>Branch Address Information</center>
						</div>
						<div class="panel-body">
							<div class="row" style="margin-bottom: 10px">
								<div class="col-sm-1"></div>
								<div id="locationField">
									<div style="margin-right: 70px" class="col-sm-8 pull-left">
										<input id="autocomplete" type="text" class="form-control"
											style="width: 818px"></input>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>Address Line 1<label></label></span> <input
										class="field form-control" id="street_number" name="addr"></input>
								</div>
								<div class="col-sm-3">
									<span>Address Line 2<label></label></span> <input
										class="field form-control" id="route" name="route"></input>
								</div>
								<div class="col-sm-3">
									<span>Location</span> <input class="field form-control"
										id="sublocality_level_1" name="location" readonly="readonly"></input>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>City<label></label></span> <input
										class="field form-control" id="locality" name="city_name"
										readonly="readonly"></input>
								</div>
								<div class="col-sm-3">
									<span>State<label></label></span> <input
										class="field form-control" name="stat"
										id="administrative_area_level_1" readonly="readonly"></input>
								</div>
								<div class="col-sm-3">
									<span>Country<label></label></span> <input
										class="field form-control" name="count" id="country"
										readonly="readonly"></input>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>ZipCode*<label></label></span> <input type="text"
										name="zcode" id="postal_code" class="field form-control"
										readonly="readonly" />
								</div>
								<div class="col-sm-3">
									<span>Status<label></label></span> <select name="stats"
										class="form-control">
										<option value='Active'>Active</option>
										<option value='Inactive'>Inactive</option>
									</select>
								</div>
								<div class="col-sm-3">
									<input type="hidden" class="field form-control" id="latitude"
										name="latitude"></input>
								</div>
								<div class="col-sm-3">
									<input type="hidden" class="field form-control" id="longitude"
										name="longitude"></input>
								</div>
							</div>
						</div>
						<!-- panel body end-->
					</div>
					<!-- panel end-->
					<div class="panel panel-default">
						<div class="panel-heading">
							<center>Contact Details</center>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3">
									<span>Mobile No<label></label></span> <input type="text"
										name="contact_mobile_no" value="" maxlength="10"
										title="please enter your 10 digit phone number(Ex:9749692397)"
										class="form-control" />
								</div>
								<div class="col-sm-3">
									<span>Alt Phone No<label></label></span> <input type="text"
										name="contact_alt_phone" value="" maxlength="10"
										title="please enter your 10 digit phone number(Ex:9749692397)"
										class="form-control" />
								</div>
								<div class="col-sm-3">
									<span>Alt Email ID<label></label></span> <input
										name="contact_alt_email" value="" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-3" style="display: none">
									<span>Email_MSG_ID<label></label></span> <input type="text"
										name="Email_MSG_ID" value="" class="form-control"
										readonly="readonly" />
								</div>
								<div class="col-sm-3" style="display: none">
									<span>SMS_MSG_ID<label></label></span> <input type="text"
										name="SMS_MSG_ID" value="" class="form-control"
										readonly="readonly" />
								</div>
							</div>
						</div>
						<!-- Panel Body Closed -->
					</div>
					<!-- Panel Body Closed -->
					<div class="row" align="center">
						<div class="col-sm-2"></div>
						<div class="col-sm-3"></div>
						<div class="col-sm-3">
							<input type="submit" value="Register" id="js-submit-button"
								class="form-control btn-primary" />
						</div>
					</div>
					<!-- padding -->
					<div style="height: 10px; line-height: 40px; font-size: 40px;"></div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.5.1/moment.min.js"></script>
	<!-- For Time Active This Script -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.4.0/lang/en-gb.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCdrHIPbEWvJF1K_BCTfKS9Aupm54Q9KGk&libraries=places&callback=initAutocomplete"></script>
	<script type="text/javascript">
		jQuery.noConflict();
		$(document).ready(function() {
			$("select").change(function() {
				$(this).find("option:selected").each(function() {
					if ($(this).attr("value") == "Individual") {
						$(".box").not(".Individual").hide();
						$(".Individual").show();
					} else if ($(this).attr("value") == "Company") {
						$(".box").not(".Company").hide();
						$(".Company").show();
					}
				});
			}).change();
		});
		function showState(str) {
			var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari 
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5 
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("state").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "getstate.jsp?q=" + str, true);
			xmlhttp.send();
		}
		function validateForm() {
			var x = $("form input#textbox").val();
			if ($('.showother').is(":visible")) {
				if (x == null || x == "") {
					alert("Text box be filled out");
					return false;
				}
			}
		}
		$(document).ready(function() {
			$('#know_us_source').change(function() {
				if ($(this).val() == "Other") {
					$('.showother').show();
				} else {
					$('.showother').hide();
				}
			});
		});
		$(document).ready(function() {
			$('#ID_Type').change(function() {
				if ($(this).val() == "Others") {
					$('.showothers').show();
				} else {
					$('.showothers').hide();
				}
			});
			$('#Alt_Id_Type').change(function() {
				if ($(this).val() == "Others") {
					$('.C_showothers').show();
				} else {
					$('.C_showothers').hide();
				}
			});
			$('#cust_company_name').change(function() {
				if ($(this).val() == "Others") {
					$('.cust_showothers').show();
				} else {
					$('.cust_showothers').hide();
				}
			});
			$('#Membership').change(function() {
				if ($(this).val() == "NO") {
					$('.Mem_showother').hide();
				} else {
					$('.Mem_showother').show();
				}
			});
		});
		jQuery('#dob_date').datetimepicker({
			format : 'DD-MM-YYYY',
			pickTime : false
		});
		$(document).ready(
				function() {
					$.get('license.jsp', {
						type : 'check_license',
						partner_id : "",
						jspPage : "customer_register.jsp"
					}, function(responseJson) {

						console.log(responseJson);
						var $select = $('#branch');
						$select.find('option').remove();
						$('<option>').val("ALL").text("Select Branch")
								.appendTo($select);
						$.each(responseJson[0], function(key, value) {
							$('<option>').val(key).text(value)
									.appendTo($select);
						});
					});
				});
		$(document).ready(
				function() {
					//City Selection for default country,
					// To get the selected name of the city. #city is the id of the select filed
					$('#state').click(
							function(event) {
								var $state = $("select#state").val();
								$.get('query_location.jsp', {
									type : 'new_city1',
									statename : $state
								}, function(responseJson) {
									var $select = $('#city');
									$select.find('option').remove();
									$('<option>').val("ALL")
											.text("Select City").appendTo(
													$select);
									$.each(responseJson, function(key, value) {
										$('<option>').val(key).text(value)
												.appendTo($select);
									});
								});
							});
					//City Chnage Event for location value changes.
					$('#city').click(
							function(event) {
								var vl = $("#city option:selected").text();
								$(".js-city-for-db").val(vl);
								//alert('Calling the Servlet ');
								var $state = $("select#state").val();
								var $city = $("select#city").val();
								$.get('query_location.jsp', {
									type : 'new_location',
									cityname : $city
								}, function(responseJson) {
									var $select = $('#location');
									$select.find('option').remove();
									$('<option>').val("ALL").text(
											"Select Location")
											.appendTo($select);
									$.each(responseJson, function(key, value) {
										// alert('REturn  key '+key+" value "+value);
										$('<option>').val(key).text(value)
												.appendTo($select);
									});
								});
							});
				});
		function checkExist() {
			var xmlhttp = new XMLHttpRequest();
			var email_id = document.forms["form1"]["contact_email_id"].value;
			var url = "email_exist_crm.jsp?email_id=" + email_id;
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					if ((xmlhttp.responseText).trim() == "Email already exists") {
						document.getElementById("isE").style.color = "red";
						document.getElementById("isE").innerHTML = xmlhttp.responseText;
						$('#js-submit-button').prop('disabled', true);
					} else {
						console.log("else block");
						document.getElementById("isE").style.color = "green";
						document.getElementById("isE").innerHTML = xmlhttp.responseText;
						$('#js-submit-button').prop('disabled', false);
					}
				}
			};
			try {
				xmlhttp.open("GET", url, true);
				xmlhttp.send();
			} catch (e) {
			}
			abc();
		}
		function abc() {
			if ($('#contact_email_id').val() == "") {
				console.log("hide");
				$("#isE").hide();
			} else {
				console.log("shooow");
				$("#isE").show();
			}
		}
		/*  This example displays an address form, using the autocomplete feature
		 of the Google Places API to help users fill in the information. */
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
			/*  Create the autocomplete object, restricting the search
			 to geographical location types.*/
			autocomplete = new google.maps.places.Autocomplete(
			/** @type {HTMLInputElement} */
			(document.getElementById('autocomplete')), {
				types : [ 'geocode' ]
			});
			/* 			 When the user selects an address from the dropdown,
			 populate the address fields in the form. */
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
		// [END region_geolocation]
	</script>
</body>
</html>