<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Course Feedback Form</h2>
    <form method="post" action="submitFeedback">
        <label>Student Name:</label>
        <input type="text" name="studentName" required /><br/><br/>
        <label>Email Address:</label>
        <input type="email" name="email" required /><br/><br/>
        <label>Course Attended:</label>
        <input type="text" name="course" required /><br/><br/>
        <label>Feedback:</label><br/>
        <textarea name="feedback" rows="5" cols="30" required></textarea><br/><br/>
        <input type="submit" value="Submit Feedback" />
    </form>
</body>
</html>