<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Forum</title>

</head>
<body>
 <header>
  <div align = "centre">
 	<% 
 	
 	if(request.getAttribute("loginStatus").toString()  == "false") {
 		
 		
 	 %>
	  <div align = "right"> 
			  <form action="login">
			  	<input type="text" name="userName">
			  	<button type= "submit">login</button>
			  </form>
	  </div>
	  
	  <%
 	}
 	else {
 		%>
 		<div
 		align = "right">User Name : <%=request.getAttribute("user") %></div>
 		<form action="logout" align = "right">
			  	
			  	<button type= "submit">logout</button>
			  </form>
 		
 		<% 
 	}
	  
 	%>
 </div>
  </header>	
 	<br>
	<br>
	<div >
 		
 		
		
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			
		
		
		<table border="1" align="center" style="width:50%">
        <thead>
            <tr>
                <th>Question And Answer</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach items="${map}" var="entry">
			   <tr>
			    <td>
			    Question : ${entry.key.question}<br><br>
			    Answers : <br><br>
			    
			    <c:forEach items="${entry.value}" var="answer">
 				${answer.answer}<br><br>
				</c:forEach>
				</td>
				</tr>
				
			</c:forEach>
        </tbody>
    </table> 
		
		
		
		
	</div>
</body>
</html>