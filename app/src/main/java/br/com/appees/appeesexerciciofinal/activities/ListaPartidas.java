package br.com.appees.appeesexerciciofinal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.appees.appeesexerciciofinal.R;
import br.com.appees.appeesexerciciofinal.domain.Partida;
import br.com.appees.appeesexerciciofinal.repository.partida.PartidaRepositorySQLHelper;

public class ListaPartidas extends AppCompatActivity {

    ListView listView;
    List<Partida> partidaList;
    private PartidaRepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partidas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),CadastroPartida.class);
                startActivity(intent);
            }
        });

        List<String> partidasTemp = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listaPartidas);

        try {
            partidaList = getRepositorySQLHelper().getPartidaDao().queryBuilder().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Partida partida: partidaList){
            partidasTemp.add(partida.getNome());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.layout_itens_lista_partidas,R.id.textoDaLista1,partidasTemp);

        listView.setAdapter(arrayAdapter);

    }

    public PartidaRepositorySQLHelper getRepositorySQLHelper() {
        if(repositorySQLHelper == null){
            repositorySQLHelper = OpenHelperManager.getHelper(this,PartidaRepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
