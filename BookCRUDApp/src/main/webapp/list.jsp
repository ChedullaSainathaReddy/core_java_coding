<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Books List</title></head>
<body>
    <h2>Books List</h2>
    <a href="books?action=new">Add New Book</a>
    <table border="1">
        <tr><th>ID</th><th>Title</th><th>Author</th><th>Actions</th></tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <a href="books?action=edit&id=${book.id}">Edit</a>
                    <a href="books?action=delete&id=${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>