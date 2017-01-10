package br.com.appees.appeesexerciciofinal.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by delan on 03/01/2017.
 */

public class Partida implements Serializable{


    private Integer id;
    private String nome;
    private String local;
    private Date data;
    private int qtdJogadoresTime;
    private List<Jogadores> jogadores;


    public Partida(String nome, String local, int qtdJogadores) {
        this.nome = nome;
        this.local = local;
        this.qtdJogadoresTime = qtdJogadores;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
