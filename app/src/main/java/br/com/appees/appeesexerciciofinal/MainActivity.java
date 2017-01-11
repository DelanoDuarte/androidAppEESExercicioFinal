package br.com.appees.appeesexerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;

//import static br.com.appees.appeesexerciciofinal.R.id.textoDaLista2;

public class MainActivity extends AppCompatActivity /*ListActivity*/ {

    //Button btnTelaJogador;
    //Button btnTelaPartida;
    MenuItem menuItemPartida;
    MenuItem menuItemJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItemJogador = (MenuItem) findViewById(R.id.menuItemJogador);
        menuItemPartida = (MenuItem) findViewById(R.id.menuItemPartida);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela_inicial,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItemJogador:
                Intent intent = new Intent(this,JogadoresActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuItemPartida:
                Intent intent1 = new Intent(this,Rachas.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
