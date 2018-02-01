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


class Info {
}

Info.schema = {
	name: 'Info',
	primaryKey: 'id',
	properties: {
		id: 'int',
		apiversion: 'string'
	}
};


class LogicalZigBeeDevices {
}

LogicalZigBeeDevices.schema = {
	name: 'LogicalZigBeeDevices',
	primaryKey: 'id',
	properties: {
		id: 'int',
		key: 'string',
		name: 'string'

	}
};


class ZigBeeHandler {
}

ZigBeeHandler.schema = {
	name: 'ZigBeeHandler',
	primaryKey: 'id',
	properties: {
		id: 'int',
		autoAdd: 'bool',
		duration: 'int',
		enableScan: 'bool',
		prospects: 'data',
		rejectUnknownDevices: 'bool'
	}
};


class DatapointLogicalDevice {
}

DatapointLogicalDevice.schema = {
	name: 'DatapointLogicalDevice',
	primaryKey: 'id',
	properties: {
		id: 'int',
		key: 'int',
		name: 'string',
		type: 'int',
		unit: 'string',
		access: 'string',
		value: 'int'
	}
};


class MultipleDatapoints {
}

MultipleDatapoints.schema = {
	name: 'MultipleDatapoints',
	primaryKey: 'id',
	properties: {
		id: 'int',
		type: 'int',
		path: 'string',
		status: 'int',
		progress: 'string',
		links: { type: 'list', objectType: 'Links' }
	}
};

class Links {
}

Links.schema = {
	name: 'Links',
	primaryKey: 'id',
	properties: {
		id: 'int',
		self: 'string'
	}
};

class Groups {
}

Groups.schema = {
	name: 'Groups',
	primaryKey: 'id',
	properties: {
		id: 'int',
		name: 'string'
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


class ScenesSogicalDevice {
}

ScenesSogicalDevice.schema = {
	name: 'ScenesSogicalDevice',
	primaryKey: 'id',
	properties: {
		id: 'int',
		name: 'string',
		transitionTime: 'int'
	}
};



class RuleCollections {
}

RuleCollections.schema = {
	name: 'RuleCollections',
	primaryKey: 'id',
	properties: {
		id: 'int',
		enabled: 'bool',
		name: 'string',
		metadata: 'string?'
	}
};



export default new Realm({
	schema: [
		URL,
		ZigBeeDevices,
		Info,
		ZigBeeHandler,
		LogicalZigBeeDevices,
		DatapointLogicalDevice,
		MultipleDatapoints,
		Links,
		Groups,
		ScenesSogicalDevice,
		RuleCollections,
	]
});
