package br.unitins.dm1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrimeiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
    }

    public void proximaTela(View view) {

        Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

        Button btnProxima = (Button) findViewById(R.id.btnPrimeiraActivity);
        int btnValor = Integer.parseInt(btnProxima.getText().toString());
        int valorIncrementado = btnValor + 1;

        intent.putExtra("Novo", valorIncrementado);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            Button btnMain = (Button) findViewById(R.id.btnSegundaActivity);

            btnMain.setText(data.getSerializableExtra("Increment").toString());

        }
    }
}