import React, { Component } from 'react';
import { View,
    Text,
    StyleSheet } from 'react-native';
import { Button } from 'react-native-elements';
import { Actions } from 'react-native-router-flux';



export default class Auth extends Component  {
 Scen2() {
       Actions.startInt();
    }

       render() {
        return (
            <View>
                  <Button
                            icon={{ name: 'home', size: 20 }}
                            buttonStyle={{ backgroundColor: 'blue', borderRadius: 10, marginTop: 20 }}
                            textStyle={{ textAlign: 'center', color: 'white' }}
                            title={ 'Auth' }
                            onPress={ () => this.Scen2()}
                        />  
            </View>
        );
    }
}