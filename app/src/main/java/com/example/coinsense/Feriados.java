package com.example.coinsense;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;


import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Feriados extends AppCompatActivity {

    private TextView textFeriado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feriados);

        textFeriado = findViewById(R.id.tex_feriado);


        OkHttpClient client = new OkHttpClient();
        String url = "https://apis.digital.gob.cl/fl/feriados/2023";
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textFeriado.setText("Error al obtener los feriados");
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textFeriado.setText(myResponse);
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textFeriado.setText("Error al obtener los feriados");
                        }
                    });
                }
            }
        });


    }
}