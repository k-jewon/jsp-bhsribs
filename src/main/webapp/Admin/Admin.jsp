<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../Header.jsp" />
<div class="adminPage">
	<h2 style="margin-top: 100px;" class="title">관리자 페이지</h2>
	<ul class="nav nav-tabs" role="tablist">
	  <li class="nav-item" role="presentation">
	    <a class="nav-link active" data-bs-toggle="tab" href="#home" aria-selected="true" role="tab">예약 현황</a>
	  </li>
	  <li class="nav-item" role="presentation">
	    <a class="nav-link" data-bs-toggle="tab" href="#profile" aria-selected="false" tabindex="-1" role="tab">메뉴 관리</a>
	  </li>
	  <li class="nav-item" role="presentation">
	    <a class="nav-link" href="#" aria-selected="false" tabindex="-1" role="tab">Disabled</a>
	  </li>
	  <li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
	    <div class="dropdown-menu" style="">
	      <a class="dropdown-item" href="#">Action</a>
	      <a class="dropdown-item" href="#">Another action</a>
	      <a class="dropdown-item" href="#">Something else here</a>
	      <div class="dropdown-divider"></div>
	      <a class="dropdown-item" href="#">Separated link</a>
	    </div>
	  </li>
	</ul>
	<div id="myTabContent" class="tab-content">
	  <div class="tab-pane fade show active" id="home" role="tabpanel">
	    <table  class="table table-responsive">
		  <thead class="table-dark">
		    <tr>
		      <th scope="col">예약자 이름</th>
		      <th scope="col">전화번호</th>
		      <th scope="col">인원수</th>
		      <th scope="col">예약시간</th>
		      <th scope="col">문의사항</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">2</th>
		      <td>Jacob</td>
		      <td>Thornton</td>
		      <td>@fat</td>
		    </tr>
		    <tr>
		      <th scope="row">3</th>
		      <td colspan="2">Larry the Bird</td>
		      <td>@twitter</td>
		    </tr>
		  </tbody>
		</table>
	  </div>
	  <div class="tab-pane fade" id="profile" role="tabpanel">
	    <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit.</p>
	  </div>
	  <div class="tab-pane fade" id="dropdown1">
	    <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork.</p>
	  </div>
	  <div class="tab-pane fade" id="dropdown2">
	    <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater.</p>
	  </div>
	</div>
</div>
<jsp:include page="../Footer.jsp" />