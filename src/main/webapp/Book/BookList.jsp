<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="book_board_list">
	<table class="table table-dark table-striped">

		<c:choose>
			<c:when test="${empty Book}">
				<tr class="table-dark">
					<th>예약자 이름</th>
					<th>전화번호</th>
					<th>인원수</th>
					<th>예약시간</th>
					<th>문의사항</th>
				</tr>
				<tr>
					<td colspan="5" class="book_none">예약이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="book" items="${Book}">
					<thead class="table-dark">
						<tr>
							<th>예약자 이름</th>
							<th>전화번호</th>
							<th>인원수</th>
							<th>예약시간</th>
							<th>문의사항</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${book.name}</td>
							<td>${book.phone}</td>
							<td>${book.howmany}</td>
							<td>${book.days}</td>
							<td>${book.content}</td>
						</tr>
					</tbody>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>