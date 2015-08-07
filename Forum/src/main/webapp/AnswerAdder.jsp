<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<jsp:useBean id="connector" class="demoforumart.ConnectorBean">
    
    </jsp:useBean>
    
    <%
    connector.ConnectionBean();
    
    Statement statement = connector.getStatement();
    if(!request.getParameter("answer").equals(""))
    	statement.execute("insert into answer values(null,'"+request.getParameter("answer")+"',"+request.getParameter("questionId")+",2)"); 
    //System.out.println( request.getHeader("Referer"));
    response.sendRedirect(request.getHeader("Referer"));
    
    
    %>

</body>
</html>