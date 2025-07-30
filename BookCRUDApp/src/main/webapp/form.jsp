<%@ page language="java" %>
<html>
<head><title>Book Form</title></head>
<body>
    <h2>Book Form</h2>
    <form method="post" action="books">
        <input type="hidden" name="id" value="${book != null ? book.id : ''}"/>
        Title: <input type="text" name="title" value="${book != null ? book.title : ''}"/><br/>
        Author: <input type="text" name="author" value="${book != null ? book.author : ''}"/><br/>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>