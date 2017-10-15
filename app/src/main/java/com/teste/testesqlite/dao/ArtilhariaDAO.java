package com.teste.testesqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.teste.testesqlite.model.Artilharia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThirdSystem on 13/10/2017.
 */

public class ArtilhariaDAO {

    public void inserirDados(SQLiteDatabase bd, List<Artilharia> lista) {

        ContentValues valores = new ContentValues();

        for (Artilharia artilharia : lista) {
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_NOME, artilharia.getNome());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_GOLS, artilharia.getGols());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_EQUIPE, artilharia.getEquipe());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_NUMERO, artilharia.getNumero());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_POSICAO, artilharia.getPosicao());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_CATEGORIA, artilharia.getCategoria());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_AMARELOS, artilharia.getAmarelos());
            valores.put(BancoDados.Tabela.COLUNA_ARTILHARIA_VERMELHOS, artilharia.getVermelhos());

            long id = bd.insert(BancoDados.Tabela.TABELA_ARTILHARIA, null, valores);
        }
    }

    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_ARTILHARIA, null, null);
    }

    public Artilharia[] listarDadosPorCategoria(Context context, String categoria) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Artilharia> retLista = new ArrayList<>();
        Artilharia[] lista = null;
        Artilharia artilharia;
        Cursor c = null;
        String t = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_NOME,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_GOLS,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_EQUIPE,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_NUMERO,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_POSICAO,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_CATEGORIA,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_AMARELOS,
                    BancoDados.Tabela.COLUNA_ARTILHARIA_VERMELHOS};

            String where =
                    BancoDados.Tabela.COLUNA_ARTILHARIA_CATEGORIA + " = ?";

            if(categoria.equals("Master")){
                t = categoria;
            }
            else if(categoria.equals("Senior")){
                t = categoria;
            }

            String[] valorWhere =
                    { t };

            String orderBy =
                    BancoDados.Tabela.COLUNA_ARTILHARIA_GOLS + " DESC";

            c = bd.query(BancoDados.Tabela.TABELA_ARTILHARIA,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    orderBy
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    artilharia = new Artilharia();
                    artilharia.setNome(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_NOME)));
                    artilharia.setGols(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_GOLS)));
                    artilharia.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_EQUIPE)));
                    artilharia.setNumero(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_NUMERO)));
                    artilharia.setPosicao(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_POSICAO)));
                    artilharia.setCategoria(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_CATEGORIA)));
                    artilharia.setAmarelos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_AMARELOS)));
                    artilharia.setVermelhos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_ARTILHARIA_VERMELHOS)));

                    Log.d("teste", artilharia.toString());
                    retLista.add(artilharia);
                }
                lista = retLista.toArray(new Artilharia[0]);
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
