package com.teste.testesqlite.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by danieldea on 09/10/2017.
 */

public class Configuracao implements Serializable{

    private String ultimaAtualizacao;
    private int campeonatoAno;
    private int versao;
    private int tema;

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public int getCampeonatoAno() {
        return campeonatoAno;
    }

    public void setCampeonatoAno(int campeonatoAno) {
        this.campeonatoAno = campeonatoAno;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "ultimaAtualizacao=" + ultimaAtualizacao +
                ", campeonatoAno=" + campeonatoAno +
                ", versao=" + versao +
                ", tema=" + tema +
                '}';
    }
}
