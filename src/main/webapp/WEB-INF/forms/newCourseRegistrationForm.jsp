<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script>
  $(function() {
    $( "#courseStartDate, #courseEndDate" ).datepicker({
    	dateFormat: "yy/mm/dd"
    });
  });
 
  </script>

		 <form:form class="form-horizontal" commandName="courseData">
		 		<%-- <form:errors path="*" /> --%>
					<div class="form-group">
						<label for="uid" class="col-sm-4 control-label">Course UID</label>
						<div class="col-sm-8">
							<form:input path="courseUID" class="form-control" id="uid"
								placeholder="UID" />
							<form:errors path="courseUID" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseName" class="col-sm-4 control-label">Course Name</label>
						<div class="col-sm-8">
							<form:input path="courseName" class="form-control" id="courseName"
								placeholder="COURSE NAME" />
							<form:errors path="courseName" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseShortDiscription" class="col-sm-4 control-label">Course Discription</label>
						<div class="col-sm-8">
							<form:input path="courseShortDiscription" class="form-control" id="courseShortDiscription"
								placeholder="COURSE SHORT DISCRIPTION" />
							<form:errors path="courseShortDiscription" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseStartDate" class="col-sm-4 control-label">Start Date</label>
						<div class="col-sm-8">
							<form:input path="courseStartDate" class="form-control " id="courseStartDate"
								 placeholder="YYYY/MM/DD" />
							<form:errors path="courseStartDate" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseEndDate" class="col-sm-4 control-label">End Date</label>
						<div class="col-sm-8">
							<form:input path="courseEndDate" class="form-control" id="courseEndDate"
								placeholder="YYYY/MM/DD"  />
							<form:errors path="courseEndDate" />
						</div>
					</div>
					
				
					<div class="form-group">
						<label for="courseSubject" class="col-sm-4 control-label">Course Subject</label>
						<div class="col-sm-8">
							<form:select path="courseSubject" class="form-control" items="${subjectOptions}" >
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseType" class="col-sm-4 control-label">Course Type</label>
						<div class="col-sm-8">
							<c:if test="${showMenu}"><fieldset disabled></c:if>
							<form:select path="courseType" class="form-control" items="${typeOptions}"  />
							<c:if test="${showMenu}"></fieldset></c:if>
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseCategory" class="col-sm-4 control-label">Course Category</label>
						<div class="col-sm-8">
							<form:select path="courseCategory" class="form-control" items="${categoryOptions}" />
						</div>
					</div>
					

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">UPDATE DETAILS</button>
					</div>
				</div>
			</form:form>
