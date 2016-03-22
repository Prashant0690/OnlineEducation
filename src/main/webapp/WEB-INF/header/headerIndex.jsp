<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<!-- Fixed navbar -->
    <nav class="navbar navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href='<spring:url value="/index.html" />'>Collaborative learning</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          <security:authorize access="hasRole('ROLE_TEACHER')">
            <li><a href='<spring:url value="/teacher/dashboard/home.html" />'>Home</a></li>
          </security:authorize>
          <security:authorize access="! hasRole('ROLE_TEACHER')">
            <li><a href='<spring:url value="/courses/all.html" />'>All Courses</a></li>
          </security:authorize>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <security:authorize access="! isAuthenticated()">
	          <li><a href='<spring:url value="/registration/newstudent.html" />'>Register</a></li>
    	  </security:authorize>
    	  <security:authorize access="! isAuthenticated()">
	          <li><a href='<spring:url value="/student/studentDashboard.html" />'>Student Dashboard</a></li>
    	  </security:authorize>
    	  <security:authorize access="hasRole('ROLE_STUDENT')">
	          <li><a href='<spring:url value="/student/studentDashboard.html" />'>Dashboard</a></li>
		  </security:authorize>
		  <security:authorize access="isAuthenticated()">
              	<li><a href="<spring:url value="/logout" />">Logout</a></li>
           </security:authorize>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<!-- 
</body>
</html> -->