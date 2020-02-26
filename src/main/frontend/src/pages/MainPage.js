import React from "react";
import { Button } from "@material-ui/core";
import { Route, Link } from "react-router-dom";
import EmrSearchPage from "./emrsearch/EmrSearchPage";

const MainPage = () => {
  return (
    <div>
      <div>
        <Link to="/emrsearch">
          <Button
            variant="contained"
            color="secondary"
            fullWidth="true"
            style={{ height: 500, fontSize: 50 }}
          >
            응급실 조회
          </Button>
        </Link>
      </div>

      <div>
        <Link to="/login">
          <Button
            variant="contained"
            color="primary"
            fullWidth="true"
            style={{ height: 500, fontSize: 50 }}
          >
            내 건강관리
          </Button>
        </Link>
      </div>
    </div>
  );
};

export default MainPage;
