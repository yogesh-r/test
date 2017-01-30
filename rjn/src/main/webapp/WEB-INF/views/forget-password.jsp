<%@include file="header/application_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main"></br></br></br></br></br></br>
	<div class="container">
		<input type='hidden' id='user_id' value=''>
		<div class="panel panel-info">
			<div class="panel-heading">Reset Password</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
						<form action="${rc.getContextPath()}/header/change-password"
							method="POST">
							<label for="new password">New Password</label> <input
								type="password" class="form-control" name="newPassword"
								placeholder="New Password"> <label
								for="conform password">Conform Password</label> <input
								type="password" class="form-control" name="conformPassword"
								placeholder="Conform Password"> <input type="hidden"
								name="token" value="${token}"> <input type="hidden"
								name="profileNumber" value="${profileNumber}">

							<button type="submit" class="btn btn-default">Submit</button>
							<button type="button" class="btn btn-default">Cancel</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
