<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../Header.jsp" />
<div class="adminPage">
	<h2 style="margin-top: 100px;" class="title">관리자 페이지</h2>
	<ul class="nav nav-tabs" role="tablist">
	<c:choose>
		<c:when test="${Tabs == 'Book_list'}">
			<li class="nav-item" role="presentation">
			    <a class="nav-link active" data-bs-toggle="tab" onclick="location.href='/Project/Book?command=Book_list&#book'" aria-selected="true" role="tab">예약 현황</a>
			</li>
		</c:when>
		<c:otherwise>
			<li class="nav-item" role="presentation">
			    <a class="nav-link" data-bs-toggle="tab" onclick="location.href='/Project/Book?command=Book_list&#book'" aria-selected="true" role="tab">예약 현황</a>
			</li>
		</c:otherwise>
	</c:choose>
	
	  
	  <li class="nav-item" role="presentation">
	    <a class="nav-link" data-bs-toggle="tab" href="#profile" aria-selected="false" tabindex="-1" role="tab">메뉴관리</a>
	  </li>
	  <li class="nav-item" role="presentation">
	    <a class="nav-link" href="#" aria-selected="false" tabindex="-1" role="tab">Disabled</a>
	  </li>
	  <c:choose>
		<c:when test="${Tabs == 'Board_list_admin'}">
		  <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle active" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
			  인기 게시물
			</a>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
			  <li><a class="dropdown-item" onclick="location.href='/Project/Board?command=Board_list_admin&#Board1'">일별 인기게시물</a></li>
			  <li><a class="dropdown-item" href="#dropdown2">월별 인기게시물</a></li>
			  <li><a class="dropdown-item" href="#">신고게시물</a></li>
			</ul>
		  </li>
		</c:when>
		<c:otherwise>
		  <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
			  인기 게시물
			</a>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
			  <li><a class="dropdown-item" onclick="location.href='/Project/Board?command=Board_list_admin&#Board1'">일별 인기게시물</a></li>
			  <li><a class="dropdown-item" href="#dropdown2">월별 인기게시물</a></li>
			  <li><a class="dropdown-item" href="#">신고게시물</a></li>
			</ul>
		  </li>
		</c:otherwise>
	</c:choose>

	</ul>
	<div id="myTabContent" class="tab-content">
		<c:choose>
			<c:when test="${Tabs == 'Book_list'}">
				<div class="tab-pane fade show active" id="book" role="tabpanel">
			    	<jsp:include page="../Book/BookList.jsp"/>
			  	</div>
			</c:when>
			<c:otherwise>
				<div class="tab-pane fade" id="book" role="tabpanel">
			    	<jsp:include page="../Book/BookList.jsp"/>
			  	</div>
			</c:otherwise>
		</c:choose>
		
		<div class="tab-pane fade" id="profile" role="tabpanel">
	    	<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit.</p>
	  	</div>
	  	<c:choose>
	  		<c:when test="${Tabs == 'Board_list_admin'}">
				<div class="tab-pane fade show active" id="Board1">
				  	<jsp:include page="../Board/BoardListAdmin.jsp"/>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tab-pane fade" id="Board1">
				  	<jsp:include page="../Board/BoardListAdmin.jsp"/>
				</div>
			</c:otherwise>
	  	</c:choose>
		
	  
	  <div class="tab-pane fade" id="dropdown2">
	    <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater.</p>
	  </div>
	</div>
</div>
<jsp:include page="../Footer.jsp" />