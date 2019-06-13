<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>fmt:formatDate</h2>
<c:set var="dt" value="<%= new Date() %>"/>
dt : ${dt}<br>
<fmt:formatDate value="${dt}" /><br>
<fmt:formatDate value="${dt}" pattern="yyyy-MM-dd"/><br>
<fmt:formatDate value="${dt}" /><br>
dt -FULL <fmt:formatDate value="${dt}" type="date" dateStyle="FULL"/><br>
dt -MEDIUM <fmt:formatDate value="${dt}" type="date" dateStyle="MEDIUM"/><br>
dt -SHORT <fmt:formatDate value="${dt}" type="date" dateStyle="SHORT"/><br>
<fmt:formatDate value="${dt}" type="time"/><br>
<fmt:formatDate value="${dt}" type="both"/><br>

<h3>de</h3>
<fmt:setLocale value="de_DE"/>
dt : <fmt:formatDate value="${dt}" /><br>



<h2>parseDate (String -> date / 2019.6.13 - date형식)</h2>
<fmt:setLocale value="ko_KR"/>
<c:set value="2019.06.13" var="dtStr"/>
dtStr : ${dtStr }<br>
dtStr : <fmt:parseDate value="${dtStr }" pattern="yyyy.MM.dd"/>  <br>

</body>
</html>