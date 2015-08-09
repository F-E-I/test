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
					<div class="panels">
						<s:iterator value="#session.questions" id="question">
						<div id='<s:property value="#question.id"/>' class="thm-panel">
							<div class="thm-panel-header thm-panel-top minimize">
								<h2><s:property value="#question.title"/></h2>
								<div class="buttons">
									<div class="minimize-button"></div>
								</div>
								<div class="h-color question-16"></div>
							</div>
							<div class="thm-panel-toolbar"></div>
							<div class="thm-panel-body">
								<div class="thm-tabbed-panel module-item-content">
									<ul>
										<li><a href="#1-details">详细信息</a></li>
										<li><a href="#1-reports">报告</a></li>
									</ul>
									<div id="1-details">
										<div class="question-details-tab">
											<div class="spinner-container hide"></div>
											<span class="loading-error hide"></span>
											<div class="question-timer hide"></div>
											<div id="status-bar">
												<table class="status-bars">
													<tbody>
														<tr class="status-report">
															<td class="num-submissions-title" rowspan="20">#&nbsp;提交数</td>
															<td class="num-submissions">0</td>
															<td class="graph"><div class="html-bar">
																	<span class="label ">0%</span>
																	<div class="bar" style="width: 0%"></div>
																</div></td>
															<td class="toggle-submission" rowspan="20"><a
																href="#">% 在线</a></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div id="question-body">
												<div class="question-container question-layout-side-by-side">
													<table class="question-description">
														<tbody>
															<tr>
																<td class="question-description-content">
																	<div class="description magnify-scale-font"
																		id="question-description-1">
																		<p><s:property value="#question.detail"/></p>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
													<section class="question-content magnify-resize-height height-base height-4">
														<div class="magnify-scale-font">
															<div>
																<s:iterator value="#question.options.split('#')" id="option">
																<label class="question">
																	<span class="option">
																		<b><s:property value="#option"/></b>
																	</span>
																	<span class="cb"></span>
																</label>
																</s:iterator>
															</div>
														</div>
													</section>
													<div class="submitted-answer"></div>
													<div class="cb"></div>
												</div>
											</div>
										</div>
									</div>
									<div id="1-reports"></div>
								</div>
							</div>
							<div class="thm-panel-footer thm-panel-bottom">
								<button class="btn btn-legacy footer-button-magnify pull-left"><span class="icon-magnify">全屏</span></button>
								<button class="btn btn-legacy footer-button-close danger"><span class="icon-delete">关闭</span></button>
								<button class="btn btn-legacy footer-button-disable-submissions amber pull-left"><span class="icon-lock">禁止提交</span></button>
								<button class="btn btn-legacy footer-button-show-answer affirmative pull-left"><span class="icon-show">显示答案</span></button>
							</div>
						</div>
						</s:iterator>
					</div>
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
							<div class="h-color course"></div>
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
												<div class="checkboxThree">
											  		<input type="checkbox" value="1" id="checkboxThreeInput" name="" checked/>
												  	<label for="checkboxThreeInput"></label>
											  	</div>
											</div>
										</div>
									</li>
									<li class="tree-row module-item no-tree-children">
										<div class="module">
											<em class="module-item module-icon"><span>#</span>配置</em>
										</div>
									</li>
								</ol>
							</div>
						</div>
						<div class="thm-panel-footer"></div>
					</div>
					<div id="attendance-control-panel" class="thm-panel">
						<div class="thm-panel-header thm-panel-top minimize">
							<h2>考勤：</h2>
							<div class="buttons">
								<div class="minimize-button"></div>
							</div>
							<div class="h-color attendance"></div>
						</div>
						<div class="thm-panel-toolbar"></div>
						<div id="attendance-control-panel-body" class="thm-panel-body thm-panel-bottom">
							<div class="take-attendance">
							    <div class="well well-unstyled text-center">
							      <div class="button btn btn-primary" style="outline: none;">签到</div>
							    </div>
							</div>
						</div>
						<div class="thm-panel-footer"></div>
					</div>
					<form id="deleteQuestionForm" action="question!delete" method="post" onsubmit="return false;">
					<s:hidden name="questionIds"></s:hidden>
					<div id="question-control-panel" class="thm-panel">
						<div class="thm-panel-header thm-panel-top minimize">
							<h2>题目：</h2>
							<div class="buttons">
								<div class="minimize-button"></div>
							</div>
							<div class="h-color question"></div>
						</div>
						<div class="thm-panel-toolbar toolbar-active">
							<button type="button" class="btn btn-primary toolbar-btn folder-btn icon"></button>
							<button id="deleteQuestionBtn" type="button" class="btn btn-primary toolbar-btn delete-btn icon">删除</button>
							<button id="addQuestionBtn" type="button" class="btn btn-primary toolbar-btn add-btn icon">新建</button>
						</div>
						<div id="question-control-panel-body" class="thm-panel-body thm-panel-bottom">
							<div class="tree control-panel-tree">
								<s:if test="#session.questions == null">
								<div class="empty hide">无内容</div>
								</s:if>
								<s:else>
								<!-- <ol class="folder-items">
									<li class="tree-row folder no-tree-children">
										<div class="module folder-details selectable">
											<a href="#" class="toggle-hide icon"></a>
											<div class="checkbox">
										        <input type="checkbox">
										        <div class="minus hide"></div>
										        <em class="module-item folder"><span class="icon"></span>文件夹1</em>
										    </div>
											<div class="action-container">
												<div class="status actionmenu actionmenu-button">
													<span class="icon active-visible"></span>
												</div>
											</div>
										</div> -->
										<ol class="folder-items">
											<s:iterator value="#session.questions" id="question">
											<li class="tree-row module-item no-tree-children no-tree-children">
												<div class="module selectable">
													<div class="checkbox">
												        <input type="checkbox" value="<s:property value="#question.id"/>">
												        <em class="module-item"><s:property value="#question.title"/></em>
												    </div>
													<div class="action-container">
														<div id='<s:property value="#question.id"/>' type="<s:property value="#question.type"/>" class="status actionmenu actionmenu-button">
															<s:if test="#question.status==0">
															<span class="icon active-visible"></span>
															</s:if>
															<s:elseif test="#question.status==1">
															<span class="icon visible"></span>
															</s:elseif>
															<s:elseif test="#question.status==2">
															<span class="icon active"></span>
															</s:elseif>
															<s:elseif test="#question.status==3">
															<span class="icon review"></span>
															</s:elseif>
															<s:elseif test="#question.status==4">
															<span class="icon inactive"></span>
															</s:elseif>
														</div>
													</div>
												</div>
											</li>
											</s:iterator>
										</ol>
									<!-- </li>
								</ol> -->
								</s:else>
							</div>
						</div>
						<div class="thm-panel-footer"></div>
					</div>
					</form>
					<div id="discussion-control-panel" class="thm-panel thm-panel-hidden"></div>
					<div class="placeholder-control">无内容</div>
				</div>
			</div>
			<div class="popover status-popover fader right in" style="top: 0;left: 303px; display: none;">
				<div class="popover-inner">
					<div class="popover-content">
						<div class="actionmenu actionmenu-popup">
							<div class="options">
								<span class="close icon x"></span>
								<div class="group">设置状态</div>
								<div class="option active-visible" status="active-visible" value="0">
									<span class="icon"></span>
									<span class="title">
										<b>问答</b>（可见且可提交）
									</span>
									<span class="desc">在线学生可见且可提交答案</span>
								</div>
								<div class="option visible" status="visible" value="1">
									<span class="icon"></span>
									<span class="title">
										<b>显示</b>（可见）
									</span>
									<span class="desc">在线学生可见但不可提交答案</span>
								</div>
								<div class="option active" status="active" value="2">
									<span class="icon"></span>
									<span class="title">
										<b>作业</b>（可提交）
									</span>
									<span class="desc">给学生发送家庭作业</span>
								</div>
								<div class="option review" status="review" value="3">
									<span class="icon"></span>
									<span class="title">
										<b>复习</b>
									</span>
									<span class="desc">答案可见，学生可进行复习</span>
								</div>
								<div class="option inactive" status="inactive" value="4">
									<span class="icon"></span>
									<span class="title">
										<b>关闭</b>
									</span>
									<span class="desc">只有教师可见</span>
								</div>
								<div class="group">
									<div class="option edit">
										<span class="icon"></span>
									</div>
								</div>
							</div>
						</div>
					</div>
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
			$('.thm-panel-header').click(function(){
				var obj = $(this).parent('.thm-panel');
				if(obj.hasClass('thm-panel-hidden')){
					obj.removeClass('thm-panel-hidden');
				}else{
					obj.addClass('thm-panel-hidden');
				}
			});	
			$('.toggle-hide').click(function(){
				var folder = $(this).parents('.folder');
				if(folder.hasClass('collapsed')){
					folder.removeClass('collapsed');
				}else{
					folder.addClass('collapsed');
				}
			});
			$('.checkbox input[type=checkbox]').click(function(){
				var folderDetails = $(this).parents('.folder-details');
				if(folderDetails.length > 0){
					folderDetails.siblings('.folder-items').find('input[type=checkbox]')
						.prop('checked',$(this).prop('checked'));
				}else{
					var isAllChecked = true;
					var isAllUnchecked = true;
					$(this).parents('.tree-row.module-item').parent().find('input[type=checkbox]')
						.each(function(){
						if($(this).prop('checked')){
							isAllUnchecked = false;
						}else{
							isAllChecked = false;
						}
					})
					var folderDetails = $(this).parents('.tree-row.module-item').parent().siblings('.folder-details');
					if(isAllChecked){
						folderDetails.find('.checkbox .minus').hide();
						folderDetails.find('input[type=checkbox]').prop('checked', true);
					}else if(isAllUnchecked){
						folderDetails.find('.checkbox .minus').hide();
						folderDetails.find('input[type=checkbox]').prop('checked', false);
					}else{
						folderDetails.find('.checkbox .minus').show();
						folderDetails.find('input[type=checkbox]').prop('checked', false);
					}
				}
			});
			$('.checkbox .minus').click(function(){
				$(this).hide();
				$(this).siblings('input[type=checkbox]').prop('checked', true).click();
			});
			$('#addQuestionBtn').click(function(){
				$.post('${ctx}/jsp/question', function(){
					var buttons = {  
				        	"取消":function(){  
				            	$(this).dialog('close');
				            	$('#main').css({'position':'absolute'});
				            },
				            "下一步":function(){
				            	var url;
				            	var type = $('.cType_radio').find('input:radio[name="type"]:checked').val();
				            	if(type == '0'){
				            		url = 'question/singleSelect.jsp';
				            	}else if(type == '1'){
				            		url = 'question/multipleSelect.jsp';
				            	}else if(type == '2'){
				            		url = 'question/wordAnswer.jsp';
				            	}
				            	var subButtons = {
				            		"取消":function(){  
							           	$(this).dialog('close');
							           	$('#main').css({'position':'absolute'});
							        },
							        "返回":function(){  
							        	openPageDialog('teacher/addQuestion.jsp', '创建题目', 300, buttons);
							           	$('#main').css({'position':'absolute'});
							        },
							        "保存":function(){  
						            	if($(this).find('form').validationEngine('validate')){
							            	$(this).find('form').submit();
							            	$(this).dialog('close');
							            	$('#main').css({'position':'absolute'});
						            	}
						            }
				            	}
				            	openPageDialog(url, '创建题目', 600, subButtons);
				            } 
				        }
					openPageDialog('teacher/addQuestion.jsp', '创建题目', 300, buttons);
				});
			});
			$('#deleteQuestionBtn').click(function(){
				var str = '';
				$('#question-control-panel-body .module-item').each(function(i){
					var obj = $(this).find('.checkbox input:checkbox');
					if(obj.is(':checked')){
						str = str + obj.val() + "#";
					}
				})
				str = str.substr(0, str.length-1);
				$('#questionIds').val(str);
				$('#deleteQuestionForm')[0].submit();
			});
			$('.thm-tabbed-panel').tabs();
			$('.status-popover .close.icon.x').click(function(){
				$('.status-popover').hide();
			});
			$('#question-control-panel .actionmenu-button').click(function(){
				var top = $(this).offset().top;
				$('.status-popover').attr('parent', $(this).attr('id'));
				$('.status-popover').attr('type', $(this).attr('type'));
				$('.status-popover').css({top:top-400});
				$('.status-popover').show();
			});
			$('.actionmenu-popup div.option').click(function(){
				var status = $(this).attr('status');
				if(status){
					var id = $(this).parents('.popover').attr('parent');
					var obj = $('#question-control-panel #'+id+'.actionmenu-button').find('span');
					obj.removeAttr('class');
					obj.addClass('icon '+status);
					$(this).siblings('.close.icon.x').click();
					
					var statusValue = $(this).attr('value');
					var url = "${ctx}/jsp/question!updateStatus";
					var param = {questionId:id,status:statusValue};
					$.post(url, param, function(data){
						if(data.errMsg){
							alert('更新问题状态失败, 错误信息：' + data.errMsg);
						}else{
							if(statusValue == '0'){
								$('.course-content .panels #'+id).remove();
							}						
						}
					});
				}
			});
			$('.actionmenu-popup .group div.option.edit').click(function(){
				var id = $(this).parents('.popover').attr('parent');
            	var type = $(this).parents('.popover').attr('type');
				$(this).parents('.status-popover').hide();
				$.post("${ctx}/jsp/question!find", {questionId:id}, function(data){
					if(data.errMsg){
						alert('编辑问题失败, 错误信息：' + data.errMsg);
					}else{
						var url;
		            	if(type == '0'){
		            		url = 'question/singleSelect.jsp';
		            	}else if(type == '1'){
		            		url = 'question/multipleSelect.jsp';
		            	}else if(type == '2'){
		            		url = 'question/wordAnswer.jsp';
		            	}
		            	var q = data.question;
		            	openPageDialog(url, '编辑题目', 600);
					}
				});
			});
		});
	</script>
</body>
</html>