<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品品牌管理</title>
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
		<li><a href="${ctx}/bruceshop/brand/bruceshopBrand/">商品品牌列表</a></li>
		<li class="active"><a href="${ctx}/bruceshop/brand/bruceshopBrand/form?id=${bruceshopBrand.id}">商品品牌<shiro:hasPermission name="bruceshop:brand:bruceshopBrand:edit">${not empty bruceshopBrand.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="bruceshop:brand:bruceshopBrand:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bruceshopBrand" action="${ctx}/bruceshop/brand/bruceshopBrand/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">品牌名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">品牌图片：</label>
			<div class="controls">
				<%-- <form:input path="bandurl" htmlEscape="false" maxlength="1024" class="input-xlarge "/> --%>
				<%-- <form:input path="bandurl" type="hidden" id="bandurl" name="bandurl" />
				<sys:ckfinder input="image" type="thumb" uploadPath="/cms/article" selectMultiple="false"/>
				 --%>
				<form:hidden path="bandurl" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="bandurl" type="images" uploadPath="/bruceshop/brand/bruceshopBrand" />
				<sapn calss="help-inline">建议Logo大小：102 x 36(像素 )</sapn>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="bruceshop:brand:bruceshopBrand:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>