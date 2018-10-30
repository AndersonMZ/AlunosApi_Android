package br.com.senaijandira.alunos.services;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.model.AlunoMedia;
import br.com.senaijandira.alunos.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//inbterface que declara os endpoints que serão acessados na api
public interface AlunosService {

    String URL_BASE = "http://192.168.0.101:5001"; //"http://10.0.2.2:5001/";

    @GET("/alunos")
    Call< List<Aluno> > obterAlunos();

    @POST("/novo")
    Call< ApiResult > cadastrarAluno(@Body Aluno aluno);

    @GET("/media/{id}")
    Call< AlunoMedia > obterMedia(@Path("id") int id);
}