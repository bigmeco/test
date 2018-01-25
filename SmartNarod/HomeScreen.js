/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import React, {Component} from 'react';
import {ActivityIndicator, AppRegistry, NativeEventEmitter, NativeModules, View, WebView} from 'react-native';
import Realm from "realm";
import {Text} from "native-base";

const {TestManager} = NativeModules;
const testManagerEmitter = new NativeEventEmitter(TestManager);

class URL {}
URL.schema = {
	name: 'URL',
	primaryKey: 'id',
	properties: {
		id: 'int',
		url: 'string'
	}

};
const realm = new Realm({schema: [URL]});
export default class DeviseScreen extends Component<{}> {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
			realm: null,
            port: 0
        }
    }


    componentDidMount() {
        const subscription = testManagerEmitter.addListener(
            'EventReminder',
            (reminder) => {
                console.log(reminder.name)
				try {

					realm.write(() => {
						realm.create('URL',  {id: 0, url:reminder.name },true);
					});
				} catch (error) {
				}
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

        var url = 'http://localhost:' + realm.objects('URL')[0].url + '/ssapi/zb';
        return (
            <View style={{flex: 1, paddingTop: 20}}>
                <Text>
					{	url +'     i    '+url2
					}
                </Text>
                <WebView
                    source={{uri: url}}
                    style={{marginTop: 20}}
                />
            </View>
        );

    }
}
AppRegistry.registerComponent('SmartNarod', () => DeviseScreen);
