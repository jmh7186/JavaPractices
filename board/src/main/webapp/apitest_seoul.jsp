<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
<div>
</div>
<script>
	var xhr = new XMLHttpRequest();
	var url = 'https://cors-anywhere.herokuapp.com/http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll'; /*URL*/
	var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'WpPySHqOm1qIYdMjmC1LhgGOd6mF9ZjOS6FQwLkv7%2BBRFwSn3wiq2%2F5FWQ1gdGJjOKI%2Bn98PrKsdk42w7uxaQQ%3D%3D'; /*Service Key*/
	queryParams += '&' + encodeURIComponent('busRouteId') + '=' + encodeURIComponent('100100118'); /**/
	xhr.open('GET', url + queryParams);
	xhr.onreadystatechange = function () {
    	if (this.readyState == 4) {
        	console.log(this.responseXML);
    	}
	};

	xhr.send('');
</script>