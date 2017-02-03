<!DOCTYPE html>
<html lang="en">

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<head>   
    <%@include file="common/meta.jsp"%>
    <title>RJN</title>
</head>
<body>
<%@include file="header/application_header.jsp"%>
<main class="main-contents">

    <%@include file="homepage_search.jsp"%>
	<%@include file="popular_cities.jsp"%>
	
    <!-- Advert Cards Holder Block Start -->
    <div class="advert-cards-holder">
        <div class="container">
            <div class="row">
              <div class="col-md-6">
                  <div class="advert-card">
                      <div class="col-md-4">
                          <img src="${rc.getContextPath()}/resources/images/home/explore-office-space-icon.png">
                      </div>
                      <div clas="col-md-8">
                          <h4>Explore office spaces</h4>
                          <p>Looking for office space that serves your purpose?.Now choose your dream office from 100's of premium workplaces around you.</p>
                          <p><a href="search_office_outside.jsp" class="btn btn-default btn-sm" style="pointer-events: none;cursor: not-allowed;">Know more</a></p>
                      </div>
                  </div>
              </div>
              <div class="col-md-6">
                  <div class="advert-card">
                      <div class="col-md-4">
                          <img src="${rc.getContextPath()}/resources/images/home/list-your-office-space-icon.png">
                      </div>
                      <div clas="col-md-8">
                          <h4>List your office spaces with us</h4>
                          <p> List your Office Space with Apna Office and get access to exclusive features tailor made for you!</p>
                          <br>
                          <p><a href="List_Your_Space.jsp" class="btn btn-default btn-sm">Know more</a></p>
                      </div>
                  </div>
              </div>
            </div><!--/.row -->
        </div><!--/.container -->
    </div><!--/.advert-cards-holder -->
    <!-- Advert Cards Holder Block End -->
    
    <%@include file="our_partners.jsp"%>
</main>

</body>

<%@include file="footer/application_footer.jsp"%>

<%@include file="common/float_bar.jsp"%>
</html>
