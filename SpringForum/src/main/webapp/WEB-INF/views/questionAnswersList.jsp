<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.HashMap"%>

<html>
<head>
<title>Forum</title>

</head>
<body>
	<header>
		<div align="centre"></div>
	</header>
	<br>
	<br>
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
						<td>Question : ${entry.key.question}<br>
						<br> Answers : <br>
						<br> <c:forEach items="${entry.value}" var="answer">
 				${answer.answer}<br>
								<br>
							</c:forEach>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>




	</div>
</body>
</html>