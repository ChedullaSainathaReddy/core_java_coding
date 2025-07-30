<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<h2>Student Feedback Form</h2>
<form action="feedbackSummary.jsp" method="post" style="max-width: 500px; margin: 0 auto;">
    <p>Select the facilities you want to give feedback on:</p>
    <div style="line-height: 1.8;">
        <label><input type="checkbox" name="facilities" value="Library" /> Library</label><br/>
        <label><input type="checkbox" name="facilities" value="Cafeteria" /> Cafeteria</label><br/>
        <label><input type="checkbox" name="facilities" value="Laboratories" /> Laboratories</label><br/>
        <label><input type="checkbox" name="facilities" value="Classrooms" /> Classrooms</label><br/>
        <label><input type="checkbox" name="facilities" value="Sports Complex" /> Sports Complex</label>
    </div>
    <br/>
    <label for="studentName">Your Name:</label><br/>
    <input type="text" name="studentName" id="studentName" required style="width: 100%; padding: 8px; margin-top: 4px;" /><br/><br/>
    <input type="submit" value="Submit Feedback" 
           style="padding: 10px 20px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer;" />
</form>
<%@ include file="footer.jsp" %>
