import React from 'react';
import {Link} from 'react-router-dom';

export default function NavBar() {
	return (<ul className="navbar">
		<li><Link to="/">Home (Component = Flower)</Link></li>
		<li><Link to="/garden">Garden (Component Garden)</Link></li>
	</ul>)
}