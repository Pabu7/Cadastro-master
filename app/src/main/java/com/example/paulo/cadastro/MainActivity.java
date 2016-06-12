package com.example.paulo.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_NOME = "com.example.paulo.cadastro.NOME";
    public final static String EXTRA_IDADE = "com.example.paulo.cadastro.IDADE";
    public final static String EXTRA_CPF = "com.example.paulo.cadastro.CPF";
    public final static String EXTRA_RG = "com.example.paulo.cadastro.RG";
    public final static String EXTRA_TELEFONE = "com.example.paulo.cadastro.TELEFONE";
    public final static String EXTRA_SEXO = "com.example.paulo.cadastro.SEXO";
    public final static String EXTRA_ESTCIV = "com.example.paulo.cadastro.ESTCIV";

    public void sendMessage(View v){
        Intent intent = new Intent(this, Cadastrados.class);
        Intent intente = new Intent(this, Erros.class);
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText telefone = (EditText) findViewById(R.id.telefone);
        EditText idade = (EditText) findViewById(R.id.idade);
        EditText cpf = (EditText) findViewById(R.id.cpf);
        EditText rg = (EditText) findViewById(R.id.rg);
        RadioButton Masc = (RadioButton) findViewById(R.id.Masc);
        RadioButton Fem = (RadioButton) findViewById(R.id.Fem);
        RadioButton Sol = (RadioButton) findViewById(R.id.Sol);
        RadioButton Cas = (RadioButton) findViewById(R.id.Cas);
        String mnome = nome.getText().toString();
        String midade = idade.getText().toString();
        String mtelefone = telefone.getText().toString();
        String mcpf = cpf.getText().toString();
        String mrg = rg.getText().toString();
        String msexo = "Vazio";
        String mestciv = "Vazio";
        if (Masc.isChecked()){
            msexo = "Masculino";
        }
        if (Fem.isChecked()){
            msexo = "Feminino";
        }
        if(Sol.isChecked()){
            mestciv = "Solteiro(a)";
        }
        if(Cas.isChecked()){
            mestciv = "Casado(a)";
        }
        intent.putExtra(EXTRA_NOME, mnome);
        intent.putExtra(EXTRA_IDADE, midade);
        intent.putExtra(EXTRA_TELEFONE, mtelefone);
        intent.putExtra(EXTRA_CPF, mcpf);
        intent.putExtra(EXTRA_RG, mrg);
        intent.putExtra(EXTRA_SEXO, msexo);
        intent.putExtra(EXTRA_ESTCIV, mestciv);
        if(mnome.isEmpty() || midade.isEmpty() || mtelefone.isEmpty() || mcpf.isEmpty() || mrg.isEmpty() || msexo.equals("Vazio") || mestciv.equals("Vazio")){
            startActivity(intente);
        }
        else {
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
