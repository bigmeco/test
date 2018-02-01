import React from 'react';
import index from './src/screen/HomeScreen';
import {Drawer, Router, Scene} from 'react-native-router-flux';
import DrawerContent from "./src/screen/components/DrawerContent";
import DeviceScreen from "./src/screen/DeviceScreen";

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
					{
						<Scene
							key="home"
							component={index}
							title="Главная" initial
						/>
					}
					<Scene
						key="setting"
						component={DeviceScreen}
						title="Устройство"
					/>
				</Drawer>
			</Scene>
		</Router>
	);
};

export default App;