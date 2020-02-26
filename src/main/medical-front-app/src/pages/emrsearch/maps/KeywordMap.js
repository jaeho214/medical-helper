/* global kakao */

import React, { useEffect, useState } from "react";

const KeywordMap = ({hx,hy}) => {
  const [xPos,setXpos] = useState(0);
  const [yPos,setYpos] = useState(0);
  
  useEffect(() => {
    // 마커를 담을 배열입니다
    setXpos(hx);
    setYpos(hy);
    
    let mapContainer = document.getElementById("keymap"),
      mapOption = {
        center: new kakao.maps.LatLng(37.56682,126.97865), 
        level: 3
      };

    let map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다.


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

    
    if(hx !== null){
      setXpos(hx);
      setYpos(hy);
    }

    // 좌표에 따른 위치 지도에 표시하기
    var locPostion = new kakao.maps.LatLng(yPos,xPos), //마커가 표시될 위치를 geolocation 좌표로 생성합니다.
          message = '<div style="padding:5px;">찾고계신 병원입니다.</div>'; // 인포윈도우에 표시될 내용입니다.
    // 마커와 인포윈도우를 표시합니다.
    displayMarker(locPostion, message);
    
    

  });

  return (
    <>
      <div
        id="keymap"
        className="keymap"
        style={{ width: "100%", height: "550px" }}
      ></div>
    </>
  );
};

export default KeywordMap;