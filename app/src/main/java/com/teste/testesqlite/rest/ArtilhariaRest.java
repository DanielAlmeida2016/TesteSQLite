package com.teste.testesqlite.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ThirdSystem on 13/10/2017.
 */

public class ArtilhariaRest {

    public String getArtilharia(String urlBase) throws Exception {

        String rs;

        String url = urlBase + "artilheiros.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if(client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = response.body().string();
        }
        else{
            rs = null;
        }

        return rs;
    }
}
