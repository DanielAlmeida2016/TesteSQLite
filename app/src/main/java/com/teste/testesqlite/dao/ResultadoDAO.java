package com.teste.testesqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.model.Resultado;
import com.teste.testesqlite.model.Suspensao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThirdSystem on 17/10/2017.
 */

public class ResultadoDAO {

    public void inserirDados(SQLiteDatabase bd, List<Resultado> lista) {

        ContentValues valores = new ContentValues();

        for (Resultado resultado : lista) {
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_DATA, resultado.getData());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_HORARIO, resultado.getHorario());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_EQUIPE1, resultado.getEquipe1());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_GOLS_EQUIPE1, resultado.getGolsEquipe1());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_EQUIPE2, resultado.getEquipe2());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_GOLS_EQUIPE2, resultado.getGolsEquipe2());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_CARTOES_AMARELOS, resultado.getCartoesAmarelos());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_CARTOES_VERMELHOS, resultado.getCartoesVermelhos());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_TOTAL_CARTOES, resultado.getTotalCartoes());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_CATEGORIA, resultado.getCategoria());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_ARBITRO, resultado.getArbitro());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_ASSISTENTE1, resultado.getAssistente1());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_ASSISTENTE2, resultado.getAssistente2());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_NOTA_ARBITRO_MEDIA, resultado.getNotaArbitroMedia());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_NOTA_ARBITRO_EQUIPE1, resultado.getNotaArbitroEquipe1());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_NOTA_ARBITRO_EQUIPE2, resultado.getNotaArbitroEquipe2());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_RODADA, resultado.getRodada());
            valores.put(BancoDados.Tabela.COLUNA_RESULTADO_TURNO, resultado.getTurno());

            long id = bd.insert(BancoDados.Tabela.TABELA_RESULTADO, null, valores);
        }
    }

    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_RESULTADO, null, null);
    }

    public Resultado[] listarDadosPorRodadaETurno(Context context, int rodada, int turno) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Resultado> retLista = new ArrayList<>();
        Resultado[] lista = null;
        Resultado resultado;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_RESULTADO_DATA,
                    BancoDados.Tabela.COLUNA_RESULTADO_HORARIO,
                    BancoDados.Tabela.COLUNA_RESULTADO_EQUIPE1,
                    BancoDados.Tabela.COLUNA_RESULTADO_GOLS_EQUIPE1,
                    BancoDados.Tabela.COLUNA_RESULTADO_EQUIPE2,
                    BancoDados.Tabela.COLUNA_RESULTADO_GOLS_EQUIPE2,
                    BancoDados.Tabela.COLUNA_RESULTADO_CATEGORIA};

            String where =
                    BancoDados.Tabela.COLUNA_RESULTADO_RODADA + " = ? AND " + BancoDados.Tabela.COLUNA_RESULTADO_TURNO + " = ?";

            String[] valorWhere =
                    { String.valueOf(rodada), String.valueOf(turno) };

            c = bd.query(BancoDados.Tabela.TABELA_RESULTADO,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    resultado = new Resultado();
                    resultado.setData(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_DATA)));
                    resultado.setHorario(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_HORARIO)));
                    resultado.setEquipe1(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_EQUIPE1)));
                    resultado.setGolsEquipe1(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_GOLS_EQUIPE1)));
                    resultado.setEquipe2(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_EQUIPE2)));
                    resultado.setGolsEquipe2(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_GOLS_EQUIPE2)));
                    resultado.setCategoria(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_RESULTADO_CATEGORIA)));

                    Log.d("teste", resultado.toString());
                    retLista.add(resultado);
                }
                lista = retLista.toArray(new Resultado[0]);
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
