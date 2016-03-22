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
			<%-- <form method="POST" enctype="multipart/form-data"
				action="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/upload/${magazineModel.magazineId}"> --%>
			
			<div class="panel panel-default">
  			<div class="panel-body">
			<form method="POST" enctype="multipart/form-data" action="${imageAction}">
				<div class="form-group">
					<label for="upload">File to upload:</label>
					<input type="file" name="file" id="upload" class="form-control">
					
				</div>
				 <div class="form-group">
				 	<label for="name">Name:</label>
					<input type="text" name="name" id="name" class="form-control">
					<p class="help-block">If Image has any name or discription</p>
				 </div> 
				<input type="submit" value="Upload" class="btn btn-default"> 
				<p class="help-block">Press here to upload the file!</p>
			</form>
			</div>
			</div>        		
        </div>
        <div class="col-md-2"></div>
      </div>
    </div>






</body>