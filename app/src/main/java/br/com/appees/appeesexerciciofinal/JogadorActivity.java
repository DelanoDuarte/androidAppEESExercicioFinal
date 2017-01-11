package br.com.appees.appeesexerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import br.com.appees.appeesexerciciofinal.domain.domain.Jogadores;
import br.com.appees.appeesexerciciofinal.repository.repository.repository.RepositorySQLHelper;

public class JogadorActivity extends AppCompatActivity {


    EditText editTextNome;
    EditText editTextNivelJogador;
    RatingBar ratingBarNivelJogador;

    Button btnSalvarJogador;

    private RepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);

        editTextNome = (EditText) findViewById(R.id.et_NomeJogador);
        //editTextNivelJogador = (EditText) findViewById(R.id.ed_NivelJogadores);
        ratingBarNivelJogador = (RatingBar) findViewById(R.id.ratingBarNivelJogador);

        btnSalvarJogador = (Button) findViewById(R.id.bt_Salvar);

        btnSalvarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jogadores jogadores = new Jogadores();

                jogadores.setNome(editTextNome.getText().toString());
                jogadores.setNivel(ratingBarNivelJogador.getRating());

                try {
                    getRepositorySQLHelper().getJogadorDAO().create(jogadores);
                    Intent intent = new Intent(view.getContext(),JogadoresActivity.class);
                    startActivity(intent);
                    Toast.makeText(view.getContext(),"Novo Jogador adicionado com Sucesso !",Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public RepositorySQLHelper getRepositorySQLHelper() {
        if(this.repositorySQLHelper == null){
            this.repositorySQLHelper = OpenHelperManager.getHelper(this,RepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
