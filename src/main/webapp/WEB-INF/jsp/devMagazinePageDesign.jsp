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
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.8.0/bootstrap-social.min.css">
	<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> -->
	
	<script type="text/javascript"  src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	
	<!-- 
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
	  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
	
</head>
<body role="document">

<%@ include file="../header/headerIndex.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	console.log( "ready!" );
	$(".triggerRemove").click(function(e) {
		console.log( "ready1" );
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		console.log( "ready55" );
		$("#modalRemove").modal(); 
		console.log( "ready2" );
	});
});
</script>



<div class="container-fluid">
	<div class="row">
		<div class="col-md-2"><%@ include file="../menu/devMagazineMenu.jsp" %></div>
        <div class="col-md-8">
        	
        	<div class="panel panel-default">
  			<div class="panel-body">
				<c:if test="${showForm == 'paraForm'}">
			 		<%@ include file="../forms/newMagazineParagraphForm.jsp" %>
				</c:if>
			</div>
			</div>
			
			<c:if test="${magazinePage.addQuiz}">
				<div class="well">
					<a class="btn btn-info btn-xs"  href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/add/questions/${magazinePage.pageId}.html" />'
                	data-toggle="tooltip" title="To add new Image at top">Add Questions</a>
				</div>
			</c:if>
			
			
		<div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <p>
                <a class="btn btn-info btn-xs"  href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}/pic/new/head/tail/current.html" />'
                	data-toggle="tooltip" title="To add new Image at top">Add Image</a>
                <a class="btn btn-info btn-xs" href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}/para/new/head/tail/current.html" />'
                	data-toggle="tooltip" title="To add new Image at top">Add Para </a>
            </p> 
                <c:forEach items="${pageDevelopmentList}" var="developmentItem" >
                <div class="well">
                	<c:if test="${developmentItem.magPageParagraph != null}">
                		
                			${developmentItem.magPageParagraph.paraContent}
                			<a class="btn btn-info btn-xs" 
	                		href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}/para/update/${developmentItem.previousLink == null?'head':developmentItem.previousLink}/${developmentItem.nextLink == null?'tail':developmentItem.nextLink}/${developmentItem.pageDevelopmentId}.html" />'>
	                        UPDATE</a>

                	</c:if>
                	
                	<c:if test="${developmentItem.magPagePicURL != null}">
                		${developmentItem.magPagePicURL.picName}
                		<img src='<spring:url value="/file/image/${developmentItem.magPagePicURL.picUrl}" />' class="img-responsive" alt="Responsive image">
                		<br />
                	</c:if>
					<a class="btn btn-danger btn-xs triggerRemove" 
		                		href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}/remove/${developmentItem.pageDevelopmentId}.html" />'>
	                			<span class="glyphicon glyphicon-remove " aria-hidden="true"></span>
                	</a>	                	
                	</div>
                	<p>
	                	<a class="btn btn-info btn-xs" href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}/pic/new/${developmentItem.previousLink == null?'head':developmentItem.previousLink}/${developmentItem.nextLink == null?'tail':developmentItem.nextLink}/${developmentItem.pageDevelopmentId}.html" />'
	                	   data-toggle="tooltip" title="To add new Image in between">Add Image</a>
		                <a class="btn btn-info btn-xs" href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page/form/design/develop/${magazinePage.pageId}/para/new/${developmentItem.previousLink == null?'head':developmentItem.previousLink}/${developmentItem.nextLink == null?'tail':developmentItem.nextLink}/${developmentItem.pageDevelopmentId}.html" />'
		                    data-toggle="tooltip" title="To add new paragrapg in between">Add Para </a>
	                </p>
                	
                </c:forEach>
                
                
              </div>
           </div>
           </div>
			
			
        </div>
		<div class="col-md-2"></div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Remove </h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>



</body>