<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../Header.jsp"/>
<c:if test="${empty loginUser }">
	<% response.sendRedirect("Main"); %>
</c:if>
<div class="container">
	<div class="page_title">
		<p class="title">메뉴 수정</p>
	</div>
	<form action="Menu?command=Menu_update" method="post" enctype="multipart/form-data" name="Menu_update_form">
		<input type="hidden" name="mid" value="${Menu.mid}">
		<div class="board_write">
			<table class="board_write_table">
				<tr class="w-100">
					<th class="board_write_head">메뉴 종류</th>
					<td>
						<select class="board_input" name="type" onchange="selectChange(this.value);">
						<c:choose>
							<c:when test="${Menu.type == 1 }">
								<option value="1" selected>고기메뉴</option>
								<option value="2">식사메뉴</option>
							</c:when>
							<c:when test="${Menu.type == 2 }">
								<option value="1">고기메뉴</option>
								<option value="2" selected>식사메뉴</option>
							</c:when>
						</c:choose>
						</select>
					</td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">메뉴 이름</th>
					<td> <input class="board_input" type="text" name="name" value="${Menu.name}" autocomplete="off"> </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">원산지</th>
					<td> <input class="board_input" type="text" name="addr" id="addr" value="${Menu.addr}" autocomplete="off"> </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">메뉴 가격</th>
					<td> <input class="board_input" type="text" name="price" value="${Menu.price}" autocomplete="off"> </td>
				</tr>
				<tr class="w-100 100g">
					<th class="board_write_head">100g당 메뉴 가격</th>
					<td> <input class="board_input" id="100g" type="text" name="price_100g" value="${Menu.price_100g}" autocomplete="off"> </td>
				</tr>				
				<tr class="w-100">
					<th class="board_write_head">메뉴 사진</th>
					<td> <input class="board_input" type="file" name="pictureurl" value="${Menu.pictureurl}"> </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">현재 메뉴 사진</th>
					<td>
					<c:choose>
						<c:when test="${empty Menu.pictureurl }">
							<img class="menu_img" src="images/noImage.png">
						</c:when>
						<c:otherwise>
							<img class="menu_img" src="images/${Menu.pictureurl}"/>
						</c:otherwise>
					</c:choose>
					 
					</td>
				</tr>
			</table>
			<br><br>
			<input class="write_btn" type="submit" value="메뉴 수정">
			<input class="write_btn" type="reset" value="다시 작성">
			<input class="write_btn" type="button" value="목록" onclick="location.href='Menu?command=Menu_list_admin'" />
			<input class="write_btn" type="button" value="메뉴 삭제" onclick="location.href='Menu?command=Menu_delete$mid=${Menu.mid}'" />
		</div>
		
	</form>
	
</div>
<jsp:include page="../Footer.jsp"/>