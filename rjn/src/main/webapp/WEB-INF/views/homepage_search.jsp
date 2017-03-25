<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="text-center"></div>
<div class="container">
	<br> <br> <br> <br> <br> <br>
	<form action="${rc.getContextPath()}/search"
		class="row form-horizontal">

		<div class="col-xs-12 col-md-4">
			<select name="cityId" class="form-control">
				<c:forEach items="${cityList}" var="thisCity">
				    <option value="${thisCity.id}">${thisCity.city}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-xs-12 col-md-4">
			<input class="form-control" name="thisProduct" />
		</div>
		<div class="col-xs-12 col-md-2">
			<button type="submit" class="btn btn-default">
				<i class="fa fa-search"></i> Search
			</button>
		</div>
	</form><br><br>
</div>
