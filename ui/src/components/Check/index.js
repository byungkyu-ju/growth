import {Button} from "@material-ui/core";
import axios from 'axios';
import {useEffect} from "react";
function Check(){

    useEffect(() => {
        axios.get('/api/member').then((response) => {
            console.log(response);
        })
    },[])

    return (
        <div className="Check">
            <div>
                call member
            </div>
        </div>
    );
}

export default Check;