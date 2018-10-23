package br.com.senaijandira.alunos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.alunos.model.Aluno;

public class AlunosAdapter extends ArrayAdapter<Aluno> {

    public AlunosAdapter(Context ctx){
        super(ctx, 0 , new ArrayList<Aluno>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){

            v = LayoutInflater.from(getContext()).inflate(R.layout.list_item_aluno, parent, false);
        }

        Aluno aluno = getItem(position);

        TextView txtNomeAluno = v.findViewById(R.id.txtNomeAluno);
        TextView txtDtNasc = v.findViewById(R.id.txtDtNasc);
        TextView txtMatricula = v.findViewById(R.id.txtMatricula);
        TextView txtCPF = v.findViewById(R.id.txtCPF);
        TextView txtNotas = v.findViewById(R.id.txtNotas);

        txtNomeAluno.setText(aluno.getNome());
        txtDtNasc.setText(String.valueOf(aluno.getDataNascimento()));
        txtMatricula.setText(String.valueOf(aluno.getMatricula()));
        txtCPF.setText(aluno.getCpf());
        txtNotas.setText(aluno.getNotas().toString());

        return v;
    }
}
