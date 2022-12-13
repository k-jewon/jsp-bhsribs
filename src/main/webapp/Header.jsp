<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link rel="stylesheet" href="/Project/css/reset.css">
	<link rel="stylesheet" href="/Project/css/slick.css">
	<link rel="stylesheet" href="/Project/css/customBootstrap.css">
	<link rel="stylesheet" href="/Project/css/custom.css">
	<title>북한산 갈비</title>
</head>
<body>
	<div class="menu">
        <div class="logo">
             <a href="/Project/index.jsp">북한산갈비&춘천숯불닭갈비</a>
        </div>
        <div class="menu_bar">
            <div class="menu_line1"></div>
            <div class="menu_line2"></div>
            <div class="menu_line3"></div>
        </div>
        <c:choose>
        	<c:when test="${empty loginUser}">
				<ul class="menu_item">
					<li class="item"><a href="/Project/User?command=Join_form">회원가입</a></li>
					<li class="item"><a href="/Project/User?command=Login_form">로그인</a></li>
					<li class="item"><a href="/Project/Menu/Menu.jsp">메뉴보기</a></li>
					<li class="item"><a href="/Project/Board?command=Board_list">게시판</a></li>
					<li class="item"><a href="/Project/Book?command=Book_write_form">예약문의</a></li>
				</ul>
			</c:when>
			<c:when test="${loginUser.admin == 1}">
				<ul class="menu_item">
					<li class="item">${loginUser.name}관리자님 환영합니다</li>
					<li class="item"><a href="/Project/User?command=Logout">로그아웃</a></li>
					<li class="item"><a href="/Project/Book?command=Book_list&#home">관리자페이지</a></li>
					<li class="item"><a href="/Project/Menu/MenuList.jsp">메뉴보기</a></li>
					<li class="item"><a href="/Project/Board?command=Board_list">게시판</a></li>
					<li class="item"><a href="/Project/Book?command=Book_write_form">예약문의</a></li>
				</ul>
			</c:when>
        	<c:when test="${loginUser.admin == 0}">
				<ul class="menu_item">
					<li class="item">${loginUser.name}님 환영합니다</li>
					<li class="item"><a href="/Project/User?command=Logout">로그아웃</a></li>
					<li class="item"><a href="/Project/Menu/Menu.jsp">메뉴보기</a></li>
					<li class="item"><a href="/Project/Board?command=Board_list">게시판</a></li>
					<li class="item"><a href="/Project/Book?command=Book_write_form">예약문의</a></li>
				</ul>
			</c:when>
        </c:choose>
        
    </div>
