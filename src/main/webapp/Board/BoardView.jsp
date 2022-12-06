<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../Header.jsp"/>
<div class="container">
	<div class="page_title">
		<p class="title">게시글 보기</p>
	</div>
	
		<input type="hidden" name="command" value="Board_write">
		<input type="hidden" name="uid" value="${loginUser.uid }">
		<input type="hidden" name="name" value="${loginUser.name }">
		<div class="board_write">
			<table class="board_write_table">
				<tr class="w-100">
					<th class="board_write_head">글 제목</th>
					<td class="board_view1" colspan="3"> ${board.title} </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">작성자</th>
					<td class="board_view2"> ${board.name} </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">작성일</th>
					<td class="board_view2"> ${board.write_date} </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_content">내용</th>
					<td><div class="board_view3" colspan="3">${board.content}</div></td>
				</tr>
			</table>
			<br><br>
			<c:choose>
				<c:when test="${loginUser.uid == board.uid }">
					<input class="write_btn" type="button" onclick="location.href='Board?command=Board_update_form&bid=${board.bid}'" value="게시물 수정">
					<input class="write_btn" type="button" onclick="location.href='Board?command=Board_delete&bid=${board.bid}'" value="게시물 삭제">
				</c:when>
				<c:when test="${loginUser.admin == 1 }">
					<input class="write_btn" type="button" onclick="location.href='Board?command=Board_delete&bid=${board.bid}'" value="게시물 삭제">
				</c:when>
			</c:choose>
			
			
			<input class="write_btn" type="button" value="목록" onclick="location.href='Board?command=Board_list'" />
		</div>
		
	
</div>
<jsp:include page="../Footer.jsp"/>