<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@   taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<table class="table table-hover table-bordered">
  <thead>
    <tr class="active">
      <th>user name</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach items="${users}" var="user"><!-- for (User user: users) -->
       <tr class="info">
         <td>
              ${user.name}
         </td>
       </tr>
       </c:forEach>
  </tbody>
</table>