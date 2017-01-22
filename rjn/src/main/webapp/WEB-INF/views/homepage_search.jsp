<%@ page import="java.util.*"%>
<div class="apna-office-search">
	<div class="apna-office-search-form">
		<div class="text-center"></div>
		<div class="text-center">
			<h3 class="title">
				<small class="description">We help you to improve your
					business</small>
			</h3>
		</div>
		<div class="container">
			<form action="${rc.getContextPath()}/search"
				class="row form-horizontal">
				<div class="col-xs-12 col-md-4 col-md-offset-2">
					<input class="form-control" name="thisProduct" />
				</div>
				<div class="col-xs-12 col-md-2">
					<button type="submit" class="btn btn-default">
						<i class="fa fa-search"></i> Search
					</button>
				</div>
			</form>
		</div>
	</div>
</div>