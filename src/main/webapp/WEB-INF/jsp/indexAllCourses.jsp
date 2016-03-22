<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ALl Courses</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css"> -->
	<!-- Web Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,400,700,300&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Raleway:700,400,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.3.1/animate.min.css">
			<!-- Worthy core CSS file -->
	<!-- <link href="../css/style.css" rel="stylesheet"> -->
	<%-- <link href="<spring:url value='/resources/css/style.css' />" rel="stylesheet"> --%>
	<style type="text/css"><%@ include file="../css/style.css"%></style>
</head>
<body class="no-trans">
<!-- Header -->
<div class="container-fluid"> <%@ include file="../header/headerIndex.jsp"%> </div>
<!-- Header ends -->
	
<!--Main Content -->
<!-- section start -->
		<!-- ================ -->
		<div class="default-bg space blue">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<h1 class="text-center">Let's Work Together!</h1>
					</div>
				</div>
			</div>
		</div>
		<!-- section end -->

		<!-- section start -->
		<!-- ================ -->
		<div class="section">
			<div class="container">
				<!-- <h1 class="text-center title" id="portfolio">Portfolio</h1>
				<div class="separator"></div>
				<p class="lead text-center">Lorem ipsum dolor sit amet laudantium molestias similique.<br> Quisquam incidunt ut laboriosam.</p>
				<br> -->			
				<div class="row object-non-visible" data-animation-effect="fadeIn">
					<div class="col-md-12">

						<!-- isotope filters start -->
						<div class="filters text-center">
							<ul class="nav nav-pills">
								<li class="active"><a href="#" data-filter="*">All</a></li>
								<c:forEach items="${SubjectFilterLisr}" var="subject">
								<li><a href="#" data-filter=".${subject}"> ${subject} </a></li>
								</c:forEach>
							</ul>
						</div>
						<!-- isotope filters end -->
						
						<!-- portfolio items start -->
						<div class="isotope-container row grid-space-20">
						<c:forEach items="${allCoursesM}" var="courseItem">
							<div class="col-sm-8 col-md-4 isotope-item ${courseItem.courseSubject}">
								<div class="image-box">
									<div class="overlay-container">
										    <h4 class="service-heading">${courseItem.courseName}</h4>
											<p class="text-muted">${courseItem.courseShortDiscription}.<br>
                							<small><strong>SUBJECT :${courseItem.courseSubject}</strong></small><br>
                							<small><strong>TYPE :${courseItem.courseType}</strong></small><br>
                							<small><strong>CATEGORY :${courseItem.courseCategory}</strong></small></p>
										<a href='<spring:url value="/index/enroll/page/${courseItem.courseId}.html" />'
										  class="overlay">
											<i class="fa fa-search-plus"></i>
											<span>Start Learning</span>
										</a>
									</div>
									<a href='<spring:url value="/index/enroll/page/${courseItem.courseId}.html" />' 
									  class="btn btn-default btn-block" >View Course </a>
								</div>
								<!-- Modal -->
								
								<!-- Modal end -->
							</div>
						</c:forEach>
						</div>
						<!-- portfolio items end -->
					
					</div>
				</div>
			</div>
		</div>
		<!-- section end -->




<!--Main Content Section Ends -->	


<!-- Footer  -->
<footer id="footer">
 <div class="container-fluid">
		<p class="text-muted text-center">We brings together the teachers and students into a
			cohesive and versioned foundational platform for modern Education.</p>
		<div class="row">
      	<div class="col-md-3">
			<table >
					<tr><td><a  href="#" >ABOUT US</a></tr></td>
					<tr><td><a  href="#" >CONTACT US</a></tr></td>
					<tr><td><a  href="#" >TERMS OF SERVICE</a></tr></td>
					<tr><td><a  href="#" >PRIVACY POLICY</a></tr></td>
					<tr><td><a  href="#" >SITE MAP</a></tr></td>
					<tr><td><a  href="#" >ADDRESS</a></tr></td>
			</table>
		</div>
		<div class="col-md-3">
			<table>
					<tr><td><a  href="#" >News & Announcements</a></tr></td>
					<tr><td><a  href="#" >DONATE</a></tr></td>
					<tr><td><a  href="#" >BLOG</a></tr></td>
					<tr><td><a  href="#" >NEWS AND MEDIA</a></tr></td>
					<tr><td><a  href="#" >SITE MAP</a></tr></td>
					<tr><td><a  href="#" >FEEDBACK PROGRAM</a></tr></td>
					<tr><td><a  href= '<spring:url value="/teacher/registration.html" />'>SUPPORT US</a></tr></td>
			</table>
		</div>
				<div class="col-md-6">
					<p class="text-primary">I’ve missed more than 9000 shots in my career. I’ve lost
						almost 300 games. 26 times I’ve been trusted to take the game
						winning shot and missed. I’ve failed over and over and over again
						in my life. And that is why I succeed. –Michael Jordan</p>
				</div>
      
      </div>
      <div >
      		<h4><small>Follow Us On</small></h4>
      		<a class="btn btn-social-icon btn-lg btn-twitter "><i class="fa fa-twitter"></i></a>
      		<a class="btn btn-social-icon btn-lg btn-facebook "><i class="fa fa-facebook"></i></a>
      		<a class="btn btn-social-icon btn-lg btn-google-plus "><i class="fa fa-google-plus"></i></a>
      		<a class="btn btn-social-icon btn-lg btn-linkedin "><i class="fa fa-linkedin"></i></a>
      </div>
      <div>
        <p class="text-muted text-center">© 2015 Prashant Tiwari</p>
      </div>
      </div>
</footer>
<!-- Footer Ends -->



<!-- JavaScript files placed at the end of the document so the pages load faster
================================================== -->
<!-- Jquery and Bootstap core js files -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<!-- <script type="text/javascript" src="JS/modernizr.js"></script> -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.isotope/2.2.1/isotope.pkgd.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.appear/0.3.3/jquery.appear.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.appear/0.3.3/jquery.appear.min.js"></script>

<!-- Initialization of Plugins -->
		<script type="text/javascript" src="js/template.js"></script>

<script type="text/javascript">
/* Theme Name: Worthy - Free Powerful Theme by HtmlCoder
 * Author:HtmlCoder
 * Author URI:http://www.htmlcoder.me
 * Version:1.0.0
 * Created:November 2014
 * License: Creative Commons Attribution 3.0 License (https://creativecommons.org/licenses/by/3.0/)
 * File Description: Initializations of plugins 
 */

(function($){
	$(document).ready(function(){
	
		$(".banner-image").backstretch('images/banner.jpg');
		
		// Fixed header
		//-----------------------------------------------
		$(window).scroll(function() {
			if (($(".header.fixed").length > 0)) { 
				if(($(this).scrollTop() > 0) && ($(window).width() > 767)) {
					$("body").addClass("fixed-header-on");
				} else {
					$("body").removeClass("fixed-header-on");
				}
			};
		});

		$(window).load(function() {
			if (($(".header.fixed").length > 0)) { 
				if(($(this).scrollTop() > 0) && ($(window).width() > 767)) {
					$("body").addClass("fixed-header-on");
				} else {
					$("body").removeClass("fixed-header-on");
				}
			};
		});

		//Scroll Spy
		//-----------------------------------------------
		if($(".scrollspy").length>0) {
			$("body").addClass("scroll-spy");
			$('body').scrollspy({ 
				target: '.scrollspy',
				offset: 152
			});
		}

		//Smooth Scroll
		//-----------------------------------------------
		if ($(".smooth-scroll").length>0) {
			$('.smooth-scroll a[href*=#]:not([href=#]), a[href*=#]:not([href=#]).smooth-scroll').click(function() {
				if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
					var target = $(this.hash);
					target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
					if (target.length) {
						$('html,body').animate({
							scrollTop: target.offset().top-151
						}, 1000);
						return false;
					}
				}
			});
		}

		// Animations
		//-----------------------------------------------
		if (($("[data-animation-effect]").length>0) && !Modernizr.touch) {
			$("[data-animation-effect]").each(function() {
				var $this = $(this),
				animationEffect = $this.attr("data-animation-effect");
				if(Modernizr.mq('only all and (min-width: 768px)') && Modernizr.csstransitions) {
					$this.appear(function() {
						setTimeout(function() {
							$this.addClass('animated object-visible ' + animationEffect);
						}, 400);
					}, {accX: 0, accY: -130});
				} else {
					$this.addClass('object-visible');
				}
			});
		};

		// Isotope filters
		//-----------------------------------------------
		if ($('.isotope-container').length>0) {
			$(window).load(function() {
				$('.isotope-container').fadeIn();
				var $container = $('.isotope-container').isotope({
					itemSelector: '.isotope-item',
					layoutMode: 'masonry',
					transitionDuration: '0.6s',
					filter: "*"
				});
				// filter items on button click
				$('.filters').on( 'click', 'ul.nav li a', function() {
					var filterValue = $(this).attr('data-filter');
					$(".filters").find("li.active").removeClass("active");
					$(this).parent().addClass("active");
					$container.isotope({ filter: filterValue });
					return false;
				});
			});
		};

		//Modal
		//-----------------------------------------------
		if($(".modal").length>0) {
			$(".modal").each(function() {
				$(".modal").prependTo( "body" );
			});
		}

	}); // End document ready
})(this.jQuery);
</script>

</body>
</html>