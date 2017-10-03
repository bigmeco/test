package com.example.bigmeco.testbt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

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
       // Toast.makeText(this, status, Toast.LENGTH_LONG).show();
  
    }

    private final BroadcastReceiver mReceiver=new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent){
            String action= intent.getAction();
// Когда найдено новое устройство
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
// Получаем объект BluetoothDevice из интента
                BluetoothDevice device= intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//Добавляем имя и адрес в array adapter, чтобы показвать в ListView
                AbstractList<String> mArrayAdapter = null;
                mArrayAdapter.add(device.getName()+"\n"+ device.getAddress());
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Регистрируем BroadcastReceiver
        IntentFilter filter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);// Не забудьте снять регистрацию в onDestroy

    }

}