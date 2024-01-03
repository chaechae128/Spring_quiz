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
					<!-- <td><button type="button" class="delete-btn btn btn-danger">삭제</button></td> -->
					<%--1) value로 값 넣기 단점: value가 하나의 값만 세탕 가능해서 여러개 값 세팅 불가 --%>
					<%-- <td><button type="button" class="delete-btn btn btn-danger" value="${bookmark.name}">삭제</button></td> --%>
					<%--2 data로 값 넣기 카멜방식X 무조건 하이픈(-) 으로--%>
					<td><button type="button" class="delete-btn btn btn-danger" data-bookmark-name="${bookmark.name}">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script>
	$(document).ready(function(){
		//삭제 버튼 클릭 
		$(".delete-btn").click(function(e){
			//내가 한 방식
			/* var deleteBtn = $(this);
			var tr = deleteBtn.parent().parent();
			var td = tr.children();
			var name = td.eq(1).text();  */
			//1. button value에 담은 값 가져오기
			//let name = $(this).val();
			//let name = $(this).attr("value");
			//let name = e.target.value //지금 클릭된 그것의 value를 가져온다
			
			//2. data를 이용해서 값 가져오기
			//태그 영역: data-bookmark-name 
			//스크림트 영역: .data('bookmark-name')
			let name = $(this).data('bookmark-name');
			
			$.ajax({
				//request
				type:"delete"
				,url:"/lesson06/quiz01/delete-bookmark"
				,data:{"name":name}
				//response
				,success:function(data){
					if(data.code == 200){
						//성공
						//location.href = "/lesson06/quiz01/after-add-bookMark-view" <- 아예 새로고침 되어서 맨 위로 스크롤 올라감
						location.reload(true); //새로고침 그 자리레 있음
					} else if(data.code == 500) {
						//실패
						alert(data.error_message)
					}
				}
				, error:function(request, status, error){
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
		
	});
</script>
</html>