<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>${title}</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
	  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
</head>
<body role="document">

<%@ include file="../header/headerIndex.jsp" %>





<div class="container-fluid">
	<div class="row">
		<div class="col-md-2"><%@ include file="../menu/devMagazineMenu.jsp" %></div>
        <div class="col-md-8">
        	
        	<div class="panel panel-default">
  			<div class="panel-body">
				<c:if test="${showForm}">
			 		<%@ include file="../forms/newMagazinePageForm.jsp" %>
				</c:if>
			</div>
			</div>
			
			<div class="panel panel-default">
  			<div class="panel-body">
				<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/new/0.html" />'
									 class="active list-group-item">Add Page</a>
			</div>
			</div>
			
			
		<div class="container">
        <div class="row">
            <!-- <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1"> -->
                
                <c:forEach items="${magazinePageList}" var="magazinePage">
                <div class="post-preview">
                <div class="panel panel-default">
                	<div class="panel-heading">
                    <a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/update/${magazinePage.pageId}.html" />'>
                        <p class="lead">
                            ${magazinePage.pageTitle}
                        </p>
                        
                            <p>${magazinePage.pageSubTitle}</p>
                        
                        <h3>UPDATE</h3>
                    </a>
                    </div>
                    <div class="panel-body">
                    <a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}.html" />'>
                        <h3>Page Design And Develop</h3>
                    </a>
                    <p class="post-meta">Posted  on ${magazinePage.goOnlineDate}</p>
                    </div>
                </div>
                </div>
                <hr>
                </c:forEach>
                
             <!--  </div> -->
           </div>
           </div>
			
			
        </div>
		<div class="col-md-2"></div>
	</div>
</div>



</body>