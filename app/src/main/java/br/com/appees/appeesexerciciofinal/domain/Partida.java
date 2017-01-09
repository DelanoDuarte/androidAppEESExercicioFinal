package br.com.appees.appeesexerciciofinal.domain;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by delan on 03/01/2017.
 */
@DatabaseTable(tableName = "tb_partida")
public class Partida implements Serializable{


    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField(columnName = "nome_partida")
    private String nome;

    @DatabaseField(columnName = "quantidade_jogadores")
    private Integer quantidadeJogadores;

    @DatabaseField(columnName = "local_partida")
    private String local;

    @DatabaseField(columnName = "data_partida",dataType = DataType.DATE)
    private Date data;

    @ForeignCollectionField()
    private ForeignCollection<Jogadores> jogadores;

    public Partida() {

    }

    public Partida(String nome, Integer quantidadeJogadores, String local, Date data, ForeignCollection<Jogadores> jogadores) {
        this.nome = nome;
        this.quantidadeJogadores = quantidadeJogadores;
        this.local = local;
        this.data = data;
        this.jogadores = jogadores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeJogadores() {
        return quantidadeJogadores;
    }

    public void setQuantidadeJogadores(Integer quantidadeJogadores) {
        this.quantidadeJogadores = quantidadeJogadores;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ForeignCollection<Jogadores> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ForeignCollection<Jogadores> jogadores) {
        this.jogadores = jogadores;
    }
}
