package com.example.coinsense;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String PREFS_FIRST_LOGIN = "prefs_first_login";
    private static final String KEY_FIRST_LOGIN ="key_first_login";
    EditText username;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(LoginActivity.this , InicioActivity.class);
                startActivity(intent);

            }
        });
        if (isFirstLogin()){
            showInstructionsDialog();
            setFirstLogin(false);
        }
    }

    private boolean isFirstLogin() {
        SharedPreferences preferences = getSharedPreferences(PREFS_FIRST_LOGIN, MODE_PRIVATE);
        return preferences.getBoolean(KEY_FIRST_LOGIN, true);
    }

    private void setFirstLogin(boolean isFirstLogin) {
        SharedPreferences preferences = getSharedPreferences(PREFS_FIRST_LOGIN, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_FIRST_LOGIN, isFirstLogin);
        editor.apply();
    }

    private void showInstructionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_instructions, null);
        builder.setView(dialogView);

        Button closeButton = dialogView.findViewById(R.id.closeButton);
        final AlertDialog dialog = builder.create();

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


}
