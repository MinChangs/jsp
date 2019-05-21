<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello, World</title>
</head>
<body>
	hello, world
	<%-- jsp 주석 --%>
	<!-- : 스크립틀릿 : 자바 코드를 작성하는 영역 -->
	<% Date date = new Date(); %>
	
	<!-- :표현식 : 객체를 출력 -->
	현재시간 : <%=date %>

</body>
</html>