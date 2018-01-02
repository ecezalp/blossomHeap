import React from 'react';

export default function Flower () {

	const testFunc = () => {
		return "I CHANGED!!!!";
	};

	return (
		<div id="flower-div">
			HAHAHAHHAHAHAH
			{testFunc()}
		</div>
	)
}