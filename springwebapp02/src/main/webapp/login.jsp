<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<div th:if="${error}" style="color: red;">
		<p th:text="${error}"></p>
	</div>
	<form action="login" method="post">
		<div>
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" required>
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required>
		</div>
		<button type="submit">Login</button>
	</form>
</body>
</html>
