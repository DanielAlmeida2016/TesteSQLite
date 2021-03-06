package com.teste.testesqlite.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teste.testesqlite.dao.ArtilhariaDAO;
import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.rest.ArtilhariaRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ThirdSystem on 23/09/2017.
 */

public class ArtilhariaService {

    private ArtilhariaDAO dao;
    private ArtilhariaRest artilhariaRest;

    public ArtilhariaService(){
        dao = new ArtilhariaDAO();
        artilhariaRest = new ArtilhariaRest();
    }

    public List<Artilharia> getArtilharia(int campeonatoAno) throws Exception{

        List<Artilharia> lista;

        //String json = artilhariaRest.getArtilharia(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[" +
                "  {" +
                "   \"nome\": \"Corello\"," +
                "   \"gols\": \"16\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"19\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"amarelos\": \"2\"," +
                "   \"vermelhos\": \"2\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Espanhol\"," +
                "   \"gols\": \"15\"," +
                "   \"equipe\": \"Novorizontino\"," +
                "   \"numero\": \"30\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"amarelos\": \"0\"," +
                "   \"vermelhos\": \"0\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Bello\"," +
                "   \"gols\": \"13\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"17\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"amarelos\": \"1\"," +
                "   \"vermelhos\": \"1\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"null\"," +
                "   \"gols\": \"0\"," +
                "   \"equipe\": \"null\"," +
                "   \"numero\": \"0\"," +
                "   \"posicao\": \"null\"," +
                "   \"categoria\": \"null\"," +
                "   \"amarelos\": \"0\"," +
                "   \"vermelhos\": \"0\"" +
                "  }" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Artilharia>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    public void inserirDados(SQLiteDatabase bd, List<Artilharia> lista){
        dao.inserirDados(bd, lista);
    }

    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    public Artilharia[] listarDadosPorCategoria(Context context, String categoria){
        return dao.listarDadosPorCategoria(context, categoria);
    }
}
