package br.com.appees.appeesexerciciofinal.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.Date;

import br.com.appees.appeesexerciciofinal.R;
import br.com.appees.appeesexerciciofinal.domain.Partida;
import br.com.appees.appeesexerciciofinal.repository.partida.PartidaRepositorySQLHelper;

public class CadastroPartida extends AppCompatActivity {

    private PartidaRepositorySQLHelper repositorySQLHelper = null;

    EditText txtNomePartida;
    EditText txtLocalPartida;
    EditText txtQtdJogadores;
    EditText txtHorarioPartida;

    Button buttonCadastrarPartida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_partida);


        txtNomePartida = (EditText) findViewById(R.id.editTextNomePartida);
        txtLocalPartida = (EditText) findViewById(R.id.editTextLocalPartida);
        txtQtdJogadores = (EditText) findViewById(R.id.editTextQtdJogadores);
        txtHorarioPartida = (EditText) findViewById(R.id.editTextDataPartida);
        txtHorarioPartida.setText(new Date().toString());

        buttonCadastrarPartida = (Button) findViewById(R.id.buttonSalvarPartida);

        buttonCadastrarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Partida partida = new Partida();

                partida.setNome(txtNomePartida.getText().toString());
                partida.setLocal(txtLocalPartida.getText().toString());
                partida.setQuantidadeJogadores(Integer.valueOf(txtQtdJogadores.getText().toString()));

                try {
                    getRepositorySQLHelper().getPartidaDao().create(partida);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public PartidaRepositorySQLHelper getRepositorySQLHelper() {
        if(repositorySQLHelper == null){
            repositorySQLHelper = OpenHelperManager.getHelper(this,PartidaRepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
