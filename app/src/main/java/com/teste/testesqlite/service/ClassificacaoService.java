package com.teste.testesqlite.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teste.testesqlite.dao.ClassificacaoDAO;
import com.teste.testesqlite.model.Classificacao;
import com.teste.testesqlite.rest.ClassificacaoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/09/2017.
 * Classe exemplo
 */

public class ClassificacaoService {

    private ClassificacaoDAO dao;
    private ClassificacaoRest classificacaoRest;

    public ClassificacaoService(){
        dao = new ClassificacaoDAO();
        classificacaoRest = new ClassificacaoRest();
    }

    public List<Classificacao> getClassificacao(int campeonatoAno) throws Exception{

        List<Classificacao> lista;

        //String json = classificacaoRest.getClassificacao(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[" +
                "\t{" +
                "\"time\":\"Corinthians\"," +
                "\"pontosGanhos\":\"12\"," +
                "\"jogos\":\"4\"," +
                "\"vitorias\":\"4\"," +
                "\"saldoGols\":\"13\"" +
                "}," +
                "{" +
                "\"time\":\"Santos\"," +
                "\"pontosGanhos\":\"10\"," +
                "\"jogos\":\"4\"," +
                "\"vitorias\":\"3\"," +
                "\"saldoGols\":\"10\"" +
                "}," +
                "{" +
                "\"time\":\"Gremio\"," +
                "\"pontosGanhos\":\"8\"," +
                "\"jogos\":\"4\"," +
                "\"vitorias\":\"2\"," +
                "\"saldoGols\":\"3\"" +
                "}" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Classificacao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    public void inserirDados(SQLiteDatabase bd, List<Classificacao> lista){
        dao.inserirDados(bd, lista);
    }

    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    public Classificacao[] listarDados(Context context){
        return dao.listarDados(context);
    }
}
