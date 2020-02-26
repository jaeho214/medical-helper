// 진료예약 확인
import React, { Component } from 'react';
import AppointmentCheckList from './AppointmentCheckLilst';
import Axios from 'axios';

//임시 데이터로 테스트 -> 서버에서 데이터 받아와야함
class AppointmentCheck extends Component {
  state={
    items: [
      
    ],

  }

  componentDidMount = async () => {
    try {
        const token = localStorage.getItem("token");
        const response = await Axios.get(
          "/medicalHelper/reservation",
          {
            headers: {
              "token": token,
            }
        });

        const { status, data } = response;
        if (status === 200) {
            console.log(data);
            const { state } = this;
            this.setState({
                ...state,
                items: data,
            });
        }
    } catch (e) {

    }
 }

  render() {
    const {items} = this.state;
    
    return (
      <div>
        <AppointmentCheckList items={items}/>
      </div>
    );
  }
}

export default AppointmentCheck;