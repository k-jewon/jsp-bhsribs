<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../Header.jsp" />
<form class="page" method="post" action="Book" name="book_form">
<input type="hidden" name="command" value="Book_write">
	<div class="login_page">
		<p class="title text-center">예약 문의</p>
		<c:choose>
			<c:when test="${empty loginUser}">
				<div class="form_group">
					<p class="mb-1">이름</p>
					<input type="text" name="name" class="login_input">
				</div>
				<div class="form_group">
					<p class="mb-1">전화번호</p>
					<input type="text" name="phone" class="login_input">
				</div>
			</c:when>
			<c:otherwise>
				<div class="form_group">
					<p class="mb-1">이름</p>
					<input type="text" name="name" value="${loginUser.name}" class="login_input">
				</div>
				<div class="form_group">
					<p class="mb-1">전화번호</p>
					<input type="text" name="phone" value="${loginUser.phone}" class="login_input">
				</div>
			</c:otherwise>
		</c:choose>
		<div class="form_group">
			<p class="mb-1">예약시간</p>
			<input type="datetime-local" name="days" class="login_input">
		</div>
		<div class="form_group">
			<p class="mb-1">예약 인원</p>
			<input type="text" name="howmany" placeholder="숫자로만 입력해 주세요" class="login_input">
		</div>
		<div class="form_group">
			<p class="mb-1">문의사항</p>
			<textarea class="text" name="content" placeholder="문의사항을 이곳에 적어주시면 감사드리겠습니다."></textarea>
		</div>
		<div class="form_group">
			<button type="submit" class="login_btn">예약 신청</button>
		</div>
	</div>
</form>
<jsp:include page="../Footer.jsp" />