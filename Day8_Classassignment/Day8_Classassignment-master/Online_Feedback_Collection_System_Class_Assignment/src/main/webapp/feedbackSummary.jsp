<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<h2>Thank You!</h2>
<p>
    We appreciate your feedback, <strong>${param.studentName}</strong>!
</p>
<%
    String[] facilities = request.getParameterValues("facilities");
%>
<% if (facilities != null && facilities.length > 0) { %>
    <p>You provided feedback on the following facilities:</p>
    <ul>
        <% for (String facility : facilities) { %>
            <li><%= facility %></li>
        <% } %>
    </ul>
<% } else { %>
    <p>You did not select any facilities.</p>
<% } %>

<%@ include file="footer.jsp" %>