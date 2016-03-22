<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
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
  		<div class="col-md-2"></div>
  		<div class="col-md-8">
		     <form:form class="form-horizontal" commandName="users">
		     
		     	<%-- <div class="form-group">
				    <label for="fullName" class="col-sm-2 control-label">Full Name</label>
				    <div class="col-sm-10">
				      <form:input  class="form-control" id="fullName" placeholder="Full Name" />
				    </div>
				  </div> --%>
		     
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				    <div class="col-sm-10">
				      <form:input path="userEmail"  class="form-control" id="inputEmail3" placeholder="Email" />
				      <form:errors path="userEmail" />
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label class="sr-only" for="userName">The name that will identify you in your courses - (cannot be changed later)t</label>
				    <label for="userName" class="col-sm-2 control-label">User Name</label>
				    <div class="col-sm-10">
				      <form:input path="userName"  class="form-control" id="userName" placeholder="User Name" />
				      <form:errors path="userName" />
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <form:password path="password"   class="form-control" id="inputPassword3" placeholder="Password" />
				      <form:errors path="password" />
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">Sign Up</button>
				    </div>
				  </div>
				</form:form>
		 </div>
		 <div class="col-md-2"></div>
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