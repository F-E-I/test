<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header">
	<div class="container">
		<div class="logo"><a class="back3" href="user"></a>授课通用平台</div>
		<div class="course-list">
			<ul class="course-list-container">
				<li class="course-list-dropdown">
					<div class="course-name-container" style="outline:none">
						<span class="course-name"><s:property value="#session.course.courseName"/></span>
					</div>
					<span class="caret"></span>
				</li>
				<ul class="dropdown-menu" tabindex="1" style="outline:none">
					<s:iterator value="#session.courseList" id="course">
						<li>
							<a href="course?courseId=<s:property value='#course.id'/>" target="_self"><s:property value="#course.courseName"/></a>
						</li>
					</s:iterator>
				</ul>
			</ul>
		</div>
		<div class="nav">
			<ul>
				<li class="link"><a href="user!logout.action">退出</a></li>
				<li><s:property value="#session.user.userName" /></li>
			</ul>
		</div>
	</div>
</div>