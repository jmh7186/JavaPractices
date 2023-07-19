<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBicq2L-tbKrWepZ7ltFJrXrxxV3OtM9BA&callback=initMap"></script>
<div id="maps" style="text-align: center;">
	<h1>오시는 길</h1>
	<div id="googlemap" style="width: 70%; height: 500px; margin: 0 auto;"></div>
	<h3>서울특별시 중랑구 봉화산로 56<br>중랑역 2번출구에서 도보 3분</h3>
</div>
<script>
	function initMap() {
		const myLatlng = { lat: 37.60144628299837, lng: 127.08063467292041 };
		const map = new google.maps.Map(document.getElementById("googlemap"), {
			center : myLatlng,
			zoom : 18
		});
		new google.maps.Marker({
		    position: myLatlng,
		    map,
		    title:"대우직업능력개발원"
		});
	}
	
	window.initMap = initMap;
</script>