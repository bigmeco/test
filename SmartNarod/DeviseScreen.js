/**
 * Created by bigi on 24.01.2018.
 */


import React, {Component} from "react";
import realm from './RealmModels';
import {fetch, NativeEventEmitter, NativeModules, StyleSheet, WebView} from "react-native";
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

	//
	// componentWillMount() {
	//     Realm.open({
	//         schema: [{name: 'Dog', properties: {name: 'string'}}]
	//     }).then(realm => {
	//         realm.write(() => {
	//             realm.create('Dog', {name: 'Rex'});
	//         });
	//         this.setState({realm});
	//         realm.addListener('change', updateUI);
	//
	//     });
	// }

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
		let url = 'http://localhost:' + realm.objects('URL')[0].url + '/ssapi/zb';

		let items = ['Simon Mignolet', 'Nathaniel Clyne'];
		return (
			<Container>
				<Text>
					{/*{fetch(url)*/}
						{/*.then((response) => response.json())*/}
						{/*.then((responseJson) => {*/}
							{/*return responseJson.movies;*/}
						{/*})*/}
						{/*.catch((error) => {*/}
							{/*console.error(error);*/}
						{/*})*/}
					{/*}*/}
				</Text>
				<Text>
					{url}
				</Text>
				<List dataArray={items}
					  renderRow={(item) =>
						  <Card>
							  <CardItem>
								  <Body>



								  </Body>
							  </CardItem>
						  </Card>
					  }>
				</List>
			</Container>
		);
	}
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
