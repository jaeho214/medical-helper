/* global kakao */
import React, { useEffect, useState } from "react";
import Search from "./Search";

const Map = () => {
  const [xPos, setXpos] = useState(0);
  const [yPos, setYpos] = useState(0);

  useEffect(() => {
    // 마커를 담을 배열입니다
    let mapContainer = document.getElementById("map"),
      mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
      };

    let map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다.

    // HTML5의 geolocaiton으로 사용할 수 있는지 확인합니다.
    if (navigator.geolocation) {
      // GeoLocation을 이용해서 접속 위치를 얻어옵니다.
      navigator.geolocation.getCurrentPosition(function(position) {
        setXpos(position.coords.latitude); // 위도
        setYpos(position.coords.longitude); // 경도

        var locPostion = new kakao.maps.LatLng(xPos, yPos), //마커가 표시될 위치를 geolocation 좌표로 생성합니다.
          message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다.

        // 마커와 인포윈도우를 표시합니다.
        displayMarker(locPostion, message);
      });
    } else {
    }

    // 지도에 마커와 인포윈도우를 표시하는 함수입니다.
    function displayMarker(locPostion, message) {
      // 마커를 생성합니다.
      var marker = new kakao.maps.Marker({
        map: map,
        position: locPostion
      });

      var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

      // 인포윈도우를 생성합니다.
      var infowindow = new kakao.maps.InfoWindow({
        content: iwContent,
        removable: iwRemoveable
      });

      // 인포윈도우를 마커위에 표시합니다.
      infowindow.open(map, marker);

      // 지도 중심좌표를 접속위치로 변경합니다.
      map.setCenter(locPostion);
    }

  });
  return (
    <>
      <div
        id="map"
        className="Map"
        style={{ width: "100%", height: "550px" }}
      ></div>

      <Search xPos={xPos} yPos={yPos} />
    </>
  );
};

export default Map;
