import Realm from './RealmModels';

export default class LocalStorage {


    static getObjects(tableName) {
        return Realm.objects(tableName);
    }



    static deleteObjects(tableName) {
        const objects = this.getObjects(tableName);
        Realm.write(() => {
            Realm.delete(objects);
        });
    }



    static addObject(tableName, object) {
        return new Promise((resolve, reject) => {
            try {
                Realm.write(() => {
                    Realm.create(tableName, object, true);
                });
                resolve();
            } catch (error) {
                reject(error);
            }
        });
    }

    static addObjects(tableName, objects) {
        return new Promise((resolve, reject) => {
            try {
                Realm.write(() => {
                    objects.forEach(task => {
                        Realm.create(tableName, task, true);
                    });
                });
                resolve();
            } catch (error) {
                reject(error);
            }
        });
    }


}
