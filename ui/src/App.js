import './App.css';
import {Route} from 'react-router-dom';
import Check from "./components/Check";
import axios from "axios";
import Login from "./components/Login";

function App() {

  return (
    <div className="App">
        <Route exact component={Check} path="/"/>
        <Route component={Login} path="/login"/>
    </div>
  );
}

export default App;
