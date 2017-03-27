<%-- <%@include file="../include/css_include.jsp"%> --%>
<link href="${rc.getContextPath()}/resources/UI/css/common.css" rel="stylesheet" type="text/css" />
<!----Media queries css--->
<link href="${rc.getContextPath()}/resources/UI/css/style.css"
	type="text/css" rel="stylesheet" />
<link href="${rc.getContextPath()}/resources/UI/css/theme1024.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/theme990.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/theme768.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/theme480.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/theme320.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/theme319.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/quickweb.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/fonts/style.css"
	rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/resources/UI/css/slider_css.css"
	type="text/css" rel="stylesheet" />
<link
	href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600,700,900'
	rel='stylesheet' type='text/css' />
<script src="${rc.getContextPath()}/resources/UI/js/jquery-ui.js"></script>
<script
	src="${rc.getContextPath()}/resources/UI/js/jquery-1.11.3.min.js"></script>
<script src="${rc.getContextPath()}/resources/UI/js/slider.js"></script>
<script src="${rc.getContextPath()}/resources/UI/js/plugin.js"></script>


<script type="text/javascript">
	var _context = '${rc.getContextPath()}';
</script>
<body ng-app="RJN">
	<header>
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
		                    <li><a href="" data-toggle="modal" data-target="#myModal" >Login</a></li>
		                    <li><a href="${rc.getContextPath()}/member/register">Customer regestration</a></li>
		                </ul>
	                </div><!--/.nav-collapse -->
	            </div><!--/.row -->
	        </div><!--/.container -->
	    </nav><!--/.navbar-default -->
	</header>
</body>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Login</h4>
      </div>
      <div class="modal-body">
          <form name='f' action="login" method='POST'>
		     
		        <div class="form-group">
		             <label>User Id:</label>
		            <input type='text' class="form-control" name='username' value=''>
		        </div>
		         
		        <div class="form-group">
		            Password:
		            <input type='password' class="form-control" name='password' />
		        </div>
		        
		         <div class="form-group">
		            <input name="submit" type="submit" value="submit" class="btn btn-primary"/>
		         </div>
		        
		      
		      <input name="pageName" type="hidden" value="${pageName}"/>
		      <input name="searchKeyWord" type="hidden" value="${param.thisProduct}"/>
		       <input name="cityId" type="hidden" value="0"/>
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
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/jquery.jqplot.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/angular-wizard.min.css">
	
<div id="registerModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Register</h4>
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
                        <button type="submit" class="btn btn-primary js-submit-button">Register</button>
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