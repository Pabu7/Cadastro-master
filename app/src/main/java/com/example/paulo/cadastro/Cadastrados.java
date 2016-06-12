package com.example.paulo.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cadastrados extends AppCompatActivity {

    public TextView nome;
    public TextView idade;
    public TextView telefone;
    public TextView cpf;
    public TextView rg;
    public TextView sexo;
    public TextView estciv;

    public void sendMessage(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrados);
        Intent intent = getIntent();
        String mnome = intent.getStringExtra(MainActivity.EXTRA_NOME);
        String midade = intent.getStringExtra(MainActivity.EXTRA_IDADE);
        String mtelefone = intent.getStringExtra(MainActivity.EXTRA_TELEFONE);
        String mcpf = intent.getStringExtra(MainActivity.EXTRA_CPF);
        String mrg = intent.getStringExtra(MainActivity.EXTRA_RG);
        String msexo = intent.getStringExtra(MainActivity.EXTRA_SEXO);
        String mestciv = intent.getStringExtra(MainActivity.EXTRA_ESTCIV);
        nome = (TextView) findViewById(R.id.nome);
        idade = (TextView) findViewById(R.id.idade);
        telefone = (TextView) findViewById(R.id.telefone);
        cpf = (TextView) findViewById(R.id.cpf);
        rg = (TextView) findViewById(R.id.rg);
        sexo = (TextView) findViewById(R.id.sexo);
        estciv = (TextView) findViewById(R.id.estciv);
        nome.setTextSize(15);
        idade.setTextSize(15);
        telefone.setTextSize(15);
        cpf.setTextSize(15);
        rg.setTextSize(15);
        sexo.setTextSize(15);
        estciv.setTextSize(15);
        nome.setText(mnome);
        idade.setText(midade);
        telefone.setText(mtelefone);
        cpf.setText(mcpf);
        rg.setText(mrg);
        sexo.setText(msexo);
        estciv.setText(mestciv);
    }
}
