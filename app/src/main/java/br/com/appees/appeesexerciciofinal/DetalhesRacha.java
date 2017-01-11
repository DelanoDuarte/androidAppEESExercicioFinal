package br.com.appees.appeesexerciciofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.domain.domain.Partida;
import br.com.appees.appeesexerciciofinal.repository.repository.repository.RepositorySQLHelper;

public class DetalhesRacha extends AppCompatActivity {

    TextView textViewNomePartida;
    TextView textViewLocalPartida;
    TextView textViewNumeroJogadoresPartida;
    TextView textViewDataPartida;
    String idPartida;

    private RepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_racha);

        idPartida = this.getIntent().getStringExtra("id_partida");

        textViewNomePartida = (TextView) findViewById(R.id.txtNomeDetalhesPartida);
        textViewLocalPartida = (TextView) findViewById(R.id.txtLocalDetalhesPartida);
        textViewDataPartida = (TextView) findViewById(R.id.txtHorarioDetalhesPartida);
        textViewNumeroJogadoresPartida = (TextView) findViewById(R.id.txtNumJogadoresDetalhesPartida);



        Partida partida = new Partida();
        try {
          partida = getRepositorySQLHelper().getPartidaDao().queryForId(Integer.parseInt(idPartida));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        textViewNomePartida.setText(partida.getNome());
        textViewLocalPartida.setText(partida.getLocal());
        textViewNumeroJogadoresPartida.setText(partida.getQuantidadeJogadores().toString());
        //textViewDataPartida.setText(partida.getData());

    }


    public RepositorySQLHelper getRepositorySQLHelper() {
        if(this.repositorySQLHelper == null){
            this.repositorySQLHelper = OpenHelperManager.getHelper(this,RepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
