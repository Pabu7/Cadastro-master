package com.example.paulo.cadastro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastrados extends AppCompatActivity {

    public TextView nome;
    public TextView idade;
    public TextView telefone;
    public TextView cpf;
    public TextView rg;
    public TextView sexo;
    public TextView estciv;

    private SharedPreferences sharedPref;
    private Context context;

    public void sendMessage(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrados);
        context = this;
        sharedPref = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String mnome = sharedPref.getString("nome", "não existe");
        String midade = sharedPref.getString("idade", "não existe");
        String mtelefone = sharedPref.getString("telefone", "não existe");
        String mcpf = sharedPref.getString("cpf", "não existe");
        String mrg = sharedPref.getString("rg", "não existe");
        String msexo = sharedPref.getString("sexo", "não existe");
        String mestciv = sharedPref.getString("estciv", "não existe");

        nome = (TextView) findViewById(R.id.nome);
        idade = (TextView) findViewById(R.id.idade);
        telefone = (TextView) findViewById(R.id.telefone);
        cpf = (TextView) findViewById(R.id.cpf);
        rg = (TextView) findViewById(R.id.rg);
        sexo = (TextView) findViewById(R.id.sexo);
        estciv = (TextView) findViewById(R.id.estciv);
        nome.setText(mnome);
        idade.setText(midade);
        telefone.setText(mtelefone);
        cpf.setText(mcpf);
        rg.setText(mrg);
        sexo.setText(msexo);
        estciv.setText(mestciv);
    }
}
