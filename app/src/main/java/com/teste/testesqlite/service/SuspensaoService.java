package com.teste.testesqlite.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teste.testesqlite.dao.SuspensaoDAO;
import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.model.Suspensao;
import com.teste.testesqlite.rest.SuspensaoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ThirdSystem on 13/10/2017.
 */

public class SuspensaoService {

    private SuspensaoDAO dao;
    private SuspensaoRest suspensaoRest;

    public SuspensaoService(){
        dao = new SuspensaoDAO();
        suspensaoRest = new SuspensaoRest();
    }

    public List<Suspensao> getSuspensao(int campeonatoAno) throws Exception{

        List<Suspensao> lista;

        //String json = suspensaoRest.getSuspensao(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[" +
                "  {" +
                "   \"equipe\": \"Ponte Preta\"," +
                "   \"jogador\": \"Amaro\"," +
                "   \"numero\": \"10\"," +
                "   \"categoria\": \"Master\"," +
                "   \"jogos\": \"1/1\"," +
                "   \"motivo\": \"Cartao Vermelho\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"jogador\": \"Pina\"," +
                "   \"numero\": \"9\"," +
                "   \"categoria\": \"Master\"," +
                "   \"jogos\": \"1/2\"," +
                "   \"motivo\": \"Cartao Vermelho\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"São Bento\"," +
                "   \"jogador\": \"Nelson\"," +
                "   \"numero\": \"23\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"jogos\": \"1/1\"," +
                "   \"motivo\": \"3 Cartões Amarelos\"" +
                "  }" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Suspensao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    public void inserirDados(SQLiteDatabase bd, List<Suspensao> lista){
        dao.inserirDados(bd, lista);
    }

    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    public Suspensao[] listarDados(Context context){
        return dao.listarDados(context);
    }
}
