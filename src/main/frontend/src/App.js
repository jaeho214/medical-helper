import React from "react";
import { Route } from "react-router-dom";
import MainPage from "./pages/MainPage";
import MyHealthCheckMain from "./pages/myhealthcheck/MyHealthCheckMain";
import EmrSearchPage from "./pages/emrsearch/EmrSearchPage";
import LoginPage from "./login/LoginPage";
import RegisterPage from "./login/register/RegisterForm";

function App() {
  return (
    <div className="App">
      <Route path="/register" component={RegisterPage} />
      <Route path="/login" component={LoginPage} />
      <Route exact path="/" component={MainPage} /> {/*메인페이지*/}
      <Route exact path="/emrsearch" component={EmrSearchPage} />{" "}
      {/*응급실조회페이지 */}
      <Route exact path="/myhealthcheck" component={MyHealthCheckMain} />{" "}
      {/* 내건강관리페이지  */}
    </div>
  );
}

export default App;
