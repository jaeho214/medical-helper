import React, { useState, useEffect } from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import Axios from "axios";
import { useHistory } from "react-router-dom";

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
    marginTop: theme.spacing(1)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  }
}));

/***여기까지 스타일 속성이였읍니다. ***/

const LoginForm = () => {
  // 스타일 속성
  const classes = useStyles();
  let history = useHistory();

  // state 사용
  const [form, setForm] = useState({
    email: "",
    password: ""
  });

  const [isLogin, setIsLogin] = useState(false);

  const { email, password } = form;

  const onChange = e => {
    const nextForm = {
      ...form,
      [e.target.name]: e.target.value
    };
    setForm(nextForm);
  };

  const onClick = async e => {
    // 새로고침 방지
    e.preventDefault();

    // 데이터 푸쉬
    try {
      const response = await Axios.post(
        "medicalHelper/sign/signIn",
        {
          email,
          password
        },
        {
          headers: {
            "Content-type": "application/json"
          }
        }
      );
      const { status, data } = response;
      if (status === 200) {
        console.log(data);

        setIsLogin(true);

        // 토큰 저장
        var token = response.data.token;
        localStorage.setItem("token", token);
        localStorage.setItem("name", data.name);

        // 페이지 이동하는 부분 구현해야함.
      }
    } catch (error) {
      console.log(error);
    }
    // 초기화
    setForm({
      email: "",
      password: ""
    });
  };

  useEffect(() => {
    if (isLogin) {
      history.push("/myhealthcheck");
    }
  });

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}></Avatar>
        <Typography component="h1" variant="h5">
          Sign in
        </Typography>
        <form className={classes.form} noValidate>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="email"
            label="Email Address"
            name="email"
            autoComplete="email"
            value={email}
            onChange={onChange}
            autoFocus
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="password"
            label="Password"
            type="password"
            id="password"
            value={password}
            onChange={onChange}
          />
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
            onClick={onClick}
          >
            Sign In
          </Button>

          <Grid container>
            <Grid item>
              <Link href="/register">{"Don't have an account? SignUp"}</Link>
            </Grid>
          </Grid>
        </form>
      </div>
      <Box mt={8}></Box>
    </Container>
  );
};

export default LoginForm;
