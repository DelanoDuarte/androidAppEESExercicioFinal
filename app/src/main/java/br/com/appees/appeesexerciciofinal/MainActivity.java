package br.com.appees.appeesexerciciofinal;

import android.app.ListActivity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import br.com.appees.appeesexerciciofinal.domain.Partida;

import static br.com.appees.appeesexerciciofinal.R.id.textoDaLista2;

public class MainActivity extends AppCompatActivity /*ListActivity*/ {

    ArrayList<Partida> partidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //salvarNovasPartidas();

        /*ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.layout_itens_lista_tela_inicial,R.id.textoDaLista1, partidas.toArray()){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(R.id.textoDaLista1);
                TextView textView1 = (TextView) view.findViewById(R.id.textoDaLista2);

                textView.setText(partidas.get(position).getNome());
                textView1.setText(partidas.get(position).getLocal());


                return view;
            }
        };*/

        setContentView(R.layout.activity_main);




        //setListAdapter(arrayAdapter);



    }

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        Toast.makeText(this,partidas.get(position).getNome(),Toast.LENGTH_LONG).show();

    }*/

    public void salvarNovasPartidas(){

        partidas = new ArrayList<Partida>();

        Partida partida = new Partida("Partida 1","Local 1",new Date());
        Partida partida1 = new Partida("Partida 2","Local 2", new Date());

        partidas.add(partida);
        partidas.add(partida1);

    }
}
