package br.com.senaijandira.alunos.util;

public class DataUtil {

    public int formatarParaInt(String dateString){

        String[] dateSplit = dateString.split("/");

        String day   = dateSplit[0];
        String month = dateSplit[1];
        String year  = dateSplit[2];

        String dateFormatted = year + month + day;

        return Integer.parseInt(dateFormatted);
    }

    public static String formatarData(int dataApi){

        String dataString = String.valueOf(dataApi);

        String dia = dataString.substring(6, 8);
        String mes = dataString.substring(4, 6);
        String ano = dataString.substring(0, 4);

        String stringRetorno = dia + "/" + mes + "/" + ano;

        return stringRetorno;
    }
}
