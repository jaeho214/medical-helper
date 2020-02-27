import React, { useState, useEffect } from "react";
import Axios from "axios";
import HospitalList from "./HospitalList";
import HospitalForm from "./HospitalForm";

import Grid from '@material-ui/core/Grid';
import { Typography } from "@material-ui/core";


const Appointment = ({ xPos, yPos }) => {

  const [data, setData] = useState([]);
  const [type, setType] = useState();

  const onClick = async e => {
    // 새로고침 방지
    e.preventDefault();

    // 데이터 가져오는 부분
    try {
      setType(e.target.value);

      const response = await Axios.get(
        `/medicalHelper/hospital/gps/name/${yPos}/${xPos}/${
          e.target.value
        }?pageNo=${1}`
      );
      console.log(response.data);
      setData(response.data);
      console.log(data)
      
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <div>
      
      <br />
      <Grid xs ={12}
        container
        direction="row"
        alignItems="flex-start"
        justify="space-evenly"
      >
      
        <button variant="outlined" value="내과" color="primary" onClick={onClick}>
          내과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="소아과"
          color="primary"
          onClick={onClick}
        >
          소아과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="피부과"
          color="primary"
          onClick={onClick}
        >
          피부과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="정형외과"
          color="primary"
          onClick={onClick}
        >
          정형외과
        </button>
        &nbsp;
        <button variant="outlined" value="외과" color="primary" onClick={onClick}>
          외과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="가정의학과"
          color="primary"
          onClick={onClick}
        >
          가정의학과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="신경외과"
          color="primary"
          onClick={onClick}
        >
          신경외과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="마취통증과"
          color="primary"
          onClick={onClick}
        >
          마취통증과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="성형외과"
          color="primary"
          onClick={onClick}
        >
          성형외과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="산부인과"
          color="primary"
          onClick={onClick}
        >
          산부인과
        </button>
        &nbsp;
        <button variant="outlined" value="안과" color="primary" onClick={onClick}>
          안과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="정신의학과"
          color="primary"
          onClick={onClick}
        >
          정신의학과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="비뇨기과"
          color="primary"
          onClick={onClick}
        >
          비뇨기과
        </button>
        &nbsp;
        <button variant="outlined" value="치과" color="primary" onClick={onClick}>
          치과
        </button>
        &nbsp;
        <button
          variant="outlined"
          value="한의원"
          color="primary"
          onClick={onClick}
        >
          한의원
        </button>
        &nbsp;
        <button variant="outlined" value="노인" color="primary" onClick={onClick}>
          노인
        </button>
        <hr/>
        </Grid>
        <Grid >
          <br/>
          {type? <HospitalList data={data} /> : <Typography h1 color="primary">병원유형을 먼저 선택해주세요!</Typography> }
          
        </Grid>

    </div>
  );
};

export default Appointment;