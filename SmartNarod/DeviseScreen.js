/**
 * Created by bigi on 24.01.2018.
 */


import React, {Component} from "react";
import Realm from "realm";
import {Alert, StyleSheet, NativeModules, NativeEventEmitter, WebView} from "react-native";
import {
    Button, Container, Content, Drawer, Footer, FooterTab, Text, ActionSheet, View, Root, List,
    Card, CardItem, Body
} from "native-base";
const {TestManager} = NativeModules;
const testManagerEmitter = new NativeEventEmitter(TestManager);

export default class HomeScreen extends Component<{}> {
    constructor(props) {
        super(props);
        this.state = {realm: null,
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

    componentDidMount() {
        const subscription = testManagerEmitter.addListener(
            'EventReminder',
            (reminder) => {
                console.log(reminder.name)

                this.setState({
                    isLoading: false,
                    port: reminder.name
                }, function () {
                    // do something with new state
                });
            }
        );
        TestManager.addEvent('Test Event', 'Test Data');
    }


    render() {
        let items = ['Simon Mignolet','Nathaniel Clyne','Dejan Lovren','Mama Sakho','Emre Can'];
        let url = 'http://localhost:' + this.state.port + '/ssapi/zb';
        return (
                <Container>
                    <List dataArray={items}
                          renderRow={(item) =>
                              <Card>
                                  <CardItem>
                                      <Body>
                                      <Text>
										  {	url
										  }
                                      </Text>  <Text>
                                          {	url
                                          }
                                      </Text>
                                      <WebView
                                          source={{uri: url}}
                                          style={{marginTop: 20}}
                                      />
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
