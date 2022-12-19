<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../Header.jsp" />
<c:if test="${empty loginUser }">
	<% response.sendRedirect("Main"); %>
</c:if>
<c:if test="${loginUser.admin == 0}">
	<% response.sendRedirect("Main"); %>
</c:if>
<div class="adminPage">
	<h2 style="margin-top: 100px;" class="title">관리자 페이지</h2>
	<ul class="nav nav-tabs" role="tablist">
		<c:choose>
			<c:when test="${Tabs == 'Book_list'}">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" data-bs-toggle="tab"
					onclick="location.href='Book?command=Book_list'"
					aria-selected="true" role="tab">예약 현황</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item" role="presentation"><a class="nav-link"
					data-bs-toggle="tab"
					onclick="location.href='Book?command=Book_list'"
					aria-selected="true" role="tab">예약 현황</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${Tabs == 'Menu_list_admin'}">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" data-bs-toggle="tab"
					onclick="location.href='Menu?command=Menu_list_admin'"
					aria-selected="false" tabindex="-1" role="tab">메뉴관리</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item" role="presentation"><a class="nav-link"
					data-bs-toggle="tab"
					onclick="location.href='Menu?command=Menu_list_admin'"
					aria-selected="false" tabindex="-1" role="tab">메뉴관리</a></li>
			</c:otherwise>
		</c:choose>

		<!-- <li class="nav-item" role="presentation">
			<a class="nav-link"
			href="#" aria-selected="false" tabindex="-1" role="tab">Disabled</a>
		</li>-->
		<c:choose>
			<c:when test="${Tabs == 'Board_list_admin'}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle active" href="#" role="button"
					id="dropdownMenuLink" data-bs-toggle="dropdown"
					aria-expanded="false"> 인기 게시물 </a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item"
							onclick="location.href='Board?command=Board_list_admin&date=day'">일별
								인기게시물</a></li>
						<li><a class="dropdown-item"
							onclick="location.href='Board?command=Board_list_admin&date=month'">월별
								인기게시물</a></li>
					</ul>
				</li>
			</c:when>
			<c:otherwise>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					id="dropdownMenuLink" data-bs-toggle="dropdown"
					aria-expanded="false"> 인기 게시물 </a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item"
							onclick="location.href='Board?command=Board_list_admin&date=day'">일별
								인기게시물</a></li>
						<li><a class="dropdown-item"
							onclick="location.href='Board?command=Board_list_admin&date=month'">월별
								인기게시물</a></li>
						<li><a class="dropdown-item" href="#">신고게시물</a></li>
					</ul></li>
			</c:otherwise>
		</c:choose>

	</ul>
	<div id="myTabContent" class="tab-content">
		<c:choose>
			<c:when test="${Tabs == 'Book_list'}">
				<div class="tab-pane fade show active" role="tabpanel">
					<jsp:include page="../Book/BookList.jsp" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="tab-pane fade" role="tabpanel">
					<jsp:include page="../Book/BookList.jsp" />
				</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${Tabs == 'Menu_list_admin' }">
				<div class="tab-pane fade show active" role="tabpanel">
					<jsp:include page="../Menu/MenuListAdmin.jsp" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="tab-pane fade" role="tabpanel">
					<jsp:include page="../Menu/MenuListAdmin.jsp" />
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${Tabs == 'Board_list_admin'}">
				<div class="tab-pane fade show active" role="tabpanel">
					<jsp:include page="../Board/BoardListAdmin.jsp" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="tab-pane fade" role="tabpanel">
					<jsp:include page="../Board/BoardListAdmin.jsp" />
				</div>
			</c:otherwise>
		</c:choose>


		<div class="tab-pane fade" id="dropdown2">
			<p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy
				art party before they sold out master cleanse gluten-free squid
				scenester freegan cosby sweater. Fanny pack portland seitan DIY, art
				party locavore wolf cliche high life echo park Austin. Cred vinyl
				keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table
				VHS viral locavore cosby sweater.</p>
		</div>
	</div>
</div>
<jsp:include page="../Footer.jsp" />