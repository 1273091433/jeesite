<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/bruceshop/user/bruceshopUser/">会员管理列表</a></li>
		<li class="active"><a href="${ctx}/bruceshop/user/bruceshopUser/form?id=${bruceshopUser.id}">会员管理<shiro:hasPermission name="bruceshop:user:bruceshopUser:edit">${not empty bruceshopUser.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="bruceshop:user:bruceshopUser:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bruceshopUser" action="${ctx}/bruceshop/user/bruceshopUser/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">会员名称：</label>
			<div class="controls">
				<form:input path="username" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员昵称：</label>
			<div class="controls">
				<form:input path="usernickname" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员密码：</label>
			<div class="controls">
				<form:input path="password" type="password" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱：</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话：</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">找回密码问题：</label>
			<div class="controls">
				<form:input path="question" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">找回密码答案：</label>
			<div class="controls">
				<form:input path="answer" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">最后登录时间：</label>
			<div class="controls">
				<input name="lastlogintime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${bruceshopUser.lastlogintime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">最后登录IP：</label>
			<div class="controls">
				<form:input path="lastloginip" htmlEscape="false" maxlength="45" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册时间：</label>
			<div class="controls">
				<input name="regeistdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${bruceshopUser.regeistdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员等级：</label>
			<div class="controls">
				<%-- <form:input path="userlevel" htmlEscape="false" maxlength="64" class="input-xlarge "/> --%>
				<%-- <form:select path="userlevel" class="input-xlarge ">
					<c:forEach var="userLevel" items="${userLevelList}">
						<form:option value="${userLevel.id}" label="${userLevel.name}"/>
					</c:forEach>
				</form:select> --%>
				<form:select path="userlevel">
					<form:options items="${fns:getDictList('bruceshop_userLevel')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否锁定用户：</label>
			<div class="controls">
				<form:input path="islock" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="bruceshop:user:bruceshopUser:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>