package com.example.bigmeco.testble;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.polidea.rxandroidble.RxBleClient;
import com.polidea.rxandroidble.scan.ScanSettings;


import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;


public class MainActivity extends AppCompatActivity {

    private RxBleClient rxBleClient;
    private Subscription subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rxBleClient = RxBleClient.create(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        int REQUEST_ENABLE_BT = 1;
        this.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        Subscription scanSubscription = rxBleClient.scanBleDevices(
                new ScanSettings.Builder()
                         //.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY) // change if needed
                        // .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES) // change if needed
                        .build()
                // add filters if needed
        )       .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        scanResult -> Toast.makeText(this, scanResult.toString(),Toast.LENGTH_LONG),
                        throwable -> {
                            Toast.makeText(this, throwable.toString(),Toast.LENGTH_LONG);
                        }
                );

// When done, just unsubscribe.
        scanSubscription.unsubscribe();
    }
}
