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
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(1),
    },
    submit: {
        marginTop: theme.spacing(3),
        backgroundColor: '#4BB2B2'
    },
    cancel: {
        marginTop: theme.spacing(2),
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

const SignUpForm = ({changeType, onSignUpSubmit}) => {
    const classes = useStyles();

    return (
        <Grid container justify="center">
            <Card className={classes.card}>
                <div className={classes.details}>
                    <CardContent>
                        <Typography component="h1" variant="h5" className={classes.headTypo}>
                            Sign Up
                        </Typography>
                        <form className={classes.form} noValidate onSubmit={onSignUpSubmit}>
                            <TextField
                                variant="outlined"
                                margin="normal"
                                required
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
                                id="nickname"
                                label="NickName"
                                name="nickname"
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
                            <TextField
                                variant="outlined"
                                margin="normal"
                                required
                                fullWidth
                                name="confirmPassword"
                                label="Confirm Password"
                                type="password"
                                id="confirmPassword"
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary"
                                className={classes.submit}
                            >
                                Sign Up
                            </Button>
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary"
                                className={classes.cancel}
                                onClick={() => changeType('login')}
                            >
                                Cancel
                            </Button>
                        </form>
                    </CardContent>
                </div>
            </Card>
        </Grid>
    );
}

export default SignUpForm;