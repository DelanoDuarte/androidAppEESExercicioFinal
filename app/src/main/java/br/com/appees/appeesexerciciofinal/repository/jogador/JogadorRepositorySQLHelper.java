package br.com.appees.appeesexerciciofinal.repository.jogador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.domain.Jogadores;

/**
 * Created by delan on 04/01/2017.
 */

public class JogadorRepositorySQLHelper extends OrmLiteSqliteOpenHelper {

    private static final String NOME_BANCO = "db_projeto";
    private static final int VERSAO_BANCO = 1;

    private Dao<Jogadores,Integer> jogadorDAO = null;


    public JogadorRepositorySQLHelper(Context context){
        super(context,NOME_BANCO,null,VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Jogadores.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Jogadores.class,true);
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
}
