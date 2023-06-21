<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
<div>
</div>
<script>
	
	window.onload = function () {
		var xhr = new XMLHttpRequest();
	
		xhr.open("GET", "http://apis.data.go.kr/6410000/busstationservice/getBusStationList?serviceKey=WpPySHqOm1qIYdMjmC1LhgGOd6mF9ZjOS6FQwLkv7%2BBRFwSn3wiq2%2F5FWQ1gdGJjOKI%2Bn98PrKsdk42w7uxaQQ%3D%3D&keyword=23");
		xhr.send();
		xhr.onreadystatechange = function () {
			if(xhr.status == 200) {
				var xml = this.responseXML;
				var stationName = xml.getElementsByTagName('stationName');
				for (i=0;i<stationName.length;i++) {
				console.log(stationName[i].childNodes[0].nodeValue);
				}
			}
		}
	}
</script>