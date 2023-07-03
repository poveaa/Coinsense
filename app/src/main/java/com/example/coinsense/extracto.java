package com.example.coinsense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class extracto extends AppCompatActivity {

    private SharedPreferences preferencias;
    private TextView texArriendo;
    private TextView texAlimentacion;
    private TextView texTransporte;
    private TextView texBasicos;
    private TextView texEducacion;
    private TextView texDeudas;
    private TextView texAhorros;

    private TextView texPresupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extracto);

        preferencias = getSharedPreferences(Preferencias.DATOS, Context.MODE_PRIVATE);
        texPresupuesto = findViewById(R.id.text_Presupuesto);

        texArriendo = findViewById(R.id.texArriendo);
        texAlimentacion = findViewById(R.id.texAlimento);
        texTransporte = findViewById(R.id.texTransporte);
        texBasicos = findViewById(R.id.textBasicos);
        texEducacion = findViewById(R.id.texEducacion);
        texDeudas  = findViewById(R.id.texDeudas);
        texAhorros = findViewById(R.id.texAhorro);

        mostrarDatos();
    }

    private void mostrarDatos(){
        int arriendo = preferencias.getInt(Preferencias.ARRIENDO, 0);
        int alimentacion = preferencias.getInt(Preferencias.ALIMENTACION, 0);
        int transporte = preferencias.getInt(Preferencias.TRANSPORTE, 0);
        int basicos = preferencias.getInt(Preferencias.GASTOS_BASICOS, 0);
        int educacion = preferencias.getInt(Preferencias.EDUCACIÓN, 0);
        int deudas = preferencias.getInt(Preferencias.DEUDAS, 0);
        int ahorros = preferencias.getInt(Preferencias.AHORROS, 0);

        int presupuesto = preferencias.getInt(Preferencias.PRESUPUESTO,0);

        texArriendo.setText(String.valueOf(arriendo));
        texAlimentacion.setText(String.valueOf(alimentacion));
        texTransporte.setText(String.valueOf(transporte));
        texBasicos.setText(String.valueOf(basicos));
        texEducacion.setText(String.valueOf(educacion));
        texDeudas.setText(String.valueOf(deudas));
        texAhorros.setText(String.valueOf(ahorros));

        texPresupuesto.setText(String.valueOf(presupuesto));
    }
}