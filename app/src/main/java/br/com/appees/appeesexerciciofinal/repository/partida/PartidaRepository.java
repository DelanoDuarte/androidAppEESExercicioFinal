package br.com.appees.appeesexerciciofinal.repository.partida;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.appees.appeesexerciciofinal.domain.Partida;

/**
 * Created by delan on 03/01/2017.
 */

public class PartidaRepository {

    private final String NOME_TABELA = "tb_partida";

    private PartidaRepositorySQLHelper repositorySQLHelper;

    public PartidaRepository(Context context){
        repositorySQLHelper = new PartidaRepositorySQLHelper(context);
    }

    public void salvarPartida(Partida partida){

        SQLiteDatabase sqLiteDatabase = repositorySQLHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",partida.getNome());
        contentValues.put("local",partida.getLocal());

        sqLiteDatabase.insert(NOME_TABELA,null,contentValues);
    }

    public List<Partida> buscarTodasPartidas(){

        SQLiteDatabase sqLiteDatabase = repositorySQLHelper.getReadableDatabase();

        String query = "select * from" + NOME_TABELA;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        List<Partida> partidas = new ArrayList<Partida>();

        while (cursor.moveToNext()){
            Partida partida = new Partida();
            partida.setId(cursor.getInt(0));
            partida.setNome(cursor.getString(1));
            partida.setLocal(cursor.getString(2));

            partidas.add(partida);
        }

        cursor.close();
        sqLiteDatabase.close();

        return partidas;
    }

}
