<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${vo.title }</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
				<li><a href="">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${vo.id }/adminbasic">블로그 관리</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${postVo.title }</h4>
					<p>
					${postVo.contents }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList }" var="vo">
						<li><a href="">${vo.title }</a> <span>${vo.regDate }</span>	</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${list }" var="vo" varStatus="status" >
					<li><a href="">${vo.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>${vo.title }</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>