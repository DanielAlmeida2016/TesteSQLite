package com.teste.testesqlite.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.teste.testesqlite.dao.ConfiguracaoDAO;
import com.teste.testesqlite.model.Configuracao;
import com.teste.testesqlite.rest.ConfiguracaoRest;

/**
 * Created by danieldea on 09/10/2017.
 */

public class ConfiguracaoService {

    private ConfiguracaoDAO dao;
    private ConfiguracaoRest configuracaoRest;

    public ConfiguracaoService() {
        dao = new ConfiguracaoDAO();
        configuracaoRest = new ConfiguracaoRest();
    }

    public Configuracao getConfiguracaoServidor() throws Exception {

        Configuracao configuracao;

        //String json = configuracaoRest.getConfiguracaoServidor();

        String json = "{" +
                "\"ultimaAtualizacao\":\"null\"," +
                "\"campeonatoAno\":\"2017\"," +
                "\"versao\":\"1\"," +
                "\"tema\":\"1\"" +
                "}";

        Gson gson = new Gson();

        configuracao = gson.fromJson(json, Configuracao.class);

        return configuracao;
    }

    public static String urlBase(int campeonatoAno){
        String urlBase = "http://www.futeboldospais.com.br/campeonato" + String.valueOf(campeonatoAno) + "/json/";
        return urlBase;
    }

    public void atualizarVersaoLocal(SQLiteDatabase bd, Configuracao configuracao, int versaoLocal) {
        dao.atualizarVersaoLocal(bd, configuracao, versaoLocal);
    }

    public int getVersaoLocal(Context context) {
        return dao.getVersaoLocal(context);
    }

    public String getUltimaAtualizacao(Context context) {
        return dao.getUltimaAtualizacao(context);
    }
}
