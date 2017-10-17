package com.teste.testesqlite.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.teste.testesqlite.model.Cartao;
import com.teste.testesqlite.model.Jogo;
import com.teste.testesqlite.model.Resultado;
import com.teste.testesqlite.service.ArtilhariaService;
import com.teste.testesqlite.service.CartaoService;
import com.teste.testesqlite.service.ClassificacaoService;
import com.teste.testesqlite.R;
import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.model.Classificacao;
import com.teste.testesqlite.service.JogoService;
import com.teste.testesqlite.service.ResultadoService;

public class MostrarResultados extends AppCompatActivity {

    //private ClassificacaoService classificacaoService;
    //private ArtilhariaService artilhariaService;
    //private CartaoService cartaoService;
    private ResultadoService resultadoService;
    private JogoService jogoService;
    //private Classificacao[] listaClassificacao;
    //private Artilharia[] listaArtilharia;
    //private Cartao[] listaCartao;
    private Resultado[] listaResultado;
    private Jogo[] listaJogo;
    private TextView mostra;
    private String rs;
    private int rodada;
    private int turno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultados);

        rodada = getIntent().getIntExtra("rodada", 1);
        Log.d("teste", String.valueOf(rodada));
        turno  = getIntent().getIntExtra("turno", 1);
        Log.d("teste", String.valueOf(turno));

        mostra = (TextView) findViewById(R.id.mostra);

        new Thread(new Runnable() {
            @Override
            public void run() {

                resultadoService = new ResultadoService();
                jogoService = new JogoService();
                Log.d("teste", "instanciou os services");

                listaResultado = resultadoService.listarDadosPorRodadaETurno(getBaseContext(), rodada, turno);
                listaJogo = jogoService.listarDadosPorRodadaETurno(getBaseContext(), rodada, turno);
                Log.d("teste", "passou por aqui");

                if(listaResultado != null) {
                    Log.d("teste", "lista resultado nao é nulo");

                    if (listaResultado.length == 6) {
                        Log.d("teste", "lista resultado é igual a 6");
                        rs = listaResultado[0].getData() + " " + listaResultado[0].getHorario() + " " + listaResultado[0].getEquipe1() + " " + listaResultado[0].getGolsEquipe1() + " X " +
                                listaResultado[0].getGolsEquipe2() + " " + listaResultado[0].getEquipe2() + " " + listaResultado[0].getCategoria() + "\n\n";

                        for (int i = 1; i < listaResultado.length; i++) {
                            rs += "\n" + listaResultado[i].getData() + " " + listaResultado[i].getHorario() + " " + listaResultado[i].getEquipe1() + " " + listaResultado[i].getGolsEquipe1() + " X " +
                                    listaResultado[i].getGolsEquipe2() + " " + listaResultado[i].getEquipe2() + " " + listaResultado[i].getCategoria() + "\n\n";
                        }
                    } else if (listaResultado.length < 6) {
                        Log.d("teste", "lista resultado é menor que 6");
                        rs = listaResultado[0].getData() + " " + listaResultado[0].getHorario() + " " + listaResultado[0].getEquipe1() + " " + listaResultado[0].getGolsEquipe1() + " X " +
                                listaResultado[0].getGolsEquipe2() + " " + listaResultado[0].getEquipe2() + " " + listaResultado[0].getCategoria() + "\n\n";

                        for (int i = 1; i < listaResultado.length; i++) {
                            rs += "\n" + listaResultado[i].getData() + " " + listaResultado[i].getHorario() + " " + listaResultado[i].getEquipe1() + " " + listaResultado[i].getGolsEquipe1() + " X " +
                                    listaResultado[i].getGolsEquipe2() + " " + listaResultado[i].getEquipe2() + " " + listaResultado[i].getCategoria() + "\n\n";
                        }

                        if (listaJogo != null) {
                            for (int i = 0; i < listaJogo.length; i++) {
                                rs += "\n" + listaJogo[i].getData() + " " + listaJogo[i].getHorario() + " " + listaJogo[i].getEquipe1() + " X " + listaJogo[i].getEquipe2() + " " +
                                        listaJogo[i].getCategoria() + "\n\n";
                            }
                        }
                    }
                }
                else if(listaJogo != null){

                    Log.d("teste", "lista resultado é nulo");

                    rs = listaJogo[0].getData() + " " + listaJogo[0].getHorario() + " " + listaJogo[0].getEquipe1() + " X " + listaJogo[0].getEquipe2() + " " +
                            listaJogo[0].getCategoria() + "\n\n";

                    for (int i = 1; i < listaJogo.length; i++) {
                        rs += "\n" + listaJogo[i].getData() + " " + listaJogo[i].getHorario() + " " + listaJogo[i].getEquipe1() + " X "  + listaJogo[i].getEquipe2() + " " +
                                listaJogo[i].getCategoria() + "\n\n";
                    }
                }
                else {
                    rs = "Resultados não encontrados";
                }
                //classificacaoService = new ClassificacaoService();
                //artilhariaService = new ArtilhariaService();
                //listaClassificacao = classificacaoService.listarDados(getBaseContext());
                //listaArtilharia = artilhariaService.listarDadosPorCategoria(getBaseContext(), "Senior");
                //cartaoService = new CartaoService();
                //listaCartao = cartaoService.listarDadosCartaoaAmarelo(getBaseContext());


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
                }

                if(listaCartao != null){
                    rs = listaCartao[0].getJogador() + "  " + listaCartao[0].getData() + "\n\n";

                    for (int i = 1; i < listaCartao.length; i++){
                        rs +=listaCartao[i].getJogador() + "  " + listaCartao[i].getData() + "\n\n";
                    }
                }
                else{
                    rs = "Falhou";
                }*/

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
