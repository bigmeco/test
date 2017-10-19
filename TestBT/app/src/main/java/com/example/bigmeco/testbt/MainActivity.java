package com.example.bigmeco.testbt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    final static int REQUEST_ENABLE_BT = 1;
    String status;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      
       // Toast.makeText(this, status, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Регистрируем BroadcastReceiver

    }

}