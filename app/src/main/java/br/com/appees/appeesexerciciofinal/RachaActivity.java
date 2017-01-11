package br.com.appees.appeesexerciciofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.Date;

import br.com.appees.appeesexerciciofinal.domain.domain.Partida;
import br.com.appees.appeesexerciciofinal.repository.repository.repository.RepositorySQLHelper;

public class RachaActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextLocal;
    EditText editTextNumJogadores;
    EditText editTextData;

    Button btnCadastrar;

    private RepositorySQLHelper repositorySQLHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racha);

        editTextNome = (EditText) findViewById(R.id.et_Nome);
        editTextLocal = (EditText) findViewById(R.id.ed_Local);
        editTextNumJogadores = (EditText) findViewById(R.id.ed_NumJogadores);
        editTextData = (EditText) findViewById(R.id.ed_Horario);
        editTextData.setText(new Date().toString());

        btnCadastrar = (Button) findViewById(R.id.bt_Salvar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Partida partida = new Partida();

                partida.setNome(editTextNome.getText().toString());
                partida.setLocal(editTextLocal.getText().toString());
                partida.setQuantidadeJogadores(Integer.valueOf(editTextNumJogadores.getText().toString()));

                try {
                    getRepositorySQLHelper().getPartidaDao().create(partida);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rachas,menu);
        return true;
    }

    public RepositorySQLHelper getRepositorySQLHelper() {
        if(repositorySQLHelper == null){
            repositorySQLHelper = OpenHelperManager.getHelper(this,RepositorySQLHelper.class);
        }
        return repositorySQLHelper;
    }
}
