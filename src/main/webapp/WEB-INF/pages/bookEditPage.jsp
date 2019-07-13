<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.07.2019
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <c:choose>
        <c:when test="${empty book.id}">
            <title>Добавление</title>
        </c:when>
        <c:otherwise>
            <title>Изменение</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<form:form method="post" modelAttribute="book" action="/books/edit">
    <form:hidden path="id"/>
    <form:label path="bookName">Название книги</form:label>
    <form:input type="text" path="bookName"/>
    <form:label path="countPage">Количество страниц</form:label>
    <form:input type="text" path="countPage"/>
    <form:label path="year">Год</form:label>
    <form:input type="text" path="year"/>
    <form:select path="author.id" items="${authors}" itemLabel="fullName" itemValue="id"/>
    <form:button type="submit">Сохранить</form:button>
</form:form>
</body>
</html>
