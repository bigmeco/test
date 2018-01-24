/**
 * Created by bigi on 24.01.2018.
 */
import React from 'react';
import index from './HomeScreen';
import {Drawer, Router, Scene} from 'react-native-router-flux';
import DrawerContent from "./DrawerContent";
import DeviseScreen from "./DeviseScreen";

const App = () => {
    return (
        <Router>
            <Scene key="root">

                <Drawer
                    hideNavBar
                    key="drawer"
                    contentComponent={DrawerContent}
                    drawerWidth={300}
                >
                    {<Scene key="home" component={ index } title="ggg" initial/>}
                    <Scene key="setting" component={ DeviseScreen } title="Tab #4"  />

                </Drawer>
            </Scene>

        </Router>
    );
};

export default App;