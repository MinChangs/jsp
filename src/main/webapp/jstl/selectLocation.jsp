<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#${language}").attr("selected","selected");
})


</script>
<title>Insert title here</title>

</head>
<body>
	<h2>select locale</h2>
	<form  action="${cp}/selectLocale">
		<select id="language" name="language" onchange="this.form.submit()">
			<option id="ko" value="ko" >한국어</option>
			<option id="en" value="en">english</option>
			<option id="ja" value="ja">日本言</option>
		</select>
	</form>
	
	<fmt:setLocale value="${language}"  />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING" />
		<BR>
		<fmt:message key="VISITOR">
			<fmt:param value="brown" />
			<br>
		</fmt:message>
	</fmt:bundle>


</body>
</html>