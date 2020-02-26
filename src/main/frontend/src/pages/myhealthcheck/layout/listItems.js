import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import ListSubheader from "@material-ui/core/ListSubheader";
import DashboardIcon from "@material-ui/icons/Dashboard";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import PeopleIcon from "@material-ui/icons/People";
import BarChartIcon from "@material-ui/icons/BarChart";
import LayersIcon from "@material-ui/icons/Layers";
import AssignmentIcon from "@material-ui/icons/Assignment";
import { Link } from "react-router-dom";

import React, { Component } from 'react';

class listItems extends Component {
  state = {
    selectedIndex: 0,
  }
 
  /**
   * index num 
   * 0 진료예약
   * 1 진료예약확인
   * 2 약국찾기
   * 3 내 회원정보
   */
  handleIndex = (index) => {
    this.props.handleIndex(index);
  }
  
  
  render() {
    return (
    
        <div>
          
          <ListItem onClick={() => this.handleIndex(0)} button>
            <ListItemIcon>
              <DashboardIcon />
            </ListItemIcon>
            <ListItemText primary="진료예약" />
          </ListItem>
       
          <ListItem onClick={() => this.handleIndex(1)} button>
              <ListItemIcon>
              <DashboardIcon />
            </ListItemIcon>
            <ListItemText primary="진료예약확인" />
          </ListItem>
       
          <ListItem onClick={() => this.handleIndex(2)} button>
            <ListItemIcon>
              <PeopleIcon />
            </ListItemIcon>
            <ListItemText primary="약국찾기" />
          </ListItem>
        
          <ListItem onClick={() => this.handleIndex(3)} button>
            <ListItemIcon>
              <PeopleIcon />
            </ListItemIcon>
            <ListItemText primary="내 회원정보" />
          </ListItem>
      </div>
    );
  }
}

export default listItems;
