package br.jhemysbarros.comunicacaofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SegundaFragment extends Fragment {

    private TextView textViewNome, textViewSobrenome;
    String nome, sobrenome;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Adciona o layout para esse fragment
        View rootView = inflater.inflate(R.layout.segunda_fragment, container, false);

        // Invova o metodo iniView
        initView(rootView);

        // Invova o metodo setarDados
        setarDados();

        return rootView;

    }

    // Metodo para fazer a ponte entre os componentes de tela e o back-end
    private void initView(View rootView) {
        textViewNome = rootView.findViewById(R.id.textViewNome);
        textViewSobrenome = rootView.findViewById(R.id.textViewSobrenome);
    }

    // Metodo responvael por setar os dados da primeira fragment na segunda
    private void setarDados() {
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            nome = bundle.getString("nome");
            sobrenome = bundle.getString("sobrenome");

            textViewNome.setText(nome);
            textViewSobrenome.setText(sobrenome);
        }
    }
}
