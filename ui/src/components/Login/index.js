import {useState} from "react";
import SignUpForm from "./SignUpForm";
import LoginForm from "./LoginForm";
import {Container} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import {makeStyles} from "@material-ui/core/styles";
import {useHistory} from "react-router";
import client from "../../lib/client";

const useStyles = makeStyles((theme) => ({
    root: {
        height: '100vh',
    },
    image: {
        backgroundColor: 'blue',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
    },
}));

function Login() {
    const history = useHistory();

    const classes = useStyles();
    const [type, setType] = useState('login');

    const changeType = (type) => {
        setType(type);
    }

    const onSignUpSubmit = (e) => {
        e.preventDefault();
        const data = {
            'email': e.target.email.value,
            'nickname': e.target.nickname.value,
            'password': e.target.password.value,
            'confirmPassword': e.target.confirmPassword.value,
        }
        if (!validatePassword(data)) {
            return false;
        }

        client.post(
            '/api/members',
                data,
            {
                headers: {
                    'content-type': 'application/json'
                },
                withCredentials: true
            }
        ).then((response) => {
            changeType('login');
        });
    }

    const onSignIn = (e) => {
        e.preventDefault();
        const data = {
            'email': e.target.email.value,
            'password': e.target.password.value,
        }

        client.post(
            '/api/login/token',
            data,
            {
                headers: {
                    'content-type': 'application/json'
                },
                withCredentials: true
            }
        ).then((response) => {
            console.log(response);
        });
    }

    function validatePassword(data) {
        if (data.password != data.confirmPassword) {
            alert("비밀번호를 다시 확인해 주시기 바랍니다.");
            return false;
        }
        return true;
    }

    return (
        <Container component="main" maxWidth="xs">
            <Grid item>
                {
                    type === 'login' ? (
                        <LoginForm
                            changeType={changeType}
                            onSignIn={onSignIn}
                        />
                    ) : (
                        <SignUpForm
                            changeType={changeType}
                            onSignUpSubmit={onSignUpSubmit}
                        />
                    )
                }
            </Grid>

        </Container>

    );
}

export default Login;

