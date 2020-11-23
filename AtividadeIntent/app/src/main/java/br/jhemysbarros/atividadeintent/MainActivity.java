package br.jhemysbarros.atividadeintent;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        //Intent intent = new Intent(getApplicationContext(), Tela2.class);
        //startActivity(intent);

        Intent intent = new Intent("br.jhemysbarros.unitins.action.TELA");
        startActivity(intent);
    }

    public void cont(View view) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}