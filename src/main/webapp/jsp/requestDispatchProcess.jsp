<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("userId : "+request.getParameter("userId"));
	
		//같은 서버내에서 운용되기때문에 getRequestDispatcher 인자값 안으로 getContextPath를 안붙여도 된다
		//
		RequestDispatcher rd =request.getRequestDispatcher("/jsp/requestDispatchTarget.jsp");
		rd.forward(request, response);
	%>
</body>
</html>