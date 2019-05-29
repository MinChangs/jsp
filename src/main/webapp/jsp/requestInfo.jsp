<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- jsp 주석 --%>
	<%-- : 스크립틀릿 <% %>: 자바 코드를 작성하는 영역 --%>
	
	<%-- :표현식 <%= %>: 객체를 출력 --%>
	
	<%
		String msg = "test";
		msg +="_append";
		
		//jsp의 내장객체, 묵시적객체(implict) (이미 선언되어있기 때문에 별도의 선언 없이 사용가능한 객체의 하나)
		
	%>
		request.getRemoteAddr() <%=request.getRemoteAddr() %><br>
		request.getLocalAddr() <%=request.getLocalAddr() %><br>
		request.getContentType() <%=request.getContentType() %><br>
		request.getContextPath() ${pageContext.request.contextPath}<br>
		request.getMethod() <%=request.getMethod() %><br>
		request.getRequestURI() <%=request.getRequestURI() %><br>
		request.getProtocol() <%=request.getProtocol() %><br>
		
		<img src="/jsp/img/brown.png"><br>
		<%--파라미터 받기 --%>
		request.getParameter("rangersName") : <%=request.getParameter("rangersName") %><br>

</body>
</html>