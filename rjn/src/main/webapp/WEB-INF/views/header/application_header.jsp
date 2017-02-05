<%@include file="../include/css_include.jsp"%>
<script type="text/javascript">
	var _context = '${rc.getContextPath()}';
</script>
<header ng-app="RJN">
    <nav class="navbar navbar-fixed-top">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#site-navigation" aria-expanded="false" aria-controls="site-navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${rc.getContextPath()}">
                        <img class="brand-logo" src="${rc.getContextPath()}/resources/images/logo/logo.png" alt="Logo">
                    </a>
                </div><!--/.navbar-header -->
                <div id="site-navigation" class="navbar-collapse collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="${rc.getContextPath()}/list-your-shop">Enquiry</a></li>
                        <li><a href="${rc.getContextPath()}/contact-us">Contact us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-actions navbar-right">
	                    <li><a data-toggle="modal" data-target="#myModal" >Login</a></li>
	                    <li><a href="${rc.getContextPath()}/member/register">Customer regestration</a></li>
	                </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.row -->
        </div><!--/.container -->
    </nav><!--/.navbar-default -->
</header>


<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">`</h4>
      </div>
      <div class="modal-body">
          <form name='f' action="login" method='POST'>
		      <table>
		         <tr>
		            <td>User Id:</td>
		            <td><input type='text' name='username' value=''></td>
		         </tr>
		         <tr>
		            <td>Password:</td>
		            <td><input type='password' name='password' /></td>
		         </tr>
		         <tr>
		            <td><input name="submit" type="submit" value="submit" /></td>
		         </tr>
		      </table>
		      <input name="pageName" type="hidden" value="${pageName}"/>
		      <input name="searchKeyWord" type="hidden" value="${param.thisProduct}"/>
		  </form>
		  <a data-toggle="modal" data-target="#forgetPasswordModal">Forget Password ??</a>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#registerModal">Register</button>
      </div>
    </div>
  </div>
</div>
<!-- 
======================================== -->
<!-- Modal -->
<div id="registerModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">login</h4>
      </div>
      <div class="modal-body">
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
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<!-- ====================================================== -->
<!-- Modal -->
<div id="forgetPasswordModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Forget Password</h4>
			</div>
			<div class="modal-body">
				<form action="${rc.getContextPath()}/forgetPassword" method='POST'>
					<table>
						<tr>
							<td>Email id:</td>
							<td><input type='text' name='email' value=''></td>
						</tr>
					</table>
					<button type="submit" class="btn btn-default-alt">Register</button>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>