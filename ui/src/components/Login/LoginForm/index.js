import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import {makeStyles} from '@material-ui/core/styles';
import {Card, CardContent} from "@material-ui/core";


const useStyles = makeStyles((theme) => ({
    card: {
        marginTop: theme.spacing(50),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        opacity: '0.9'
    },
    details: {
        display: 'flex',
        flexDirection: 'column',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(1),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
        backgroundColor: '#4BB2B2'
    },
    headTypo: {
        color: '#4BB2B2',
        fontWeight: '600'
    },
    textTypo: {
        color: '#4BB2B2',
    }
}));

const LoginForm = ({changeType, onSignIn}) => {
    const classes = useStyles();

    return (
        <Grid container justify="center">
            <Card className={classes.card}>
                <div className={classes.details}>
                    <CardContent>
                        <Typography component="h1" variant="h5" className={classes.headTypo}>
                            Please Login
                        </Typography>
                        <form className={classes.form} noValidate onSubmit={onSignIn}>
                            <TextField
                                variant="outlined"
                                margin="normal"
                                fullWidth
                                id="email"
                                label="Email Address"
                                name="email"
                                autoComplete="email"
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
                                autoComplete="current-password"
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary"
                                className={classes.submit}
                                onSubmit={onSignIn}
                            >
                                LogIn
                            </Button>
                            <Grid container justify="space-between">
                                <Grid item>
                                    <Link href="#" onClick={() => changeType('signUp')} variant="body2"
                                          className={classes.textTypo}>
                                        {"Don't have an account? Sign Up"}
                                    </Link>
                                </Grid>
                                <Grid item>
                                    <Link href="/chat" variant="body2" className={classes.textTypo}>
                                        Direct View
                                    </Link>
                                </Grid>
                            </Grid>
                        </form>
                    </CardContent>
                </div>
            </Card>
        </Grid>
    );
}

export default LoginForm;