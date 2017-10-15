package com.teste.testesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.teste.testesqlite.dao.BancoDadosHelper;
import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.model.Cartao;
import com.teste.testesqlite.model.Classificacao;
import com.teste.testesqlite.model.Configuracao;
import com.teste.testesqlite.model.Suspensao;
import com.teste.testesqlite.service.ArtilhariaService;
import com.teste.testesqlite.service.CartaoService;
import com.teste.testesqlite.service.ClassificacaoService;
import com.teste.testesqlite.service.ConfiguracaoService;
import com.teste.testesqlite.service.SuspensaoService;

import java.util.List;

/**
 * Created by danieldea on 09/10/2017.
 */

public class Atualizacao {

    private ConfiguracaoService configuracaoService;
    private ClassificacaoService classificacaoService;
    private ArtilhariaService artilhariaService;
    private CartaoService cartaoService;
    private SuspensaoService suspensaoService;
    private Context context;

    public Atualizacao(Context context){
        this.context = context;
    }

    public boolean verificarAtualizacao() {
        Log.d("teste", "1 - entrou no verificar atualizacao");

        boolean atualizacaoStatus = false;

        Configuracao configuracaoServidor;

        int versaoLocal;
        int versaoAtual;

        try {
            configuracaoService = new ConfiguracaoService();
            Log.d("teste", "1 - instanciou configuracao service");

            configuracaoServidor = configuracaoService.getConfiguracaoServidor();
            Log.d("teste", configuracaoServidor.toString());

            versaoLocal = configuracaoService.getVersaoLocal(context);
            Log.d("teste", "versao local: " + versaoLocal);
            versaoAtual = configuracaoServidor.getVersao();
            Log.d("teste", "versao atual: " + versaoAtual);

            Log.d("teste", "campeonato ano: " + configuracaoServidor.getCampeonatoAno());
            Log.d("teste", "ultima atualizacao: " + configuracaoService.getUltimaAtualizacao(context));

            if (versaoLocal == -1) {
                atualizacaoStatus = atualizarDados(configuracaoServidor, versaoLocal, configuracaoService);
                Log.d("teste", "executou primeira atualizacao");
            } else if (versaoLocal != versaoAtual) {
                atualizacaoStatus = atualizarDados(configuracaoServidor, versaoLocal, configuracaoService);
                Log.d("teste", "executou atualizacao");
            }
            else{
                Log.d("teste", "nao executou atualizacao");
            }

            atualizacaoStatus = true;

        } catch (Exception e) {
            atualizacaoStatus = false;
        }

        return atualizacaoStatus;
    }

    public boolean atualizarDados(Configuracao configuracaoServidor, int versaoLocal, ConfiguracaoService configuracaoService) throws Exception{
        Log.d("teste", "entrou no atualizar dados");

        boolean atualizacaoStatus = false;

        SQLiteDatabase bd = null;
        Log.d("teste", "criou sqlitehelper");

        try {
            classificacaoService = new ClassificacaoService();
            artilhariaService = new ArtilhariaService();
            cartaoService = new CartaoService();
            suspensaoService = new SuspensaoService();
            Log.d("teste", "instanciou os services");

            bd = BancoDadosHelper.FabricaDeConexao.getConexaoServico(context);
            Log.d("teste", "recebeu uma conexao de servico");

            List<Classificacao> listaClassificacao = classificacaoService.getClassificacao(configuracaoServidor.getCampeonatoAno());
            List<Artilharia> listaArtilharia = artilhariaService.getArtilharia(configuracaoServidor.getCampeonatoAno());
            List<Cartao> listaCartaoAmarelo = cartaoService.getCartaoAmarelo(configuracaoServidor.getCampeonatoAno());
            List<Cartao> listaCartaoVermelho = cartaoService.getCartaoVermelho(configuracaoServidor.getCampeonatoAno());
            List<Suspensao> listaSuspensao = suspensaoService.getSuspensao(configuracaoServidor.getCampeonatoAno());
            Log.d("teste", "carregou as listas");

            bd.beginTransaction();
            Log.d("teste", "iniciou a transacao");

            classificacaoService.deletarDados(bd);
            artilhariaService.deletarDados(bd);
            cartaoService.deletarDados(bd);
            suspensaoService.deletarDados(bd);
            Log.d("teste", "deletou dados antigos");
            classificacaoService.inserirDados(bd, listaClassificacao);
            artilhariaService.inserirDados(bd, listaArtilharia);
            cartaoService.inserirDados(bd, listaCartaoAmarelo, listaCartaoVermelho);
            suspensaoService.inserirDados(bd, listaSuspensao);
            Log.d("teste", "inseriu novos dados");

            configuracaoService.atualizarVersaoLocal(bd, configuracaoServidor, versaoLocal);
            Log.d("teste", "atualizou a versao");

            bd.setTransactionSuccessful();
            Log.d("teste", "1 - deu commit");

            atualizacaoStatus = true;

        } catch (Exception e) {
            atualizacaoStatus = false;
            Log.d("teste", " 2 - transacao falhou");
        } finally {
            if(bd != null) {
                bd.endTransaction();
                Log.d("teste", "1 - finalizou transacao com sucesso, 2 - deu rollback");
            }
        }
        return atualizacaoStatus;
    }
}
