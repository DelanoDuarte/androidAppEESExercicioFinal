package br.com.appees.appeesexerciciofinal.domain.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by delan on 04/01/2017.
 */
@DatabaseTable(tableName = "tb_jogador")
public class Jogadores implements Serializable{

    @DatabaseField(generatedId = true,columnName = "id_jogador")
    private Integer id;

    @DatabaseField(columnName = "nome_jogador")
    private String nome;

    @DatabaseField(columnDefinition = "nivel_jogador")
    private Float nivel;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "id_partida")
    private Partida partida;

    public Jogadores(String nome, Float nivel, Partida partida) {
        this.nome = nome;
        this.nivel = nivel;
        this.partida = partida;
    }

    public Jogadores() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getNivel() {
        return nivel;
    }

    public void setNivel(Float nivel) {
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
