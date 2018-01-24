/**
 * Created by bigi on 24.01.2018.
 */


import React, {Component} from "react";
import Realm from "realm";
import {Alert, StyleSheet} from "react-native";
import {
    Button, Container, Content, Drawer, Footer, FooterTab, Text, ActionSheet, View, Root, List,
    Card, CardItem, Body
} from "native-base";


export default class HomeScreen extends Component<{}> {
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


    render() {
        let items = ['Simon Mignolet','Nathaniel Clyne','Dejan Lovren','Mama Sakho','Emre Can'];

        return (
                <Container>
                    <List dataArray={items}
                          renderRow={(item) =>
                              <Card>
                                  <CardItem>
                                      <Body>
                                      <Text>
                                          {items}
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
