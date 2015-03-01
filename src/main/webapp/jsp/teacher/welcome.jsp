<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../meta.jsp"%>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp"%>
<body>
	<%@ include file="../header.jsp" %>
	<div id="main">
		<div class="course-list-wrapper">
			<div class="page-header">
				<h4>福大至诚学院</h4>
				<div class="btn-group fr">
					<input id="addCourseBtn" type="button" class="btn btn-primary btn-large" value="创建课程">
				</div>
				<h1>课程</h1>
			</div>
			<div class="list-filter btn-group">
				<label class="btn btn-default active">
					<input type="radio" name="list-filter" id="filter-available" checked>可见的
				</label>
				<label class="btn btn-default">
					<input type="radio" name="list-filter" id="filter-unavailable">不可见的
				</label>
			</div>
			<div class="course-list">
				<div id="available-courses">
					<s:iterator value="#session.courseList" id="course">
						<div class="course-list-item">
							<div class="info">
								<h3 class="icon course"><s:property value="#course.courseName"/></h3>
								<span class="subinfo">讲师：<s:property value="#course.professorName"/></span>
							</div>
							<div class="course-actions fr">
								<input type="button" class="btn btn-default" value="#">
								<input type="button" class="btn btn-legacy" value="进入课程">
							</div>
						</div>
					</s:iterator>
				</div>
				<div id="no-courses" class="hide"><h2 style="text-align: center;color: #bbb;">无课程列表</h2></div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
	<%-- <%@ include file="addCourse.jsp" %> --%>
	<script type="text/javascript">
		$(function(){
			$('#addCourseBtn').click(function(){
				openPageDialog('teacher/addCourse.jsp', '创建课程', 600);
			});
		});
	</script>
</body>
</html>