<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<!-- ADD COURSE MODEL  -->
<a class="btn btn-primary btn-lg"
	 href='<spring:url value="/course/development/addNewCourse/classroom.html" />'
	  role="button">Develop new Course</a>
<!-- ADD COURSE MODEL ENDS  -->



<!-- COURSES TABLE  -->
		<div class="page-header">
		        <h1>Course Added by You</h1>
		 </div>
		<div class="container-fluid">
			  <div class="row">
			    <div class="row">
				  <div class="col-md-1"><h3>S No.</h3></div>
				  <div class="col-md-5"><h3>Course Name</h3></div>
				  <div class="col-md-2"><h3>Reg Date</h3></div>
				  <div class="col-md-2"><h3>START DATE</h3></div>
				  <div class="col-md-2"><h3>END DATE</h3></div>
				</div>
				<c:forEach items="${teacherCourseList}" var="courseModel" varStatus="status">
				<div class="row">
				  <div class="col-md-1">${status.index}</div>
				  <div class="col-md-5"><a href='<spring:url value="/course/development/${courseModel.courseId}/${courseModel.courseName}/${courseModel.courseType}.html" />'
				  						   class="btn btn-sm btn-primary btn-block"><strong> ${courseModel.courseName } </strong> </a></div>
				  <div class="col-md-2"><a class="btn btn-default" href="#" role="button">${courseModel.courseRegDate }</a></div>
				  <div class="col-md-2"><a class="btn btn-default" href="#" role="button">${courseModel.courseStartDate }</a></div>
				  <div class="col-md-2"><a class="btn btn-default" href="#" role="button">${courseModel.courseEndDate }</a></div>
				</div>
				<div class="row">
				  <div class="col-md-1"></div>
				  <div class="col-md-5"></div>
				  <div class="col-md-2"></div>
				  <div class="col-md-2"></div>
				  <div class="col-md-2"></div>
				</div>
			    </c:forEach>
			  </div>
		</div>
<!-- COURSES TABLE ENDS  -->

