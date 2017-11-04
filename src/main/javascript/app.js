import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, BrowserRouter} from 'react-router-dom';
import Flower from './components/flower';

ReactDOM.render(
	<Router history={BrowserRouter}>
		<Route path="/" component={Flower}/>
	</Router>,
	document.getElementById('react')
);


// {/*<Route path="/:flowers" component={} />*/}