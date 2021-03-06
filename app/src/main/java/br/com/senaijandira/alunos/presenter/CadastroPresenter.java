package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.model.ApiResult;
import br.com.senaijandira.alunos.services.AlunosService;
import br.com.senaijandira.alunos.view.CadastroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPresenter {

    CadastroView view;
    AlunosService service;

    public CadastroPresenter(CadastroView view, AlunosService service) {
        this.view = view;
        this.service = service;
    }

    public void cadastrarAluno(Aluno aluno){

        service.cadastrarAluno(aluno).enqueue(new Callback<ApiResult>() {

            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {

                ApiResult result = response.body();

                if(result.isSucesso()){
                    view.showMessage("Sucesso","Cadastrado com sucesso");
                }
                else{
                    view.showMessage("Erro","Cadastrado com sucesso");
                }
            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {

                view.showMessage("Erro", t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
