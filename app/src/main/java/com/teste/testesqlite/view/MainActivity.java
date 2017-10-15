package com.teste.testesqlite.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teste.testesqlite.Atualizacao;
import com.teste.testesqlite.AtualizationService;
import com.teste.testesqlite.dao.BancoDadosHelper;
import com.teste.testesqlite.service.ClassificacaoService;
import com.teste.testesqlite.R;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private Button btn;
    private Atualizacao atualizacao;
    private ClassificacaoService classificacaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        txt = (EditText) findViewById(R.id.txt);
    }

    public void salvar(View v) {

        /*new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d("teste", "1 - criou a thread");

                atualizacao = new Atualizacao(getBaseContext());
                Log.d("teste", "2 - instanciou atualizacao");
                boolean teste = atualizacao.verificarAtualizacao();
                Log.d("teste", "13 - executou verificar atualizacao");
                Log.d("teste", String.valueOf(teste));

                classificacaoService = new ClassificacaoService();
                Log.d("teste", "2 - instanciou classificacao service");
                classificacaoService.inserirDados(getBaseContext());
                Log.d("teste", "13 - executou inserir dados");

            }
        }).start();*/

        Intent intent = new Intent(getBaseContext(), AtualizationService.class);
        Log.d("teste", "1 - instanciou o intent");
        startService(intent);
        Log.d("teste", "1 - iniciou o servico");
    }

    public void mostrar(View view) {

        Intent intent = new Intent(this, MostrarResultados.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

       // BancoDadosHelper.FabricaDeConexao.fecharConexaoAplicacao();
       // BancoDadosHelper.FabricaDeConexao.fecharConexaoServico();
    }
}
