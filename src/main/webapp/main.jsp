<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			메뉴소개 <a class="plus" href="/Project/View/Menu.jsp">+ 더보기</a>
		</h2>
		<div class="content1">
			<div class="slider2">
				<div class="content1_item">
					<div class="img">
						<img class="img" src="images/간장숯불닭갈비.jpeg">
					</div>
					<p class="title2">간장 숯불 닭갈비</p>
				</div>
				<div class="content1_item">
					<div class="img">
						<img class="img" src="images/매운숯불닭갈비.jpg">
					</div>
					<p class="title2">매운 숯불 닭갈비</p>
				</div>
				<div class="content1_item">
					<div class="img">
						<img class="img" src="images/수제양념돼지갈비.png">
					</div>
					<p class="title2">수제 양념돼지갈비</p>
				</div>
				<div class="content1_item">
					<div class="img">
						<img class="img" src="images/생삼겹살.jpg">
					</div>
					<p class="title2">생 삼겹살</p>
				</div>
				<div class="content1_item">
					<div class="img">
						<img class="img" src="images/할매비빔국수.jpg">
					</div>
					<p class="title2">할매 비빔국수</p>
				</div>
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