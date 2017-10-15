package com.teste.testesqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.teste.testesqlite.model.Configuracao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ThirdSystem on 12/10/2017.
 */

public class ConfiguracaoDAO {

    public void atualizarVersaoLocal(SQLiteDatabase bd, Configuracao configuracaoServidor, int versaoLocal) {

        Date dataHora = new Date();
        ContentValues valores = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Log.d("teste", "versao passada: " + versaoLocal);
        if(versaoLocal == -1){
            Log.d("teste", "entrou no if");
            Log.d("teste", dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO, dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO, configuracaoServidor.getCampeonatoAno());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO, configuracaoServidor.getVersao());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA, configuracaoServidor.getTema());

            bd.insert(BancoDados.Tabela.TABELA_CONFIGURACAO, null, valores);
            Log.d("teste", "inseriu a versao");
        }
        else {
            Log.d("teste", "entrou no else");
            Log.d("teste", dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO, dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO, configuracaoServidor.getCampeonatoAno());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO, configuracaoServidor.getVersao());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA, configuracaoServidor.getTema());
            Log.d("teste", "inseriu os valores");
            int count = bd.update(
                    BancoDados.Tabela.TABELA_CONFIGURACAO,
                    valores,
                    null,
                    null
            );
        }
    }

    public int getVersaoLocal(Context context){

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        int versao = -1;

        try{

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if(c.moveToFirst()){
                versao = c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO));
            }
            else{
                versao = -1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(c != null) {
                c.close();
            }
        }

        return versao;
    }

    public String getUltimaAtualizacao(Context context){

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        String dataHora = null;

        try{

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if(c.moveToFirst()){
                dataHora = c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO));
            }
            else{
                dataHora = null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(c != null) {
                c.close();
            }
        }

        return dataHora;
    }
}
