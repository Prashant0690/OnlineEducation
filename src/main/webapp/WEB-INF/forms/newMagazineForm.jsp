<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>
 <script>
  $(function() {
    $( "#dispatchedDate" ).datepicker({
    	dateFormat: "yy/mm/dd"
    });
  });
 </script>

		 <form:form class="form-horizontal" commandName="magazineData">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group">
						<label for="title" class="col-sm-4 control-label">Title</label>
						<div class="col-sm-8">
							<form:input path="title" class="form-control" id="title"
								placeholder="Title" />
							<form:errors path="title" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="openingQuote" class="col-sm-4 control-label">Opening Quote</label>
						<div class="col-sm-8">
							<form:input path="openingQuote" class="form-control" id="openingQuote"
								placeholder="Quote for the Magazine cover" />
							<form:errors path="openingQuote" />
						</div>
					</div>
					
					<div class="form-group" disabled>
						<label for="coverPicUrl" class="col-sm-4 control-label">Pic URL</label>
						<div class="col-sm-8"> ${magazineData.coverPicUrl}
							<form:hidden  path="coverPicUrl" class="form-control" id="coverPicUrl"
								placeholder=""   />
						</div>
					</div>
					
					<div class="form-group">
						<label for="scheduled" class="col-sm-4 control-label">Magazine Schedual</label>
						<div class="col-sm-8">
						<form:select path="scheduled" class="form-control" items="${schedualOptions}" />
						<form:errors path="scheduled" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="authorBio" class="col-sm-4 control-label">Author Bio</label>
						<div class="col-sm-8">
							<form:input path="authorBio" class="form-control" id="authorBio"
								placeholder="Little about yourself" />
							<form:errors path="authorBio" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="dispatchedDate" class="col-sm-4 control-label">Dispatched Date</label>
						<div class="col-sm-8">
							<form:input path="dispatchedDate" class="form-control " id="dispatchedDate"
								 placeholder="YYYY/MM/DD" />
							<form:errors path="dispatchedDate" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="adviceColumn" class="col-sm-4 control-label">Author Advice</label>
						<div class="col-sm-8">
							<form:input path="adviceColumn" class="form-control" id="adviceColumn"
								placeholder="Little about yourself" />
							<form:errors path="authorBio" />
						</div>
					</div>
					
					

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE MAGAZINE</button>
					</div>
				</div>
			</form:form>
