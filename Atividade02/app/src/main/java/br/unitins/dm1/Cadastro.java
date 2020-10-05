package br.unitins.dm1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    private EditText nome;
    private EditText idade;
    private EditText email;
    private EditText telefone;
    private EditText cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.ptNome);
        idade = (EditText) findViewById(R.id.ptIdade);
        email = (EditText) findViewById(R.id.ptEmail);
        telefone = (EditText) findViewById(R.id.ptTelefone);
        cpf = (EditText) findViewById(R.id.ptCpf);
    }
}