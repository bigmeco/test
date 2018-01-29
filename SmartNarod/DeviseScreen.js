/**
 * Created by bigi on 24.01.2018.
 */


import React, {Component} from "react";
import realm from './RealmModels';
import {ActivityIndicator} from "react-native";
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
import {getMoviesFromApiAsync} from "./RestModels";
import {getObject} from "./LocalStorage";


let set;
export default class HomeScreen extends Component<{}> {
	constructor(props) {
		super(props);
		this.state = {
			realm: null,
			isLoading: true,
			port: 0,
			rediploi: 0
		};

	}


	componentWillMount() {
		set = this;
	}

	render() {
		let url = 'http://localhost:' + realm.objects('URL')[0].url + '/ssapi/zb/dev';
		let items = getObject('ZigBeeDevices');

		if (this.state.isLoading) {
			getMoviesFromApiAsync(url, set);
			return (
				<Container style={{flex: 1, paddingTop: 20}}>
					<ActivityIndicator/>
				</Container>
			);
		}
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



