package br.com.appees.appeesexerciciofinal.repository.repository.repository;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.R;
import br.com.appees.appeesexerciciofinal.domain.domain.Jogadores;

public class DetalhesJogador extends AppCompatActivity {

    TextView textViewDetalhesNomeJogador;
    RatingBar ratingBarDetalhesNivelJogador;

    String idJogador;

    private RepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_jogador);

        idJogador = this.getIntent().getStringExtra("id_jogador");

        textViewDetalhesNomeJogador = (TextView) findViewById(R.id.txt_DetalhesNomeJogador);
        ratingBarDetalhesNivelJogador = (RatingBar) findViewById(R.id.ratingBarDetalhesNivelJogador);


        Jogadores jogador = new Jogadores();

        try {
            jogador = getRepositorySQLHelper().getJogadorDAO().queryForId(Integer.parseInt(idJogador));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        textViewDetalhesNomeJogador.setText(jogador.getNome());
        //ratingBarDetalhesNivelJogador.setNumStars(jogador.getNivel().intValue());
        ratingBarDetalhesNivelJogador.setRating(jogador.getNivel());
    }

    public RepositorySQLHelper getRepositorySQLHelper() {
        if(this.repositorySQLHelper == null){
            this.repositorySQLHelper = OpenHelperManager.getHelper(this,RepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
