<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@   taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<table>
  <thead>
    <tr>
      <th>user name</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach items="${users}" var="user"><!-- for (User user: users) -->
       <tr>
         <td>
              ${user.name}
         </td>
       </tr>
       </c:forEach>
  </tbody>
</table>