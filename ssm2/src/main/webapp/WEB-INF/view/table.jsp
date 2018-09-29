<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>表格--列表</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/bootstrap.min.css" />
    <style type="text/css">
        th {text-align: center;}
        td {text-align: center;}
    </style>
</head>
<body>

	<div class="container">
		<div class="row">
			<h2>用户列表</h2>
		</div>
		<div class="row">
			<div class="col-md-9">
				<table class="table table-bordered">
					<tr>
						<th>编号</th>
						<th>用户名</th>
						<th>密码</th>
					</tr>
					<c:forEach items="${res }" var="tab">
						<tr>
							<td>${tab.id }</td>
							<td>${tab.name }</td>
							<td>${tab.password }</td>
						</tr>
					</c:forEach>
				</table>
				<nav style="text-align:center;">
				    <ul class="pagination">
				        <li><a href="?start=${page.start-page.count}">&laquo;</a></li><!-- 上一页  -->
				        <li class="active"><a href="?start=0">首页</a></li>
				        <li><a href="?start=${page.last}">尾页</a></li>
				        <li><a href="?start=${page.start+page.count}">&raquo;</a></li><!-- 下一页 -->
				    </ul>
			    </nav>
			</div>
		</div>
		
	</div>
	
	<script type="text/javascript" src="<%=path %>/static/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
</body>
</html>