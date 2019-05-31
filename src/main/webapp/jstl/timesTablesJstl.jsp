<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
<c:forEach begin="1" end="${empty param.dan1 ? 9: param.dan1}" var="i">
	<tr>
	<c:forEach begin="2" end="${empty param.dan2 ? 9: param.dan2}" var="j">
		<td>${j} * ${i} = ${j*i}</td>
	</c:forEach>
	</tr>
</c:forEach>
</table>

</body>
</html>