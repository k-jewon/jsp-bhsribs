<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Header.jsp"/>
    <div class="container">
        <h2 style="margin-top: 100px;" class="title">고기메뉴</h2>
        <ul class="menu_list">
        	<c:forEach var="meet" items="${Meet}">
        		<li class="menu_box">
	                <div class="img"><img class="img" src="images/${meet.pictureurl}"></div>
	                <p class="title2">${meet.name}</p>
            	</li>
        	</c:forEach>
        </ul>
        <h2 class="title">식사메뉴</h2>
        <ul class="menu_list">
            <c:forEach var="meal" items="${Meal}">
        		<li class="menu_box">
	                <div class="img"><img class="img" src="images/${meal.pictureurl}"></div>
	                <p class="title2">${meal.name}</p>
            	</li>
        	</c:forEach>  
        </ul>
    </div>
<jsp:include page="../Footer.jsp"/>