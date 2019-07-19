<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.07.2019
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Электронная библиотека$</title>
  </head>
  <body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
      <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>

      <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
  </div>
  <h2><a href="${pageContext.request.contextPath}/books/">Books</a> </h2>
  <h2><a href="${pageContext.request.contextPath}/authors/">Authors</a> </h2>
  </body>
</html>
