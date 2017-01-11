package br.com.appees.appeesexerciciofinal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.appees.appeesexerciciofinal.domain.domain.Partida;
import br.com.appees.appeesexerciciofinal.repository.repository.repository.RepositorySQLHelper;

public class Rachas extends AppCompatActivity {

    ListView listView;
    List<Partida> partidaList;
    private RepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rachas);

        FloatingActionButton floatingActionButton= (FloatingActionButton) findViewById(R.id.fabAddRacha);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RachaActivity.class);
                startActivity(intent);
            }
        });


        List<String> partidasTemp = new ArrayList<>();

        listView = (ListView) findViewById(R.id.lvRachas);

        try {
            partidaList = getRepositorySQLHelper().getPartidaDao().queryBuilder().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Partida partida: partidaList){
            partidasTemp.add(partida.getNome());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_layout_list_rachas,R.id.txtNomePartida,partidasTemp);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();

                Bundle bundle= new Bundle();

                startActivity(intent);
            }
        });

    }

    public RepositorySQLHelper getRepositorySQLHelper() {
        if(repositorySQLHelper == null){
            repositorySQLHelper = OpenHelperManager.getHelper(this,RepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }

}
