<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Header.jsp"/>
    <div class="container">
        <h2 style="margin-top: 100px;" class="title">고기메뉴</h2>
        <ul class="menu_list">
        	<c:forEach var="meet" items="${Meet}">
        		<li class="menu_box">
	                <div class="img">
	                	<img class="menu_list_img" src="images/${meet.pictureurl}">
	                	<div class="hover_text">
		                	<div>
			                	<p>가격 : (1인분) ${meet.price} 원</p><br/>
		                		<p>100g당 가격 : ${meet.price_100g} 원</p><br/>
		                		<p>원산지 : ${meet.addr}</p>
		                	</div>
	                	</div>
	                </div>
	                <p class="title2">${meet.name}</p>
            	</li>
        	</c:forEach>
        </ul>
        <h2 class="title">식사메뉴</h2>
        <ul class="menu_list">
            <c:forEach var="meal" items="${Meal}">
        		<li class="menu_box">
	                <div class="img">
	                	<img class="menu_list_img" src="images/${meal.pictureurl}">
	                	<div class="hover_text">
		                	<div>
			                	<p>가격 : ${meal.price} 원</p>
		                	</div>
	                	</div>
	                </div>
	                <p class="title2">${meal.name}</p>
            	</li>
        	</c:forEach>  
        </ul>
    </div>
<jsp:include page="../Footer.jsp"/>