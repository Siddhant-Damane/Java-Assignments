<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp" >HOME</a>
	
	
	<jsp:useBean id="connector" class="demoforumart.ConnectorBean">
    
    </jsp:useBean>
    
    <%
    connector.ConnectionBean();
    
    Statement statement = connector.getStatement();
    
    ResultSet resultSet=statement.executeQuery("Select * from question where ques_id="+request.getParameter("questionId")+" ");
    while(resultSet.next())
    {
   %>
    <p><b>Ouestion is</b> : <%=resultSet.getString(3)%>
	<p>Answers are :</p>
    <%
    }
    resultSet=statement.executeQuery("Select * from answer where ques_id="+request.getParameter("questionId")+" ");
    while(resultSet.next())
    {
    	%><p><%=resultSet.getString(2)%></p>
    	<% 
    }
    %>
    
    <form action="AnswerAdder.jsp">
    
    <input name="questionId" type="hidden" value=<%=request.getParameter("questionId") %>>
    
    <textarea rows="10" cols="50" name="answer"></textarea>
    <button type="submit">Add Answers</button>
    </form>
    
    

    
</body>
</html>