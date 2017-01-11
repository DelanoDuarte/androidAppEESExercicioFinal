package br.com.appees.appeesexerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.appees.appeesexerciciofinal.domain.Partida;
import br.com.appees.appeesexerciciofinal.repository.partida.PartidaRepository;

public class Rachas extends AppCompatActivity {

    PartidaRepository rep;
    List<Partida> rachas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rachas);

        rep = new PartidaRepository(this);
        rachas = rep.buscarTodasPartidas();

        ListView lv = (ListView)findViewById(R.id.lvRachas);

        //ArrayAdapter adaptor = new ArrayAdapter<Partida>(this)
    }


    public void CriarRacha(View view)
    {
        Intent it = new Intent(this, RachaActivity.class);
        startActivity(it);
    }
}
