<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public String hello(){
	return "hello~";
} 
%>
hello() : <%=hello() %><br>
<%! public int fac(int i){
	
	int result = 1;
	if(i==0){
		return result;
	}else{
		for(int j=1; j<i; j++){
			result+= result*j;
		}
		return result;
	}
	
} 
%>
<%! public int fac2(int i){
	
	int result = 1;
	if(i==0){
		return result;
	}else{
		return fac2(i-1)*i;
	}
	
} 
%>
fac(1) : <%=fac2(1) %><br>
fac(2) : <%=fac2(2) %><br>
fac(3) : <%=fac2(3) %><br>
fac(4) : <%=fac2(4) %><br>
fac(5) : <%=fac2(5) %><br>
fac(6) : <%=fac2(6) %><br>
fac(7) : <%=fac2(7) %><br>
fac(8) : <%=fac2(8) %><br>

</body>
</html>