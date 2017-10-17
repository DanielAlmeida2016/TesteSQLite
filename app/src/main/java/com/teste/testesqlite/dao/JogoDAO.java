package com.teste.testesqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.teste.testesqlite.model.Jogo;
import com.teste.testesqlite.model.Resultado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThirdSystem on 17/10/2017.
 */

public class JogoDAO {

    public void inserirDados(SQLiteDatabase bd, List<Jogo> lista) {

        ContentValues valores = new ContentValues();

        for (Jogo jogo : lista) {
            valores.put(BancoDados.Tabela.COLUNA_JOGO_RODADA, jogo.getRodada());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_TURNO, jogo.getTurno());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_DATA, jogo.getData());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_HORARIO, jogo.getHorario());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_EQUIPE1, jogo.getEquipe1());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_EQUIPE2, jogo.getEquipe2());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_CATEGORIA, jogo.getCategoria());

            long id = bd.insert(BancoDados.Tabela.TABELA_JOGO, null, valores);
        }
    }

    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_JOGO, null, null);
    }

    public Jogo[] listarDadosPorRodadaETurno(Context context, int rodada, int turno) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Jogo> retLista = new ArrayList<>();
        Jogo[] lista = null;
        Jogo jogo;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_JOGO_DATA,
                    BancoDados.Tabela.COLUNA_JOGO_HORARIO,
                    BancoDados.Tabela.COLUNA_JOGO_EQUIPE1,
                    BancoDados.Tabela.COLUNA_JOGO_EQUIPE2,
                    BancoDados.Tabela.COLUNA_JOGO_CATEGORIA};

            String where =
                    BancoDados.Tabela.COLUNA_JOGO_RODADA + " = ? AND " + BancoDados.Tabela.COLUNA_JOGO_TURNO + " = ?";

            String[] valorWhere =
                    { String.valueOf(rodada), String.valueOf(turno) };

            c = bd.query(BancoDados.Tabela.TABELA_JOGO,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    jogo = new Jogo();
                    jogo.setData(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_DATA)));
                    jogo.setHorario(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_HORARIO)));
                    jogo.setEquipe1(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_EQUIPE1)));
                    jogo.setEquipe2(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_EQUIPE2)));
                    jogo.setCategoria(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_CATEGORIA)));

                    Log.d("teste", jogo.toString());
                    retLista.add(jogo);
                }
                lista = retLista.toArray(new Jogo[0]);
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
