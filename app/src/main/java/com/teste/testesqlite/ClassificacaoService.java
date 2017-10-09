package com.teste.testesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/09/2017.
 * Classe exemplo
 */

public class ClassificacaoService {

    public List<Classificacao> classificacao(){

        List<Classificacao> lista;

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

    public void inserirDados(Context context){
        Log.d("teste", "3 - entrou no inserir dados");

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoServico(context);
        Log.d("teste", "9 - pegou a conexao");

        try {
            bd.beginTransaction();
            Log.d("teste", "10.1 - iniciou a transação");

            bd.delete(BancoDados.Tabela.TABELA_CLASSIFICACAO, null, null);
            Log.d("teste", "Teste 2 - deletou conteudo antigo");

            List<Classificacao> lista = classificacao();

            ContentValues values = new ContentValues();

            for (Classificacao classificacao : lista) {

                values.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_TIME, classificacao.getTime());
                values.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS, classificacao.getPontosGanhos());
                values.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS, classificacao.getJogos());
                values.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS, classificacao.getVitorias());
                values.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS, classificacao.getSaldoGols());

                long id = bd.insert(BancoDados.Tabela.TABELA_CLASSIFICACAO, null, values);
            }

            bd.setTransactionSuccessful();
            Log.d("teste", "11 - finalizou a transacao com sucesso");
        }
        catch (Exception e){
            e.printStackTrace();
            Log.d("teste", "10.2 - deu erro na transacao");
        }
        finally {
            bd.endTransaction();
            Log.d("teste", "12 - finalizou a transacao");
        }
    }

    public Classificacao[] listarDados(Context context){

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Classificacao> retLista = new ArrayList<>();
        Classificacao[] lista;
        Classificacao classificacao;
        Cursor c = null;

        try{

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_TIME,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS};

            c = bd.query(BancoDados.Tabela.TABELA_CLASSIFICACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            while(c.moveToNext()){
                classificacao = new Classificacao();
                classificacao.setTime(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_TIME)));
                classificacao.setPontosGanhos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS)));
                classificacao.setJogos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS)));
                classificacao.setVitorias(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS)));
                classificacao.setSaldoGols(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS)));

                Log.d("teste", classificacao.toString());
                retLista.add(classificacao);
            }

            lista = retLista.toArray(new Classificacao[0]);
        }
        catch (Exception e){
            e.printStackTrace();

            lista = null;
        }
        finally {
            if(c != null) {
                c.close();
            }
        }

        return lista;
    }

}
