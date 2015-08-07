<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ page import="java.sql.ResultSet" %>
     <%@ page import="java.sql.Statement" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="index.jsp">
	<button type="submit" name="show" value="showQuestion">Show Questions</button>
	<button type="submit" name="show" value="addQuestion">Add Questions</button>
	<button type="submit" name="show" value="searchQuestion">Search Questions</button>
	</form>
	
	
	
	<jsp:useBean id="connector" class="demoforumart.ConnectorBean">
    
    </jsp:useBean>
    
	
	
	<%
	connector.ConnectionBean();

		Statement statement = connector.getStatement();
		System.out.println(request.getParameter("show"));
		if(statement==null)
			System.out.println("Statement is null");
		
		String buttonValue=request.getParameter("show");
		String addValue=request.getParameter("question");
		if(buttonValue!=null)
		{
		
		 if(buttonValue.equals("addQuestion"))
			{
			 %> 
			<form action="index.jsp">
			 <input type="text" name="question" >
			 <button type="submit" name="show" value="inputQuestion">Add</button>
			 <form>
			 <%						
			}
		 else if(buttonValue.equals("showQuestion"))
			{
			ResultSet resultSet =statement.executeQuery("select * from question");
			while(resultSet.next())
			{	
				%>
				
				<form action="showAnswer.jsp">
				
				
				<input type="hidden" name="questionId" value="<%=resultSet.getInt(1) %>">				
				<%=resultSet.getString(3)%>
				
				<button type="submit">See Answers</button>
				
				</form>
				
			
				
			<%
			
	
			}
			
			}
		 else if(buttonValue.equals("inputQuestion"))
		 {
			 String question=request.getParameter("question");
			 if(!question.equals(""))
			 	statement.execute("insert into question values(null,2,'"+question+"')");
			 else
			 {
				 %>
				 <p>Please Enter Something..!!!</p>
				 <%
			 }
		 }	  
		 	 
		 else if(buttonValue.equals("searchedQuestion"))
		 {
			 String question=request.getParameter("question");
			 if(!question.equals(""))
			 {
			 ResultSet resultSet = statement.executeQuery("select * from question");
			 
			 ArrayList<String> matchedQuestions = new ArrayList<String>();
			 		 
			 while(resultSet.next()){
			 	
				 if(resultSet.getString(3).contains(question)){						
						matchedQuestions.add(resultSet.getString(3)); 				 
				 }				 
			 }
			 int length=matchedQuestions.size();
			 if(length!=0)
			 {			 
			 %>
			 	<p><b>Search Results are: </b></p> 
				<%
				for(int i=0;i<length;i++)
				{
					%>
					<p><%=matchedQuestions.get(i)%></p>
					 <%
				}
							
			 }
			 else
			 {

				 %>
					<p>Sorry, No Question Found..!!</p>
				 <%
			 }
			 }
			 else
			 {
				 %><p>Please, Enter Something To Search..!!</p><%
			 }
			
			
			 
		 }
		 else if(buttonValue.equals("searchQuestion"))
			{
			 %> 
			<form action="index.jsp">
			 <input type="text" name="question">
			 <button type="submit" name="show" value="searchedQuestion">Search</button>
			 <form>
			 <%						
			}		 		 
		}	
	
	%>
	
	
	


</body>
</html>