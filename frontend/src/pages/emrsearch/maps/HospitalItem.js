/*global kakao*/

import React, { useEffect } from "react";
import { Button, Typography } from "@material-ui/core";
import { useState } from "react";
import KeywordMap from "./KeywordMap";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import TextField from "@material-ui/core/TextField";

import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableRow from "@material-ui/core/TableRow";
import Grid from "@material-ui/core/Grid";
import Axios from "axios";

const HospitalItem = ({ data }) => {
  const [open, setOpen] = useState(false);
  const [datas, setDatas] = useState([]);

  const handlePos = async () => {
    setOpen(true);
    const response = await Axios.get(
      `/medicalHelper/emergency/information/${data.hpid}/${1}`
    );
    setDatas(response.data.body.items[0]);
    console.log(datas);
  };

  //모달창 닫기
  const handleClickClose = e => {
    setOpen(false);
  };

  return (
    <>
      <div>
        병원명: {data.dutyName} <br />
        위치 : {data.dutyAddr}
        <button onClick={handlePos}>지도</button>
        <hr />
      </div>
      {/* 모달창 start */}
      <Dialog open={open} onClose={handleClickClose} fullWidth maxWidth="lx">
        <DialogTitle>병원위치</DialogTitle>
        <DialogContent>
          <Grid
            container
            direction="row"
            justify="flex-start"
            alignItems="flex-start"
            spacing={3}
          >
            <Grid column="row" item xs={6}>
              <KeywordMap hx={data.wgs84Lon} hy={data.wgs84Lat} />
            </Grid>
            <Grid item xs={6}>
              <Table size="small">
                <TableBody>
                  <Typography variant="h6">병원정보</Typography>
                  <TableRow>
                    <TableCell align="center">병원명</TableCell>
                    <TableCell align="center">{datas.dutyName}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">전화번호</TableCell>
                    <TableCell align="center">{datas.dutyTel1}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">주소</TableCell>
                    <TableCell align="center">{datas.dutyAddr}</TableCell>
                  </TableRow>

                  <br />
                  <br />
                  <Typography variant="h6">응급실정보</Typography>
                  <TableRow>
                    <TableCell align="center">응급실 개수</TableCell>
                    <TableCell align="center">{datas.hvec}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">수술실 개수</TableCell>
                    <TableCell align="center">{datas.hvoc}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">입원실 수</TableCell>
                    <TableCell align="center">{datas.hvgc}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">병상 수</TableCell>
                    <TableCell align="center">{datas.hpbdn}</TableCell>
                  </TableRow>
                  <br />
                  <br />
                  <Typography variant="h6">
                    수술 가능 여부 
                  </Typography>
                  <Typography variant="h7">
                    (Y:가능   N:불가능)
                  </Typography>
                  <br/>
                  <TableRow>
                    <TableCell align="center">뇌출혈 수술</TableCell>
                    <TableCell align="center">{datas.MKioskTy1}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">뇌경색의 재관류</TableCell>
                    <TableCell align="center">{datas.MKioskTy2}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">심근경색의 재관류</TableCell>
                    <TableCell align="center">{datas.MKioskTy3}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">복부손상의 수술</TableCell>
                    <TableCell align="center">{datas.MKioskTy4}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">사지접합의 수술</TableCell>
                    <TableCell align="center">{datas.MKioskTy5}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">응급내시경</TableCell>
                    <TableCell align="center">{datas.MKioskTy6}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">응급투석</TableCell>
                    <TableCell align="center">{datas.MKioskTy7}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">조산산모</TableCell>
                    <TableCell align="center">{datas.MKioskTy8}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">정신질환자</TableCell>
                    <TableCell align="center">{datas.MKioskTy9}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">신생아</TableCell>
                    <TableCell align="center">{datas.MKioskTy10}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="center">중증화상</TableCell>
                    <TableCell align="center">{datas.MKioskTy11}</TableCell>
                  </TableRow>
                </TableBody>
              </Table>
            </Grid>
          </Grid>
        </DialogContent>
        <DialogActions>
          <Button variant="outlined" color="primary" onClick={handleClickClose}>
            닫기
          </Button>
        </DialogActions>
      </Dialog>
      {/* 모달창 end */}
    </>
  );
};

export default HospitalItem;
