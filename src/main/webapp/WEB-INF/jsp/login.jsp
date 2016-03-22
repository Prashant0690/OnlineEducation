<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>
<body>

<!-- Header -->
<div class="container-fluid"><%@ include file="../header/headerIndex.jsp" %></div>
<!-- Header ends -->
 

<!--      LOGIN           -->

<div class="container">
	<div class="row">
  		<div class="col-md-3"></div>
  		<div class="col-md-6">
		      <form class="form-signin" name='f' action="<spring:url value="/login" />" method="post">
		        <h2 class="form-signin-heading">Please sign in</h2>
		        <label for="username" class="sr-only">User Name</label>
		        <input type="text" name='username' id="username" class="form-control " placeholder="User Name" >
		        <label for="password" class="sr-only">Password</label>
		        <input type="password" name='password' id="password" class="form-control" placeholder="Password" >
		      
		        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		      </form>
		 </div>
		 <div class="col-md-3"></div>
	</div>

</div> <!-- /container -->

<div class="container">
<div class="row">
		<div class="col-md-3"></div>
  		<div class="col-md-6">
      		<h4><small>OR LOGIN WITH</small></h4>
      		<a class="btn btn-social-icon btn-lg btn-twitter "><i class="fa fa-twitter"></i></a>
      		<a class="btn btn-social-icon btn-lg btn-facebook "><i class="fa fa-facebook"></i></a>
      		<a class="btn btn-social-icon btn-lg btn-google-plus "><i class="fa fa-google-plus"></i></a>
      		<a class="btn btn-social-icon btn-lg btn-linkedin "><i class="fa fa-linkedin"></i></a>
      	</div>
	    <div class="col-md-3"></div>
</div>
</div>
</div>


<!--    LOGIN ENDS  -->

<!-- Footer  -->
 <%@ include file="../footer/footerIndex.jsp" %>
 <!-- Footer Ends -->
</body>
</html>