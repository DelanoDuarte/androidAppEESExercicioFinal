package br.com.appees.appeesexerciciofinal.repository.repository.partida;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.domain.domain.Partida;

/**
 * Created by delan on 03/01/2017.
 */

public class PartidaRepositorySQLHelper extends OrmLiteSqliteOpenHelper {

    private static final String NOME_BANCO = "db_projeto";
    private static final int VERSAO_BANCO = 1;

    private Dao<Partida,Integer> partidaDao = null;

    public PartidaRepositorySQLHelper(Context context){
        super(context,NOME_BANCO,null,VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Partida.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Partida.class,true);
            TableUtils.createTableIfNotExists(connectionSource, Partida.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Partida, Integer> getPartidaDao() throws SQLException {
        if(this.partidaDao == null){
            this.partidaDao = getDao(Partida.class);
        }
        return partidaDao;
    }
}
