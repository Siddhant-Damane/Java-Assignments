<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.HashMap"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Forum</title>

</head>
<body>

	<h1 align="center">Home</h1>
	<div></div>

	<form:form method="POST" action="/forum/addQuestion" commandName="question">
		<form:input path="question" type="text" placeholder="Question" />
		<form:input type="submit" value="Add Question" path="" />
	</form:form>

	<form:form method="POST" action="/forum/searchQuestion"	commandName="question">
		<form:input path="question" type="text" placeholder="Question" />
		<form:input type="submit" value="Search Question" path="" />
	</form:form>

	<div>
		<table border="1" align="center" style="width: 50%">
			<thead>
				<tr>
					<th>Question And Answer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${map}" var="entry">
					<tr>
						<td><a href="/forum/question/${entry.key.questionId}/answers">Question
								: ${entry.key.question}</a> <br> Answers : <br> <br>
							<c:forEach items="${entry.value}" var="answer">${answer.answer}<br>
								<br>
							</c:forEach></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>




	</div>
</body>
</html>