<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-hover table-bordered">
	<thead>
		<tr class="active">
			<th>user name</th>
			<th>operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<!-- for (User user: users) -->
			<tr class="info">
				<td><a href="<spring:url value="/users/${user.id}.html"/>">
						${user.name} </a></td>
				<td><a href="<spring:url value="/users/remove/${user.id}.html"/>" class="btn btn-danger">
						remove </a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>