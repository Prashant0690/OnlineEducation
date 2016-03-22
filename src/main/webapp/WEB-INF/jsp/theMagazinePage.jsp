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

    <title>Course Updates</title>

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

<%-- <c:forEach items="${pageDevelopmentList}" var="developmentItem" >
<c:if test="${developmentItem.magPageParagraph != null}">
       ${developmentItem.magPageParagraph.paraContent}
</c:if>
<c:if test="${developmentItem.magPagePicURL != null}">
${developmentItem.magPagePicURL.picName}
<img src='<spring:url value="/file/image/${developmentItem.magPagePicURL.picUrl}" />' class="img-responsive" alt="Responsive image">
<br />
</c:if>

</c:forEach>
 --%>
<!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Blog Home Two
                    <small>Subheading</small>
                </h1>
                <ol class="breadcrumb">
                    <li ><a href="index.html">List</a></li>
                    <li class="active">Page</li>
                    <c:if test="${magazinePage.addQuiz }">
                    	<li  class="navbar-right">
                    	<a class="btn btn-primary" 
                		href='<spring:url value="/classroom/TheMagazineCourse/${courseModel.courseId}/${courseModel.courseName}/quiz/${magazinePage.pageId}.html" />'>
                    	QUIZ</a></li>
                    </c:if>
                </ol>
            </div>
        </div>

<!-- Blog Post Row -->
        <div class="row">
        	<div class="col-md-2"></div>
            <div class="col-md-9">
            <c:forEach items="${pageDevelopmentList}" var="developmentItem" >
				<c:if test="${developmentItem.magPageParagraph != null}">
				       ${developmentItem.magPageParagraph.paraContent}
				</c:if>
				<c:if test="${developmentItem.magPagePicURL != null}">
					${developmentItem.magPagePicURL.picName}
					<img src='<spring:url value="/file/image/${developmentItem.magPagePicURL.picUrl}" />' class="img-responsive" alt="Responsive image">
					<br />
				</c:if>
			</c:forEach>
			
			<c:if test="${magazinePage.addQuiz }">
			<a class="btn btn-primary" 
                	href='<spring:url value="/classroom/TheMagazineCourse/${courseModel.courseId}/${courseModel.courseName}/quiz/${magazinePage.pageId}.html" />'>
                	Solve Quiz <i class="fa fa-angle-right"></i></a>
			</c:if>
			
            </div>
            <div class="col-md-1"></div>
        </div>
        <!-- /.row -->



</div>
   
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