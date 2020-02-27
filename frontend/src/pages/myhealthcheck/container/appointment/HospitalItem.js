/*global kakao*/

import React,{useEffect} from 'react';
import { Button, Typography } from '@material-ui/core';
import {useState } from "react";
import KeywordMap from "./KeywordMap";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import TextField from "@material-ui/core/TextField";

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableRow from '@material-ui/core/TableRow';
import Grid from '@material-ui/core/Grid';



const HospitalItem = ({data}) => {

    const [open, setOpen] = useState(false);
  
    const handlePos=(e)=>{
       setOpen(true);
    }

    //모달창 열기
    const handleClickOpen = (e) => {
        setOpen(true);
    }
    //모달창 닫기
    const handleClickClose = (e) => {
        setOpen(false);
    }

    


    return (
        <>
        <div>   
            병원명: {data.name} <br/>위치 : {data.address} 
            {data.xpos && <button onClick={()=>handlePos()}>지도</button>}
            {/* <button onClick={handleSubmit}>선택</button> */}
            <hr/>
        </div>
        {/* 모달창 start */}
                <Dialog
                  open={open}
                  onClose={handleClickClose}
                  fullWidth
                  maxWidth="lx"
                >
        
                  <DialogTitle>병원위치</DialogTitle>
                      <DialogContent>
                      <Grid
                        container
                        direction="row"
                        justify="flex-start"
                        alignItems="flex-start"
                        spacing={3}
                        >
                            <Grid column="row" item xs ={6}>
                                <KeywordMap hx={data.xpos} hy={data.ypos}/>
                            </Grid>
                            <Grid item xs ={6}>
                                <Table size="small">
                                    <TableBody>
                                        <Typography variant="h6">병원정보</Typography>
                                        <TableRow ><TableCell align="center">병원명</TableCell><TableCell align="center">{data.name}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">전화번호</TableCell><TableCell align="center">{data.tel}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">주소</TableCell><TableCell align="center">{data.address}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">개업일</TableCell><TableCell align="center">{data.openDate}</TableCell></TableRow>
                                        <br/><br/><Typography variant="h6">병원인력정보</Typography>
                                        <TableRow ><TableCell align="center">진료의(명)</TableCell><TableCell align="center">{data.doctorCount}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">일반의(명)</TableCell><TableCell align="center">{data.generalDoctorCount}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">전문의(명)</TableCell><TableCell align="center">{data.specialDoctorCount}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">레지턴트(명)</TableCell><TableCell align="center">{data.residentCount}</TableCell></TableRow>
                                        <TableRow ><TableCell align="center">인턴(명)</TableCell><TableCell align="center">{data.internCount}</TableCell></TableRow>
                                    </TableBody>
                                </Table>
                            </Grid>
                        </Grid>
                      </DialogContent>
                      <DialogActions>
                        <Button variant="outlined" color="primary" onClick={handleClickClose}>닫기</Button>
                      </DialogActions>

              </Dialog>
            {/* 모달창 end */}


        </>
    );
};

export default HospitalItem;