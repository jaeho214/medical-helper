import clsx from "clsx";
import CssBaseline from "@material-ui/core/CssBaseline";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Grid from "@material-ui/core/Grid";
import Link from "@material-ui/core/Link";
import Button from "@material-ui/core/Button";
import useStyles from "../style/useStyles";

import React, { useState } from 'react';

//data -> LoginPage에서 넘어오는 개인정보 중 name

const Header = () => {
  const classes = useStyles.bind();

  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
  const [data, setData] = useState("");

  

  const handleLogout= () => {
    //로그인페이지로 이동

    console.log("click logout");
    localStorage.clear();
  }

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar
        position="absolute"
        className={clsx(classes.appBar, classes.appBarShift)}
      >
        <Toolbar className={classes.toolbar}>
          <Grid item xs={10}>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              className={classes.title}
            >
              내 건강관리
            </Typography>
          </Grid>
          <Grid itme xs={2}>
            {"안녕하세요, "+localStorage.getItem("name")+"님"}
          </Grid>
          <Grid itme xs={1}>
            <Link href="/" color="inherit"> 
              <Button variant="contained" color="secondary" onClick={handleLogout}>로그아웃</Button>
              </Link>
          </Grid>
          
        </Toolbar>
      </AppBar>
    </div>
  );
};
export default Header;