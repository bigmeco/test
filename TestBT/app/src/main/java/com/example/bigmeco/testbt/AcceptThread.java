package com.example.bigmeco.testbt;

import android.bluetooth.BluetoothServerSocket;

/**
 * Created by bigmeco on 19.10.2017.
 */

    class AcceptThread extends Thread{
        private final BluetoothServerSocket mmServerSocket;

public AcceptThread(){
// используем вспомогательную переменную, которую в дальнейшем
// свяжем с mmServerSocket,
            BluetoothServerSocket tmp=null;
            try{
// MY_UUID это UUID нашего приложения, это же значение
// используется в клиентском приложении
                tmp= mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            } catch(IOException e){}
            mmServerSocket= tmp;
        }

    public void run(){
        BluetoothSocket socket=null;
// ждем пока не произойдет ошибка или не
// будет возвращен сокет
        while(true){
            try{
                socket= mmServerSocket.accept();
            } catch(IOException e){
                break;
            }
// если соединение было подтверждено
            if(socket!=null){
// управлчем соединением (в отдельном потоке)
                manageConnectedSocket(socket);
                mmServerSocket.close();
                break;
            }
        }
    }

    /** отмена ожидания сокета */
    public void cancel(){
        try{
            mmServerSocket.close();
        } catch(IOException e){}
    }
}
}
