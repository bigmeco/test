/**
 * Created by bigi on 23.01.2018.
 */
import React, { Component } from 'react';
import {
    Text,
} from 'react-native';

import {Button, Content,ActionSheet} from 'native-base';
import Drawer from "native-base/src/basic/Drawer/index";

export default class Sidebar extends Component {
    render() {
        return (
            <Content padder style={{backgroundColor:'#FFFFFF'}}>
                    <Button
                    >
                        <Text>Actionsheet</Text>
                    </Button>

            </Content>
        );
    }
}

