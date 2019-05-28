<%@page import="kr.or.ddit.user.model.LprodVo"%>
<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자 페이징 리스트</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
</head>

<body>
<!-- header -->
<%@include file="/common/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

<!-- left -->
<%@include file="/common/left.jsp" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>상품 번호</th>
									<th>상품 아이디</th>
									<th>상품 이름</th>
								</tr>
								<%
									List<LprodVo> lprodList= (List<LprodVo>)request.getAttribute("lprodList");
									for(int i=0; i<lprodList.size(); i++){
										out.write("<tr>");
										out.write("<td>"+lprodList.get(i).getLprod_id()+"</td>");
										out.write("<td>"+lprodList.get(i).getLprod_gu()+"</td>");
										out.write("<td>"+lprodList.get(i).getLprod_nm()+"</td>");
										out.write("</tr>");
										
									}
								%>
				

							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						
						<!--  사용자수 : 105건
						 	  페이지네이션 : 11건 -->
						<div class="text-center">
							<ul class="pagination">
							<% 
								PageVo pageVo= (PageVo)request.getAttribute("LpageVo");
								int paginationSize = (Integer)request.getAttribute("LpaginationSize");
								if(pageVo.getPage()==1){%>
									
								<li class="prev disabled"><span>«</span></li>
								<% }else{%>
								<li class="prev"><a href="<%=request.getContextPath()%>/lprodPagingList?page=<%=pageVo.getPage()-1 %>&pageSize=<%= pageVo.getPageSize()%>">«</a></li>
								<%	
								}
								
								//내가 현재 몇번째 페이지에 있는가?
// 								PageVo pageVo= (PageVo)request.getAttribute("pageVo");
								for(int i=1; i<=paginationSize; i++){
									if(i == pageVo.getPage()){
									%>
										<li class="active"><span><%=i %></span></li>
									<% }else{%>
										
									<li><a href="<%=request.getContextPath()%>/lprodPagingList?page=<%=i %>&pageSize=<%= pageVo.getPageSize()%>"><%=i%></a></li>
		
									<% }
								}
								
								if(pageVo.getPage()==paginationSize){%>
								
								<li class="next disabled"><span>»</span></li>
								<% }else{%>
								<li class="next"><a href="<%=request.getContextPath()%>/lprodPagingList?page=<%=pageVo.getPage()+1 %>&pageSize=<%= pageVo.getPageSize()%>">»</a></li>
								<%	
								}
								
							%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
