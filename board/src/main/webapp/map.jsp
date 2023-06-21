<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            min-width: 1540px;
        }
        h1 {
            text-align: center;

        }

        div {
            display: inline-block;
        }
    </style>
</head>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=4abbpdcb7q&callback=initNaverMap"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8b9fff63b03fbd71b7d14a02a31a44a0"></script>
<body>
    <div id="maps">
        <div>
            <h1 style="background-color: rgb(0, 182, 0);">네이버</h1>
            <div id="navermap" style="width:500px;height:700px;"></div>
        </div>
        <div>
            <h1 style="background-color: rgb(81, 81, 255);">구글</h1>
            <div id="googlemap" style="width:500px;height:700px;"></div>
        </div>
        <div>
            <h1 style="background-color: gold;">카카오</h1>
            <div id="kakaomap" style="width:500px;height:700px;"></div>
        </div>
    </div>
</body>
<script type="text/javascript">
    var map = null;

    window.initNaverMap = function () {
        map = new naver.maps.Map('navermap', {
            center: new naver.maps.LatLng(37.56685, 126.97864),
            zoom: 17
        });
    }

    window.initGoogleMap =  function () {
        map = new google.maps.Map(document.getElementById("googlemap"), {
            center: { lat: 37.56685, lng: 126.97864 },
            zoom: 17,
        });
    }

    function initKakaoMap () {
        map = new kakao.maps.Map(document.getElementById('kakaomap'), {
            center: new kakao.maps.LatLng(37.56685, 126.97864),
            level: 3
        });
    }
	initKakaoMap();
</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBicq2L-tbKrWepZ7ltFJrXrxxV3OtM9BA&callback=initGoogleMap"></script>
</body>

</html>