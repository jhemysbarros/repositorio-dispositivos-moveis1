package br.jhemysbarros.comunicacaofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class PrimeiraFragment extends Fragment implements View.OnClickListener {

    Button btnEnviar;
    private EditText editTextNome, editTextSobrenome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Adciona o layout para esse fragment
        View rootView = inflater.inflate(R.layout.primeira_fragment, container, false);


        // Invova o metodo iniView
        iniView(rootView);

        // Invova o metodo registerListener
        registerListener();
        return rootView;
    }

    private void registerListener() {
        btnEnviar.setOnClickListener(this);
    }

    // Metodo para fazer a ponte entre os componentes de tela e o back-end
    private void iniView(View rootView) {
        editTextNome = rootView.findViewById(R.id.editTextNome);
        editTextSobrenome = rootView.findViewById(R.id.editTextSobrenome);
        btnEnviar = rootView.findViewById(R.id.btnEnviar);
    }

    @Override
    public void onClick(View v) {

        String nome = editTextNome.getText().toString();
        String sobrenome = editTextSobrenome.getText().toString();

        // Invoca o metodo imprimeToast que tem os parametros nome e sobrenome
        imprimeToast(nome, sobrenome);

        // Invoca o metodo dadosInformado
        dadosInformado(nome, sobrenome);
    }

    // Metodo para passagem dos dados nome e sobrenome
    private void dadosInformado(String nome, String sobrenome) {

        Bundle bundle = new Bundle();

        bundle.putString("nome", nome);
        bundle.putString("sobrenome", sobrenome);

        SegundaFragment segundaFragment = new SegundaFragment();
        segundaFragment.setArguments(bundle);


        // Substitui o primeiro fragment pelo segundo fragment
        getFragmentManager().
                beginTransaction().
                addToBackStack(null).
                replace(R.id.constraintLayout, segundaFragment).
                commit();
    }

    // Método para impressão do Toast com dois parametros string
    private void imprimeToast(String nome, String sobrenome) {

        if (nome.matches("") || sobrenome.matches("")) {
            Toast.makeText(getContext(), "Por favor, preencha seu nome e sobrenome", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getContext(), "Nome : " + nome + "  " + "Sobrenome : " + sobrenome, Toast.LENGTH_SHORT).show();
        }
    }
}
