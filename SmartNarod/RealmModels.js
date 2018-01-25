import Realm from 'realm';

class URL {}
URL.schema = {
	name: 'URL',
	primaryKey: 'name',
	properties: {
		id: 'int',
		url: 'string'
	}

};

export default new Realm({ schema: [
	URL

] });
