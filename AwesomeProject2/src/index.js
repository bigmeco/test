import React, { Component } from 'react';
import { Router, Scene, Actions} from 'react-native-router-flux';


import Auth from './Auth';
import StartInt from './StartInt';

import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

export default class AwesomeProject2 extends Component {
  render() {
    return (
       <Router>
                <Scene key="root">
                    <Scene key="suth" component={ Auth } initial hideNavBar={ true } title="Auth" />
                    <Scene key="startInt" component={ StartInt } hideNavBar={ true } title="StartInt" />

                </Scene>
            </Router>
    );
  }
}

