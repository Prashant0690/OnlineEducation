<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>
<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> 
<script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>

<script>
  $(function() {
    $( "#goOnlineDate" ).datepicker({
    	dateFormat: "yy/mm/dd"
    });
  });
  </script>

		 <form:form class="form-horizontal" commandName="magazinePageData">
		 			
		 			<div class="form-group">
						<label for="pageTitle" class="col-sm-4 control-label">PageTitle/Banner Headline</label>
						<div class="col-sm-8">
							<form:input path="pageTitle" class="form-control" id="pageTitle"
								placeholder="Heading" />
							<form:errors path="pageTitle" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="pageSubTitle" class="col-sm-4 control-label">Page Sub Title</label>
						<div class="col-sm-8">
							<form:input path="pageSubTitle" class="form-control" id="pageSubTitle"
								placeholder="To describe page in content list" />
							<form:errors path="pageSubTitle" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="pageQuote" class="col-sm-4 control-label">Page Quote</label>
						<div class="col-sm-8">
							<form:input path="pageQuote" class="form-control" id="pageQuote"
								placeholder="" />
							<form:errors path="pageQuote" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="goOnlineDate" class="col-sm-4 control-label">Page Publish date</label>
						<div class="col-sm-8">
							<form:input path="goOnlineDate" class="form-control " id="goOnlineDate"
								 placeholder="YYYY/MM/DD" />
							<form:errors path="goOnlineDate" />
						</div>
					</div>
					
					<div class="form-group" disabled>
						<label for="pageNo" class="col-sm-4 control-label">Page No</label>
						<div class="col-sm-8"> ${magazinePageData.pageNo}
							<form:hidden  path="pageNo" class="form-control" id="pageNo"
								placeholder="pageNo"   />
						</div>
					</div>
					
					<div class="form-group" disabled>
						<label for="videoUrl" class="col-sm-4 control-label">Video URL</label>
						<div class="col-sm-8"> ${magazinePageData.videoUrl}
							<form:hidden  path="videoUrl" class="form-control" id="videoUrl"
								placeholder=""   />
						</div>
					</div>
					
					<div class="form-group" disabled>
						<label for="pagePicUrl" class="col-sm-4 control-label">PIC URL</label>
						<div class="col-sm-8"> ${magazinePageData.pagePicUrl}
							<form:hidden  path="pagePicUrl" class="form-control" id="pagePicUrl"
								placeholder=""   />
						</div>
					</div>
					
					<div class="form-group">
						<label for="contribution" class="col-sm-4 control-label">Contribution</label>
						<div class="col-sm-8">
							<form:input path="contribution" class="form-control" id="contribution"
								placeholder="" />
							<form:errors path="contribution" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="addQuiz" class="col-sm-4 control-label">Do you Want to add Quiz to the page</label>
						<form:checkbox  path="addQuiz" class="checkbox" id="addQuiz" />
					</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE Magazine Page</button>
					</div>
				</div>
			</form:form>
			

