<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Header.jsp" />
<form class="page">
	<div class="login_page">
		<p class="title text-center">예약 문의</p>
		<div class="form_group">
			<p class="mb-1">이름</p>
			<input type="text" class="login_input">
		</div>
		<div class="form_group">
			<p class="mb-1">전화번호</p>
			<input type="text" class="login_input">
		</div>
		<div class="form_group">
			<p class="mb-1">예약시간</p>
			<input type="datetime-local" class="login_input">
		</div>
		<div class="form_group">
			<p class="mb-1">예약 인원</p>
			<input type="text" class="login_input">
		</div>
		<div class="form_group">
			<p class="mb-1">문의사항</p>
			<textarea class="text" name="" id=""
				placeholder="문의사항을 이곳에 적어주시면 감사드리겠습니다."></textarea>
		</div>
		<div class="form_group">
			<button class="login_btn">예약 신청</button>
		</div>
	</div>
</form>
<jsp:include page="../Footer.jsp" />