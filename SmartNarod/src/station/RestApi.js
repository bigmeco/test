import {LocalStorage} from '../storage/LocalStorage';


export class RestApi {

	static refreshZigBeeDevices(callback) {
		return fetch(LocalStorage.getPort() + '/ssapi/zb/dev')
			.then((response) => response.json())
			.then((responseJson) => {
				console.log(responseJson);
				LocalStorage.upsertZigBeeDevices(responseJson, callback);
			})
			.catch((error) => {
				console.error(error);
			});
	}
}


// export function upsertZigBeeDevicesJson(state) {
//
// 	return fetch(url+'/ssapi/zb/dev')
// 		.then((response) => response.json())
// 		.then((responseJson) => {
// 			console.log(responseJson);
// 			upsertZigBeeDevices( responseJson, () => {
// 				state.setState({
// 					isLoading: false,
// 				}, function () {
// 				});
// 			});
//
// 		})
// 		.catch((error) => {
// 			console.error(error);
// 		});
// }

