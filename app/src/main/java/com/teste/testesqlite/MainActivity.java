package com.teste.testesqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private Button btn;
    private ClassificacaoService classificacaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        txt = (EditText) findViewById(R.id.txt);
    }

    public void salvar(View v) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d("teste", "1 - criou a thread");

                classificacaoService = new ClassificacaoService();
                Log.d("teste", "2 - instanciou classificacao service");
                classificacaoService.inserirDados(getBaseContext());
                Log.d("teste", "13 - executou inserir dados");

            }
        }).start();

    }

    public void destruirBanco(){

    }

    public void mostrar(View view) {

        Intent intent = new Intent(this, MostrarResultados.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        BancoDadosHelper.FabricaDeConexao.fecharConexaoAplicacao();
        BancoDadosHelper.FabricaDeConexao.fecharConexaoServico();
    }
}
