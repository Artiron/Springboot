<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.07.2019
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Авторы-хуявторы</h2>
<h2><a href="/">Назад</a></h2>
<h2><a href="/authors/add">Добавить</a></h2>
<table>
    <tr>
        <th>id</th>
        <th>ФИО</th>
    </tr>
    <c:forEach var="author" items="${authorsList}">
    <tr>
        <td>${author.id}</td>
        <td>${author.fullName}</td>
        <td>
            <a href="/books/getByAuthor/${author.id}">Книги автора</a>
            <a href="/authors/edit/${author.id}">Изменить</a>
            <a href="/authors/delete/${author.id}">Удалить</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
