<!-- Popular Cities Block Start -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
function submitForm(latitude,longitude,address){
	var form = document.createElement("form");
   document.body.appendChild(form);
   form.method = "POST";
   form.action = "search_office_outside.jsp";
   
   var element1 = document.createElement("INPUT");         
    element1.name="Latitude"
    element1.value = latitude;
    element1.type = 'hidden'
    form.appendChild(element1);

   var element2 = document.createElement("INPUT");         
    element2.name="Longitude"
    element2.value = longitude;
    element2.type = 'hidden'
    form.appendChild(element2);
	
   var element3 = document.createElement("INPUT");         
    element3.name="address"
    element3.value = address;
    element3.type = 'hidden'
    form.appendChild(element3);
	
	
    form.submit();
}
</script>

<style>
.popular_city img {
    width: 100%;
    max-width: 100%;
    height: 150px;
}
</style>


<div class="popular-cities">
    <div class="container text-center">
        <h3 class="title">Popular Cities</h3>
        <div class="row">
            <c:forEach items="${popularCities}" var="city">
	            <div class="col-md-3 col-sm-6" onclick="submitForm('')" style="cursor:pointer">
	                <div class="popular_city">
	                    <img src="${rc.getContextPath()}/resources/images/popular-city/${city.img}">
	                    <p class="overlay_text">${city.cityName}</p>
	                </div>
	            </div>
		    </c:forEach>
        </div><!--/.row -->
    </div><!--/.container -->
</div><!--/.popular-cities -->
<!-- Popular Cities Block End -->

