<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="/css/weather_history/historyView.css">

</head>
<body>
	<div class="container" id="wrap">
		<div class="d-flex main">
			<div class="col-2 menu">
				<img src="/img/foot_logo.png" alt="기상청 로고" class="" width=80px>
				<nav class="mt-3">
					<ul class="nav">
						<li class="nav-item"><a href="#" class="nav-link text-white">날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white">날씨입력</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white">테마날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white">관측
								기후</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-10">
				<div class="display-4">과거 날씨</div>
				<table class="text-center w-100 table">
					<thead>
						<th>날짜</th>
						<th>날씨</th>
						<th>기온</th>
						<th>강수량</th>
						<th>미세먼지</th>
						<th>풍속</th>
					</thead>
					<tbody>
						<c:forEach items="${weathers}" var="weather">
							<tr>
								<fmt:parseDate value="${weather.date}" pattern="yyyy-MM-dd" var="date"/>
								<td><fmt:formatDate value="${date}" pattern="yyyy년 M월 dd일"  /></td>
								<td>
									<c:choose>
										<c:when test="${weather.weather eq '맑음'}">
											<img src="/img/sunny.jpg" alt="맑음">
										</c:when>
										<c:when test="${weather.weather eq '구름조금'}">
											<img src="/img/partlyCloudy.jpg" alt="구름조금">
										</c:when>
										<c:when test="${weather.weather eq '흐림'}">
											<img src="/img/cloudy.jpg" alt="흐림">
										</c:when>
										<c:when test="${weather.weather eq '비'}">
											<img src="/img/rainy.jpg" alt="비">
										</c:when>
									</c:choose>
								</td>
								<td>${weather.temperatures}℃</td>
								<td>${weather.precipitation}mm</td>
								<td>${weather.microDust}</td>
								<td>${weather.windSpeed}km/h</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		<footer class="d-flex align-items-center" id="footer">
			<img src="/img/foot_logo.png" alt="기상청 로고" class="m-3 col-2">
			<div class="text-secondary">
				<small>서울 (07062) 서울특별시 동작구 여의대방로16길 61</small>
				<p>Copyright@2022 KMA. All Rights RESERVED.
				<p>
			</div>
		</footer>
	</div>
</body>
</html>