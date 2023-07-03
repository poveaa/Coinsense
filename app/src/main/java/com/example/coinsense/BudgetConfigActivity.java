package com.example.coinsense;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.coinsense.BaseDatos.DatabaseHelper;

public class BudgetConfigActivity extends AppCompatActivity {

    private SharedPreferences preferencias;
    private EditText edArriendo;
    private EditText edAlimentacion;
    private EditText edTransporte;
    private EditText edGastosBasicos;
    private EditText edEducacion;
    private EditText edDeudas;
    private EditText edAhorros;
    private Button btnGuardar;

    private Button btnVolver;

    private EditText edPresupuesto;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_config);

        preferencias = getSharedPreferences(Preferencias.DATOS, Context.MODE_PRIVATE);

        edPresupuesto = findViewById(R.id.edit_prresu);

        edArriendo = findViewById(R.id.edArriendo);
        edAlimentacion = findViewById(R.id.edAlimento);
        edTransporte = findViewById(R.id.edTransporte);
        edGastosBasicos = findViewById(R.id.edBasicos);
        edEducacion = findViewById(R.id.edEducacion);
        edDeudas = findViewById(R.id.edDeudas);
        edAhorros = findViewById(R.id.edAhorro);

        btnGuardar = findViewById(R.id.btn_guardar);
        btnVolver = findViewById(R.id.btn_volver);

        databaseHelper = new DatabaseHelper(this);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetConfigActivity.this , InicioActivity.class);
                startActivity(intent);
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });

        mostrarDato();

    }

    private void mostrarDato(){
        int presupuesto = preferencias.getInt(Preferencias.PRESUPUESTO, 0);
        edPresupuesto.setText(String.valueOf(presupuesto));
    }
    private void guardarDatos(){

        int arriendo = parseEditTextToInt(edArriendo);
        int alimentacion = parseEditTextToInt(edAlimentacion);
        int transporte = parseEditTextToInt(edTransporte);
        int basicos = parseEditTextToInt(edGastosBasicos);
        int educacion = parseEditTextToInt(edEducacion);
        int deudas = parseEditTextToInt(edDeudas);
        int ahorro = parseEditTextToInt(edAhorros);

        preferencias.edit().putInt(Preferencias.ARRIENDO, arriendo).apply();
        preferencias.edit().putInt(Preferencias.ALIMENTACION, alimentacion).apply();
        preferencias.edit().putInt(Preferencias.TRANSPORTE, transporte).apply();
        preferencias.edit().putInt(Preferencias.GASTOS_BASICOS, basicos).apply();
        preferencias.edit().putInt(Preferencias.EDUCACIÓN, educacion).apply();
        preferencias.edit().putInt(Preferencias.DEUDAS, deudas).apply();
        preferencias.edit().putInt(Preferencias.AHORROS, ahorro).apply();

        databaseHelper.insertBudget(arriendo, alimentacion, transporte, basicos, educacion, deudas, ahorro);


    }

    private int parseEditTextToInt(EditText editText) {
        String text = editText.getText().toString();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }

    private void abrirExtracto(){
        Intent intent = new Intent(BudgetConfigActivity.this , extracto.class);
        startActivity(intent);
    }
}