package br.com.appees.appeesexerciciofinal.repository.repository.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.domain.domain.Jogadores;
import br.com.appees.appeesexerciciofinal.domain.domain.Partida;

/**
 * Created by delan on 04/01/2017.
 */

public class RepositorySQLHelper extends OrmLiteSqliteOpenHelper {

    private static final String NOME_BANCO = "db_projeto";
    private static final int VERSAO_BANCO = 1;

    private Dao<Jogadores,Integer> jogadorDAO = null;
    private Dao<Partida,Integer> partidaDao = null;


    public RepositorySQLHelper(Context context){
        super(context,NOME_BANCO,null,VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Jogadores.class);
            TableUtils.createTableIfNotExists(connectionSource, Partida.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Jogadores.class,true);
            TableUtils.createTableIfNotExists(connectionSource, Jogadores.class);
            TableUtils.dropTable(connectionSource,Partida.class,true);
            TableUtils.createTableIfNotExists(connectionSource, Partida.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Jogadores, Integer> getJogadorDAO() {
        if(this.jogadorDAO == null){
            try {
                this.jogadorDAO = getDao(Jogadores.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jogadorDAO;
    }

    public Dao<Partida, Integer> getPartidaDao() throws SQLException {
        if(this.partidaDao == null){
            this.partidaDao = getDao(Partida.class);
        }
        return partidaDao;
    }
}
