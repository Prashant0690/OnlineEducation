<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<hr>
<br><br>

<a href='<spring:url value="/teacher/resume/demo.html" />' class="btn btn-primary btn-lg active" role="button">Demo link</a>
<c:if test="${resumeModel != null }">
	<a href='<spring:url value="/teacher/resume/view.html" />' class="btn btn-primary btn-lg active" role="button">Professional Resume</a>
</c:if>

<c:if test="${resumeModel == null }">
	<a href='<spring:url value="/teacher/resume/develop/new.html" />'  class="btn btn-success btn-lg active" role="button">Build a Resume</a>
</c:if>
<br><br>

<c:if test="${resumeModel != null }">
	<div class="well"> 
	<a href='<spring:url value="/teacher/resume/develop/update.html" />'  class="btn btn-success btn-lg active" role="button">Edit my Resume</a>
	<a href='<spring:url value="/teacher/resume/develop/add/info.html" />'  class="btn btn-success btn-lg active" role="button">Add Work or Education</a>
	<a href='<spring:url value="/teacher/resume/develop/add/skills.html" />'  class="btn btn-success btn-lg active" role="button">Add Skills</a>
	</div>
</c:if>


<hr>
<br><br><br><br>

<!--FORMS =================================================================================  -->
<c:if test="${showForm == 'resumeForm'}">
	<div class="well">...
		<%@ include  file="../forms/newGResumeForm.jsp" %>
	</div>
</c:if>

<c:if test="${showForm == 'resumeInfoForm'}">
	<div class="well">...
		<%@ include  file="../forms/newGResumeInfoForm.jsp" %>
	</div>
</c:if>

<c:if test="${showForm == 'resumeSkillsForm'}">
	<div class="well">...
		<%@ include  file="../forms/newGResumeSkillsForm.jsp" %>
	</div>
</c:if>




<br><br>
