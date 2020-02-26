import React, { useEffect, useState } from "react";
import Axios from "axios";
import {
  Grid,
  Table,
  TableBody,
  Typography,
  TableRow,
  TableCell
} from "@material-ui/core";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import { useHistory } from "react-router-dom";

const MyProfile = () => {
  let history = useHistory();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");
  const [birth, setBirth] = useState("");
  const [sex, setSex] = useState("");
  const [address, setAddress] = useState("");
  const [open, setOpen] = useState(false);

  const [rename, setRename] = useState("");
  const [rephone, setRephone] = useState("");
  const [readdress, setReaddress] = useState("");

  useEffect(() => {
    const get = async () => {
      try {
        const response = await Axios.get("medicalHelper/sign", {
          headers: {
            token: localStorage.getItem("token")
          }
        });
        const { data } = response;
        console.log(response);
        setEmail(data.email);
        setName(data.name);
        setPhone(data.phone);
        setBirth(data.birth);
        setSex(data.sex);
        setAddress(data.address);
        setPassword(data.password);
      } catch (e) {
        console.log(e);
      }
    };
    get();
  });

  const handleOpen = e => {
    setOpen(true);
  };

  const handleClose = e => {
    setOpen(false);
  };

  const nameChange = e => {
    setRename(e.target.value);
  };
  const phoneChange = e => {
    setRephone(e.target.value);
  };
  const addressChange = e => {
    setAddress(e.target.value);
  };
  
  const handleComfirm = e => {
    var con = window.confirm("정말 탈퇴하시겠습니까?");
    if (con) {
      const response = Axios.delete("/medicalHelper/sign", {
        headers: {
          token: localStorage.getItem("token")
        }
      });
      localStorage.clear();
      history.push("/");
    } else {
      console.log("탈퇴안함");
    }
  };

  const handleInfoClick = async e => {
    // 수정한 데이터 보내기
    try {
      const response = await Axios.put(
        "/medicalHelper/sign",
        {
          name: rename,
          password,
          address : readdress,
          phone : rephone,
          sex
        },
        {
          headers: {
            token: localStorage.getItem("token")
          }
        }
      );
      alert("수정완료되었습니다.");
      history.push("/myhealthcheck");
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <div>
      <Grid
        container
        direction="row"
        justify="flex-start"
        alignItems="flex-start"
        spacing={3}
      >
        <Grid item xs={6}>
          <Table size="small">
            <TableBody>
              <Typography variant="h6">회원정보</Typography>
              <br />
              <TableRow>
                <TableCell align="center">이메일</TableCell>
                <TableCell align="center">{email}</TableCell>
              </TableRow>
              <TableRow>
                <TableCell align="center">이름</TableCell>
                <TableCell align="center">{name}</TableCell>
              </TableRow>
              <TableRow>
                <TableCell align="center">전화번호</TableCell>
                <TableCell align="center">{phone}</TableCell>
              </TableRow>
              <TableRow>
                <TableCell align="center">생년월일</TableCell>
                <TableCell align="center">{birth}</TableCell>
              </TableRow>
              <TableRow>
                <TableCell align="center">성별</TableCell>
                <TableCell align="center">{sex}</TableCell>
              </TableRow>
              <TableRow>
                <TableCell align="center">주소</TableCell>
                <TableCell align="center">{address}</TableCell>
              </TableRow>
            </TableBody>
          </Table>
        </Grid>
        <Button variant="contained" color="primary" onClick={handleOpen}>
          회원정보 수정하기
        </Button>
        &nbsp;&nbsp;&nbsp;
        <Button variant="contained" color="secondary" onClick={handleComfirm}>
          탈퇴하기
        </Button>
        <Dialog open={open} onClose={handleClose} fullWidth maxWidth="xs">
          <DialogTitle>회원정보 수정</DialogTitle>

          <form>
            <DialogContent>
              <br />
              이름 :{"   "}
              <TextField
                variant="outlined"
                required
                fullWidth
                id="rename"
                type="text"
                label="name"
                name="rename"
                value={rename}
                onChange={nameChange}
              />
              <br />
              <br />
              전화번호 :{"   "}
              <TextField
                variant="outlined"
                required
                fullWidth
                id="phone"
                type="text"
                label="phone"
                name="phone"
                value={phone}
               onChange={phoneChange}
              />
              <br />
              <br />
              주소 :{"   "}
              <TextField
                variant="outlined"
                required
                fullWidth
                id="address"
                label="address"
                type="text"
                name="address"
                value={address}
               onChange={addressChange}
              />
              <br />
              <br />
            </DialogContent>
            <DialogActions>
              <Button variant="outlined" color="primary" onClick={handleClose}>
                취소
              </Button>
              <Button
                type="submit"
                variant="contained"
                color="secondary"
                onClick={handleInfoClick}
              >
                수정하기
              </Button>
            </DialogActions>
          </form>
        </Dialog>
      </Grid>
    </div>
  );
};

export default MyProfile;
