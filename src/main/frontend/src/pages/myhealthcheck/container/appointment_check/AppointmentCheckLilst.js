import React, { Component } from 'react';
import useStyles from "../../style/useStyles";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import SelfCheckButton from './SelfCheckButton';


/**
 * 진료예약확인리스트 테이블.
 * 
 * AppointmentCheck.js에서 데이터를 받아서 테이블 셀 삽입
 */

class AppointmentCheckList extends Component {
    render() {
        const classes = useStyles.bind();
        const {items} = this.props;

        return (
            <div>
            
                <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead>
                    <TableRow>
                        <TableCell>증상</TableCell>
                        <TableCell align="center">예약병원</TableCell>
                        <TableCell align="center">예약날짜</TableCell>
                        <TableCell align="center">예약시간</TableCell>
                        <TableCell align="center">상태</TableCell>
                    </TableRow>
                    </TableHead>
                    <TableBody>
                    {items.map(row => (
                        <TableRow>
                        <TableCell component="th" scope="row">{row.symptom}</TableCell>
                        <TableCell align="center">{row.hospital.name}</TableCell>
                        <TableCell align="center">{row.reserveDate}</TableCell>
                        <TableCell align="center">{row.reserveTime}</TableCell>
                        <TableCell align="center"><SelfCheckButton reservationId={row.id} status={row.status} serverDate={row.reserveDate} serverTime={row.reserveTime}/></TableCell>
                        </TableRow>
                    ))}

                    </TableBody>
                </Table>
                </TableContainer>
            </div>
        );
    }
}

export default AppointmentCheckList;