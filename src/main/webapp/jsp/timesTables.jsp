<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 9*9단 출력 -->

	<% 
		String param1=request.getParameter("i");
		String param2=request.getParameter("j");
	%>
	<table border="1">

		<% for (int i = 1; i <= Integer.parseInt(param1); i++) { %>
		<tr>
			<% for (int j = 2; j <= Integer.parseInt(param2); j++) { %>
			<td><%=j %>  *  <%= i %>  =  <%= i * j%></td>
			<%	} %>
		</tr>
		<%	} %>
	</table>

</body>
</html>