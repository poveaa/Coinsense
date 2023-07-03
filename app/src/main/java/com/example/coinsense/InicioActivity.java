package com.example.coinsense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class InicioActivity extends AppCompatActivity {

    private Button presupuesto;
    private EditText edPresupuesto;
    private Button agregar;
    private Button resumen;
    private Button feriado;
    private SharedPreferences preferecias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        presupuesto = findViewById(R.id.btn_presupuesto);
        edPresupuesto = findViewById(R.id.edPresupuesto);
        agregar = findViewById(R.id.btn_agregar);
        resumen = findViewById(R.id.btn_resumen);
        feriado = findViewById(R.id.btn_feriados);
        preferecias = getSharedPreferences(Preferencias.DATOS, Context.MODE_PRIVATE);

        feriado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioActivity.this, Feriados.class);
                startActivity(intent);
            }
        });
        resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioActivity.this, extracto.class);
                startActivity(intent);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        presupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioActivity.this, BudgetConfigActivity.class);
                startActivity(intent);
            }
        });
    }

    private void guardar(){
        int presupuesto = parseEditTextToInt(edPresupuesto);

        preferecias.edit().putInt(Preferencias.PRESUPUESTO, presupuesto).apply();


    }

    private int parseEditTextToInt(EditText editText) {
        String text = editText.getText().toString();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }

}