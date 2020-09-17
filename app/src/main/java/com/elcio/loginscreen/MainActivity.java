package com.elcio.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editLogin, editPassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);

        sharedPreferences = getSharedPreferences(getString(R.string.email), Context.MODE_PRIVATE);

        if(sharedPreferences.contains(getString(R.string.email))){
            editLogin.setText(sharedPreferences.getString(getString(R.string.email), "email"));
        }

    }

    /**
     * Take a String comming from a view and check if it is valid,
     * if was put then into a SharedPreference
     * else show a Toast to user put a write input.
     *
     * @param view
     * @auth ElcioCestari
     */
    public void saveLogin(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (!editLogin.getText().toString().equals("")) {//negando a sentença (!)
            editor.putString(getString(R.string.email), editLogin.getText().toString());
            editor.commit();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.wrongLogin), Toast.LENGTH_SHORT).show();
        }
    }
}
