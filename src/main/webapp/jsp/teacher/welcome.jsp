<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../meta.jsp"%>
<!DOCTYPE html">
<html>
<%@ include file="../head.jsp"%>
<body>
	<%@ include file="../header.jsp" %>
	<div id="main">
		<div class="course-list-wrapper">
			<div class="page-header">
				<h4>福大至诚学院</h4>
				<div class="btn-group fr">
					<input id="addCourseBtn" href="#add-course" type="button" class="btn btn-primary btn-large" value="创建课程">
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
								<span class="subinfo">讲师：<s:property value="#session.user.userName"/></span>
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
	<div id="add-course" class="dialog content">
		<form id="addCourseForm" action="course!add" method="post">
		<div class="header">
			<h2>创建课程</h2>
		</div>
		<div class="body">
			<div class="cForm">
				<div class="cRow cType_text cTextInput" id="cId_name">
					<div class="cLabel">
						<label>名称</label>
					</div>
					<div class="cInput">
						<input type="text" id="name" name="course.courseName"
							class="validate[required]" placeholder="课程名称">
					</div>
				</div>
				<div class="cRow cType_fieldset cCollapsible cCollapsed"
					id="cId_advanced_settings">
					<fieldset id="cId_advanced_settings">
						<legend class="icon" style="outline: none;">更多配置</legend>
						<div class="cFieldsetData hide">
							<div class="cRow cType_text cTextInput" id="cId_course_code">
								<div class="cLabel">
									<label>课程编号</label>
								</div>
								<div class="cInput">
									<input type="text" id="course_code" name="course.courseCode" 
										class="" placeholder="课程编号">
								</div>
							</div>
							<div class="cRow cType_textarea cTextInput" id="cId_description">
								<div class="cLabel">
									<label>课程描述</label>
								</div>
								<div class="cInput">
									<textarea id="description" name="course.description"
										class="" placeholder="课程描述"></textarea>
								</div>
							</div>
							<div class="cRow cType_password cTextInput" id="cId_password">
								<div class="cLabel">
									<label>密码</label>
								</div>
								<div class="cInput">
									<input type="password" id="password" name="course.password"
										class="" placeholder="密码">
								</div>
							</div>
							<div class="cRow cType_text cTextInput" id="cId_subject">
								<div class="cLabel">
									<label>学科</label>
								</div>
								<div class="cInput">
									<input type="text" id="subject" name="course.subject"
										class="" placeholder="学科">
								</div>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
		<div class="footer">
			<input type="button" class="btn btn-legacy footer_button_cancel" value="取消">
			<input type="submit" class="btn btn-legacy footer_button_ok" value="确认">
		</div>
		</form>
	</div>
	<script type="text/javascript">
		$(function(){
			$("#addCourseForm").validationEngine();
			$('.list-filter .btn').click(function(){
				$(this).siblings('.btn').removeClass('active');
				$(this).addClass('active');
				if($(this).find('input:radio').attr('id')=='filter-unavailable'){
					$('#available-courses').hide();
					$('#no-courses').show();
				}else{
					$('#available-courses').show();
					$('#no-courses').hide();
				}
			});
			$('#addCourseBtn').leanModal({modal_id : "add-course", top : 200, overlay : 0.4, closeButton: ".footer_button_cancel" });
			$('.cCollapsible legend').click(function(){
				var parent = $(this).parents('.cCollapsible');
				var fieldset = $(this).siblings('.cFieldsetData');
				if(fieldset.is(':hidden')){
					parent.removeClass('cCollapsed');
					$(this).addClass('expand');
					fieldset.show();
				}else{
					fieldset.hide();
					$(this).removeClass('expand');
					parent.addClass('cCollapsed');
				}
			});
		});
	</script>
</body>
</html>