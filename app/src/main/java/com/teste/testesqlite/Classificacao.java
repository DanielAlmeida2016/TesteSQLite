package com.teste.testesqlite;

import java.io.Serializable;

/**
 * Created by Daniel Almeida on 17/09/2017.
 * Classe exemplo
 */

public class Classificacao implements Serializable{

    private String time;
    private int pontosGanhos;
    private int jogos;
    private int vitorias;
    private int saldoGols;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(int pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    @Override
    public String toString() {
        return "Classificacao{" +
                "time='" + time + '\'' +
                ", pontosGanhos=" + pontosGanhos +
                ", jogos=" + jogos +
                ", vitorias=" + vitorias +
                ", saldoGols=" + saldoGols +
                '}';
    }
}
