package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.services.AlunosService;
import br.com.senaijandira.alunos.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    VisualizarView view;
    AlunosService service;

    public VisualizarPresenter(VisualizarView view, AlunosService service) {
        this.view = view;
        this.service = service;
    }

    public void requisitarDados(int idAluno){

        service.obterAlunoId(idAluno).enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {

                view.preencherDados(response.body());
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
