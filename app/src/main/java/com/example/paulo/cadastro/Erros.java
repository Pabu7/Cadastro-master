package com.example.paulo.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Erros extends AppCompatActivity {

    public TextView erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erros);
        Intent intent = getIntent();
        String merro = intent.getStringExtra(MainActivity.EXTRA_ERRO);
        erro = (TextView) findViewById(R.id.erro);
        erro.setText(merro);
    }

    public void Voltar(View v){
        finish();
    }
}
