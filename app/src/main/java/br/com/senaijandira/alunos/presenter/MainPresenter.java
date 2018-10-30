package br.com.senaijandira.alunos.presenter;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.services.AlunosService;
import br.com.senaijandira.alunos.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView mainView;
    AlunosService service;

    public MainPresenter(MainView mainView, AlunosService service){
        this.mainView = mainView;
        this.service = service;
    }

    public void carregarAlunos() {

        //chamada para a api /alunos
        Call<List<Aluno>> call = service.obterAlunos();

        mainView.exibirBarraProgresso();

        //executa a chamada a API
        //quando retorna a chamada, executa o callback
        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {

                List<Aluno> alunos = response.body();

                mainView.preencherLista(alunos);
                mainView.esconderBarraProgresso();
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {

                Log.d("ERRO", t.getMessage());
            }
        });
    }
}