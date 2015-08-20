
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Answers</title>
</head>
<body>
	<div align="right">
		<a href="/forum">Home</a>
	</div>
	<table border="1" align="center" style="width: 50%">
		<thead>
			<tr>
				<th>${question}</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="answer" items="${answers}">
				<tr>
					<td>${answer.answer}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><form:form method="POST" action="/forum/question/${questionId}/answers/addAnswer" commandName="answer">
						<form:input path="answer" type="text" placeholder="Enter Your Answer" />
						<form:input type="submit" value="Add Answer" path="" />
					</form:form></td>
			</tr>
		</tbody>
	</table>
</body>
</html>