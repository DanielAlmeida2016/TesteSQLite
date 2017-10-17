package com.teste.testesqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by danieldea on 05/10/2017.
 */

public class BancoDadosHelper extends SQLiteOpenHelper{

    private BancoDadosHelper(Context context){
        super(context, BancoDados.BANCO_NOME, null, BancoDados.BANCO_VERSAO);
        Log.d("teste", "6 - entrou no construtor da banco dados helper");
    }

    public void onCreate(SQLiteDatabase bd){
        bd.execSQL(BancoDados.CRIAR_TABELA_CONFIGURACAO);
        bd.execSQL(BancoDados.CRIAR_TABELA_CLASSIFICACAO);
        bd.execSQL(BancoDados.CRIAR_TABELA_ARTILHARIA);
        bd.execSQL(BancoDados.CRIAR_TABELA_AMARELO);
        bd.execSQL(BancoDados.CRIAR_TABELA_VERMELHO);
        bd.execSQL(BancoDados.CRIAR_TABELA_SUSPENSAO);
        bd.execSQL(BancoDados.CRIAR_TABELA_RESULTADO);
        bd.execSQL(BancoDados.CRIAR_TABELA_JOGO);
        bd.execSQL(BancoDados.CRIAR_TABELA_ATAQUE);
        bd.execSQL(BancoDados.CRIAR_TABELA_DEFESA);
        Log.d("teste", "Teste 1 - criou as tabelas");
    }

    public void onUpgrade(SQLiteDatabase bd, int versaoAntiga, int novaVersao){
        bd.execSQL(BancoDados.DELETAR_TABELA_CONFIGURACAO);
        bd.execSQL(BancoDados.DELETAR_TABELA_CLASSIFICACAO);
        bd.execSQL(BancoDados.DELETAR_TABELA_ARTILHARIA);
        bd.execSQL(BancoDados.DELETAR_TABELA_AMARELO);
        bd.execSQL(BancoDados.DELETAR_TABELA_VERMELHO);
        bd.execSQL(BancoDados.DELETAR_TABELA_SUSPENSAO);
        bd.execSQL(BancoDados.DELETAR_TABELA_RESULTADO);
        bd.execSQL(BancoDados.DELETAR_TABELA_JOGO);
        bd.execSQL(BancoDados.DELETAR_TABELA_ATAQUE);
        bd.execSQL(BancoDados.DELETAR_TABELA_DEFESA);
        onCreate(bd);
    }

    public static class FabricaDeConexao {

        private static SQLiteDatabase CONEXAO_APLICACAO = null;
        private static SQLiteDatabase CONEXAO_SERVICO = null;

        private static BancoDadosHelper BANCO_DADOS_HELPER;

        private FabricaDeConexao(){}

        public static SQLiteDatabase getConexaoAplicacao(Context context){

            if(CONEXAO_APLICACAO == null){
                BANCO_DADOS_HELPER = new BancoDadosHelper(context);
                CONEXAO_APLICACAO = BANCO_DADOS_HELPER.getReadableDatabase();
            }
            return CONEXAO_APLICACAO;
        }

        public static SQLiteDatabase getConexaoServico(Context context){
            Log.d("teste", "4 - entrou no get conexao servico");

            if(CONEXAO_SERVICO == null){
                Log.d("teste", "5 - verificou a conexao servico");

                BANCO_DADOS_HELPER = new BancoDadosHelper(context);
                Log.d("teste", "7 - instanciou banco dados helper");

                CONEXAO_SERVICO = BANCO_DADOS_HELPER.getWritableDatabase();
                Log.d("teste", "8 - inseriu a conexao");
            }
            return CONEXAO_SERVICO;
        }

        public static void fecharConexaoAplicacao(){
            CONEXAO_APLICACAO.close();
        }

        public static void fecharConexaoServico(){
            CONEXAO_SERVICO.close();
        }
    }

}
