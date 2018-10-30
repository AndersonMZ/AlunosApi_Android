package br.com.senaijandira.alunos.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.CadastroPresenter;
import br.com.senaijandira.alunos.services.AlunosService;
import br.com.senaijandira.alunos.services.ServiceFactory;
import br.com.senaijandira.alunos.util.DataUtil;
import br.com.senaijandira.alunos.view.CadastroView;

public class CadastroActivity extends AppCompatActivity implements CadastroView {

    static EditText txtNome,txtDtNasc,txtMatricula, txtCpf;

    AlunosService service;
    CadastroPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtNome = findViewById(R.id.txtNome);
        txtDtNasc = findViewById(R.id.txtDtNasc);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCPF);

        service = ServiceFactory.create();
        presenter = new CadastroPresenter(this, service);
    }

    @Override
    public void showMessage(String titulo, String mensagem) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle(titulo);
        alert.setMessage(mensagem);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert.show();
    }

    public void cadastrarAluno(View v) {

        String nome = txtNome.getText().toString();
        String dtNasc = (txtDtNasc.getText().toString());
        String matricula = txtMatricula.getText().toString();
        String cpf = txtCpf.getText().toString();

        int dataFormatada = new DataUtil().formatarParaInt(dtNasc);

        Aluno aluno = new Aluno();

        aluno.setNome(nome);
        aluno.setDataNascimento(dataFormatada);
        aluno.setMatricula(Integer.parseInt(matricula));
        aluno.setCpf(cpf);

        presenter.cadastrarAluno(aluno);
    }

    public void abrirCalendario(View v) {

        //abre o datepicker
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment
            extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            // Seta a data padrão do datePicker
            final Calendar c = Calendar.getInstance();
            int year  = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day   = c.get(Calendar.DAY_OF_MONTH);

            // Instancia o datePicker
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            // Converte para 00/00/0000
            String data = String.format("%02d/%02d/%d", day, month, year);
            txtDtNasc.setText(data);
        }
    }
}
