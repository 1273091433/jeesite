<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>促销活动管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/bruceshop/activity/bruceshopActivity/">促销活动列表</a></li>
		<shiro:hasPermission name="bruceshop:activity:bruceshopActivity:edit"><li><a href="${ctx}/bruceshop/activity/bruceshopActivity/form">促销活动添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bruceshopActivity" action="${ctx}/bruceshop/activity/bruceshopActivity/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>活动标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>活动标题</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="bruceshop:activity:bruceshopActivity:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bruceshopActivity">
			<tr>
				<td><a href="${ctx}/bruceshop/activity/bruceshopActivity/form?id=${bruceshopActivity.id}">
					${bruceshopActivity.title}
				</a></td>
				<td>
					<fmt:formatDate value="${bruceshopActivity.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopActivity.remarks}
				</td>
				<shiro:hasPermission name="bruceshop:activity:bruceshopActivity:edit"><td>
    				<a href="${ctx}/bruceshop/activity/bruceshopActivity/form?id=${bruceshopActivity.id}">修改</a>
					<a href="${ctx}/bruceshop/activity/bruceshopActivity/delete?id=${bruceshopActivity.id}" onclick="return confirmx('确认要删除该促销活动吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>