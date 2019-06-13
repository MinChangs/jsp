<%@tag import="kr.or.ddit.prod.model.ProdVo"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.dao.ProdDao"%>
<%@tag import="kr.or.ddit.prod.dao.IProdDao"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" type="java.lang.String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<% 
	String code = (String)jspContext.getAttribute("code");
	IProdDao dao = new ProdDao();
	List<ProdVo> list = dao.prodList(code);
	request.setAttribute("list",list);
%>
 
<select>
<c:forEach items="${list}" var="i">
	<option id="${i.prod_id }">${i.prod_name}</option>
</c:forEach>
</select>
