import React, { useState, useEffect } from "react";
import Axios from "axios";
import HospitalList from "./HospitalList";
import {
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  ListSubheader
} from "@material-ui/core";

const Search = ({ xPos, yPos }) => {
  const [text, setText] = useState("");
  const [data, setData] = useState([]);
  const [q1, setQ1] = useState("");
  const [q2, setQ2] = useState("");

  const onChange = e => {
    setText(e.target.value);
  };

  // 기관명으로 검색하는 버튼 클릭시 동작하는 부분
  const onClick = async e => {
    // 새로고침 방지
    e.preventDefault();

    // 데이터 가져오는 부분
    try {
      const response = await Axios.get(
        `/medicalHelper/emergency/emergentList/${text}/${1}`
      );
      setData(response.data.body.items);
      setText("");
    } catch (e) {
      console.log(e);
    }
  };

  // 지역으로 검색하는 부분

  const handleChangeQ1 = e => {
    setQ1(e.target.value);
    console.log("setQ1"+q1)

  };
  const handleChangeQ2 = e => {
    setQ2(e.target.value);
    console.log("setQ2"+q2)
  };

  const handleOnClick = async e => {
    // 새로고침 방지
    e.preventDefault();

    // 데이터 가져오는 부분
    try {
      const response = await Axios.get(
        `/medicalHelper/emergency/emergentList/${q1}/${q2}/${1}`
      );
      setData(response.data.body.items);
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <div>
      <form>
        이름으로 검색: &nbsp;
        <input
          type="text"
          placeholder="검색할 병원을 입력하세요."
          value={text}
          onChange={onChange}
          name="text"
        />
        <button variant="outlined" color="secondary" onClick={onClick}>
          검색
        </button>
      </form>
      <br />
      지역으로 검색{" "}
      <form>
        시/도{" "}
        <Select value={q1} onChange={handleChangeQ1} autoWidth="true">
          <MenuItem value="강원도">강원도</MenuItem>
          <MenuItem value="경기도">경기도</MenuItem>
          <MenuItem value="경상남도">경상남도</MenuItem>
          <MenuItem value="경상북도">경상북도</MenuItem>
          <MenuItem value="광주광역시">광주광역시</MenuItem>
          <MenuItem value="대구광역시">대구광역시</MenuItem>
          <MenuItem value="대전광역시">대전광역시</MenuItem>
          <MenuItem value="부산광역시">부산광역시</MenuItem>
          <MenuItem value="서울특별시">서울특별시</MenuItem>
          <MenuItem value="세종특별자치시">세종특별자치시</MenuItem>
          <MenuItem value="울산광역시">울산광역시</MenuItem>
          <MenuItem value="인천광역시">인천광역시</MenuItem>
          <MenuItem value="전라남도">전라남도</MenuItem>
          <MenuItem value="전라북도">전라북도</MenuItem>
          <MenuItem value="제주특별자치도">제주특별자치도</MenuItem>>
          <MenuItem value="충청남도">충청남도</MenuItem>
          <MenuItem value="충청북도">충청북도</MenuItem>>
        </Select>{" "}
        &nbsp; 구/군/읍/면{" "}
   
          {q1 === '강원도' &&
          <>
          <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>강원도</ListSubheader>
          <MenuItem value="홍천군">홍천군</MenuItem>
          <MenuItem value="횡성군">횡성군</MenuItem>
          <MenuItem value="영월군">영월군</MenuItem>
          <MenuItem value="평창군">평창군</MenuItem>
          <MenuItem value="정선군">정선군</MenuItem>
          <MenuItem value="철원군">철원군</MenuItem>
          <MenuItem value="화천군">화천군</MenuItem>
          <MenuItem value="양구군">양구군</MenuItem>
          <MenuItem value="인제군">인제군</MenuItem>
          <MenuItem value="고성군">고성군</MenuItem>
          
          </Select>
          </>}

          {q1 === '경기도' &&
          <>
          <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>경기도</ListSubheader>
          <MenuItem value="가평군">가평군</MenuItem>
          <MenuItem value="고양시">고양시</MenuItem>
          <MenuItem value="과천시">과천시</MenuItem>
          <MenuItem value="광명시">광명시</MenuItem>
          <MenuItem value="광주시">광주시</MenuItem>
          <MenuItem value="구리시">구리시</MenuItem>
          <MenuItem value="군포시">군포시</MenuItem>
          <MenuItem value="김포시">김포시</MenuItem>
          <MenuItem value="남양주시">남양주시</MenuItem>
          <MenuItem value="동두천시">동두천시</MenuItem>
          <MenuItem value="부천시">부천시</MenuItem>
          <MenuItem value="성남시">성남시</MenuItem>
          <MenuItem value="수원시">수원시</MenuItem>
          <MenuItem value="시흥시">시흥시</MenuItem>
          <MenuItem value="안산시">안산시</MenuItem>
          <MenuItem value="안성시">안성시</MenuItem>
          <MenuItem value="안양시">안양시</MenuItem>
          <MenuItem value="양주시">양주시</MenuItem>
          <MenuItem value="양평군">양평군</MenuItem>
          <MenuItem value="여주시">여주시</MenuItem>
          <MenuItem value="연천군">연천군</MenuItem>
          <MenuItem value="오산시">오산시</MenuItem>
          <MenuItem value="용인시">용인시</MenuItem>
          <MenuItem value="의왕시">의왕시</MenuItem>
          <MenuItem value="이천시">이천시</MenuItem>
          <MenuItem value="파주시">파주시</MenuItem>
          <MenuItem value="평택시">평택시</MenuItem>
          <MenuItem value="포천시">포천시</MenuItem>
          <MenuItem value="하남시">하남시</MenuItem>
          <MenuItem value="화성시">화성시</MenuItem>
          
          </Select>
          </>}

          {q1 === '경상남도' &&
          <>
          <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>경상남도</ListSubheader>
          <MenuItem value="함안군">함안군</MenuItem>
          <MenuItem value="거창군">거창군</MenuItem>
          <MenuItem value="창녕군">창녕군</MenuItem>
          <MenuItem value="고성군">고성군</MenuItem>
          <MenuItem value="하동군">하동군</MenuItem>
          <MenuItem value="합천군">합천군</MenuItem>
          <MenuItem value="남해군">남해군</MenuItem>
          <MenuItem value="함양군">함양군</MenuItem>
          <MenuItem value="산청군">산청군</MenuItem>
          <MenuItem value="의령군">의령군</MenuItem>
          
          </Select>

          </>}

          {q1 === '경상북도' &&
          <>
           <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>경상북도</ListSubheader>
          <MenuItem value="군위군">군위군</MenuItem>
          <MenuItem value="의성군">의성군</MenuItem>
          <MenuItem value="청송군">청송군</MenuItem>
          <MenuItem value="영양군">영양군</MenuItem>
          <MenuItem value="영덕군">영덕군</MenuItem>
          <MenuItem value="청도군">청도군</MenuItem>
          <MenuItem value="고령군">고령군</MenuItem>
          <MenuItem value="성주군">성주군</MenuItem>
          <MenuItem value="칠곡군">칠곡군</MenuItem>
          <MenuItem value="예천군">예천군</MenuItem>
          <MenuItem value="봉화군">봉화군</MenuItem>
          <MenuItem value="울진군">울진군</MenuItem>
          <MenuItem value="울릉군">울릉군</MenuItem>
          </Select>

          </>}

          {q1 === '광주광역시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>광주광역시</ListSubheader>
          <MenuItem value="광산구">광산구</MenuItem>
          <MenuItem value="남구">남구</MenuItem>
          <MenuItem value="동구">동구</MenuItem>
          <MenuItem value="북구">북구</MenuItem>
          <MenuItem value="서구">서구</MenuItem>
          </Select>

          </>}

          {q1 === '대구광역시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>대구광역시</ListSubheader>
          <MenuItem value="남구">남구</MenuItem>
          <MenuItem value="달서구">달서구</MenuItem>
          <MenuItem value="달성군">달성군</MenuItem>
          <MenuItem value="동구">동구</MenuItem>
          <MenuItem value="북구">북구</MenuItem>
          <MenuItem value="서구">서구</MenuItem>
          <MenuItem value="수성구">수성구</MenuItem>
          <MenuItem value="중구">중구</MenuItem>
          </Select>

          </>}

          {q1 === '대전광역시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>대전광역시</ListSubheader>
          <MenuItem value="대덕구">대덕구</MenuItem>
          <MenuItem value="동구">동구</MenuItem>
          <MenuItem value="서구">서구</MenuItem>
          <MenuItem value="유성구">유성구</MenuItem>
          <MenuItem value="중구">중구</MenuItem>
          </Select>

          </>}

          {q1 === '부산광역시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>부산광역시</ListSubheader>
          <MenuItem value="강서구">강서구</MenuItem>
          <MenuItem value="금정구">금정구</MenuItem>
          <MenuItem value="남구">남구</MenuItem>
          <MenuItem value="동구">동구</MenuItem>
          <MenuItem value="동래구">동래구</MenuItem>
          <MenuItem value="부산진구">부산진구</MenuItem>
          <MenuItem value="북구">북구</MenuItem>
          <MenuItem value="사상구">사상구</MenuItem>
          <MenuItem value="사하구">사하구</MenuItem>
          <MenuItem value="서구">서구</MenuItem>
          <MenuItem value="수영구">수영구</MenuItem>
          <MenuItem value="연제구">연제구</MenuItem>
          <MenuItem value="영도구">영도구</MenuItem>
          <MenuItem value="중구">중구</MenuItem>
          <MenuItem value="해운대구">해운대구</MenuItem>
          </Select>

          </>}

          {q1 === '서울특별시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true"> 
          <ListSubheader>서울특별시</ListSubheader>
          <MenuItem value="강남구">강남구</MenuItem>
          <MenuItem value="강동구">강동구</MenuItem>
          <MenuItem value="강북구">강북구</MenuItem>
          <MenuItem value="강서구">강서구</MenuItem>
          <MenuItem value="관악구">관악구</MenuItem>
          <MenuItem value="광진구">광진구</MenuItem>
          <MenuItem value="구로구">구로구</MenuItem>
          <MenuItem value="금천구">금천구</MenuItem>
          <MenuItem value="노원구">노원구</MenuItem>
          <MenuItem value="도봉구">도봉구</MenuItem>
          <MenuItem value="마포구">마포구</MenuItem>
          <MenuItem value="서대문구">서대문구</MenuItem>
          <MenuItem value="서초구">서초구</MenuItem>
          <MenuItem value="성동구">성동구</MenuItem>
          <MenuItem value="성북구">성북구</MenuItem>
          <MenuItem value="송파구">송파구</MenuItem>
          <MenuItem value="양천구">양천구</MenuItem>
          <MenuItem value="영등포구">영등포구</MenuItem>
          <MenuItem value="용산구">용산구</MenuItem>
          <MenuItem value="은평구">은평구</MenuItem>
          <MenuItem value="종로구">종로구</MenuItem>
          <MenuItem value="중구">중구</MenuItem>
          <MenuItem value="중랑구">중랑구</MenuItem>
          </Select>

          </>}

          {q1 === '세종특별자치시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>세종특별자치시</ListSubheader>
          <MenuItem value="고운동">고운동</MenuItem>
          <MenuItem value="금남면">금남면</MenuItem>
          <MenuItem value="대평동">대평동</MenuItem>
          <MenuItem value="도담동">도담동</MenuItem>
          <MenuItem value="보람동">보람동</MenuItem>
          <MenuItem value="부강동">부강동</MenuItem>
          <MenuItem value="새롬동">새롬동</MenuItem>
          <MenuItem value="소담동">소담동</MenuItem>
          <MenuItem value="소정면">소정면</MenuItem>
          <MenuItem value="아름동">아름동</MenuItem>
          <MenuItem value="연기면">연기면</MenuItem>
          <MenuItem value="연동면">연동면</MenuItem>
          <MenuItem value="연서면">연서면</MenuItem>
          <MenuItem value="장군면">장군면</MenuItem>
          <MenuItem value="전동면">전동면</MenuItem>
          <MenuItem value="전의면">전의면</MenuItem>
          <MenuItem value="조치원읍">조치원읍</MenuItem>
          <MenuItem value="종촌동">종촌동</MenuItem>
          <MenuItem value="한솔동">한솔동</MenuItem>
          </Select>

          </>}

          {q1 === '울산광역시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>울산광역시</ListSubheader>
          <MenuItem value="남구">남구</MenuItem>
          <MenuItem value="동구">동구</MenuItem>
          <MenuItem value="북구">북구</MenuItem>
          <MenuItem value="울주군">울주군</MenuItem>
          <MenuItem value="중구">중구</MenuItem>
          </Select>

          </>}

          {q1 === '인천광역시' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>인천광역시</ListSubheader>
          <MenuItem value="강화군">강화군</MenuItem>
          <MenuItem value="계양구">계양구</MenuItem>
          <MenuItem value="남동구">남동구</MenuItem>
          <MenuItem value="동구">동구</MenuItem>
          <MenuItem value="미추홀구">미추홀구</MenuItem>
          <MenuItem value="부평구">부평구</MenuItem>
          <MenuItem value="서구">서구</MenuItem>
          <MenuItem value="연수구">연수구</MenuItem>
          <MenuItem value="옹진군">옹진군</MenuItem>
          <MenuItem value="중구">중구</MenuItem>
          </Select>
          </>}

          {q1 === '전라남도' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>전라남도</ListSubheader>
          <MenuItem value="담양군">담양군</MenuItem>
          <MenuItem value="곡성군">곡성군</MenuItem>
          <MenuItem value="구례군">구례군</MenuItem>
          <MenuItem value="고흥군">고흥군</MenuItem>
          <MenuItem value="보성군">보성군</MenuItem>
          <MenuItem value="화순군">화순군</MenuItem>
          <MenuItem value="장흥군">장흥군</MenuItem>
          <MenuItem value="강진군">강진군</MenuItem>
          <MenuItem value="해남군">해남군</MenuItem>
          <MenuItem value="영암군">영암군</MenuItem>
          <MenuItem value="무안군">무안군</MenuItem>
          <MenuItem value="함평군">함평군</MenuItem>
          <MenuItem value="영광군">영광군</MenuItem>
          <MenuItem value="장성군">장성군</MenuItem>
          <MenuItem value="완도군">완도군</MenuItem>
          <MenuItem value="진도군">진도군</MenuItem>
          <MenuItem value="신안군">신안군</MenuItem>
          </Select>
          </>}

          {q1 === '전라북도' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>전라북도</ListSubheader>
          <MenuItem value="안주군">안주군</MenuItem>
          <MenuItem value="고창군">고창군</MenuItem>
          <MenuItem value="부안군">부안군</MenuItem>
          <MenuItem value="임실군">임실군</MenuItem>
          <MenuItem value="순창군">순창군</MenuItem>
          <MenuItem value="진안군">진안군</MenuItem>
          <MenuItem value="무주군">무주군</MenuItem>
          <MenuItem value="장수군">장수군</MenuItem>
          </Select>
          </>}

          {q1 === '제주특별자치도' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>제주특별자치도</ListSubheader>
          <MenuItem value="서귀포시">서귀포시</MenuItem>
          <MenuItem value="제주시">제주시</MenuItem>
          </Select>
          </>}

          {q1 === '충청남도' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>충청남도</ListSubheader>
          <MenuItem value="금산군">금산군</MenuItem>
          <MenuItem value="부여군">부여군</MenuItem>
          <MenuItem value="서천군">서천군</MenuItem>
          <MenuItem value="청양군">청양군</MenuItem>
          <MenuItem value="홍성군">홍성군</MenuItem>
          <MenuItem value="예산군">예산군</MenuItem>
          <MenuItem value="태안군">태안군</MenuItem>
          
          </Select>
          </>}

          {q1 === '충청북도' &&
          <>
            <Select value={q2} onChange={handleChangeQ2} autoWidth="true">
          <ListSubheader>충청북도</ListSubheader>
          <MenuItem value="보은군">보은군</MenuItem>
          <MenuItem value="옥천군">옥천군</MenuItem>
          <MenuItem value="영동군">영동군</MenuItem>
          <MenuItem value="증평군">증평군</MenuItem>
          <MenuItem value="진천군">진천군</MenuItem>
          <MenuItem value="괴산군">괴산군</MenuItem>
          <MenuItem value="음성군">음성군</MenuItem>
          <MenuItem value="단양군">단양군</MenuItem>
          </Select>
          </>}


        <button onClick={handleOnClick}>찾기</button>
      </form>
      <br />
      병원목록
      <hr />
      {data ? (
        <HospitalList data={data} />
      ) : (
        "선택하신 지역에 응급실이 존재하지 않습니다."
      )}
    </div>
  );
};

export default Search;