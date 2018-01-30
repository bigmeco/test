import {NativeEventEmitter, NativeModules} from 'react-native';
import {LocalStorage} from "../storage/LocalStorage";

const {NabtoManager} = NativeModules;
const NabtoManagerEmitter = new NativeEventEmitter(NabtoManager);

export class TCPApi {

	static getNewPort(callback) {
		const subscription = NabtoManagerEmitter.addListener(
			'EventReminder',
			(answer) => {
				console.log(answer.port);
				LocalStorage.savePort(answer.port, callback);
			}
		);
		NabtoManager.addEvent('Event', 'Data');
	}
}
