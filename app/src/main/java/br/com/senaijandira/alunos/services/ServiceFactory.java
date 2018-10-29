package br.com.senaijandira.alunos.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static AlunosService create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AlunosService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AlunosService.class);
    }
}