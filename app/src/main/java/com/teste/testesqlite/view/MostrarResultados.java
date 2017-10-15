package com.teste.testesqlite.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.teste.testesqlite.model.Cartao;
import com.teste.testesqlite.service.ArtilhariaService;
import com.teste.testesqlite.service.CartaoService;
import com.teste.testesqlite.service.ClassificacaoService;
import com.teste.testesqlite.R;
import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.model.Classificacao;

public class MostrarResultados extends AppCompatActivity {

    private ClassificacaoService classificacaoService;
    private ArtilhariaService artilhariaService;
    private CartaoService cartaoService;
    private Classificacao[] listaClassificacao;
    private Artilharia[] listaArtilharia;
    private Cartao[] listaCartao;
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

                //classificacaoService = new ClassificacaoService();
                //artilhariaService = new ArtilhariaService();
                //listaClassificacao = classificacaoService.listarDados(getBaseContext());
                //listaArtilharia = artilhariaService.listarDadosPorCategoria(getBaseContext(), "Senior");
                cartaoService = new CartaoService();
                listaCartao = cartaoService.listarDadosCartaoaAmarelo(getBaseContext());


                /*if(listaClassificacao != null) {
                    rs = listaClassificacao[0].getTime() + listaClassificacao[0].getPontosGanhos() + listaClassificacao[0].getJogos() + listaClassificacao[0].getVitorias() + listaClassificacao[0].getSaldoGols() + "\n\n";

                    for (int i = 1; i < listaClassificacao.length; i++) {
                        rs += "\n" + listaClassificacao[i].getTime() + listaClassificacao[i].getPontosGanhos() + listaClassificacao[i].getJogos() +
                                listaClassificacao[i].getVitorias() + listaClassificacao[i].getSaldoGols() + "\n\n";
                    }
                }
                else{
                    rs = "Falhou";
                }

                if(listaArtilharia != null){
                    rs = listaArtilharia[0].getNome() + listaArtilharia[0].getGols() + "\n\n";

                    for (int i = 1; i < listaArtilharia.length; i++){
                        rs +=listaArtilharia[i].getNome() + listaArtilharia[i].getGols() + "\n\n";
                    }
                }
                else{
                    rs = "Falhou";
                }*/

                if(listaCartao != null){
                    rs = listaCartao[0].getJogador() + "  " + listaCartao[0].getData() + "\n\n";

                    for (int i = 1; i < listaCartao.length; i++){
                        rs +=listaCartao[i].getJogador() + "  " + listaCartao[i].getData() + "\n\n";
                    }
                }
                else{
                    rs = "Falhou";
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
