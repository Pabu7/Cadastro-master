package com.example.paulo.cadastro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_ERRO = "com.example.paulo.cadastro.ERRO";
    private Context context;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

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
        RadioButton Div = (RadioButton) findViewById(R.id.Div);
        RadioButton Viu = (RadioButton) findViewById(R.id.Viu);
        String mnome = nome.getText().toString();
        String midade = idade.getText().toString();
        String mtelefone = telefone.getText().toString();
        String mcpf = cpf.getText().toString();
        String mrg = rg.getText().toString();
        String msexo = "Vazio";
        String mestciv = "Vazio";
        String merro = "Vazio";
        if (Masc.isChecked()){
            msexo = "Masculino";
        }
        if (Fem.isChecked()){
            msexo = "Feminino";
        }
        if(Sol.isChecked()){
            if(Masc.isChecked()) {
                mestciv = "Solteiro";
            }
            else{
                mestciv = "Solteira";
            }
        }
        if(Cas.isChecked()){
            if(Masc.isChecked()) {
                mestciv = "Casado";
            }
            else{
                mestciv = "Casada";
            }
        }
        if(Div.isChecked()){
            if(Masc.isChecked()) {
                mestciv = "Divorciado";
            }
            else{
                mestciv = "Divorciada";
            }
        }
        if(Viu.isChecked()){
            if(Masc.isChecked()) {
                mestciv = "Viúvo";
            }
            else{
                mestciv = "Viúva";
            }
        }
        context = getBaseContext();
        sharedPref = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString("nome", mnome);
        editor.putString("idade", midade);
        editor.putString("telefone", mtelefone);
        editor.putString("cpf", mcpf);
        editor.putString("rg", mrg);
        editor.putString("sexo", msexo);
        editor.putString("estciv", mestciv);

        if(mnome.isEmpty() || midade.isEmpty() || mtelefone.isEmpty() || mcpf.isEmpty() || mrg.isEmpty() || msexo.equals("Vazio") || mestciv.equals("Vazio")){
            merro = "Forgot something, did we?";
        }
        if(mnome.isEmpty()){
            if(merro.equals("Vazio")) {
                merro = "Digite seu nome";
            }
            else{
                merro = merro + "\nDigite seu nome";
            }
        }
        if(midade.isEmpty()){
            if(merro.equals("Vazio")) {
                merro = "Digite sua idade";
            }
            else{
                merro = merro + "\nDigite sua idade";
            }
        }
        if(!(midade.isEmpty()) && Integer.parseInt(idade.getText().toString())>150){
            if(merro.equals("Vazio")) {
                merro = "Idade acima do limite, tente novamente";
            }
            else{
                merro = merro + "\nIdade acima do limite, tente novamente";
            }
        }
        if(cpf.length() > 11){
            if(merro.equals("Vazio")) {
                merro = "CPF com muitos digitos";
            }
            else{
                merro = merro + "\nCPF com muitos digitos";
            }
        }
        if(cpf.length() < 11){
            if(merro.equals("Vazio")) {
                merro = "CPF faltando digitos";
            }
            else{
                merro = merro + "\nCPF faltando digitos";
            }
        }
        if(rg.length()>9){
            if(merro.equals("Vazio")) {
                merro = "RG com muitos digitos";
            }
            else{
                merro = merro + "\nRG com muitos digitos";
            }
        }
        if(rg.length()<7){
            if(merro.equals("Vazio")) {
                merro = "RG faltando digitos";
            }
            else{
                merro = merro + "\nRG faltando digitos";
            }
        }
        if(telefone.length()>11){
            if(merro.equals("Vazio")) {
                merro = "Telefone com muitos digitos";
            }
            else{
                merro = merro + "\nTelefone com muitos digitos";
            }
        }
        if(telefone.length()<7){
            if(merro.equals("Vazio")) {
                merro = "Telefone faltando digitos";
            }
            else{
                merro = merro + "\nTelefone faltando digitos";
            }
        }
        if(msexo.equals("Vazio")){
            if(merro.equals("Vazio")) {
                merro = "Sexo não definido";
            }
            else{
                merro = merro + "\nSexo não definido";
            }
        }
        if(mestciv.equals("Vazio")){
            if(merro.equals("Vazio")) {
                merro = "Estado civil não definido";
            }
            else{
                merro = merro + "\nEstado civil não definido";
            }
        }

        if(merro.equals("Vazio")) {
            if(editor.commit()){
                Toast.makeText(context, "Deu Certo", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(context, "Deu Errado", Toast.LENGTH_LONG).show();
            }
            startActivity(intent);
        }
        else{
            editor.putString("erro", merro);
            if(editor.commit()){
                Toast.makeText(context, "Deu Certo", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(context, "Deu Errado", Toast.LENGTH_LONG).show();
            }
            startActivity(intente);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
