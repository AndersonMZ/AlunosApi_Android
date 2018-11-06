package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.services.AlunosService;
import br.com.senaijandira.alunos.services.ServiceFactory;
import br.com.senaijandira.alunos.util.DataUtil;
import br.com.senaijandira.alunos.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView {

    AlunosService service;
    VisualizarPresenter presenter;

    EditText txtNome, txtDtNasc, txtMatricula, txtCpf, txtNotas, txtMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        //pegando o id do aluno enviado via intent
        int idAluno = getIntent().getIntExtra("idAluno", 0);

        txtNome = findViewById(R.id.txtNome);
        txtDtNasc = findViewById(R.id.txtDtNasc);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCPF);
        txtNotas = findViewById(R.id.txtNotas);
        txtMedia = findViewById(R.id.txtMedia);

        service = ServiceFactory.create();
        presenter = new VisualizarPresenter(this, service);

        //envia o id para o presenter requisitar os dados
        presenter.requisitarDados(idAluno);
    }

    @Override
    public void preencherDados(Aluno aluno) {
        //recebe os dados do presenter e seta nos TextView

        String nome = aluno.getNome();
        String dtNasc = DataUtil.formatarData(aluno.getDataNascimento());
        String matricula = String.valueOf(aluno.getMatricula());
        String cpf = aluno.getCpf();
        String notas = aluno.getNotas().toString();
        String mediaStr = aluno.calcularMedia().toString();

        txtNome.setText(nome);
        txtDtNasc.setText(dtNasc);
        txtMatricula.setText(matricula);
        txtCpf.setText(cpf);
        txtNotas.setText(notas);
        txtMedia.setText(mediaStr);
    }
}
