<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<ul class="nav nav-tabs">
  <li role="presentation" class="${teacherNavBarMenu == 'home' ? 'active' : ''}">
  		<a href='<spring:url value="/teacher/dashboard/home.html" />'>Home</a></li>
  <li role="presentation" class="${teacherNavBarMenu == 'classSchedule' ? 'active' : ''}">
  		<a href='<spring:url value="/teacher/dashboard/classSchedule.html" />'>Class Schedule</a></li>
  <li role="presentation" class="${teacherNavBarMenu == 'personalBranding' ? 'active' : ''}">
  		<a href='<spring:url value="/teacher/dashboard/personalBranding.html" />'>Personal Branding</a></li>
</ul>