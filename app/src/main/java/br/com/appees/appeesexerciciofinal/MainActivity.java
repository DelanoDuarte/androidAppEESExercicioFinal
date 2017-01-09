package br.com.appees.appeesexerciciofinal;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.appees.appeesexerciciofinal.domain.Partida;

public class MainActivity extends ListActivity {

    ArrayList<Partida> partidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.layout_itens_lista_partidas,R.id.textoDaLista1, partidas.toArray()){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

               //TextView textView = (TextView) view.findViewById(R.id.textoDaLista1);

                //textView.setText(partidas.get(position).getNome());
                //textView1.setText(partidas.ge


                return view;
            }
        };




        setListAdapter(arrayAdapter);



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        Toast.makeText(this,partidas.get(position).getNome(),Toast.LENGTH_LONG).show();

    }

}
