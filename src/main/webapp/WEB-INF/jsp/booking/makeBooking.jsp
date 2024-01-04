<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션 예약하기</title>
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
				<li class="nav-item"><a href="/booking/check-booking-view"
					class="nav-link text-white font-weight-bold">펜션소개</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="/booking/make-booking-view"
					class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/booking/booking-list-view"
					class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<div class="d-flex justify-content-center">
			<div class="content">
				<div class="d-flex justify-content-around">
					<h2 class="font-weight-bold mt-3 mb-3">예약 하기</h2>
				</div>
				<%--예약 form 작성 --%>
				<div class="mt-3">
					<div class="font-weight-bold">이름</div>
					<input type="text" id="name" name="name" class="col-12 form-control">
				</div>
				<div class="mt-3">
					<div class="font-weight-bold">예약날짜</div>
					<input type="text" id="date" name="date" class="col-12 form-control">
				</div>
				<div class="mt-3">
					<div class="font-weight-bold">숙박일수</div>
					<input type="text" id="day" name="day" class="col-12 form-control">
				</div>
				<div class="mt-3">
					<div class="font-weight-bold">숙박인원</div>
					<input type="text" id="headcount" name="headcount" class="col-12 form-control">
				</div>
				<div class="mt-3">
					<div class="font-weight-bold">전화번호</div>
					<input type="text" id="phoneNumber" name="phoneNumber" class="col-12 form-control">
				</div>
				<button type="button" id="reserve-btn" class="btn btn-warning col-12 mt-3">예약하기</button>
			</div>
		</div>
		
		<%--footer --%>
		<footer class="d-flex align-items-center pl-3">
			<div class="address">
				제주특별자치도 제주시 애월읍<br> 사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 /
				대표:김통목<br> Copyright 2025 tongnamu. All right reserved.
			</div>
		</footer>
	</div>
	
	<script>
		$(document).ready(function(){
			/*datepicker*/
			$.datepicker.setDefaults({
				dateFormat:"yy-mm-dd"
               ,dayNamesMin:["일", "월", "화", "수", "목", "금", "토"]
				,minDate : 0
			})
			$("#date").datepicker({    
                showButtonPanel:true //오늘 버튼 노출   
                ,dateFormat:"yy-mm-dd"
                , onSelect:function(dateText) { //dateText로 이름을 안 지어도 됨
                }
            });
			
			
			//validation
			$('#reserve-btn').on('click', function(){
				//alert("클릭");
				let name = $("#name").val().trim();
				let date = $("#date").val().trim();
				let day = $("#day").val().trim();
				let headcount = $("#headcount").val().trim();
				let phoneNumber = $("#phoneNumber").val().trim();
				
				if(!name){
					alert("이름을 입력하세요");
					return false;
				}
				if(!date){
					alert("예약날짜를 입력하세요");
					return false;
				}
				if(!day){
					alert("숙박일수를 입력하세요");
					return false;
				}
				if(isNaN(day)){ //숫자가 아닐 때 참
					alert("숙박일은 숫자만 가능합니다.");
					return false;
				}
				if(isNaN(headcount)){ //숫자가 아닐 때 참
					alert("숙박인원은 숫자만 가능합니다.");
					return false;
				}
				if(!headcount){
					alert("숙박인원을 입력하세요");
					return false;
				}
				if(!phoneNumber){
					alert("전화번호를 입력하세요");
					return false;
				}
				
				$.ajax({
					//request
					type:"POST"
					,url:"/booking/make-booking"
					,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				
					//response
					, success:function(data) { //data: JSON String => jquery ajax함수가 parsing 과정 거친 후 => dictionary가 됨
						//alert(data.code);
						if(data.code == 200) {  //혹은 data.result == "성공"
							alert("예약되었습니다.");
							location.href = "/booking/booking-list-view"
						}
					}
					,error:function(request, status, error){
						alert(status);
						alert(request);
						alert(error);
					}
				});
			});
		});
	</script>
</body>
</html>