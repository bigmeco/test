import React, {Component} from 'react';
import {ActivityIndicator, AppRegistry, View, WebView} from 'react-native';
import {ControlStation} from "../station/ControlStation";
import {LocalStorage} from "../storage/LocalStorage";


export default class HomeScreen extends Component<{}> {
	constructor(props) {
		super(props);
		this.state = {
			isLoading: true,
			realm: null,
			port: 0
		}
	}

	componentDidMount() {
		ControlStation.getNewPort(() => {
			this.setState({
				isLoading: false,
			}, function () {
			});
		});
	}


	render() {
		if (this.state.isLoading) {
			return (
				<View style={{flex: 1, paddingTop: 20}}>
					<ActivityIndicator/>
				</View>
			);
		}

		return (
			<View style={{flex: 1}}>
				<WebView
					source={{uri: LocalStorage.getPort() + '/api-docs'}}
				/>
			</View>
		);

	}
}
AppRegistry.registerComponent('SmartNarod', () => HomeScreen);
