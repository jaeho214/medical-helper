import React, { Component } from 'react';
import {Header,Body,Footer} from "./layout";
import Grid from '@material-ui/core/Grid';



//내건강관리페이지의 메인홈페이지
class MyHealthCheckMain extends Component {
    render() {
        return (
            <div>
                    <Grid
                        container
                        item sm = {9} 
                        direction="column"
                        justify="space-between"
                        alignItems="stretch"
                        spacing={10}
                    >
                        <Grid item sm>
                            <Header />
                        </Grid>     


                        <Grid item sm>
                            <Body/>
                        </Grid>

                        <Grid item sm>
                            <Footer />
                        </Grid>
                    
                    </Grid>

            </div>
        );
    }
}

export default MyHealthCheckMain;