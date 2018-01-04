<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单类型管理</title>
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
		<li><a href="${ctx}/bruceshop/order/bruceshopOrder/">订单类型列表</a></li>
		<li><a href="${ctx}/bruceshop/order/bruceshopOrder/refundlist">订单退款列表</a></li>
		<li><a href="${ctx}/bruceshop/order/bruceshopOrder/returnlist">订单退货列表</a></li>
		<li class="active"><a href="${ctx}/bruceshop/order/bruceshopOrder/form?id=${bruceshopOrder.id}">订单类型<shiro:hasPermission name="bruceshop:order:bruceshopOrder:edit">${not empty bruceshopOrder.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="bruceshop:order:bruceshopOrder:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bruceshopOrder" action="${ctx}/bruceshop/order/bruceshopOrder/save?path=${path}" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div class="control-group">
			<label class="control-label">会员昵称：</label>
			<div class="controls">
				<form:select path="userid" class="input-xlarge ">
					<c:forEach var="user" items="${userList}">
						<form:option value="${user.id}" label="${user.usernickname}"/>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">支付方式：</label>
			<div class="controls">
				<form:select path="paytype" class="input-xlarge ">
					<%-- <form:option value="" label=""/> --%>
					<form:options items="${fns:getDictList('bruceshop_payType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">支付状态：</label>
			<div class="controls">
				<form:select path="paystatus" class="input-xlarge ">
					<form:options items="${fns:getDictList('bruceshop_payStatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">订单状态：</label>
			<div class="controls">
				<%-- <form:input path="orderstatus" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/> --%>
				<form:select path="orderstatus" class="input-xlarge ">
					<form:options items="${fns:getDictList('bruceshop_orderStatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">订单总额：</label>
			<div class="controls">
				<form:input path="amount" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">订单运费：</label>
			<div class="controls">
				<form:input path="fee" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品总数量：</label>
			<div class="controls">
				<form:input path="quantity" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">送货城市：</label>
			<div class="controls">
				<%-- <form:input path="city" htmlEscape="false" maxlength="255" class="input-xlarge "/> --%>
				<sys:treeselect id="city" name="city" value="${bruceshopOrder.city}" labelName="parent.name" labelValue="${bruceshopOrder.cityName}"
					title="送货城市" url="/sys/area/treeData" extId="${area.id}" cssClass="" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">详细地址：</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">快递运单号：</label>
			<div class="controls">
				<form:input path="expressno" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">快递公司名称：</label>
			<div class="controls">
				<form:select path="expresscompanyname" class="input-xlarge ">
					<form:options items="${fns:getDictList('bruceshop_express')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="bruceshop:order:bruceshopOrder:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>