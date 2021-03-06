import Realm from 'realm';


class URL {
}

URL.schema = {
	name: 'URL',
	primaryKey: 'id',
	properties: {
		id: 'int',
		url: 'string'
	}
};

class ZigBeeDevices {
}

ZigBeeDevices.schema = {
	name: 'ZigBeeDevices',
	primaryKey: 'id',
	properties: {
		defaultName: 'string',
		discovered: 'bool',
		eui: 'string',
		id: 'int',
		name: 'string',
		online: 'bool',
		templateHash: 'string?'
	}
};

export default new Realm({
	schema: [
		URL,
		ZigBeeDevices
	]
});
