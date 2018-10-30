package br.com.senaijandira.alunos.util;

public class DateUtil {

    public int toInt(String dateString){

        String[] dateSplit = dateString.split("/");

        String day   = dateSplit[0];
        String month = dateSplit[1];
        String year  = dateSplit[2];

        String dateFormatted = year + month + day;

        return Integer.parseInt(dateFormatted);
    }
}
