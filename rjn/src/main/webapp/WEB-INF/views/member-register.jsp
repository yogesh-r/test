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
		<c:if test="${not empty errorMessage}">
			<span>${errorMessage}</span>		
		</c:if>
				<form:form method="POST" modelAttribute="vendor" action="${rc.getContextPath()}/member/register">
					<div class="form-group">
                        <label for="first_name">First Name *</label>
                        <form:input path="firstName" type="text" id="first_name" name="firstName" required="true" class="form-control" value="" />
                    	 &nbsp;<form:errors path="firstName" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name *</label>
                        <form:input path="lastName" type="text" id="last_name" name="lastName" class="form-control" required="true"/>
                   		&nbsp;<form:errors path="lastName" cssClass="error"/>
                    </div>
                    <div class="form-group">
					<label for="contact_mobile_no">Contact No. *</label>
                        <form:input path="contactMobileNo" type="text" value="" name="contactMobileNo" id="contact_mobile_no"  class="form-control" required="true" maxlength="10"  />
                    	&nbsp;<form:errors path="contactMobileNo" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="contact_email_id">Email ID *</label>
                        <form:input path="contactEmailId" type="email" name="contactEmailId" id="contact_email_id" value="" class="form-control" required="true" onblur="checkExist();" />
                    	&nbsp;<form:errors path="contactEmailId" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="pass1">Password *</label>
                        <form:input type="password" path="password" name="password" id="pass1" class="form-control" required="true" />
                   		&nbsp;<form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="pass2">Repeat Password *</label>
                        <form:input type="password" path="cpwd" name="cpwd" id="pass2"  class="form-control" onkeyup="checkPass(); return false;" required="true" />
                    	&nbsp;<form:errors path="cpwd" cssClass="error"/>
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
