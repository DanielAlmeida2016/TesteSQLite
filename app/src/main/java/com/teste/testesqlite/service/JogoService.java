package com.teste.testesqlite.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teste.testesqlite.dao.JogoDAO;
import com.teste.testesqlite.model.Configuracao;
import com.teste.testesqlite.model.Jogo;
import com.teste.testesqlite.model.Resultado;
import com.teste.testesqlite.rest.JogoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ThirdSystem on 17/10/2017.
 */

public class JogoService {

    private JogoDAO dao;
    private JogoRest jogoRest;

    public JogoService(){
        dao = new JogoDAO();
        jogoRest = new JogoRest();
    }

    public List<Jogo> getJogo(int campeonatoAno) throws Exception{

        List<Jogo> lista;

        //String json = jogoRest.getJogo(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[" +
                " {" +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"08:00\"," +
                "  \"equipe1\": \"Westham\"," +
                "  \"equipe2\": \"Liverpool\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"10:00\"," +
                "  \"equipe1\": \"Park-Rangers\"," +
                "  \"equipe2\": \"Tottenham\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"12:00\"," +
                "  \"equipe1\": \"Manchester-United\"," +
                "  \"equipe2\": \"Fulham\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"14:00\"," +
                "  \"equipe1\": \"Arsenal\"," +
                "  \"equipe2\": \"Everton\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"16:00\"," +
                "  \"equipe1\": \"Manchester-City\"," +
                "  \"equipe2\": \"Newcastle\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"08:00\"," +
                "  \"equipe1\": \"Manchester-City\"," +
                "  \"equipe2\": \"Westham\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"10:00\"," +
                "  \"equipe1\": \"Park-Rangers\"," +
                "  \"equipe2\": \"Arsenal\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"12:00\"," +
                "  \"equipe1\": \"Liverpool\"," +
                "  \"equipe2\": \"Chelsea\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"14:00\"," +
                "  \"equipe1\": \"Everton\"," +
                "  \"equipe2\": \"Newcastle\"," +
                "  \"categoria\": \"Senior\"" +
                " }" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Jogo>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    public void inserirDados(SQLiteDatabase bd, List<Jogo> lista){
        dao.inserirDados(bd, lista);
    }

    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    public Jogo[] listarDadosPorRodadaETurno(Context context, int rodada, int turno){
       return dao.listarDadosPorRodadaETurno(context, rodada, turno);
    }
}
