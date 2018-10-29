package br.com.senaijandira.alunos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.adapter.AlunoAdapter;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.services.ServiceFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    ProgressBar barra;
    ListView listaAlunos;

    AlunoAdapter adapter;
    MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = findViewById(R.id.progressBar);

        listaAlunos = findViewById(R.id.listaAlunos);
        adapter = new AlunoAdapter(this);

        listaAlunos.setAdapter(adapter);

        //config presenter
        presenter = new MainPresenter(this,
                ServiceFactory.create());

        presenter.carregarAlunos();
    }

    @Override
    public void exibirBarraProgresso(){
        barra.setVisibility(View.VISIBLE);
        listaAlunos.setVisibility(View.GONE);
    }

    @Override
    public void esconderBarraProgresso(){
        barra.setVisibility(View.GONE);
        listaAlunos.setVisibility(View.VISIBLE);
    }

    @Override
    public void preencherLista(List<Aluno> lstAlunos){
        adapter.clear();
        adapter.addAll(lstAlunos);
    }
}
