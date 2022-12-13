<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="page_title">
	<p class="title">고기메뉴</p>
</div>
<table class="table table-responsive menu_board_list">
	<thead class="table-dark">
		<tr>
			<th>메뉴이름</th>
			<th>원산지</th>
			<th>가격</th>
			<th>100g당 가격</th>
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
						<td>${meet.name}</td>
						<td>${meet.addr}</td>
						<td>${meet.price}</td>
						<td>${meet.price_100g}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div class="page_title">
	<p class="title">식사메뉴</p>
</div>
<table class="table table-responsive menu_board_list">
	<thead class="table-dark">
		<tr>
			<th>메뉴이름</th>
			<th>가격</th>
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
						<td>${meal.name}</td>
						<td>${meal.price}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div class="page_title">
	<button class="write_btn" onclick="location.href='Menu?command=Menu_write_form'">글쓰기</button>
</div>
