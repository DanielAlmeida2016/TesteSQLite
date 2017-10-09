package com.teste.testesqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MostrarResultados extends AppCompatActivity {

    private ClassificacaoService classificacaoService;
    private Classificacao[] lista;
    private TextView mostra;
    private String rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultados);

        mostra = (TextView) findViewById(R.id.mostra);

        new Thread(new Runnable() {
            @Override
            public void run() {

                classificacaoService = new ClassificacaoService();
                lista = classificacaoService.listarDados(getBaseContext());

                rs = lista[0].getTime();

                for (int i = 1; i < lista.length; i++){
                    rs += "\n" + lista[i].getTime();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       mostra.setText(rs);
                    }
                });
            }
        }).start();
    }
}
