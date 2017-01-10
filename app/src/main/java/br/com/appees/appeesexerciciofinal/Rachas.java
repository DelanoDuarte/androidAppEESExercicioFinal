package br.com.appees.appeesexerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Rachas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rachas);
    }


    public void CriarRacha(View view)
    {
        Intent it = new Intent(this, RachaActivity.class);
        startActivity(it);
    }
}
