<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
<div>
</div>
<script>
	var xhr = new XMLHttpRequest();
	var url = 'http://apis.data.go.kr/6410000/busstationservice/getBusStationList'; /*URL*/
	var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'WpPySHqOm1qIYdMjmC1LhgGOd6mF9ZjOS6FQwLkv7%2BBRFwSn3wiq2%2F5FWQ1gdGJjOKI%2Bn98PrKsdk42w7uxaQQ%3D%3D'; /*Service Key*/
	queryParams += '&' + encodeURIComponent('keyword') + '=' + encodeURIComponent('진접'); /**/
	xhr.open('GET', url + queryParams);
	xhr.onreadystatechange = function () {
    	if (this.readyState == 4) {
        	xml = this.responseXML;
        	stationNames = xml.getElementsByTagName("stationName");
        	for(i=0;i<stationNames.length;i++) {
        		document.querySelector("div").innerHTML+=stationNames[i].childNodes[0].nodeValue+"<br>";
        	}
    	}
	};

	xhr.send('');
</script>