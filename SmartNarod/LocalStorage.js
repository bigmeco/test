import realm from './RealmModels';

export default class LocalStorage {


	static getObjects(tableName) {
		return realm.objects(tableName);
	}


	static deleteObjects(tableName) {
		const objects = this.getObjects(tableName);
		realm.write(() => {
			realm.delete(objects);
		});
	}


	static addObject(tableName, object) {
		return new Promise((resolve, reject) => {
			try {
				realm.write(() => {
					realm.create(tableName, object, true);
				});
				resolve();
			} catch (error) {
				reject(error);
			}
		});
	}


}


export function getObject(tableName) {
	return realm.objects(tableName);
}



export function addZigBeeDevices( objects,callback) {

	return new Promise((resolve, reject) => {
		try {
			realm.write(() => {
				let i = 0;
				objects.forEach(task => {
					if (task === undefined) {
					}
					realm.create('ZigBeeDevices', {
						id: i,
						defaultName: task.defaultName,
						discovered: task.discovered,
						eui: task.eui,
						idD: task.id,
						name: task.name,
						online: task.online,
						templateHash: task.templateHash
					}, true);
					i++;
				});
			});
			resolve();
			callback();
		} catch (error) {
			console.error(error);
			reject(error);

		}
	});
}

export function addUrl(objects,callback) {

	return new Promise((resolve, reject) => {
		try {
			realm.write(() => {
				realm.create('URL', {id: 0, url: objects}, true);
			});
			resolve();
			callback();
		} catch (error) {
			console.error(error);
			reject(error);

		}
	});
}