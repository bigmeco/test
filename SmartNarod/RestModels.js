import {addZigBeeDevices} from './LocalStorage';


export function getMoviesFromApiAsync(url,state) {
	return fetch(url)
		.then((response) => response.json())
		.then((responseJson) => {
			console.log(responseJson);
			addZigBeeDevices( responseJson, () => {
				state.setState({
					isLoading: false,
				}, function () {
				});
				console.log('rediploi')
			});

		})
		.catch((error) => {
			console.error(error);
		});
}
