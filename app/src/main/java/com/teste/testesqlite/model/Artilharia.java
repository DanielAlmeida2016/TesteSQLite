package com.teste.testesqlite.model;

import java.io.Serializable;

/**
 * Created by ThirdSystem on 23/09/2017.
 */

public class Artilharia implements Serializable{

    private String nome;
    private int gols;
    private String equipe;
    private int numero;
    private String posicao;
    private String categoria;
    private int amarelos;
    private int vermelhos;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAmarelos() {
        return amarelos;
    }

    public void setAmarelos(int amarelos) {
        this.amarelos = amarelos;
    }

    public int getVermelhos() {
        return vermelhos;
    }

    public void setVermelhos(int vermelhos) {
        this.vermelhos = vermelhos;
    }

    @Override
    public String toString() {
        return "Artilharia{" +
                "nome='" + nome + '\'' +
                ", gols=" + gols +
                ", equipe='" + equipe + '\'' +
                ", numero=" + numero +
                ", posicao='" + posicao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", amarelos=" + amarelos +
                ", vermelhos=" + vermelhos +
                '}';
    }
}
