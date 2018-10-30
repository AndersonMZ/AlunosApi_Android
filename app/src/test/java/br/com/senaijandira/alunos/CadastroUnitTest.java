package br.com.senaijandira.alunos;

import org.junit.Test;

import br.com.senaijandira.alunos.util.DateUtil;

import static org.junit.Assert.*;

public class CadastroUnitTest {

    @Test
    public void conversaoDataEstaCorreta(){

        DateUtil util = new DateUtil();

        String input = "01/01/2000";
        int outputEsperado = 20000101;

        int resposta = util.toInt(input);

        assertEquals( outputEsperado , resposta);
    }
}
