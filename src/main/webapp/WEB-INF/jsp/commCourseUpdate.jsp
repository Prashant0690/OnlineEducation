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
        <div class="col-md-2"><%@ include file="../menu/devMagazineMenu.jsp" %></div>
        <div class="col-md-8">
        
        	<div class="well">
        	<c:if test="${showForm}"> 
        		<%@ include file="../forms/newCourseUpdateForm.jsp" %>
        	</c:if>
        	</div>
        
        <a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/update/updateId.html" />'
        	 class="btn btn-default" role="button">Add Update</a>
        <hr><br>  
        <c:forEach items="${updateList}" var="updateItem">
			 <div class="well"> 
			 	<blockquote>
			 	  <h3><mark> ${updateItem.updateTitle}</mark> </h3>
			 	  <footer>Posted On :<cite title="Source Title">
			 	  <fmt:formatDate pattern="MMM-dd-yyyy" value="${updateItem.updateDate}" /> </cite></footer>
				  <p>${updateItem.updateMessage} </p>
				  
				</blockquote>
				<c:if test="${!updateItem.doUpdate }">
					<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/update/${updateItem.updateId}.html" />'
						class="btn btn-info" role="button">Update</a>
           			<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/update/${updateItem.updateId}/post.html" />'
           				class="btn btn-danger" role="button">POST</a>
           			<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/update/${updateItem.updateId}/remove.html" />'>
           				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>	
				
				</c:if>
				<c:if test="${updateItem.doUpdate }">
					<p>Update has been posted no more changes can be done</p>
				</c:if>
			 </div>       
        </c:forEach>
        
        </div>
        <div class="col-md-2"></div>
      </div>
    </div>


</body>
</html>
