package com.teste.testesqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.teste.testesqlite.model.Classificacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThirdSystem on 12/10/2017.
 */

public class ClassificacaoDAO {

    public void inserirDados(SQLiteDatabase bd, List<Classificacao> lista) {

        ContentValues valores = new ContentValues();

        for (Classificacao classificacao : lista) {
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_TIME, classificacao.getTime());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS, classificacao.getPontosGanhos());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS, classificacao.getJogos());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS, classificacao.getVitorias());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS, classificacao.getSaldoGols());

            long id = bd.insert(BancoDados.Tabela.TABELA_CLASSIFICACAO, null, valores);
        }
    }

    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_CLASSIFICACAO, null, null);
    }

    public Classificacao[] listarDados(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Classificacao> retLista = new ArrayList<>();
        Classificacao[] lista = null;
        Classificacao classificacao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_TIME,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS};

            c = bd.query(BancoDados.Tabela.TABELA_CLASSIFICACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    classificacao = new Classificacao();
                    classificacao.setTime(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_TIME)));
                    classificacao.setPontosGanhos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS)));
                    classificacao.setJogos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS)));
                    classificacao.setVitorias(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS)));
                    classificacao.setSaldoGols(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS)));

                    Log.d("teste", classificacao.toString());
                    retLista.add(classificacao);
                }
                lista = retLista.toArray(new Classificacao[0]);
            }
            else{
                lista = null;
            }
        } catch (Exception e) {
            lista = null;
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }
}
