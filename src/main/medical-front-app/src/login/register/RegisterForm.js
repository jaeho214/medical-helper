import React, { useState } from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import Axios from "axios";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";

const useStyles = makeStyles(theme => ({
  paper: {
    marginTop: theme.spacing(8),
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(3)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  }
}));

const RegisterForm = () => {
  // 간단한 회원가입 구현
  const [form, setForm] = useState({
    email: "",
    password: "",
    name: "",
    birth: "",
    sex: {
      male: "남",
      female: "여"
    },
    phone: "",
    address: ""
  });

  const { email, password, name, birth, phone, address, sex } = form;

  const onChange = e => {
    const nextForm = {
      ...form, // 기존의 form 내용을 이 자리에 복사 한 뒤
      [e.target.name]: e.target.value // 원하는 값을 덮어씌우기
    };
    setForm(nextForm);
  };

  // button클릭시 이벤트 발생
  const onClick = async e => {
    // 새로고침방지
    e.preventDefault();

    // 비어있는 정보가 있는지 확인
    if (email === "") alert("이메일을 입력하세요");

    // 데이터 서버에 전송하는 내용
    try {
      const response = await Axios.post(
        "/medicalHelper/sign/signUp",
        {
          email,
          password,
          name,
          birth,
          phone,
          address,
          sex
        },
        {
          headers: {
            "Content-type": "application/json"
          }
        }
      );
      alert("회원가입이 완료되었습니다. 로그인페이지로 가서 로그인하세요");
    } catch (error) {
      alert(error);
      console.log(error);
    }

    // 폼 초기화
    setForm({
      email: "",
      password: "",
      name: "",
      birth: "",
      phone: "",
      address: "",
      sex: {
        male: "남",
        female: "여"
      }
    });
  };

  // 스타일 속성 설정
  const classes = useStyles();

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}></Avatar>
        <Typography component="h1" variant="h5">
          Sign up
        </Typography>
        <form className={classes.form} noValidate>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                value={email}
                onChange={onChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                value={password}
                onChange={onChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="name"
                label="fullName"
                name="name"
                autoComplete="name"
                value={name}
                onChange={onChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="phone"
                type="text"
                label="phone"
                name="phone"
                value={phone}
                onChange={onChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="address"
                label="address"
                type="text"
                name="address"
                value={address}
                onChange={onChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="birth"
                type="date"
                defaultValue="1990-01-01"
                name="birth"
                value={birth}
                onChange={onChange}
              />
            </Grid>
            성 별: 남
            <input
              type="radio"
              value={sex.male}
              onChange={onChange}
              name="sex"
            />
            여
            <input
              type="radio"
              value={sex.female}
              onChange={onChange}
              name="sex"
            />{" "}
            <br />
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
            onClick={onClick}
          >
            Sign Up
          </Button>
          <Grid container justify="flex-end">
            <Grid item>
              <Link href="/login">{"Don't have an account? SignIn"}</Link>
            </Grid>
          </Grid>
        </form>
      </div>
      <Box mt={5}></Box>
    </Container>
  );
};

export default RegisterForm;
