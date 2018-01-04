<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员管理管理</title>
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
	<form:form id="searchForm" modelAttribute="bruceshopUser" action="${ctx}/bruceshop/user/bruceshopUser/lockList" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>会员名称：</label>
				<form:input path="username" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>会员昵称：</label>
				<form:input path="usernickname" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>会员名称</th>
				<th>会员昵称</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>最后登录时间</th>
				<th>最后登录IP</th>
				<th>注册时间</th>
				<th>会员等级</th>
				<th>是否锁定用户</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="bruceshop:user:bruceshopUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bruceshopUser">
			<tr>
				<td><a href="${ctx}/bruceshop/user/bruceshopUser/form?id=${bruceshopUser.id}">
					${bruceshopUser.username}
				</a></td>
				<td>
					${bruceshopUser.usernickname}
				</td>
				<td>
					${bruceshopUser.email}
				</td>
				<td>
					${bruceshopUser.phone}
				</td>
				<td>
					<fmt:formatDate value="${bruceshopUser.lastlogintime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopUser.lastloginip}
				</td>
				<td>
					<fmt:formatDate value="${bruceshopUser.regeistdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopUser.userlevel}
				</td>
				<td>
					${bruceshopUser.islock}
				</td>
				<td>
					<fmt:formatDate value="${bruceshopUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopUser.remarks}
				</td>
				<shiro:hasPermission name="bruceshop:user:bruceshopUser:edit"><td>
					<a href="${ctx}/bruceshop/user/bruceshopUser/unlock?id=${bruceshopUser.id}" onclick="return confirmx('确认要冻结该会员吗？', this.href)">解冻</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>