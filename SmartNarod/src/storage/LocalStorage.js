import realm from './RealmModels';

export class LocalStorage {


	static getObjects(tableName) {
		return realm.objects(tableName);
	}
	static getZigBeeDevices() {
		return realm.objects('ZigBeeDevices');
	}

	static getPort() {
		return realm.objects('URL')[0].url;
	}

	// static deleteObjects(tableName) {
	// 	const objects = this.getObjects(tableName);
	// 	realm.write(() => {
	// 		realm.delete(objects);
	// 	});
	// }
	//
	//
	// static addObject(tableName, object) {
	// 	return new Promise((resolve, reject) => {
	// 		try {
	// 			realm.write(() => {
	// 				realm.create(tableName, object, true);
	// 			});
	// 			resolve();
	// 		} catch (error) {
	// 			reject(error);
	// 		}
	// 	});
	// }

	static savePort(objects, callback) {
		return new Promise((resolve, reject) => {
			try {
				realm.write(() => {
					realm.create('URL', {id: 0, url: 'http://localhost:' + objects}, true);
				});
				resolve();
				if (callback && typeof(callback) === "function") {
					callback();
				}
			} catch (error) {
				console.error(error);
				reject(error);
			}
		});
	}
	

	static upsertZigBeeDevices(devices, callback) {
		return new Promise((resolve, reject) => {
			try {
				realm.write(() => {
					devices.forEach(device => {
						if (device === undefined) {}
						realm.create('ZigBeeDevices', {
							defaultName:  device.defaultName,
							discovered:   device.discovered,
							eui:          device.eui,
							id:           device.id,
							name:         device.name,
							online:       device.online,
							templateHash: device.templateHash
						}, true);
					});
				});
				resolve();
				if (callback && typeof(callback) === "function") {
					callback();
				}
			} catch (error) {
				console.error(error);
				reject(error);
			}
		});
	}

}


