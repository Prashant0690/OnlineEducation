<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Course Home</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css" >
    
    <!-- <link rel="stylesheet" href="css/creative.css" type="text/css"> -->
    <style type="text/css"><%@ include file="../css/creative.css" %></style>
    

</head>
<body >

<body id="page-top">

<nav class="navbar navbar-default " id="navigation">
  <div class="container-fluid">
  <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
     
    </div>
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  <a class="navbar-brand" href='<spring:url value="/index.html" />'>Collaborative learning</a>
   <ul class="nav nav-pills">
   	  <li  class="${magazineMenu=='Update'?'abc':'' }">
   	  	   <a href='<spring:url value="/classroom/TheMagazineCourse/${courseModel.courseId}/${courseModel.courseName}/all/updates.html" />' >
   	  	   Magazine Update</a></li>
	  <li  class="${magazineMenu=='Cover'?'abc':'' }">
	  	   <a href='<spring:url value="/classroom/TheMagazineCourse/${courseModel.courseId}/${courseModel.courseName}.html" />' >
	  	   Magazine Cover</a></li>
	  <li  class="${magazineMenu=='Page'?'abc':'' }">
	  	   <a href='<spring:url value="/classroom/TheMagazineCourse/${courseModel.courseId}/${courseModel.courseName}/pagelist.html" />' >
	  	   Magazine Pages</a></li>
	  <li  class="navbar-right">
	  	   <a href='<spring:url value="/student/studentDashboard.html" />'>
	  	   <span class="glyphicon glyphicon-home" aria-hidden="true"></span>HOME</a></li>
	  
	</ul>

	</div>
  </div>
 
</nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>${typeMagazine.title}</h1>
                <hr>
                <blockquote>
                	<p>${typeMagazine.openingQuote}</p>
                </blockquote>
                <a href="#about" class="btn btn-primary btn-xl">Find Out More</a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Latest Update</h2>
                    <hr class="light">
                    <!-- <p class="text-faded"> </p> -->
                    <blockquote>
				 	  <h3><mark> ${latestUpdate.updateTitle}</mark> </h3>
				 	  <footer>Posted On :<cite title="Source Title">
				 	  <fmt:formatDate pattern="MMM-dd-yyyy" value="${latestUpdate.updateDate}" /> </cite></footer>
					  <p>${latestUpdate.updateMessage} </p>
					  
					</blockquote>
                    <a href="#" class="btn btn-default btn-xl">Read More Updates!</a>
                </div>
            </div>
        </div>
    </section>

    <!-- <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">At Your Service</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-diamond wow bounceIn text-primary"></i>
                        <h3>Sturdy Templates</h3>
                        <p class="text-muted">Our templates are updated regularly so they don't break.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-paper-plane wow bounceIn text-primary" data-wow-delay=".1s"></i>
                        <h3>Ready to Ship</h3>
                        <p class="text-muted">You can use this theme as is, or you can make changes!</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary" data-wow-delay=".2s"></i>
                        <h3>Up to Date</h3>
                        <p class="text-muted">We update dependencies to keep things fresh.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-heart wow bounceIn text-primary" data-wow-delay=".3s"></i>
                        <h3>Made with Love</h3>
                        <p class="text-muted">You have to make your websites with love these days!</p>
                    </div>
                </div>
            </div>
        </div>
    </section> -->

    <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="container">
		            <div class="row">
		                <div class="col-lg-12 text-center">
		                    <h2 class="section-heading">Course Info</h2>
		                    <hr class="primary">
		                </div>
		            </div>
		        </div>
                
                
                <c:forEach items="${courseModel.descriptionsList}" var="descriptionsItem">
                <div class="col-lg-4 col-sm-6">
                    <a  href="#" role="button" data-toggle="modal" data-target="#myModal" class="portfolio-box">
                        <!-- <img src="img/portfolio/5.jpg" class="img-responsive" alt=""> -->
                        <h1 align="center">${descriptionsItem.descType}</h1>
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    ${descriptionsItem.descType}
                                </div>
                                <div class="project-name">
                                    Find Out More!
                                </div>
                            </div>
                        </div>
                    </a>
                    <div class="modal fade bs-example-modal-sm bg-primary" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog modal-sm">
    					<!-- <div class="modal-content"> -->
    						<!-- <div class="modal-body"> -->
							<p>
								${descriptionsItem.descString}
							</p>
							<!-- </div> -->
							<div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        
						    </div>
					</div>
					<!-- </div> -->
				</div>
                </div>
                </c:forEach>
                
                
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <!-- <img src="img/portfolio/6.jpg" class="img-responsive" alt=""> -->
                        <h1 align="center">NEW</h1>
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>
<br>
    <aside class="bg-dark">
        <div class="container text-center">
            <div class="call-to-action">
                <h2>Free Download at Start Bootstrap!</h2>
                <a href="#" class="btn btn-default btn-xl wow tada">Download Now!</a>
            </div>
        </div>
    </aside>

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Ready to start your next project with us? That's great! Give us a call or send us an email and we will get back to you as soon as possible!</p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class="fa fa-phone fa-3x wow bounceIn"></i>
                    <p>123-456-6789</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
                    <p><a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a></p>
                </div>
            </div>
        </div>
    </section>


   
<!-- ============================================================================================== 
                                   JAVA-SCRIPTS                                                    
                                   ================================================================ 
 ================================================ -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/FitText.js/1.2.0/jquery.fittext.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>

<script type="text/javascript">
/*!
 * Start Bootstrap - Creative Bootstrap Theme (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

(function($) {
    "use strict"; // Start of use strict

    // jQuery for page scrolling feature - requires jQuery Easing plugin
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top - 50)
        }, 1250, 'easeInOutExpo');
        event.preventDefault();
    });

    // Highlight the top nav as scrolling occurs
    $('body').scrollspy({
        target: '.navbar-fixed-top',
        offset: 51
    })

    // Closes the Responsive Menu on Menu Item Click
    $('.navbar-collapse ul li a').click(function() {
        $('.navbar-toggle:visible').click();
    });

    // Fit Text Plugin for Main Header
    $("h1").fitText(
        1.2, {
            minFontSize: '35px',
            maxFontSize: '65px'
        }
    );

    // Offset for Main Navigation
    $('#mainNav').affix({
        offset: {
            top: 100
        }
    })

    // Initialize WOW.js Scrolling Animations
    new WOW().init();

})(jQuery); // End of use strict

</script>

</body>
</html>