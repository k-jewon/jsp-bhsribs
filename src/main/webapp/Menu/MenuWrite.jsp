<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../Header.jsp"/>
<c:if test="${empty loginUser }">
	<% response.sendRedirect("/Main"); %>
</c:if>
<div class="container">
	<div class="page_title">
		<p class="title">메뉴 추가</p>
	</div>
	<form action="Menu?command=Menu_write" method="post" name="Menu_form" enctype="multipart/form-data">
		<div class="menu_write">
			<table class="board_write_table">
				<tr class="w-100">
					<th class="board_write_head">메뉴 종류</th>
					<td>
						<select class="board_input" name="type" onchange="selectChange(this.value);">
							<option value="1">고기메뉴</option>
							<option value="2">식사메뉴</option>
						</select>
					</td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">메뉴 이름</th>
					<td> <input class="board_input" type="text" name="name" autocomplete="off"> </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">원산지</th>
					<td> <input class="board_input" type="text" name="addr" id="addr" autocomplete="off"> </td>
				</tr>
				<tr class="w-100">
					<th class="board_write_head">메뉴 가격</th>
					<td> <input class="board_input" type="text" name="price" autocomplete="off"> </td>
				</tr>
				<tr class="w-100 100g">
					<th class="board_write_head">100g당 메뉴 가격</th>
					<td> <input class="board_input" id="100g" type="text" name="price_100g" autocomplete="off"> </td>
				</tr>				
				<tr class="w-100">
					<th class="board_write_head">메뉴 사진</th>
					<td> <input class="board_input" type="file" name="pictureurl"> </td>
				</tr>
			</table>
			<br><br>
			<input class="write_btn" type="submit" value="작성">
			<input class="write_btn" type="reset" value="다시 작성">
			<input class="write_btn" type="button" value="목록" onclick="location.href='Menu?command=Menu_list_admin'" />
		</div>
		
	</form>
	
</div>
<script>
var selectChange = function(value){
	if(value == 1){
		$('.100g').removeClass('none');
		$('#100g').attr('value','');
		$('#addr').attr('value','');
	} else if (value == 2 ){
		$('.100g').addClass('none');
		$('#100g').attr('value','0');
		$('#addr').attr('value','해당없음');
	}
	
}
</script>
<jsp:include page="../Footer.jsp"/>