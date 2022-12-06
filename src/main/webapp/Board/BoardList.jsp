<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../Header.jsp" />
<div class="container">
	<div class="page_title">
		<p class="title">게시판</p>
		<c:choose>
			<c:when test="${empty loginUser}">
				<p>글쓰기 기능은 로그인 후 사용 가능합니다.</p>
			</c:when>
			<c:otherwise>
				<button class="write_btn" onclick="location.href='Board?command=Board_write_form'">글쓰기</button>
			</c:otherwise>
		</c:choose>

	</div>
	<ul class="board_list">
		<li class="board_header">
			<div>글제목</div>
			<div>작성날짜</div>
		</li>
		<c:choose>
			<c:when test="${empty List}">
				<li class="board_none">게시물이 없습니다	</li>
			</c:when>
			<c:otherwise>
				<c:forEach var="board" items="${List}">
					<li class="board_line" onclick="location.href='Board?command=Board_view&bid=${board.bid}'">
						<div class="board_title">
							<p class="mb-1">${board.title}</p>
							<span>${board.name}</span>
						</div>
						<div class="board_date">
							<fmt:formatDate value="${board.write_date}"></fmt:formatDate>
						</div>
					</li>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	</ul>
</div>
<jsp:include page="../Footer.jsp" />