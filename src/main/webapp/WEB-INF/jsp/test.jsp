<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>
<body>Welcome To test jsp


<h2>New Person Form</h2>

		<form:form method="POST" commandName="testEntity"  action="/test/add" enctype="multipart/form-data">
			<fieldset>
				<table cellspacing="0">
					<tr>
						<th><label for="name">Name:</label></th>
						<td><form:input path="name" id="name" /></td>
						<td><form:errors path="name" /></td>
					</tr>
					<tr>
						<th><label for="age">Age:</label></th>
						<td><form:input path="age" id="age" /></td>
						<td><form:errors path="age" /></td>
					</tr>
					<tr>
						<th><label for="image">Image (in JPEG format only):</label></th>
						<td><input name="image" type="file" />
					</tr>
					<tr>
						<th><input type="Submit" value="Submit" /></th>
						<td></td>
					</tr>
				</table>
			</fieldset>
		</form:form></body>
</html>