import {RestApi} from './RestApi';
import {TCPApi} from './TCPApi';


export class ControlStation {

	static refreshZigBeeDevices(callback) {
		return RestApi.refreshZigBeeDevices(callback);
	}

	static getNewPort(callback) {
		return TCPApi.getNewPort(callback);
	}


}

//
// RestApi;
// WSApi;
// RPCApi;
//
// function refreshZigBeeDevices(this) {
// 	RestApi.getDevices().then(...);
// }
