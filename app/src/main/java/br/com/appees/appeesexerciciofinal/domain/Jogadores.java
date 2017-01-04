package br.com.appees.appeesexerciciofinal.domain;

import java.io.Serializable;

/**
 * Created by delan on 04/01/2017.
 */
public class Jogadores implements Serializable{

    private Integer id;
    private String nome;
    private Integer nivel;

    public Jogadores(String nome, Integer nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public Jogadores() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
