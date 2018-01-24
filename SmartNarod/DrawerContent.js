import React from 'react';
import PropTypes from 'prop-types';
import {
    ListView,
    Text,
} from 'react-native';

import {Button, Content, ActionSheet, List, ListItem, CardItem, Body, Card, H1, H2, H3, Left, Icon} from 'native-base';
import { Actions } from 'react-native-router-flux';



class DrawerContent extends React.Component {
    constructor() {
        super();
        const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
        this.state = {
            dataSource: ds.cloneWithRows(['row 1', 'row 2', 'row 3']),
        };
    }
  static propTypes = {
    name: PropTypes.string,
    title: PropTypes.string,
  }

  static contextTypes = {
    drawer: PropTypes.object,
  }

  render() {
    return (
        <Content  style={{backgroundColor: '#FFFFFF'}}>
            <H1 style={{ paddingLeft: 12}}>Header One</H1>
            <H3 style={{ paddingLeft: 12}}>Header Two</H3>
            <ListView
                horizontal={true}
                style={{flex: 1, padding: 12}}
                dataSource={this.state.dataSource}
                renderRow={(rowData) =>
                    <Card>
                        <CardItem>
                            <Body>
                            <Text>
                                {rowData}
                            </Text>
                            </Body>
                        </CardItem>
                    </Card>}/>
            <List>
                <ListItem icon onPress={Actions.setting} >
                    <Left>
                        <Icon name="plane" />
                    </Left>
                    <Body>
                    <Text>Устройства</Text>
                    </Body>

                </ListItem>
                <ListItem icon  onPress={Actions.index}>
                    <Left>
                        <Icon name="plane" />
                    </Left>
                    <Body>
                    <Text>Back</Text>
                    </Body>

                </ListItem>
            </List>

        </Content>
    );
  }
}

export default DrawerContent;
