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
	<link rel="stylesheet" href="../css/dashboardCorseManagement.css">
</head>
<body role="document">

<%@ include file="../header/headerIndex.jsp" %>





<div class="container-fluid">
      <div class="row">
        <div class="col-md-2"><%@ include file="../menu/devMagazineMenu.jsp" %></div>
        <div class="col-md-8">
        			<c:if test="${typeId == '101'|| typeId == '102' || typeId == '103' || typeId == '104'
        					   || typeId == '105'|| typeId == '106' || typeId == '107' || typeId == '108'
        					   || typeId == '109'|| typeId == '110' || typeId == '111' }">
		        		<%@ include file="../forms/newCourseDescriptionForm.jsp" %>
		        	</c:if>
        	<div class="row">
        		<div class="col-md-4">
	        		<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/101/description.html" />' 
		        		role="button">1.Introduction</a>
	        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/102/description.html" />' 
		        		role="button">2.General information </a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/103/description.html" />' 
		        		role="button">3.Student learning outcomes </a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/104/description.html" />' 
		        		role="button">4.Syllabus</a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/105/description.html" />' 
		        		role="button">5.Instructional method</a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/106/description.html" />' 
		        		role="button">6.References , Resources and Course materials</a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/107/description.html" />' 
		        		role="button">7.Policy statements, links</a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/108/description.html" />' 
		        		role="button">8.Assignments, assessments and evaluation </a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/109/description.html" />' 
		        		role="button">9.Prerequisites and Requirements </a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/110/description.html" />' 
		        		role="button">10.pace of the course and time commitment </a>
		        		
		        	<a class="btn btn-primary btn-lg btn-block" href='<spring:url 
		        		value="/course/development/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/111/description.html" />' 
		        		role="button">11.Calendar of events</a>
		        		
		        	
        		</div>
        		<div class="col-md-8">
        			<c:forEach items="${descriptionModel}" var="description">
        				<div class="panel panel-default">
							  <div class="panel-heading">${description.descType}</div>
							  <div class="panel-body">
							    <p>${description.descString}</p>
							  </div>
						</div>
		        	</c:forEach>
        		</div>
        	</div>
        </div>
        <div class="col-md-2"></div>
      </div>
    </div>






</body>