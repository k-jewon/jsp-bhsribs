<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<p class="menu_title">고기메뉴</p>
<div class="menu_board_list">
<table class="table table-dark table-striped table-hover">
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
</div>
<p class="menu_title">식사메뉴</p>
<div class="menu_board_list">
<table class="table table-dark table-striped table-hover ">
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
</div>

<div class="menu_btn">
	<button class="write_btn" onclick="location.href='Menu?command=Menu_write_form'">메뉴 추가</button>
</div>
