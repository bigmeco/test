import React from 'react';
import PropTypes from 'prop-types';
import {ListView, Text,} from 'react-native';

import {ActionSheet, Body, Button, Card, CardItem, Content, H1, H2, H3, Icon, Left, List, ListItem} from 'native-base';
import {Actions} from 'react-native-router-flux';


class DrawerContent extends React.Component {
	constructor() {
		super();
		const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
		this.state = {
			dataSource: ds.cloneWithRows(['Устройство 1', '+']),
		};
	}

	static propTypes = {
		name: PropTypes.string,
		title: PropTypes.string,
	};

	static contextTypes = {
		drawer: PropTypes.object,
	};

	render() {
		const backgroundPhoto = require('../../resource/fonSN.png');
		return (
			<Content style={{backgroundColor: '#FFFFFF'}}>
				{/*<ImageBackground  source={backgroundPhoto}>*/}
				<H3 style={{padding: 16}}>Анотолий Петров</H3>
				<Text style={{paddingHorizontal: 16}}>Главный</Text>
				<ListView
					horizontal={true}
					style={{flex: 1, padding: 12}}
					dataSource={this.state.dataSource}
					renderRow={(rowData) =>
						<Card>
							<CardItem style={{ paddingRight: 16 }}>
								<Body>
								<Text>
									{rowData}
								</Text>
								</Body>
							</CardItem>
						</Card>}/>

				{/*</ImageBackground>*/}
				<List>
					<ListItem icon onPress={Actions.setting}>
						<Left>
							<Icon name="eye"/>
						</Left>
						<Body>
						<Text>Устройства</Text>
						</Body>
					</ListItem>
				</List>

			</Content>
		);
	}


}

export default DrawerContent;
