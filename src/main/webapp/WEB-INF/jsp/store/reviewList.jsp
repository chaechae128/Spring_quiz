<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족 리뷰 목록</title>
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

<link rel="stylesheet" type="text/css" href="/css/store/store.css">

</head>
<body>
	<div class="container" id="wrap">
		<%--로고--%>
		<header class="bg-info d-flex align-items-center">
			<h1 class="text-white ml-3">배탈의 민족</h1>
		</header>
		<%--컨텐츠 제목 --%>
		<div class="contentName d-flex align-items-center">
			<div class="display-4">${storeName}- 리뷰</div>
		</div>
		<%--컨텐츠 --%>
		<div class="contents  p-2">
			<%--컨텐츠  - 리뷰 있을 때 --%>
			<c:forEach items="${newReviewList}" var="review">
			<c:choose>
				<c:when test="${!empty review}">
				<div class="border border-info rounded border-3 p-3 mb-3">
					<div class="d-flex align-items-top">	
						<%--userName, point --%>
						<h4 class="font-weight-bold">${review.userName}</h4>
						<%--fullStar --%>
						<c:forEach begin="1" end="${review.point}" step="1" varStatus="status">
							<img src="/img/star_fill.png" width="20px" height="20px"class="mr-1 mt-1">
							<c:set var="fullStarCount" value="${status.index}"/>
						</c:forEach>
						<%--halfStar --%>
						<c:set var="emptyStar" value="${5-review.point}" />
						<c:if test="${(review.point - fullStarCount)!= 0}">
							<img src="/img/star_half.png" width="20px" height="20px"class="mr-1 mt-1">
						</c:if>
						<%--emptyStar --%>
						<c:forEach begin="1" end="${emptyStar}" step="1">
							<img src="/img/star_empty.png" width="20px" height="20px"class="mr-1 mt-1">
						</c:forEach>
					</div>
					<%--createdAt --%>
					<h6 class="text-secondary pb-1">
						<fmt:formatDate value="${review.createdAt}" pattern="yyyy년 M월 dd일" />
					</h6>
					<%--review --%>
					<c:if test="${not empty review.review}">
						<h6 class="font-weight-bold pt-1 pb-2">${review.review}</h6>
					</c:if>
					<%--menu --%>
					<span class="menu p-1 rounded ">${review.menu}</span>
				</div>
				
				
				</c:when>
			<%--컨텐츠  - 리뷰 없을 때 --%>
			<c:otherwise>
				<h1>없어</h1>
			</c:otherwise>
			</c:forEach>
			</c:choose>

		</div>
		<%--footer --%>
		<hr>
		<footer class=" pt-3">
			<div class="d-flex align-items-center">
				<h5 class="font-weight-bold">(주)우와한형제</h5>
			</div>
			<div class="d-flex align-items-center">
				<div>고객센터:1500-1500</div>
			</div>
		</footer>
	</div>
</body>
</html>