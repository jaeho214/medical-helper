import React, { Component } from 'react';
import { Route } from "react-router-dom";

import Appointment from "../container/appointment/Appointment"
import AppointmentCheck from "../container/appointment_check/AppointmentCheck";

import Grid from '@material-ui/core/Grid';
import { Link } from "react-router-dom";

import ListItems from "./listItems";
import { Container } from '@material-ui/core';
import MyProfile from '../container/MyProfile';
import Pharmacy from '../container/pharmacy/Pharmacy';

class body extends Component {
    state = {
        selectedIndex:0,
    }

    handleIndex = (selectedIndex) => {
        this.setState({
            selectedIndex,
        });
        console.log("index in Body",this.state.selectedIndex);  
    }

    render() {
        const { selectedIndex } = this.state;

        return (
            <div>
                 <Grid
                     container
                     direction="row"
                     justify="flex-start"
                     alignItems="flex-start"
                    spacing={5}>

                    <Grid item sm={3}>
                        <ListItems handleIndex={this.handleIndex}/>
                    </Grid>

                    <Grid item sm={9}>
                        {selectedIndex===0 &&<Link to="/appointment" component={Appointment}></Link> }
                        {selectedIndex===1 &&<Link to="/appointmentcheck" component={AppointmentCheck}></Link>}
                        {selectedIndex===2 &&<Link to="/findpharmacy" component={Pharmacy}></Link>}
                        {selectedIndex===3 &&<Link to="/myprofile" component={MyProfile}></Link>}
                    </Grid>

                </Grid> 
            </div>
        );
    }
}

export default body;