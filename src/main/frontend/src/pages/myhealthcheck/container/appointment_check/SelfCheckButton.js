import React, { Component } from 'react';
import { Button, ListItemSecondaryAction, Typography } from "@material-ui/core";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import TextField from "@material-ui/core/TextField";
import FormLabel from '@material-ui/core/FormLabel';
import FormControl from '@material-ui/core/FormControl';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormHelperText from '@material-ui/core/FormHelperText';
import Input from '@material-ui/core/Input';

import Checkbox from '@material-ui/core/Checkbox';
import useStyles from "../../style/useStyles";
import Axios, {post, put} from "axios";

/**
 * 버튼 상태
 * 예약완료 (state 예약)
 */

class SelfCheckButton extends Component {
    state = {
        doctorName: "",
        breakfast: false,
        lunch: false,
        dinner: false,
        deadline: "", //달력
        solution: "",
        title: "",
        reservationId:this.props.reservationId,

        file:null,

        serverDate: this.props.serverDate,
        serverTime: this.props.serverTime,
        toggle: false, // false-> 예약완료, true->처방입력
        open: false, //처방입력 모달창 오픈 유무
        resultOpen: false, //처방내역 모달창 오픈 유무

        treatmentItems: [],

        tb:false, //서버data 중 data.drug에 대한 참조가 되지 않아서 데이터를 두번저장함...
        tl:false,
        td:false,
        tdl:"",
    }

    //처방입력모달창 열기
    handleClickOpen = (e) => {
        this.setState({
            open: true,
        })
    }

    //처방내역모달창 열기
    handleClickResultOpen = (e) => {
        this.getTreatment(this.state.reservationId);
        this.setState({
            resultOpen: true,
        })
        console.log("처방내역모달창 열게~ ")
    }


    //모달창 닫기
    handleClickClose = (e) => {
        this.setState({
            open: false,
            resultOpen: false,
        })
    }

    addTreatment() {
        const url = "/medicalHelper/treatment";
  
        const formData = new FormData();
        const {doctorName,breakfast,lunch,dinner,deadline,solution,title, reservationId, file} = this.state;
        const token = localStorage.getItem("token");
  
        formData.append("imageFile", file);
  
        const config = {
            headers: {
                "Content-type": "multipart/form-data",
                "token": token,
            },
        };
  
        const json = `{ "title": "${title}", "solution": "${solution}", "doctorName": "${doctorName}", "reservationId": ${reservationId}, "breakfast": ${breakfast}, "lunch": ${lunch}, "dinner": ${dinner}, "deadline": "${deadline}"}`;
        console.log(json);
  
        formData.append("json", json);
        return post(url, formData, config);
    }

    //처방입력모달창 완료 버튼 클릭 시 서버로 데이터 전송
    handleFormSubmit = (e) => {
        e.preventDefault();
        console.log("Here is handleFormSubmit in SelfCheckButton");

        this.addTreatment()
            .then((response) => {
                console.log(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

    }

    getTreatment = async (id) => {
        try {
            const token = localStorage.getItem("token");

            const response = await Axios.get(
              `/medicalHelper/treatment/${id}`,
              {
                headers: {
                  "token": token,
                }
            });
    
            const { status, data } = response;
            if (status === 200) {
                console.log("데이터가져올게~ ");
                console.log(data);

                const { state } = this;
                this.setState({
                    ...state,
                    treatmentItems: data,
                    tb: data.drug.breakfast,
                    tl: data.drug.lunch,
                    td: data.drug.dinner,
                    tdl: data.drug.deadline,

                });

                console.log("treatment data를 보자!")
                console.log(this.state.treatmentItems)
            }
        } catch (e) {
    
        }


    }

    modifyTreatment(id) {
        
        const url = `/medicalHelper/treatment`;
  
        const formData = new FormData();
        const {doctorName,solution,title, file} = this.state;
        const token = localStorage.getItem("token");
  
        formData.append("imageFile", file);
  
        const config = {
            headers: {
                "Content-type": "multipart/form-data",
                "token": token,
            },
        };
  
        const json = `{ "id": ${id}, "title": "${title}", "solution": "${solution}", "doctorName": "${doctorName}"}`;
        console.log(json);
  
        formData.append("json", json);
        return put(url, formData, config);
    }


    //처방내역모달창 완료 버튼 클릭 시 서버로 데이터 전송
    handleModifySubmit = (e) => {
        e.preventDefault();
        console.log("Here is handleModifySubmit in SelfCheckButton");

        const id = this.state.reservationId;

        this.modifyTreatment(id)
            .then((response) => {
                console.log(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

    }


    //시간비교
    componentDidMount = () => {
        try {
            const {serverDate, serverTime,toggle} = this.state;
            const preDate = new Date();
            const year = preDate.getFullYear();
            const month = preDate.getMonth()+1;
            const date = preDate.getDate();

            const currentDate = addZero(year)+"-"+addZero(month)+"-"+addZero(date); //현재날짜 string 2020-02-06
            const currentTime = addZero(preDate.getHours())+":"+addZero(preDate.getMinutes()); //현재시간 string 18:03
            
            console.log("현재날짜 >>>",currentDate+" "+currentTime);
            console.log("서버날짜 >>>",serverDate+" "+serverTime);

            if(currentDate+" "+currentTime > serverDate+" "+serverTime){
                if(!toggle)
                    this.setState({
                        toggle:true,
                    });
                console.log("지났으니까 처방입력으로 전환")
            }
            
            //(ex) 시간표시 6:5 -> 06:05로 변환
            function addZero(time){
                if(time<10)
                    time="0"+time;
                return time;
            }
            
            
        } catch (e) {

        }


    }

    
    // form valueChange
    handleValueChange = (e) => {
        const nextState = {};
        nextState[e.target.name] = e.target.value;
        this.setState(nextState);
    }
  
    // checkbox toggle
    handleToggle = name => event => {
        this.setState({ 
            [name]: event.target.checked,
        });
    }

    render() {
        const classes = useStyles.bind();
        const {status} = this.props;
        
        const {doctorName, breakfast, lunch, dinner, deadline, solution, title, toggle, treatmentItems} = this.state;
        
        return (
            <div>
                {console.log(toggle)}

                {/* 예약시간전 상태(예약)*/}
                {status==="예약완료"&&!toggle&&
                    <Button variant="contained" color="secondary"> 
                        예약완료
                    </Button>
                }
            
                {/* 예약시간후 상태(예약)*/}
                {status==="예약완료"&&toggle&&
                    <Button variant="contained" color="primary" onClick={this.handleClickOpen}>
                        처방입력
                    </Button>
                }

                {/* 처방입력후 상태(처방)*/}
                {status==="처방완료"&&
                    <Button variant="outlined" color="primary" onClick={this.handleClickResultOpen}>
                        처방내역
                    </Button>
                }      

                {/* 처방입력 모달창 start */}
                <Dialog
                  open={this.state.open}
                  onClose={this.handleClickClose}
                  fullWidth
                  maxWidth="sm"
                >
                    <DialogTitle>처방입력</DialogTitle>
                    <form onSubmit={this.handleFormSubmit}>
                        <DialogContent>

                        <TextField
                            id="standard-basic"
                            label="제목"
                            name="title"
                            value={title}
                            onChange={this.handleValueChange}
                            style={{ width: 300 }}
                            />
                            <br />
                            <br />
                            <TextField
                            id="standard-basic"
                            label="처방내용"
                            style={{ width: 300 }}
                            multiline
                            rows="4"
                            variant="filled"
                            name="solution"
                            value={solution}
                            onChange={this.handleValueChange}
                            />
                            <br />
                            <br />
                            <TextField
                            id="standard-basic"
                            label="교수이름"
                            style={{ width: 100 }}
                            name="doctorName"
                            value={doctorName}
                            onChange={this.handleValueChange}
                            />
                            <br />
                            <br />
                            {/* 아침 점심 저녁 toggle */}
                            <FormControl component="fieldset" className={classes.formControl}>
                            <FormLabel component="legend">Assign responsibility</FormLabel>
                                <FormGroup>
                                <FormControlLabel
                                    control={<Checkbox checked={breakfast} onChange={this.handleToggle('breakfast')} value={breakfast} />}
                                    label="breakfast"
                                />
                                <FormControlLabel
                                    control={<Checkbox checked={lunch} onChange={this.handleToggle('lunch')} value={lunch} />}
                                    label="lunch"
                                />
                                <FormControlLabel
                                    control={<Checkbox checked={dinner} onChange={this.handleToggle('dinner')} value={dinner} />}
                                    label="dinner"
                                />
                                </FormGroup>
                            </FormControl>
                            <br />
                            <br />
                            <TextField
                            id="datetime-local"
                            label="~까지"
                            type="date"
                            name="deadline"
                            value={deadline}
                            onChange={this.handleValueChange}
                            />
                          <br />
                        </DialogContent>

                        <DialogActions>
                            <Button variant="outlined" color="primary" onClick={this.handleClickClose}>취소</Button>
                            <Button type="submit" variant="contained" color="secondary" onClick={this.handleClickClose}>완료</Button>
                        </DialogActions>

                    </form>
                </Dialog>
                {/* 모달창 end */}

                {/* 처방내역 모달창 start */}
                <Dialog
                  open={this.state.resultOpen}
                  onClose={this.handleClickClose}
                  fullWidth
                  maxWidth="sm"
                >
                    {console.log("혹시 모달창에 데이터 잘있니~?")}
                    {console.log(treatmentItems)}
                    <DialogTitle>처방내역</DialogTitle>
                    <form onSubmit={this.handleModifySubmit}>
                        <DialogContent>
                        
                        <Typography>Title</Typography>
                        <TextField
                            id="standard-basic"
                            name="title"
                            
                            defaultValue={treatmentItems.title}
                            style={{ width: 300 }}
                            onChange={this.handleValueChange}
                            
                            />
                            <br />
                            <br />
                            <Typography>Solution</Typography>

                            <TextField
                            id="standard-basic"
                            style={{ width: 300 }}
                            name="solution"
                            defaultValue={treatmentItems.solution}
                            onChange={this.handleValueChange}

                            />
                            <br />
                            <br />
                            <Typography>담당진료의</Typography>

                            <TextField
                            id="standard-basic"
                            style={{ width: 100 }}
                            name="doctorName"
                            defaultValue={treatmentItems.doctorName}
                            onChange={this.handleValueChange}

                            />
                            <br />
                            <br />
                            {/* 아침 점심 저녁 toggle */}
                            <FormControl component="fieldset" className={classes.formControl}>
                            <FormLabel component="legend">처방시간</FormLabel>
                            {console.log(this.state.tb)}
                            {console.log(this.state.tl)}
                            {console.log(this.state.td)}

                                <FormGroup>
                                <FormControlLabel
                                
                                    control={<Checkbox checked={this.state.tb}  />}
                                    label="breakfast"
                                />
                                <FormControlLabel
                                    control={<Checkbox checked={this.state.tl}  />}
                                    label="lunch"
                                />
                                <FormControlLabel
                                    control={<Checkbox checked={this.state.td}/>}
                                    label="dinner"
                                />
                                
                                </FormGroup> 
                            </FormControl>
                            <br />
                            <br />
                            <Typography>~까지</Typography>

                            <TextField
                            id="datetime-local"
                            type="text"
                            value={this.state.tdl}
                            unselectable
                            />
                          <br />
                        </DialogContent>

                        <DialogActions>
                            <Button variant="outlined" color="primary" onClick={this.handleClickClose}>취소</Button>
                            <Button type="submit" variant="contained" color="secondary" onClick={this.handleClickClose}>수정</Button>
                        </DialogActions>

                    </form>
                </Dialog>
                {/* 모달창 end */}

            </div>
        );
    }
}

export default SelfCheckButton;