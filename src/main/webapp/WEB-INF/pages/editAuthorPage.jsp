<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.07.2019
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование автора</title>
</head>
<body>
<spring:form modelAttribute="author" method="post" action="/authors/edit">
    <spring:hidden path="id"/>
    <spring:label path="fullName">ФИО автора</spring:label>
    <spring:input path="fullName"/>
    <spring:button type="submit">Сохранить</spring:button>
</spring:form>
</body>
</html>
