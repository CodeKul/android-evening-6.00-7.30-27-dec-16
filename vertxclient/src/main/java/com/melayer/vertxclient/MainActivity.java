package com.melayer.vertxclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private WebSocketClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new WebSocketClient(URI.create("ws://192.168.0.95:8080/eb/in")) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i("@melayer","onOpen");
            }

            @Override
            public void onMessage(String message) {
                Log.i("@melayer","onMesage");
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.i("@melayer","onClose");
            }

            @Override
            public void onError(Exception ex) {
                Log.i("@melayer","onError "+ex);
            }
        };
        client.connect();
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnOkay).setOnClickListener(this::send);
    }

    private void send(View view) {
        client.send("Hi");
    }
}
