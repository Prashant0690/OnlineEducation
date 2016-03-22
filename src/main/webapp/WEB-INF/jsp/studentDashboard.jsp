<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student Dashboard</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>
<body>
   <!-- Header -->
<div class="container-fluid"> <%@ include file="../header/headerIndex.jsp"%> </div>
<!-- Header ends -->
	
<div class="container theme-showcase" role="main">

	<!-- <panels -->
	<div class="container-fluid">
	<div class="row">
		<c:forEach items="${studentM.coursesStudent }" var="course" >  
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-body">${course.courseName}</div>
					<div class="panel-footer">${course.courseShortDiscription}</div>
					<a class="btn btn-primary btn-xs btn-block" 
					  href='<spring:url value="/ClassRoom/info/${course.courseId}/${course.courseUID}.html" />'
					  role="button">Learn</a>
				</div>
			</div>
		</c:forEach>
		
	</div>
	</div>
</div>
	


<!-- Footer  -->
 <%@ include file="../footer/footerIndex.jsp" %>
<!-- Footer Ends -->
</body>
</html>