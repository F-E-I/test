<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<div id="add-course" class="dialog">
	<form id="addCourseForm" action="course!add" method="post">
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
							<div class="cRow cType_text cTextInput" style="margin-top:0" id="cId_course_code">
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
	</form>
</div>
<script type="text/javascript">
	$(function(){
		initDialog();
		$("#addCourseForm").validationEngine({promptPosition: "topLeft"});
		$('#name').focus();
	});
</script>
</body>
</html>