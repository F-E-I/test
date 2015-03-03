<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../meta.jsp"%>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp"%>
<body>
	<%@ include file="../headerCourse.jsp" %>
	<div id="main">
		<div class="course-view">
			<div class="course-wrapper">
				<div class="course-content">
					<div class="panels"></div>
				</div>
			</div>
			<div class="control">
				<div class="panels">
					<div id="course-control-panel" class="thm-panel">
						<div class="thm-panel-header thm-panel-top minimize">
							<h2>课程：</h2>
							<div class="buttons">
								<div class="minimize-button"></div>
							</div>
							<div class="h-color"></div>
						</div>
						<div class="thm-panel-toolbar"></div>
						<div id="course-control-panel-body" class="thm-panel-body thm-panel-bottom">
							<div class="tree">
								<div class="empty hide">无内容</div>
								<ol class="folder-items">
									<li class="tree-row module-item no-tree-children">
										<div class="module">
											<em class="module-item module-icon"><span>#</span>课程状态</em>
										</div>
										<div class="action-container">
											<div class="status actionmenu actionmenu-button">
												<span class="icon yes"></span>
											</div>
										</div>
									</li>
									<li class="tree-row item no-tree-children">
										<div class="module">
											<em class="module-item module-icon"><span>#</span>配置</em>
										</div>
									</li>
								</ol>
							</div>
						</div>
						<div class="thm-panel-footer"></div>
					</div>
					<div id="attendance-control-panel" class="thm-panel thm-panel-hidden"></div>
					<div id="question-control-panel" class="thm-panel thm-panel-hidden"></div>
					<div id="discussion-control-panel" class="thm-panel thm-panel-hidden"></div>
					<div class="placeholder-control">无内容</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
	<script type="text/javascript">
		$(function(){
			$('#addCourseBtn').click(function(){
				openPageDialog('teacher/addCourse.jsp', '创建课程', 600);
			});
			$('.course-list-container .course-list-dropdown').click(function(){
				if($('.course-list-container').hasClass('open')){
					$('.course-list-container').removeClass('open');
				}else{
					$('.course-list-container').addClass('open');
					$('.course-list-container .dropdown-menu').focus();
				}
			});
			$('.course-list-container .dropdown-menu').blur(function(){
				var isClickOnLink = false;
				$('.dropdown-menu li').each(function(){
					if($(this).is(':hover')){
						isClickOnLink = true;
						return false;
					}
				});
				if($('.course-list-container').hasClass('open') && !isClickOnLink 
						&& !$('.course-list-dropdown').is(':hover')){
					$('.course-list-container').removeClass('open');
				}
			});
			$('.action-container .status').click(function(){
				var btn = $(this).find('.icon');
				if(btn.hasClass('yes')){
					btn.removeClass('yes');
					btn.addClass('no');
				}else{
					btn.removeClass('no');
					btn.addClass('yes');
				}
			});
			$('.thm-panel-header').click(function(){
				var obj = $(this).parent('.thm-panel');
				if(obj.hasClass('thm-panel-hidden')){
					obj.removeClass('thm-panel-hidden');
				}else{
					obj.addClass('thm-panel-hidden');
				}
			});			
		});
	</script>
</body>
</html>