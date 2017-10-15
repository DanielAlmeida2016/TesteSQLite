package com.teste.testesqlite.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teste.testesqlite.dao.CartaoDAO;
import com.teste.testesqlite.model.Artilharia;
import com.teste.testesqlite.model.Cartao;
import com.teste.testesqlite.rest.CartaoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ThirdSystem on 13/10/2017.
 */

public class CartaoService {

    private CartaoDAO dao;
    private CartaoRest cartaoRest;

    public CartaoService(){
        dao = new CartaoDAO();
        cartaoRest = new CartaoRest();
    }

    public List<Cartao> getCartaoAmarelo(int campeonatoAno) throws Exception{

        List<Cartao> lista;

        //String json = cartaoRest.getCartaoAmarelo(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[" +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"01/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"01/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"01/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"02/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"02/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"02/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"03/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"03/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"03/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"04/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"04/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"04/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"05/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"05/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"05/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"06/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"06/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"06/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"07/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"07/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"07/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"08/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"08/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"08/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"09/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"09/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"09/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"10/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"10/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"10/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"11/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"11/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"11/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"12/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"12/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"12/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"13/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"13/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"13/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"14/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"14/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"14/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"15/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"15/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"15/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"17/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"17/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"17/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"18/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"18/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"18/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"19/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"19/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"19/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"20/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"20/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"20/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"21/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"21/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"21/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"22/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"22/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"22/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"23/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"23/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"23/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"24/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"24/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"24/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"25/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"25/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"25/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"28/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"28/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"28/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"29/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"29/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"29/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"30/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"30/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"30/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"27/05/2017\"," +
                "   \"tempo\": \"53\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"26/08/2017\"," +
                "   \"tempo\": \"49\"," +
                "   \"adversario\": \"Linense\"," +
                "   \"arbitro\": \"Leandro Almeida\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"1\"," +
                "   \"jogador\": \"Alessandro\"," +
                "   \"data\": \"16/09/2017\"," +
                "   \"tempo\": \"86\"," +
                "   \"adversario\": \"Red-Bull\"," +
                "   \"arbitro\": \"Marco Motta\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"2\"," +
                "   \"jogador\": \"Paulinho\"," +
                "   \"data\": \"04/03/2017\"," +
                "   \"tempo\": \"74\"," +
                "   \"adversario\": \"Ferroviaria\"," +
                "   \"arbitro\": \"Jacildo Antonio de Paula\"" +
                "  }" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Cartao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    public List<Cartao> getCartaoVermelho(int campeonatoAno) throws Exception{

        List<Cartao> lista;

        //String json = cartaoRest.getCartaoVermelho(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[" +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"4\"," +
                "   \"jogador\": \"Adriano Helena\"," +
                "   \"data\": \"29/07/2017\"," +
                "   \"tempo\": \"89\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Marcos Silva Santos Gonçalves\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"8\"," +
                "   \"jogador\": \"Luis Claudio\"," +
                "   \"data\": \"20/08/2017\"," +
                "   \"tempo\": \"77\"," +
                "   \"adversario\": \"São Bento\"," +
                "   \"arbitro\": \"Leandro Leão\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"9\"," +
                "   \"jogador\": \"Pina\"," +
                "   \"data\": \"12/03/2017\"," +
                "   \"tempo\": \"90\"," +
                "   \"adversario\": \"Mirassol\"," +
                "   \"arbitro\": \"Marco Antônio\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Ferroviaria\"," +
                "   \"numero\": \"6\"," +
                "   \"jogador\": \"Elder Boy\"," +
                "   \"data\": \"21/05/2017\"," +
                "   \"tempo\": \"90\"," +
                "   \"adversario\": \"São Bento\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Cartao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    public void inserirDados(SQLiteDatabase bd, List<Cartao> listaCartaoAmarelo, List<Cartao> listaCartaoVermelho){
        dao.inserirDadosCartaoAmarelo(bd, listaCartaoAmarelo);
        dao.inserirDadosCartaoVermelho(bd, listaCartaoVermelho);
    }

    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDadosCartaoAmarelo(bd);
        dao.deletarDadosCartaoVermelho(bd);
    }

    public Cartao[] listarDadosCartaoaAmarelo(Context context){
        return dao.listarDadosCartaoAmarelo(context);
    }

    public Cartao[] listarDadosCartaoVermelho(Context context){
        return dao.listarDadosCartaoVermelho(context);
    }
}
