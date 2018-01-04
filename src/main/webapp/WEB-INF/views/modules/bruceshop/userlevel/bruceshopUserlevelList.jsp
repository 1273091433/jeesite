<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员等级管理</title>
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
		<li class="active"><a href="${ctx}/bruceshop/userlevel/bruceshopUserlevel/">会员等级列表</a></li>
		<shiro:hasPermission name="bruceshop:userlevel:bruceshopUserlevel:edit"><li><a href="${ctx}/bruceshop/userlevel/bruceshopUserlevel/form">会员等级添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm " modelAttribute="bruceshopUserlevel" action="${ctx}/bruceshop/userlevel/bruceshopUserlevel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label style="width:100px;text-align:right;">会员等级名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>会员等级编码</th>
				<th>会员等级名称</th>
				<th>最小积分</th>
				<th>积分区间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="bruceshop:userlevel:bruceshopUserlevel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bruceshopUserlevel">
			<tr>
				<td><a href="${ctx}/bruceshop/userlevel/bruceshopUserlevel/form?id=${bruceshopUserlevel.id}">
					${bruceshopUserlevel.code}
				</a></td>
				<td>
					${bruceshopUserlevel.name}
				</td>
				<td>
					${bruceshopUserlevel.minscore}
				</td>
				<td>
					${bruceshopUserlevel.minscore}~${bruceshopUserlevel.maxscore}
				</td>
				<td>
					<fmt:formatDate value="${bruceshopUserlevel.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopUserlevel.remarks}
				</td>
				<shiro:hasPermission name="bruceshop:userlevel:bruceshopUserlevel:edit"><td>
    				<a href="${ctx}/bruceshop/userlevel/bruceshopUserlevel/form?id=${bruceshopUserlevel.id}">修改</a>
					<a href="${ctx}/bruceshop/userlevel/bruceshopUserlevel/delete?id=${bruceshopUserlevel.id}" onclick="return confirmx('确认要删除该会员等级吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>