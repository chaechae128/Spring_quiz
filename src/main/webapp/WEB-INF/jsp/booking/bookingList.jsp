<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무펜션 예약 목록 보기</title>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
   integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
   crossorigin="anonymous"></script>

<!-- bootstrap -->
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
   integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
   crossorigin="anonymous">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
   crossorigin="anonymous"></script>

<!-- datepicker -->
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 외부 스타일 시트 -->
<link rel="stylesheet" type="text/css" href="/css/booking/booking.css">
</head>
<body>
	<div id="wrap" class="container">
      <header
         class="bg-light d-flex justify-content-center align-items-center">
         <div class="display-4">통나무 펜션</div>
      </header>
      <nav>
         <ul class="nav nav-fill">
            <li class="nav-item"><a href="/booking/check-booking-view" class="nav-link text-white font-weight-bold">펜션소개</a></li>
            <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
     		<li class="nav-item"><a href="/booking/make-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
            <li class="nav-item"><a href="/booking/booking-list-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
         </ul>
      </nav>
      <div class="d-flex justify-content-center">
      	<h2 class="font-weight-bold"">예약 목록 보기</h2>
      </div>
      
      <%--예약 목록 테이블 --%>
      <table class="table text-center">
      	<thead>
      		<th>이름</th>
      		<th>예약날짜</th>
      		<th>숙박일수</th>
      		<th>숙박인원</th>
      		<th>전화번호</th>
      		<th>예약상태</th>
      	</thead>
      	<tbody>
      		<c:forEach items="${bookingList}" var="booking">
      			<tr>
      				<td>${booking.name}</td>
      				<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 dd일" /></td>
      				<td>${booking.day}</td>
      				<td>${booking.headcount}</td>
      				<td>${booking.phoneNumber}</td>
      				<td>
      					<c:choose>
      						<c:when test="${booking.state eq '대기중'}">
      							<span class="text-info">${booking.state}</span>
      						</c:when>
      						<c:when test="${booking.state eq '확정'}">
      							<span class="text-info">${booking.state}</span>
      						</c:when>
      					</c:choose>
      				</td>
      			</tr>
      		
      		</c:forEach>
      	</tbody>
      </table>
      
     </div>
</body>
</html>