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
    }

    @Override
    protected void onStart() {
        super.onStart();
       // Toast.makeText(this, status, Toast.LENGTH_LONG).show();
        BroadcastReceiver discoveryResult = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String remoteDeviceName =
                        intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
                BluetoothDevice remoteDevice;
                remoteDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                Toast.makeText(getApplicationContext(),
                        "Discovered: " + remoteDeviceName,
                        Toast.LENGTH_SHORT).show();
                // TODO Сделать что-нибудь с объектом BluetoothDevice.
            }
        };

        registerReceiver(discoveryResult, new IntentFilter(BluetoothDevice.ACTION_FOUND));
        if (!bluetooth.isDiscovering())
            bluetooth.startDiscovery();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Регистрируем BroadcastReceiver

    }

}