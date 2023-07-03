package com.example.coinsense.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "budget.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "budget";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ARRIENDO = "arriendo";
    private static final String COLUMN_ALIMENTACION = "alimentacion";
    private static final String COLUMN_TRANSPORTE = "transporte";
    private static final String COLUMN_GASTOS_BASICOS = "gastos_basicos";
    private static final String COLUMN_EDUCACION = "educacion";
    private static final String COLUMN_DEUDAS = "deudas";
    private static final String COLUMN_AHORROS = "ahorros";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_ARRIENDO + " INTEGER," +
                COLUMN_ALIMENTACION + " INTEGER," +
                COLUMN_TRANSPORTE + " INTEGER," +
                COLUMN_GASTOS_BASICOS + " INTEGER," +
                COLUMN_EDUCACION + " INTEGER," +
                COLUMN_DEUDAS + " INTEGER," +
                COLUMN_AHORROS + " INTEGER" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // En caso de actualizaciones futuras de la base de datos
        // puedes implementar la lógica de migración aquí
    }

    public void insertBudget(int arriendo, int alimentacion, int transporte,
                             int basicos, int educacion, int deudas, int ahorro) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ARRIENDO, arriendo);
        values.put(COLUMN_ALIMENTACION, alimentacion);
        values.put(COLUMN_TRANSPORTE, transporte);
        values.put(COLUMN_GASTOS_BASICOS, basicos);
        values.put(COLUMN_EDUCACION, educacion);
        values.put(COLUMN_DEUDAS, deudas);
        values.put(COLUMN_AHORROS, ahorro);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

}

