/**
 * Created by bigi on 24.01.2018.
 */


import React, {Component} from "react";
import realm from './RealmModels';
import { NativeEventEmitter, NativeModules, StyleSheet, WebView} from "react-native";
import {
	ActionSheet,
	Body,
	Button,
	Card,
	CardItem,
	Container,
	Content,
	Drawer,
	Footer,
	FooterTab,
	List,
	Root,
	Text,
	View
} from "native-base";

const {TestManager} = NativeModules;
const testManagerEmitter = new NativeEventEmitter(TestManager);

export default class HomeScreen extends Component<{}> {
	constructor(props) {
		super(props);
		this.state = {
			realm: null,
			isLoading: true,
			port: 0
		};

	}


	// componentDidMount() {
	// 	const subscription = testManagerEmitter.addListener(
	// 		'EventReminder',
	// 		(reminder) => {
	// 			console.log(reminder.name)
	//
	// 			this.setState({
	// 				isLoading: false,
	// 				port: reminder.name
	// 			}, function () {
	// 				// do something with new state
	// 			});
	// 		}
	// 	);
	// 	TestManager.addEvent('Test Event', 'Test Data');
	// }


	render() {
		let url = 'http://localhost:' + realm.objects('URL')[0].url + '/ssapi/zb/dev';
		let tr;
getMoviesFromApiAsync(url);

		let items = realm.objects('ZigBeeDevices');
		return (
			<Container>

				<Text>
					{url}
				</Text>
				<List dataArray={items}
					  renderRow={(item) =>
						  <Card>
							  <CardItem>
								  <Body>

								  <Text>
									  {
										  item.name + '  ' +
										  '  ' + item.templateHash
									  }
								  </Text>

								  </Body>
							  </CardItem>
						  </Card>
					  }>
				</List>
			</Container>
		);
	}
}

function getMoviesFromApiAsync(url) {
	return fetch(url)
		.then((response) => response.json())
		.then((responseJson) => {
			console.log(responseJson);

			parseArray(	responseJson);

			return responseJson;
		})
		.catch((error) => {
			console.error(error);
		});
}

function parseArray(arr) {
	let newArr = [];
	for (let i = 0; i < arr.length; i++) {
		if(arr[i]===undefined) {}
			try {
				realm.write(() => {
					realm.create('ZigBeeDevices', {
						id: i ,
						defaultName: arr[i].defaultName,
						discovered: arr[i].discovered,
						eui: arr[i].eui,
						idD: arr[i].id,
						name: arr[i].name,
						online: arr[i].online,
						templateHash: arr[i].templateHash
					}, true);
				});
			} catch (error) {
				console.error(error);
			}

		console.log(realm.objects('ZigBeeDevices')[i])
	}

	function notNull(param) {
		if(param===undefined){
			return 'undefined';
		}
		return param;
	}



	return newArr;
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		justifyContent: 'center',
		alignItems: 'center',
		backgroundColor: '#F5FCFF',
	},
	welcome: {
		fontSize: 20,
		textAlign: 'center',
		margin: 10,
	},
	instructions: {
		textAlign: 'center',
		color: '#333333',
		marginBottom: 5,
	},
});
