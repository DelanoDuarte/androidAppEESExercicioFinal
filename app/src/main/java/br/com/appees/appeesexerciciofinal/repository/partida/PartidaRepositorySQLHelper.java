package br.com.appees.appeesexerciciofinal.repository.partida;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by delan on 03/01/2017.
 */

public class PartidaRepositorySQLHelper extends SQLiteOpenHelper  {

    private static final String NOME_BANCO = "db_projeto";
    private static final int VERSAO_BANCO = 1;

    private static final String SQL_CRIAR_TABELA = "CREATE TABLE tb_partida(id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nome TEXT NOT NULL, local TEXT NOT NULL)";

    public PartidaRepositorySQLHelper(Context context){

        super(context,NOME_BANCO,null,VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CRIAR_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
