package com.example.bigmeco.testbt;

import android.app.Activity;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.Set;

public class Main2Activity extends ListActivity {

    BluetoothAdapter bluetooth = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1);
        bluetooth = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices= bluetooth.getBondedDevices();
        if(pairedDevices.size()>0){
// идём в цикле по этому списку
            for(BluetoothDevice device: pairedDevices){
// Добавляем имена и адреса в mArrayAdapter,
// чтобы показать через ListView
                mArrayAdapter.add(device.getName()+"\n"+ device.getAddress());
            }
            setListAdapter(mArrayAdapter);
    }
}
}
