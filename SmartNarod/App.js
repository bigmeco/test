/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from "react";
import Realm from "realm";
import {Alert, StyleSheet} from "react-native";
import {Button, Container, Content, Drawer, Footer, FooterTab, Text, ActionSheet, View, Root} from "native-base";

import AppHeader from './AppHeader';


import Sidebar from './sidebar';
export default class App extends Component<{}> {
    constructor(props) {
        super(props);
        this.state = {realm: null};

    }


    componentWillMount() {
        Realm.open({
            schema: [{name: 'Dog', properties: {name: 'string'}}]
        }).then(realm => {
            realm.write(() => {
                realm.create('Dog', {name: 'Rex'});
            });
            this.setState({realm});
            realm.addListener('change', updateUI);

        });
    }

    componentWillMountq() {
        Realm.open({
            schema: [{name: 'Dog', properties: {name: 'string'}}]
        }).then(realm => {
            realm.write(() => {
                realm.create('Dog', {name: 'Rex'});
            });
            realm.addListener('change', updateUI);

        });
    }

    closeDrawer = () => {
        this.drawer._root.close()
    };
    openDrawer = () => {
        this.drawer._root.open()
    };
    render() {
        return (
            <Root>
            <Container>
                <Drawer
                    ref={(ref) => { this.drawer = ref; }}
                    content={<Sidebar/>}
                    onClose={() => this.closeDrawer()} >

                    <AppHeader
                        openDrawer={this.openDrawer.bind(this)}
                    />
                </Drawer>

        </Container>
            </Root>
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
