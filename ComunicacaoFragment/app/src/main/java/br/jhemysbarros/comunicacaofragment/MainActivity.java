package br.jhemysbarros.comunicacaofragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Invoca o metodo fragmentPrincipal
        fragmentPrincipal();
    }

    private void fragmentPrincipal(){
        // Cria uma nova fragment e transaction

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PrimeiraFragment primeiraFragment = new PrimeiraFragment();

        // Substitui o está no container principal e adiciona a transaction na back stack
        fragmentTransaction.add(R.id.constraintLayout, primeiraFragment);
        fragmentTransaction.addToBackStack(null);

        // Faz o Commit da transaction
        fragmentTransaction.commit();
    }
}