<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%--AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<h1>즐겨찾기 목록</h1>
	<table class="table text-center">
		<thead>
			<th>No.</th>
			<th>이름</th>
			<th>주소</th>
		</thead>
		<tbody>
			<c:forEach items="${bookmarkList}" var="bookmark" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td id="name">${bookmark.name}</td>
					<td><a href="${bookmark.url}">${bookmark.url}</a></td>
					<td><button type="button" class="btn btn-danger deleteBtn">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script>
	$(document).ready(function(){
		$(".deleteBtn").click(function(){
			var deleteBtn = $(this);
			var tr = deleteBtn.parent().parent();
			var td = tr.children();
			var name = td.eq(1).text();
			$.ajax({
				//request
				type:"POST"
				,url:"/lesson06/quiz01/delete-bookmark"
				,data:{"name":name}
				//response
				,success:function(data){
					if(data.code == 200){
						location.href = "/lesson06/quiz01/after-add-bookMark-view"
					}
				}
				, error:function(request, status, error){
					alert(request);
					alert(status);
					alert(error);
				}
			});
		});
		
	});
</script>
</html>