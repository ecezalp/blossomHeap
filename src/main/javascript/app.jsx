import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import "../styles/main.scss";

import NavBar from "./components/navbar.jsx";
import Flower from "./components/flower.jsx"
import Garden from "./components/garden.jsx";
import NotFound from "./components/notFound.jsx";

export default function App () {
  return <BrowserRouter>
    <div>
      {NavBar()}
      <Switch>
        <Route exact path="/" component={Flower}/>
        <Route path="/garden" component={Garden}/>
        <Route component={NotFound}/>
      </Switch>
    </div>
  </BrowserRouter>
};