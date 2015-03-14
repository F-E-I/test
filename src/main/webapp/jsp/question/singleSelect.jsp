<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<div id="add-question" class="dialog">
	<form id="addQuestionForm" action="question!add" method="post">
		<input type="hidden" name="question.type" value="0">
		<div class="body">
			<div id="question-form" class="cForm">
				<div class="cRow cType_text cTextInput" id="cId_title">
					<div class="cLabel">
						<label>标题</label>
					</div>
					<div class="cInput">
						<input type="text" id="name" name="question.title"
							class="validate[required]" placeholder="标题">
					</div>
				</div>
				<div class="cRow cType_textarea cTextInput" id="cId_question">
					<div class="cLabel">
						<label>问题</label>
					</div>
					<div class="cInput">
						<textarea id="description" name="question.detail"
							class="validate[required]" placeholder="问题描述"></textarea>
					</div>
				</div>
				<div class="cRow cType_fieldset" id="cId_question_fields">
					<fieldset id="cId_question_fields">
						<div class="cFieldsetData">
							<div class="cRow cType_set cTextInput" id="cId_choices">
								<div class="cInput">
									<table>
										<thead>
											<tr>
												<th>选项</th>
												<th>是否正确</th>
												<th>删除</th>
											</tr>
										</thead>
										<tbody class="cSetWrapper">
											<tr class="cSetItem">
												<td><input name="options[0]" type="text" tabindex="1" class="auto" placeholder="a"></td>
												<td class="correct_answer"><input type="checkbox" name="correctOptions" value="a"></td>
												<td><a href="#" class="cButton delete">删除</a></td>
											</tr>
											<tr class="cSetItem">
												<td><input name="options[1]" type="text" tabindex="1" class="auto" placeholder="b"></td>
												<td class="correct_answer"><input type="checkbox" name="correctOptions" value="b"></td>
												<td><a href="#" class="cButton delete">删除</a></td>
											</tr>
											<tr class="cSetItem">
												<td><input name="options[2]" type="text" tabindex="1" class="auto" placeholder="c"></td>
												<td class="correct_answer"><input type="checkbox" name="correctOptions" value="c"></td>
												<td><a href="#" class="cButton delete">删除</a></td>
											</tr>
											<tr class="cSetItem">
												<td><input name="options[3]" type="text" tabindex="1" class="auto" placeholder="d"></td>
												<td class="correct_answer"><input type="checkbox" name="correctOptions" value="d"></td>
												<td><a href="#" class="cButton delete">删除</a></td>
											</tr>
										</tbody>
									</table>
									<a href="#" class="cButton add">添加</a>
								</div>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="cRow cType_checkbox cClickInput" id="cId_active_immediately">
					<div class="cInput">
						<input type="checkbox" name="createAndActive" value=true id="active_immediately">
					</div>
					<div class="cLabel">
						<label>创建后立即激活</label>
					</div>
				</div>
				<div class="cRow cType_checkbox cClickInput" id="cId_advanced">
					<div class="cInput">
						<input type="checkbox" id="advanced" checked="checked">
					</div>
					<div class="cLabel">
						<label>显示更多配置</label>
					</div>
				</div>
				<div class="cRow cType_checkbox cClickInput" id="cId_is_anonymous">
					<div class="cInput">
						<input type="checkbox" id="is_anonymous">
					</div>
					<div class="cLabel">
						<label>匿名问题</label>
					</div>
				</div>
			</div>
			<div id="question-sidebar">
				<h2>单选题</h2>
				<p></p>
				<p>学生只能选择其中一个答案</p>
				<p></p>
				<div id="accordion">
					<h3>分数</h3>
					<div id="grading-form" class="cForm" style="height:0px">
						<div class="cRow cType_text cTextInput"
							id="cId_correctness_score" style="display: block;">
							<div class="cLabel">
								<label for="correctness_score">正确分</label>
							</div>
							<div class="cInput">
								<input type="text" id="correctness_score" name="question.correntScore">
							</div>
						</div>
						<div class="cRow cType_text cTextInput"
							id="cId_participation_score" style="outline: none;">
							<div class="cLabel" style="outline: none;">
								<label for="participation_score">参与分</label>
							</div>
							<div class="cInput">
								<input type="text" id="participation_score" name="question.participationScore">
							</div>
						</div>
					</div>
					<h3>时间</h3>
					<div id="time-form" class="cForm">
						<div class="cRow cType_checkbox cClickInput" id="cId_is_timed">
							<div class="cInput">
								<input type="checkbox" id="is_timed" name="timeLimit" value="1">
							</div>
							<div class="cLabel">
								<label title="Select Timer enabled" for="is_timed"
									style="outline: none;">启用时间</label>
							</div>
						</div>
						<div class="cRow cType_text cTextInput" id="cId_time_limit">
							<div class="cLabel">
								<label for="time_limit">限制时间(s)</label>
							</div>
							<div class="cInput">
								<input type="text" id="time_limit" name="time">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(function(){
		initDialog();
		$("#addCourseForm").validationEngine({promptPosition: "topLeft"});
		$('#title').focus();
		$('#question-form .cClickInput .cLabel').click(function(){
			$(this).siblings('.cInput').find('input:checkbox').click();
		});
	});
</script>
</body>
</html>