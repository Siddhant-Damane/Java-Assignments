<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Forum</title>

</head>
<body>
 <header>
  
 	<% 
 	
 	if(request.getAttribute("loginStatus").toString()  == "false") {
 		
 		
 	 %>
	  <div margin = 0 auto; width = 960px;> 
			  <form action="login">
			  	<input type="text" name="userName">
			  	<button type= "submit">login</button>
			  </form>
	  </div>
	  
	  <%
 	}
 	else {
 		%>
 		<div>User Name : <%=request.getAttribute("user") %></div>
 		<form action="logout">
			  	
			  	<button type= "submit">logout</button>
			  </form>
 		
 		<% 
 	}
	  
 	%>
 
  </header>	
 	<br>
	<br>
	<div >
 		
 		
		
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<c:forEach items="${map}" var="entry">
			    Question : ${entry.key}<br><br>
			    Answers : <br><br>
			    <c:forEach items="${entry.value}" var="ans">
 				${ans}<br><br>
				</c:forEach>
			</c:forEach>
		
		
		
		
		
		
	</div>
</body>
</html>