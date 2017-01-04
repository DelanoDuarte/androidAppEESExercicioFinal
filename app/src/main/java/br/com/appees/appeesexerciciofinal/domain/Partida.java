package br.com.appees.appeesexerciciofinal.domain;

import java.io.Serializable;

/**
 * Created by delan on 03/01/2017.
 */

public class Partida implements Serializable{


    private Integer id;
    private String nome;
    private String local;

    public Partida(String nome, String local) {
        this.nome = nome;
        this.local = local;
    }

    public Partida() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
