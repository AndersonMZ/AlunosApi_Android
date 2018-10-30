package br.com.senaijandira.alunos;

import org.junit.Test;

import br.com.senaijandira.alunos.util.DataUtil;

import static org.junit.Assert.*;

public class CadastroUnitTest {

    @Test
    public void conversaoDataEstaCorreta(){

        DataUtil util = new DataUtil();

        String input = "01/01/2000";
        int outputEsperado = 20000101;

        int resposta = util.formatarParaInt(input);

        assertEquals( outputEsperado , resposta);
    }

    @Test
    public void conversaoData(){

        int input = 20000101;
        String outputEsperado = "01/01/2000";

        String resposta = DataUtil.formatarData(input);

        assertEquals( outputEsperado, resposta);
    }
}
