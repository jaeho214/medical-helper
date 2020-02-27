import React, { Component } from "react";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import { Container, Grid, Box } from "@material-ui/core";

import useStyles from "../style/useStyles";

class footer extends Component {
    render() {
        const classes = useStyles.bind();

        return (
            <div>
                <main className={classes.content}>
                    <div className={classes.appBarSpacer} />
                    <Container maxWidth="lg" className={classes.container}>
                    <Grid container spacing={3}></Grid>
                    <Box pt={4}></Box>

                    <Typography variant="body2" color="textSecondary" align="center">
                        {"Copyright © "}
                        <Link color="inherit" href="https://material-ui.com/">
                            Your Website
                        </Link>{" "}
                        {new Date().getFullYear()}
                        {"."}
                    </Typography>
                    </Container>
                </main>
            </div>
        );
    }
}

export default footer;
