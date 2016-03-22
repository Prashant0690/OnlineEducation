<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student Dashboard</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
	  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>
<body>
   <!-- Header -->
<div class="container-fluid"> <%@ include file="../header/headerIndex.jsp"%> </div>
<!-- Header ends -->

<div class="container-fluid">
      <div class="row">
        <div class="col-md-2">
        	<c:if test="${showMenu}">
        		<%@ include file="../menu/devMagazineMenu.jsp" %>
        	</c:if>
        </div>
        <div class="col-md-8">
        	<c:if test="${showForm}">
        	
	        <div class="well well-lg">
				 <p>Please fill all the below details to start a new course</p>
				 <%@ include file="../forms/newCourseRegistrationForm.jsp" %>
			</div>
			</c:if>
			
			
			<c:if test="${showData}">
			<div class="well well-lg">
			<a href='<spring:url value="/course/development/classroom/progress/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}/update.html" />'
						 class="btn btn-default">
							Update Course</a>
				${displayCourseModel}
			</div>
			</c:if>
		</div>
		<div class="col-md-2"></div>
	  </div>
</div>
</body>
</html>
