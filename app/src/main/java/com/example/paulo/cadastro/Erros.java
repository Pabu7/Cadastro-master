package com.example.paulo.cadastro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Erros extends AppCompatActivity {

    public TextView erro;
    private SharedPreferences sharedPref;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erros);
        context = this;
        sharedPref = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        erro = (TextView) findViewById(R.id.erro);
        String merro = sharedPref.getString("erro", "não existe");
        erro.setText(merro);

    }

    public void Voltar(View v){
        finish();
    }
}
