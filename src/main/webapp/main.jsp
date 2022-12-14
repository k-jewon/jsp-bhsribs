<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Header.jsp" />
	<header class="main_header">
		<div class="slider">
			<div class="slide1">
				<div class="slide_bg"></div>
			</div>
			<div class="slide2">
				<div class="slide_bg"></div>
			</div>
			<div class="slide3">
				<div class="slide_bg"></div>
			</div>
		</div>
	</header>
	<div class="container">
		<h2 style="position: relative;" class="title">
			메뉴소개 <a class="plus" href="Menu?command=Menu_list">+ 전체보기</a>
		</h2>
		<div class="content1">
			<div class="slider2">
			<c:forEach var="menu" items="${Menu}">
				<div class="content1_item">
					<div class="main_img">
	                	<img class="menu_list_img" src="images/${menu.pictureurl}">
	                	<div class="hover_text">
		                	<div>
			                	<p>가격 : ${menu.price} 원</p>
		                	</div>
	                	</div>
	                </div>
	                <p class="title2">${menu.name}</p>
				</div>
			</c:forEach>	
			</div>

			<button class="prev_btn">
				<i class="fa fa-chevron-left"></i>
			</button>
			<button class="next_btn">
				<i class="fa fa-chevron-right"></i>
			</button>
		</div>
		<h2 class="title">오시는길</h2>
		<div class="content2">
			<div class="map"></div>
			<div class="map_text">
				<div>
					<p class="title2" style="margin-top: 0px">주소</p>
					<p>서울 은평구 북한산로 281-3입니다</p>

					<p class="title2">버스</p>
					<p>
						704 , 34 번 버스에서 (백화사) 역에 하차<br> 송추가마골 반대편 쪽으로 들어오시면 보입니다.
					</p>

					<p class="title2">문의사항</p>
					<p>02-381-0399로 연락 주시면 감사드리겠습니다.</p>
				</div>

			</div>

		</div>
	</div>
	<jsp:include page="Footer.jsp"/>