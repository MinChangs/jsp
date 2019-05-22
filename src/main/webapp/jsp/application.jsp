<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileInputStream"%>
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
	out.write("application.getContextPath() : "+application.getContextPath()+"<br>");
	out.write("application.getServerInfo() : "+application.getServerInfo()+"<br>");
	out.write("application.getMajorVersion() : "+application.getMajorVersion()+"<br>");
	out.write("application.getMinorVersion() : "+application.getMinorVersion()+"<br>");
	out.write("application.getInitParameter(\"ADMIN\") : "+application.getInitParameter("ADMIN")+"<br>");
	
	
	out.write("application.getRealPath(\"/res/190522.txt\") : "+ application.getRealPath("/res/190522.txt")+"<br>" );
	FileInputStream fis = new FileInputStream(application.getRealPath("/res/190522.txt"));
	
	InputStreamReader isr = new InputStreamReader(fis,"utf-8");
	
	BufferedReader br = new BufferedReader(isr);
	

	while(true) {
		String str = br.readLine();//한줄씩 읽기
		if(str==null) break;
		out.write(str+"<br>");
	}
	//스트림닫기 

	br.close();
	isr.close();
	
%>
</body>
</html>