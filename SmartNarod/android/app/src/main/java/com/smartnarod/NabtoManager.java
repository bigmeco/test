package com.smartnarod;


import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.react.bridge.*;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.nabto.api.*;

import java.util.HashMap;
import java.util.Map;

//import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

public class NabtoManager extends ReactContextBaseJavaModule {


    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ReactApplicationContext rectcontext;

    Thread tunnelThread = null;

    public NabtoManager(ReactApplicationContext reactContext) {
        super(reactContext);
        this.rectcontext = reactContext;
    }

    @Override
    public String getName() {
        return "NabtoManager";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        return constants;
    }

    @ReactMethod
    public void addEvent(String message1, String message2) {
        //Toast.makeText(getReactApplicationContext(), message, duration).show();
        Log.d(message1, message2);
        //this.eventReminderReceived("8080");
        this.nabtoTunnel();
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }


    public void eventReminderReceived(String port) {
        WritableMap params = Arguments.createMap();
        params.putString("port", port);
        sendEvent(this.rectcontext, "EventReminder", params);
    }

    @ReactMethod
    private void nabtoTunnel() {
        final NabtoApi api = new NabtoApi(new NabtoAndroidAssetManager(this.rectcontext));

        // Start Nabto
        api.startup();

// Login as guest
        Session session = api.openSession("guest", "");
        if (session.getStatus() == NabtoStatus.OK) {
            int localPort = 0;
            String nabtoHost = "0200000100005b7c-1d39a6ab858f26d77610.nabto.squid.link";
            String remoteHost = "localhost";
            int remotePort = 80;

            final Tunnel tunnel = api.tunnelOpenTcp(localPort, nabtoHost, remoteHost, remotePort, session);
            if (tunnel.getStatus() == NabtoStatus.OK) {
                Log.d(this.getClass().getSimpleName(),
                        "TCP tunnel opened with status: " + tunnel.getStatus());

                tunnelThread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            NabtoTunnelState newState;
                            NabtoTunnelState state = NabtoTunnelState.CLOSED;
                            boolean keepRunning = true;
                            while (keepRunning) {
                                sleep(100);
                                //handler.post(this);
                                final TunnelInfoResult info = api.tunnelInfo(tunnel);
                                if (info.getStatus() != NabtoStatus.OK) {
                                    Log.d(this.getClass().getSimpleName(),
                                            "Failed to get tunnel info: " + info.getStatus());
                                } else {
                                    newState = info.getTunnelState();
                                    if (newState != state) {
                                        state = newState;
                                        final NabtoTunnelState finalNewState = newState;
                                        getCurrentActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Log.d(this.getClass().getSimpleName(),
                                                        "State changed for Tunnel : " + tunnel + " status: " + finalNewState);
                                            }
                                        });

                                        if ((newState == NabtoTunnelState.LOCAL) ||
                                                (newState == NabtoTunnelState.REMOTE_P2P) ||
                                                (newState == NabtoTunnelState.REMOTE_RELAY) ||
                                                (newState == NabtoTunnelState.REMOTE_RELAY_MICRO)) {

                                            keepRunning = false;
                                            try {
                                                Thread.sleep(300);
                                                getCurrentActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Log.d(this.getClass().getSimpleName(),
                                                                "Tunnel connected, tunnel version: " + info.getVersion() + " local port: " + info.getPort());
                                                        String stringPort = String.valueOf(info.getPort());
                                                        eventReminderReceived(stringPort);
                                                        stopThread();
                                                    }
                                                });
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };

                tunnelThread.start();
            } else {
                Log.d(this.getClass().getSimpleName(),
                        "Failed to open TCP tunnel: " + nabtoHost);
            }

        }


    }


    public void stopThread() {
        if (tunnelThread != null) {
            tunnelThread.interrupt();
            Log.d(this.getClass().getSimpleName(),
                    "Tunnel Thread interrupted");
        }
    }

}