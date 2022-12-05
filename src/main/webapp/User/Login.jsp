<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../Header.jsp" />
<form class="page" method="post" action="User" name="login_form">
	<input type="hidden" name="command" value="Login">
	<div class="login_page">
		<p class="title text-center">로그인</p>
		<c:if test="${message}">
			<p class="text-center" style="color:red;">${message}</p>
		</c:if>
		<div class="form_group">
			<p class="mb-1">E-mail</p>
			<input type="text" name="email" class="login_input" >
		</div>
		<div class="form_group">
			<p class="mb-1">Password</p>
			<input type="password" name="pw" class="login_input">
		</div>
		<div class="form_group">
			<input type="submit" class="login_btn" value="로그인" onclick="return loginCheck()"/>
		</div>
		<div class="form_group text-right">
			<a href="User?command=Join_form">회원가입</a>
		</div>
	</div>
</form>
<jsp:include page="../Footer.jsp" />