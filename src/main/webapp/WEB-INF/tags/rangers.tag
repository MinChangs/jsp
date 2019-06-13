<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="rangers" type="java.lang.String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<select>
<c:forTokens items="${rangers}" delims="," var="i">
		<option>${i}</option>
</c:forTokens>
	</select>