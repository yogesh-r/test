<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="shortcut icon" href="favicon.png" type="image/png" />
    <title>Register Vendor</title>
	<style>
		.section {
			color: red;
			//text-align: center;
		}		
	</style>
</head>
<body>
<%@include file="header/application_header.jsp"%>
<main class="main-contents">
    <div class="container">
        <div class="row login">
         <div class="col-md-4 col-md-offset-1">
		<div>
			<div class="section" style="display:block;"> <i class="fa fa-warning"></i></div>
		</div>
				<form:form method="POST" modelAttribute="vendor" action="${rc.getContextPath()}/member/register">
					<div class="form-group">
                        <label for="first_name">First Name *</label>
                        <input type="text" id="first_name" name="firstName" required title="Please enter your first name" class="form-control" value="" >
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name *</label>
                        <input type="text" id="last_name" name="lastName" class="form-control">
                    </div>
                    <div class="form-group">
					<label for="contact_mobile_no">Contact No. *</label>
                        <input type="text" value="" name="contactMobileNo" id="contact_mobile_no"  class="form-control" required pattern=[7-9][0-9]{9} maxlength="10" title="please enter your 10 digit phone number(Ex:9749692397)">
                    </div>
                    <div class="form-group">
                        <label for="contact_email_id">Email ID *</label>
                        <input type="email" value="" name="contactEmailId" id="contact_email_id" value="" class="form-control" required onblur="checkExist();"><span id="isE"></span>
                    </div>
                    <div class="form-group">
                        <label for="pass1">Password *</label>
                        <input type="password" name="password" id="pass1" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="pass2">Repeat Password *</label>
                        <input type="password" name="cpwd" id="pass2"  class="form-control" onkeyup="checkPass(); return false;" required>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default-alt js-submit-button">Register</button>
                    </div>
				</form:form>
            </div>
        </div>
    </div>
</main>

<%@include file="footer/application_footer.jsp"%>

</body>
</html>
