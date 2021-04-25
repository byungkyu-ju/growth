import {Button} from "@material-ui/core";
import axios from 'axios';
function Check(){

    const findMember = () => {
        axios.get('/api/member').then((response) => {
            console.log(response);
        })
    }
    return (
        <div className="Check">
            <div>
                <Button
                    onClick={findMember}
                >
                    call member
                </Button>
            </div>
        </div>
    );
}

export default Check;