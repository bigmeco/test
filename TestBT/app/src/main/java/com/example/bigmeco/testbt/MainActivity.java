package com.example.bigmeco.testbt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    final static int REQUEST_ENABLE_BT = 1;
    final static int CONEXAO = 2;
    String status;
    BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (bluetooth != null) {
            if (bluetooth.isEnabled()) {
                // Bluetooth включен. Работаем.
               String mydeviceaddress= bluetooth.getAddress();
               String mydevicename= bluetooth.getName();
//                status= mydevicename+" : "+ mydeviceaddress;
                String state= String.valueOf(bluetooth.getState());
                status= mydevicename+ " ;  "+ mydeviceaddress+" : "+ state;
                Set<BluetoothDevice> pairedDevices = bluetooth.getBondedDevices();

                if (pairedDevices.size() > 0) {
                    // There are paired devices. Get the name and address of each paired device.
                    for (BluetoothDevice device : pairedDevices) {
                        String  deviceName = device.getName();
                        String deviceHardwareAddress = device.getAddress(); // MAC address
                        System.out.println(deviceName+"  !!!!!!!!!!!!!!!!!!!!!!!!");

                    }
                }

            } else {
                // Bluetooth выключен. Предложим пользователю включить его.
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
       // Toast.makeText(this, status, Toast.LENGTH_LONG).show();
            registerReceiver(discoveryMonitor, new IntentFilter(dStarted));
    }
    String dStarted = BluetoothAdapter.ACTION_DISCOVERY_STARTED;
    String dFinished = BluetoothAdapter.ACTION_DISCOVERY_FINISHED;
    BroadcastReceiver discoveryMonitor;
    @Override
    protected void onStart() {
        super.onStart();
//        Intent List = new Intent(MainActivity.this,Main2Activity.class);
//        startActivityForResult(List,CONEXAO);

        String aDiscoverable = BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE;
        startActivityForResult(new Intent(aDiscoverable),
                0);
         discoveryMonitor = new BroadcastReceiver() {


            @Override
            public void onReceive(Context context, Intent intent) {
                if (dStarted.equals(intent.getAction())) {
                    // Процесс обнаружения начался.
                    Toast.makeText(getApplicationContext(),
                            "Discovery Started...", Toast.LENGTH_SHORT).show();
                }
                else if (dFinished.equals(intent.getAction())) {
                    // Процесс обнаружения завершился.
                    Toast.makeText(getApplicationContext(),
                            "Discovery Completed...", Toast.LENGTH_SHORT).show();
                }
            }

        };



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();


        // Регистрируем BroadcastReceiver
       IntentFilter filter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(discoveryMonitor, new IntentFilter(dFinished));
//        registerReceiver(mReceiver, filter);// Не забудьте снять регистрацию в onDestroy

    }

}