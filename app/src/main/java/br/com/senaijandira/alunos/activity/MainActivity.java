package br.com.senaijandira.alunos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.presenter.MainPresenter;
import br.com.senaijandira.alunos.view.MainView;
import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.adapter.AlunoAdapter;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.services.ServiceFactory;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

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
        listaAlunos.setOnItemClickListener(this);

        //config presenter
        presenter = new MainPresenter(this, ServiceFactory.create());
    }

    @Override
    protected void onResume() {
        super.onResume();

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

    public void abrirCadastro(View v){
        startActivity(new Intent(this, CadastroActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Aluno alunoSeleciona = adapter.getItem(position);

        Intent intent = new Intent(this, VisualizarActivity.class);

        intent.putExtra("idAluno", alunoSeleciona.getId());

        startActivity(intent);
    }
}
