import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Switch, Link} from 'react-router-dom';

import NavBar from "./components/navbar.jsx";
import Flower from "./components/flower.jsx"
import Garden from "./components/garden.jsx";
import NotFound from "./components/notFound.jsx";

const Root = () => (
	<BrowserRouter>
		<div>
			{NavBar()}
			<Switch>
				<Route exact path="/" component={Flower}/>
				<Route path="/garden" component={Garden}/>
				<Route component={NotFound}/>
			</Switch>
		</div>
	</BrowserRouter>
);


ReactDOM.render(
	<Root/>,
	document.getElementById('react')
);


// // {/*<Route path="/:flowers" component={} />*/}
// <Route exact path="/flower" component={Flower}/>