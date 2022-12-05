<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../Header.jsp" />

<form method="post" action="User" class="page" name="join_form">
	<input type="hidden" name="command" value="Join">
	<div class="login_page">
        <p class="title text-center">회원가입</p>
		<p class="text-center">회원가입에 필요한 정보들을 기입해주세요</p>
		<c:if test="${message}">
			<p class="text-center" style="color:red;">${message}</p>
		</c:if>
		<div class="form_group">
            <p class="mb-1">이름</p>
            <input type="text" name="name" class="login_input">
        </div>
        
        <div class="form_group">
            <p class="mb-1">E-mail</p>
            <input type="text" name="email" class="login_input">
        </div>
        <div class="form_group">
            <p class="mb-1">전화번호</p>
            <input type="text" name="phone" size="13" class="login_input">
        </div>
        <div class="form_group">
          <p class="mb-1">비밀번호</p>
          <input type="password" name="pw" class="login_input">
        </div>
        <div class="form_group">
          <p class="mb-1">비밀번호 확인</p>
          <input type="password" name="pw_check" class="login_input">
        </div>
        <div class="form_group">
          <input type="submit" class="login_btn" value="회원가입" onclick="return joinCheck()" />
        </div>
        <div class="form_group text-right">
          <a href="User?command=Login_form">로그인</a>
        </div>
      </div>
</form>
<jsp:include page="../Footer.jsp" />