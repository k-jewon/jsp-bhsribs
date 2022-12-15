<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_title">고기메뉴</p>
<div class="menu_board_list">
<table class="table table-dark table-striped table-hover">
	<thead class="table-dark">
		<tr>
			<th class="text-center">메뉴이름</th>
			<th class="text-center">원산지</th>
			<th class="text-center">가격</th>
			<th class="text-center">100g당 가격</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty Meet}">
				<li class="board_none">새로운 고기메뉴를 추가해주세요</li>
			</c:when>
			<c:otherwise>
				<c:forEach var="meet" items="${Meet}">
					<tr>
						<td class="text-center">${meet.name}</td>
						<td class="text-center">${meet.addr}</td>
						<td class="text-center">${meet.price}</td>
						<td class="text-center">${meet.price_100g}</td>
						<td class="text-center"><button class="btn btn-secondary" onclick="location.href='Menu?command=Menu_update_form&mid=${meet.mid}'">수정</button></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>
<p class="menu_title">식사메뉴</p>
<div class="menu_board_list">
<table class="table table-dark table-striped table-hover ">
	<thead class="table-dark">
		<tr>
			<th class="text-center">메뉴이름</th>
			<th class="text-center">가격</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty Meal}">
				<li class="board_none">새로운 식사메뉴를 추가해주세요</li>
			</c:when>
			<c:otherwise>
				<c:forEach var="meal" items="${Meal}">
					<tr>
						<td class="text-center">${meal.name}</td>
						<td class="text-center">${meal.price}</td>
						<td class="text-center"><button class="btn btn-secondary" onclick="location.href='Menu?command=Menu_update_form&mid=${meal.mid}'">수정</button></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>

<div class="menu_btn">
	<button class="write_btn" onclick="location.href='Menu?command=Menu_write_form'">메뉴 추가</button>
</div>
