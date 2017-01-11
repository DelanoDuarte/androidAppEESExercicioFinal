package br.com.appees.appeesexerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;

//import static br.com.appees.appeesexerciciofinal.R.id.textoDaLista2;

public class MainActivity extends AppCompatActivity /*ListActivity*/ {

    Button btnTelaJogador;
    Button btnTelaPartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnTelaJogador = (Button) findViewById(R.id.btJogadores);
        btnTelaPartida = (Button) findViewById(R.id.btRachas);

        btnTelaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Rachas.class);
                startActivity(intent);
            }
        });

        btnTelaJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),JogadoresActivity.class);
                startActivity(intent);
            }
        });

    }

}
