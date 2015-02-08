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
					<input id="addCourseBtn" href="add-course" type="button" class="btn btn-primary btn-large" value="创建课程">
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
				<div class="course-list-item">
					<div class="info">
						<h3 class="icon course">计算机科学与技术</h3>
						<span class="subinfo">讲师：钟飞</span>
					</div>
					<div class="course-actions fr">
						<input type="button" class="btn btn-default" value="#">
						<input type="button" class="btn btn-legacy" value="进入课程">
					</div>
				</div>
				<div class="course-list-item">
					<div class="info">
						<h3 class="icon course">计算机科学与技术</h3>
						<span class="subinfo">讲师：钟飞</span>
					</div>
					<div class="course-actions fr">
						<input type="button" class="btn btn-default" value="#">
						<input type="button" class="btn btn-legacy" value="进入课程">
					</div>
				</div>
				</div>
				<div id="no-courses" class="hide"><h2 style="text-align: center;color: #bbb;">无课程列表</h2></div>
			</div>
		</div>
	</div>
	<div id="add-course" class="dialog content">
		<div class="header">
			<h2>创建课程：</h2>
		</div>
		<div class="body">
			<div class="cForm">
				<div class="cRow cType_text cTextInput" id="cId_name">
					<div class="cLabel">
						<label>名称</label>
					</div>
					<div class="cInput">
						<input type="text" id="name" placeholder="课程名称">
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<input type="button" class="btn btn-legacy footer_button_cancel" value="取消">
			<input type="button" class="btn btn-legacy footer_button_ok" value="确认">
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
	<script type="text/javascript">
		$(function(){
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
			$('#addCourseBtn').leanModal({ top : 200, overlay : 0.4, closeButton: ".modal_close" });
		});
	</script>
</body>
</html>