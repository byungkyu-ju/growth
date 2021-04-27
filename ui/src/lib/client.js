import axios from 'axios';

const client = axios.create();

client.interceptors.response.use(
    response => {
        return response;
    },
    error => {
        const response = error.response;
        alert(response.data.message);
        return Promise.reject(error);
    }
);

export default client;