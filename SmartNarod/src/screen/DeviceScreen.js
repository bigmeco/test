/**
 * Created by bigi on 24.01.2018.
 */


import React, {Component} from "react";
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
import {LocalStorage} from "../storage/LocalStorage";
import {ControlStation} from "../station/ControlStation";


export default class DeviceScreen extends Component<{}> {
	constructor(props) {
		super(props);
		this.state = {
			realm: null,
			isLoading: true,
			port: 0
		};
	}

	render() {
		let items = LocalStorage.getZigBeeDevices();

		if (this.state.isLoading) {
			ControlStation.refreshZigBeeDevices(() => {
				this.setState({
					isLoading: false,
				}, function () {
				});
			});
			return (
				<Container style={{flex: 1, paddingTop: 20}}>
					<ActivityIndicator/>
				</Container>
			);
		}
		return (
			<Container>
				<List dataArray={items}
					  renderRow={(item) =>
						  <Card>
							  <CardItem>
								  <Body>
								  <Text>
									  {'Имя: ' + item.name}
								  </Text>
								  <Text>
									  {item.eui}
								  </Text>
								  <Text>
									  {'Онлайн: ' + item.online.toString()}
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



