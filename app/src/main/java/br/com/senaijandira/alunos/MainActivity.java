package br.com.senaijandira.alunos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.services.AlunosService;
import br.com.senaijandira.alunos.services.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listaAlunos;
    AlunosAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAlunos = findViewById(R.id.listaAlunos);
        adapter = new AlunosAdapter(this);

        listaAlunos.setAdapter(adapter);
    }

    public void chamarApi(View v) {

        AlunosService service = ServiceFactory.create();

        //chamada para a api
        Call<List<Aluno>> call = service.obterAlunos();

        //executa a chamada a API
        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {

                List<Aluno> alunos = response.body();
                adapter.clear();
                for(Aluno a : alunos){

                    adapter.add(a);
                }

            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                    Log.d("ERRO", t.getMessage());
            }
        });
    }
}
