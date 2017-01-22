<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="common/meta.jsp"%>
<link rel="shortcut icon" href="favicon.png" type="image/png" />
<title>Why Us?</title>
</head>
<body>
	<%@include file="header/application_header.jsp"%>
	<div class="container">
		<table border="0" cellspacing="0" cellpadding="0"
			class="table_width_100" width="100%"
			style="max-width: 780px; min-width: 300px;" align="center">
			<tr>
				<td align="center" bgcolor="#ffffff">
					<!-- padding -->
					<div style="height: 30px; line-height: 30px; font-size: 10px;"></div>
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						align="center">
						<tr>
							<td align="center" bgcolor="#fbfcfd">
								<table width="80%" border="0" cellspacing="0" cellpadding="0">
									<!-- Fourth Table open -->
									<tr>
										<td align="center">
											<div
												style="height: 10px; line-height: 30px; font-size: 10px;"></div>
											<div style="line-height: 24px;">
												<font face="Arial, Helvetica, sans-serif" size="4"
													color="#57697e" style="font-size: 34px;"> <span
													style="font-family: Arial, Helvetica, sans-serif; font-size: 18px; color: #57697e;">
														Congratulations !! Your membership registered at --
														Office. </span></font>
											</div> <!-- padding -->
											<div
												style="height: 20px; line-height: 20px; font-size: 10px;"></div>
										</td>
									</tr>
									<tr>
										<td align="center">
											<div style="line-height: 20px;">
												<font face="Arial, Helvetica, sans-serif" size="4"
													color="#57697e" style="font-size: 12px;"> <span
													style="font-family: Arial, Helvetica, sans-serif; font-size: 15px; color: #57697e;">

												</span></font>
											</div> <!-- padding -->
											<div style="height: 40px; line-height: 40px;">Member
												Registered Successfully</div>
										</td>
									</tr>

								</table> <!-- Fourth Table close -->
							</td>
						</tr>
						<tr>
							<td align="center" bgcolor="#ffffff"
								style="border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #eff2f4;">
								<table width="94%" border="0" cellspacing="0" cellpadding="0">
									<div style="height: 20px; line-height: 20px; font-size: 10px;"></div>
									<div class="panel panel-info">
										<div class="panel-body">
											<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-4">
													<span>Member Id<label> : ${contactEmail} </label></span>
												</div>
												<div class="col-sm-4"></div>
											</div>
											<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-4">
													<span>Registration Id<label> : ${profileNumber} </label></span>
												</div>
												<div class="col-sm-4"></div>
											</div>

										</div>
										<!-- Div row compelted -->

									</div>
									<!-- Panel Body -->

									<div class="panel-footer clearfix"
										style="background-color: #fbfcfd;">
										<div>
											<a href="login.jsp" class="btn btn-default">Login</a>
										</div>
									</div>
									<!-- Panel Foother Completed -->
									</div>
									<!-- Panel Compelte -->
									<!-- padding -->
									<div style="height: 20px; line-height: 20px; font-size: 10px;"></div>

								</table> <!-- Fith Table close -->
							</td>
						</tr>
						<!--content 2 END-->
					</table> <!-- Third Table close -->
			<tr>
				<td>
		</table>
		</td>
		</tr>
		<tr>
			<td>
				</table>
	</div>
	</div>

	<%@include file="footer/application_footer.jsp"%>

</body>
</html>
