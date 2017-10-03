package com.example.bigmeco.testbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    final static int REQUEST_ENABLE_BT = 1;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
        if (bluetooth != null) {
            if (bluetooth.isEnabled()) {
                // Bluetooth включен. Работаем.
                String mydeviceaddress= bluetooth.getAddress();
                String mydevicename= bluetooth.getName();
                status= mydevicename+" : "+ mydeviceaddress;

            } else {
                // Bluetooth выключен. Предложим пользователю включить его.
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
        Toast.makeText(this, status, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, status, Toast.LENGTH_LONG).show();
    }
}