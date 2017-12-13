package com.example.bigmeco.testble;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.polidea.rxandroidble.RxBleClient;
import com.polidea.rxandroidble.RxBleDevice;
import com.polidea.rxandroidble.scan.ScanFilter;
import com.polidea.rxandroidble.scan.ScanSettings;


import java.util.UUID;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.scan_results)
    TextView textView;
    @BindView(R.id.conect)
    TextView txtcon;
    @BindView(R.id.button)
    Button button;
    String macAddress = "CC:78:AB:1A:7B:04";
    private RxBleClient rxBleClient;
    private Subscription scanSubscription;
    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rxBleClient = RxBleClient.create(this);
        textView.setText("123");
    }

    @OnClick(R.id.button)
    public void setScanSubscription(){
        if (isScanning()) {
            scanSubscription.unsubscribe();
        } else {
            scanSubscription = rxBleClient.scanBleDevices(
                    new ScanSettings.Builder()
                            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                            .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES)
                            .build(),
                    new ScanFilter.Builder()
                            // add custom filters if needed
                            .build()
            )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(scanResult -> {
                                if (scanResult.getBleDevice().getName()!=null){

                                textView.setText(scanResult.getBleDevice().getMacAddress().toString());

                                }
                    },
                            throwable -> textView.setText(throwable.toString()));
        }
        RxBleDevice device = rxBleClient.getBleDevice(macAddress);

        subscription = device.establishConnection(true)
                .observeOn(AndroidSchedulers.mainThread())
// <-- autoConnect flag
                .flatMap(rxBleConnection -> rxBleConnection.readCharacteristic(UUID.fromString("0000fff8-0000-1000-8000-00805f9b34fb")))
                .subscribe(
                            bytes -> {
                                txtcon.setText(HexString.bytesToHex(bytes));

                        },
                        throwable -> {
                            // Handle an error here.
                        }
                );




    }

    private boolean isScanning() {
        return scanSubscription != null;
    }

    private void clearSubscription() {
        scanSubscription = null;
    }
    @Override
    protected void onResume() {
        super.onResume();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        scanSubscription.unsubscribe();
        subscription.unsubscribe();

    }
}
