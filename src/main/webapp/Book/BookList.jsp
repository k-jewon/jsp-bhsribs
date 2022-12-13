<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="table table-responsive board_list">
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
		<c:choose>
			<c:when test="${empty Book}">
				<li class="board_none">게시물이 없습니다	</li>
			</c:when>
			<c:otherwise>
				<c:forEach var="book" items="${Book}">
					<tr>
						<td>${book.name}</td>
						<td>${book.phone}</td>
						<td>${book.howmany}</td>
						<td>${book.days}</td>
						<td>${book.content}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<ul class="pagination">
	<c:choose>
		<c:when test="${PageVO.prev}">
			<li class="page-item"><a class="page-link"
				href="Board?command=Board_Board&pageNum=${PageVO.startPage - 1 }&amount=${PageVO.amount}"><i
					class="fa fa-angle-double-left" aria-hidden="true"></i></a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled"><a class="page-link" href="#"><i
					class="fa fa-angle-double-left" aria-hidden="true"></i></a></li>
		</c:otherwise>
	</c:choose>

	<c:forEach var="num" begin="${PageVO.startPage}"
		end="${PageVO.endPage}">
		<li class="page-item ${PageVO.pageNum eq num ? 'active' : '' }">
			<a class="page-link"
			href="Board?command=Board_Board&pageNum=${num }&amount=${PageVO.amount}">${num}</a>
		</li>
	</c:forEach>

	<c:choose>
		<c:when test="${PageVO.next}">
			<li class="page-item"><a class="page-link"
				href="Board?command=Board_Board&pageNum=${PageVO.endPage + 1 }&amount=${PageVO.amount}"><i
					class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled"><a class="page-link" href="#"><i
					class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
		</c:otherwise>
	</c:choose>

</ul>