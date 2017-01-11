package br.com.appees.appeesexerciciofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.domain.domain.Jogadores;
import br.com.appees.appeesexerciciofinal.repository.repository.jogador.JogadorRepositorySQLHelper;

public class JogadorActivity extends AppCompatActivity {


    EditText editTextNome;
    EditText editTextNivelJogador;
    RatingBar ratingBarNivelJogador;

    Button btnSalvarJogador;

    private JogadorRepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);

        editTextNome = (EditText) findViewById(R.id.et_NomeJogador);
        //editTextNivelJogador = (EditText) findViewById(R.id.ed_NivelJogadores);
        ratingBarNivelJogador = (RatingBar) findViewById(R.id.ratingBarNivelJogador);

        ratingBarNivelJogador.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Jogadores jogadores = new Jogadores();

                jogadores.setNome(editTextNome.getText().toString());
                jogadores.setNivel(ratingBarNivelJogador.getNumStars());

                try {
                    getRepositorySQLHelper().getJogadorDAO().create(jogadores);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public JogadorRepositorySQLHelper getRepositorySQLHelper() {
        if(this.repositorySQLHelper == null){
            this.repositorySQLHelper = OpenHelperManager.getHelper(this,JogadorRepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
