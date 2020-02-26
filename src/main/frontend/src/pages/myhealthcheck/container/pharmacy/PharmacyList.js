import React, { useEffect, useState } from "react";
import Axios from "axios";
import PharmacyItem from "./PharmacyItem";

const PharmacyList = ({ xpos, ypos }) => {
  const [data, setData] = useState([]);
  useEffect(() => {
    const get = async () => {
      try {
        const response = await Axios.get(
          `/medicalHelper/pharmacy/gps/${ypos}/${xpos}?pageNo=${1}`
        );
        setData(response.data);
      } catch (e) {
        console.log(e);
      }
    };
    get();
  });
  return (
    <div>
      <h4>가까운 약국목록</h4> <hr />
      {data.map(data => (
        <PharmacyItem key={data.postNo} data={data} />
      ))}
    </div>
  );
};

export default PharmacyList;
