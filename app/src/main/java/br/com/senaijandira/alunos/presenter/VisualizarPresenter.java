package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.AlunoMedia;
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

        service.obterMedia(idAluno).enqueue(new Callback<AlunoMedia>() {
            @Override
            public void onResponse(Call<AlunoMedia> call, Response<AlunoMedia> response) {

                view.preencherDados(response.body());
            }

            @Override
            public void onFailure(Call<AlunoMedia> call, Throwable t) {

            }
        });
    }
}
