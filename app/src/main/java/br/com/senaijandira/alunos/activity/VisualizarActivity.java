package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.AlunoMedia;
import br.com.senaijandira.alunos.services.AlunosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarActivity extends AppCompatActivity {

    AlunosService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        //pegando o id do aluno enviado via intent
        int idAluno = getIntent().getIntExtra("idAluno", 0);

        service.media(idAluno).enqueue(new Callback<AlunoMedia>() {
            @Override
            public void onResponse(Call<AlunoMedia> call, Response<AlunoMedia> response) {

            }

            @Override
            public void onFailure(Call<AlunoMedia> call, Throwable t) {

            }
        });
    }
}
