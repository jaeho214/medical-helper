import React, { Component } from 'react';
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";


import Axios from "axios";

class HospitalForm extends Component {
    state={
        
        hospitalId: 0+this.props.hospitalId,
        hospitalName:this.props.hospitalName,
        reserveDate:new Date(),
        // reserveDate:"",
        reserveTime:"",
        symptom:"",

        open:false,
            
        
    }

    handleValueChange = (e) => {
        const nextState = {};
        nextState[e.target.name] = e.target.value;
        this.setState(nextState);
    }

    handleFormSubmit = async (e) => {
        e.preventDefault();

        
        const {hospitalId,reserveDate,reserveTime,symptom } = this.state;
        const token = localStorage.getItem("token");
        
        console.log(this.state)

        try {
            const response = await Axios.post(
              "/medicalHelper/reservation",
              {
                hospitalId,reserveDate,reserveTime,symptom
              },
              {
                headers: {
                  "token": token,
                }
              });
            
            if (response.status === 200) {
              console.log("전송됨");
              console.log(response.data)
             
            }
          } catch (error) {
            console.log(error);
          }
  
        
    }

    //예약선택하기
    handleOpen = (e) => {
        this.setState({
            open: true
        })
    
    }

    handleClose = (e) => {
        this.setState({
            open: false
        })
    
    }

    
  
    render() {
        const {hospitalName, reserveDate, reserveTime, symptom, open} = this.state;
        const {handleValueChange, handleFormSubmit, handleOpen, handleClose} = this;

        return (
            <div>
                
                        <Button variant="outlined" color="primary" style={{width:20,}} onClick={handleOpen}>예약</Button>
                    
                        <Dialog
                            open={open}
                            onClose={handleClose}
                            fullWidth
                            maxWidth="xs"
                        >
                        
                        <DialogTitle >병원예약</DialogTitle>
                     
                            <form onSubmit={handleFormSubmit}>
                            <DialogContent>

                                병원명 :{"   "}
                                <TextField
                                    type="text"
                                    value={hospitalName}
                                    name="hospitalName"
                                    style={{width: 250}}
                                    unselectable
                                />
                                <br/><br/>
                                예약날짜 :{"   "}
                                <TextField
                                    type="date"
                                    value={reserveDate}
                                    name="reserveDate"
                                    style={{width: 250}}
                                    onChange={handleValueChange}
                                    autoFocus
                                />
                                <br/><br/>
                                예약시간 :{"   "}
                                <TextField
                                    label="예약시간"
                                    type="text"
                                    value={reserveTime}
                                    name="reserveTime"
                                    style={{width: 250}}
                                    onChange={handleValueChange}
                                />
                                
                                <br/><br />
                                증상 :{"   "}
                                <TextField
                                    label="증상"
                                    type="text"
                                    value={symptom}
                                    name="symptom"
                                    style={{width: 250}}
                                    onChange={handleValueChange}
                                />
                                <br />
                                <br />
                                </DialogContent>
                                <DialogActions>
                                    <Button variant="outlined" color="primary" onClick={this.handleClose}>취소</Button>
                                    <Button type="submit" variant="contained" color="secondary" onClick={this.handleClose}>예약하기</Button>
                                </DialogActions>
                                </form>

                            </Dialog>
                        
                    
            </div>
        );
    }
}

export default HospitalForm;