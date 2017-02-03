<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="favicon.png" type="image/png" />
    <title>How it works?</title>
</head>
<body>
<%@include file="header/application_header.jsp"%>
<main class="main-contents how-it-works">
    <div class="container">
        <div class="row">
            <h3>How it works?</h3>
            <img src="${rc.getContextPath()}/resources/images/how-it-works/how-it-works.jpg" alt="how it works" />

            <div class="row bs-wizard">
                <div class="col-xs-3 bs-wizard-step complete">
                    <div class="text-center bs-wizard-stepnum">Step 1</div>
                    <div class="progress">
                        <div class="progress-bar"></div>
                    </div>
                    <a href="#" class="bs-wizard-dot"></a>
                    <div class="bs-wizard-info text-center">
                    </div>
                </div>

                <div class="col-xs-3 bs-wizard-step complete">
                    <!-- complete -->
                    <div class="text-center bs-wizard-stepnum">Step 2</div>
                    <div class="progress">
                        <div class="progress-bar"></div>
                    </div>
                    <a href="#" class="bs-wizard-dot"></a>
                    <div class="bs-wizard-info text-center">
                        Find an Office space that matches your requirements with our advanced search engine.
                    </div>
                </div>

                <div class="col-xs-3 bs-wizard-step complete">
                    <!-- complete -->
                    <div class="text-center bs-wizard-stepnum">Step 3</div>
                    <div class="progress">
                        <div class="progress-bar"></div>
                    </div>
                    <a href="#" class="bs-wizard-dot"></a>
                    <div class="bs-wizard-info text-center">
                        Register and login to the portal, check availability, pay online and book your slot.
                        You are now ready to move.
                    </div>
                </div>

                <div class="col-xs-3 bs-wizard-step active">
                    <!-- active -->
                    <div class="text-center bs-wizard-stepnum">Step 4</div>
                    <div class="progress">
                        <div class="progress-bar"></div>
                    </div>
                    <a href="#" class="bs-wizard-dot"></a>
                    <div class="bs-wizard-info text-center">
                        Our flexible plans allows you to renew/stop your subscription at
                        your convenience. Cancellation policy may vary.
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%@include file="footer/application_footer.jsp"%>

</body>
</html>
