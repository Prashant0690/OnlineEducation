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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	
	
</head>
<body role="document">

<%@ include file="../header/headerIndex.jsp" %>

<div class="container theme-showcase" role="main">

<%@ include file="../teacher/teacherNavBarMenu.jsp" %>

<c:if test="${teacherNavBarMenu == 'home' }">
	<%@ include file="../teacher/teacherHome.jsp" %>
</c:if>

<c:if test="${teacherNavBarMenu == 'classSchedule' }">
	<%@ include file="../teacher/teacherClassSchedule.jsp" %>
</c:if>

<c:if test="${teacherNavBarMenu == 'personalBranding' }">
	<%@ include file="../teacher/teacherPersonalBranding.jsp" %>
</c:if>



</div>
</body>
</html>