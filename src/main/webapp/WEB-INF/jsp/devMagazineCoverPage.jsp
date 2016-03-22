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
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body role="document">

<%@ include file="../header/headerIndex.jsp" %>





<div class="container-fluid">
      <div class="row">
        <div class="col-md-2"><%@ include file="../menu/devMagazineMenu.jsp" %></div>
        <div class="col-md-8">
	        <div class="well well-lg">
		        <a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/coverPage/form.html" />'
									 class="active list-group-item">Add Data</a>
				<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/coverPage/image/${magazineModel.magazineId}.html" />'
									 class="active list-group-item">Image</a>
									 <br />
		        	<c:if test="${showForm}">
		        		<%@ include file="../forms/newMagazineForm.jsp" %>
		        	</c:if>
		        </div>
	        
	        <div class="well">
	        	<p >${magazineModel.dispatchedDate}</p>
	            <h1 >${magazineModel.title}</h1>
	            <blockquote>
	            <p >${magazineModel.openingQuote}</p>
	            </blockquote>
	            <p >
	              <a href="#" class="btn btn-lg btn-default">Learn more</a>
	            </p>
	            <c:if test="${magazineModel.coverPicUrl != null }">
	            	<img src='<spring:url value="/file/image/${magazineModel.coverPicUrl}" />' class="img-responsive" alt="Responsive image">
	            </c:if>
	         </div>   
          </div>
	        
        <div class="col-md-2"></div>
      </div>
    </div>






</body>