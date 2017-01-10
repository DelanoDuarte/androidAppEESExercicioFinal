package br.com.appees.appeesexerciciofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import br.com.appees.appeesexerciciofinal.domain.Jogadores;
import br.com.appees.appeesexerciciofinal.domain.Partida;

public class RachaActivity extends AppCompatActivity {

    private Partida racha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rachas,menu);
        return true;
    }

    public void SalvarRacha(View view)
    {
        String nome, local;
        int qtdJogadores;
        Date data;

        EditText n = (EditText)findViewById(R.id.et_NomeRacha);
        nome = n.getText().toString();

        EditText q = (EditText)findViewById(R.id.et_NumJogadores);
        qtdJogadores = Integer.parseInt(q.getText().toString());

        EditText l = (EditText)findViewById(R.id.et_Local);
        local = l.getText().toString();

        //EditText h = (EditText)findViewById(R.id.et_Horario);
        //data = Date.parse(h.getText().toString());

        racha = new Partida(nome,local,qtdJogadores);

    }
}
