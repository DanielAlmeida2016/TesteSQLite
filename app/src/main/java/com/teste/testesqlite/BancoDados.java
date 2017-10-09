package com.teste.testesqlite;

import android.provider.BaseColumns;

/**
 * Created by danieldea on 05/10/2017.
 */

public class BancoDados {

    private BancoDados() {};

    public static final int BANCO_VERSAO = 1;
    public static final String BANCO_NOME = "FutebolDosPais.db";

    public static class Tabela implements BaseColumns{

        private static final String CRIAR_TABELA = "CREATE TABLE IF NOT EXISTS ";
        private static final String EXCLUIR_TABELA = "DROP TABLE IF EXISTS ";
        private static final String CHAVE_PRIMARIA = " PRIMARY KEY";
        private static final String AUTO_INCREMENTO = " AUTOINCREMENT";
        private static final String PARENTESES_ENTRADA = " (";
        private static final String PARENTESES_SAIDA = " )";
        private static final String PONTO_VIRGULA = ";";
        private static final String VIRGULA = ",";

        private static final String TIPO_TEXTO = " TEXT";
        private static final String TIPO_INTEIRO = " INTEGER";

        public static final String TABELA_CLASSIFICACAO = "tabelaClassificacao";
        public static final String COLUNA_CLASSIFICACAO_TIME = "time";
        public static final String COLUNA_CLASSIFICACAO_PONTOS_GANHOS = "pontosGanhos";
        public static final String COLUNA_CLASSIFICACAO_JOGOS = "jogos";
        public static final String COLUNA_CLASSIFICACAO_VITORIAS = "vitorias";
        public static final String COLUNA_CLASSIFICACAO_SALDO_GOLS = "saldoGols";

        public static final String TABELA_ARTILHARIA = "tabelaArtilharia";
        public static final String COLUNA_ARTILHARIA_NOME = "nome";
        public static final String COLUNA_ARTILHARIA_GOLS = "gols";
        public static final String COLUNA_ARTILHARIA_EQUIPE = "equipe";
        public static final String COLUNA_ARTILHARIA_NUMERO = "numero";
        public static final String COLUNA_ARTILHARIA_POSICAO = "posicao";
        public static final String COLUNA_ARTILHARIA_CATEGORIA = "categoria";
        public static final String COLUNA_ARTILHARIA_AMARELOS = "amarelos";
        public static final String COLUNA_ARTILHARIA_VERMELHOS = "vermelhos";
    }

    public static final String CRIAR_TABELAS =
            Tabela.CRIAR_TABELA + Tabela.TABELA_CLASSIFICACAO + Tabela.PARENTESES_ENTRADA +
                    Tabela._ID + Tabela.TIPO_INTEIRO + Tabela.CHAVE_PRIMARIA + Tabela.AUTO_INCREMENTO + Tabela.VIRGULA +
                    Tabela.COLUNA_CLASSIFICACAO_TIME + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
                    Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
                    Tabela.COLUNA_CLASSIFICACAO_JOGOS + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
                    Tabela.COLUNA_CLASSIFICACAO_VITORIAS + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
                    Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS + Tabela.TIPO_INTEIRO + Tabela.PARENTESES_SAIDA + Tabela.PONTO_VIRGULA +

            Tabela.CRIAR_TABELA + Tabela.TABELA_ARTILHARIA + Tabela.PARENTESES_ENTRADA +
            Tabela._ID + Tabela.TIPO_INTEIRO + Tabela.CHAVE_PRIMARIA + Tabela.AUTO_INCREMENTO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_NOME + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_GOLS + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_EQUIPE + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_NUMERO + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_POSICAO + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_CATEGORIA + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_AMARELOS + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
                    Tabela.COLUNA_ARTILHARIA_VERMELHOS + Tabela.TIPO_INTEIRO + Tabela.PARENTESES_SAIDA;

    public static final String DELETAR_TABELAS =
            Tabela.EXCLUIR_TABELA + Tabela.TABELA_CLASSIFICACAO + Tabela.PONTO_VIRGULA +
            Tabela.EXCLUIR_TABELA + Tabela.TABELA_ARTILHARIA;

}
