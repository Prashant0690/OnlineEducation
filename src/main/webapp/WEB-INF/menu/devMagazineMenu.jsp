<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

			<!-- -----------Magazine Course Navigation Bar Start------------------ -->

				<div class="list-group nav nav-pills">
						
						<a href='<spring:url value="/course/development/classroom/progress/${courseM.courseId}/${courseM.courseName}/${courseM.courseType}.html" />'
						 class="${current == 'course' ? 'active' : ''} list-group-item">
							Course</a>
							
						<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/update.html" />' 
						class="${current == 'courseUpdate' ? 'active' : ''} list-group-item">
							Course Updates</a>
							
						<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/description.html" />'
							 class="${current == 'description' ? 'active' : ''} list-group-item">
							Course Description</a>
							
						<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/coverPage.html" />'
							 class="${current == 'cover' ? 'active' : ''} list-group-item">
							Magazine Cover</a>
						
						<a href='<spring:url value="/course/development/${courseM.courseId}/${courseM.courseUID}/${courseM.courseType}/page.html" />'
							 class="${current == 'page' ? 'active' : ''} list-group-item">
							Magazine Page</a>
							
				</div>

			<!-- -----------Magazine Course Navigation Bar Ends------------------ -->