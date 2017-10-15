package com.teste.testesqlite.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by danieldea on 09/10/2017.
 */

public class RestFull {

    public String urlBase(int campeonatoAno){
        String urlBase = "http://www.futeboldospais.com.br/campeonato" + String.valueOf(campeonatoAno) + "/json/";
        return urlBase;
    }

    public String getConfiguracao() throws Exception {

        String rs;

        String url = "http://www.futeboldospais.com.br/aplicativo/json/configuracaoes.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String t = "Tempo esgotado!";

        if(client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = response.body().string();
        }
        else{
            rs = t;
        }

        return rs;
    }

    public String getClassificacao(String urlBase) throws Exception {

        String rs;

        String url = urlBase + "classificacao-geral.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String t = "Tempo esgotado!";

        if(client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = response.body().string();
        }
        else{
            rs = t;
        }

        return rs;
    }

    public String getArtilharia(String urlBase) throws Exception {

        String rs = null;

        String url = urlBase + "artilheiros.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String t = "Tempo esgotado!";

        if(client.connectTimeoutMillis() < 10001 && client.readTimeoutMillis() < 5001) {
            rs = response.body().string();
        }
        else{
            rs = t;
        }

        return rs;
    }
}
