package br.com.appees.appeesexerciciofinal.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by delan on 04/01/2017.
 */
@DatabaseTable(tableName = "tb_jogador")
public class Jogadores implements Serializable{

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField(columnName = "nome_jogador")
    private String nome;

    @DatabaseField(columnDefinition = "nivel_jogador")
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
