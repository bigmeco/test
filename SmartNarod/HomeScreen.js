/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import React, {Component} from 'react';
import {ActivityIndicator, AppRegistry, NativeEventEmitter, NativeModules, View, WebView} from 'react-native';

const {TestManager} = NativeModules;
const testManagerEmitter = new NativeEventEmitter(TestManager);

export default class DeviseScreen extends Component<{}> {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            port: 0
        }
    }
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
        if (this.state.isLoading) {
            return (
                <View style={{flex: 1, paddingTop: 20}}>
                    <ActivityIndicator/>
                </View>
            );
        }

        var url = 'http://localhost:' + this.state.port + '/ssapi/zb'
        return (
            <View style={{flex: 1, paddingTop: 20}}>
                <WebView
                    source={{uri: url}}
                    style={{marginTop: 20}}
                /> //Мы continue
            </View>
        );

    }
}
AppRegistry.registerComponent('SmartNarod', () => DeviseScreen);
