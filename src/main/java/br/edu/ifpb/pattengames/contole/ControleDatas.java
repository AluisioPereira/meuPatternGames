/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.contole;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.internet.MailDateFormat;

/**
 *
 * @author Zilderlan
 */
public class ControleDatas {
    Date data = null;
    Calendar date = null;
    Calendar dateDevolucao = null;
    public String dataCadastro(){
        date = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String saida = df.format(date.getTime());
        
        return saida;
    }
    
    public String dataDevolucao(){
        dateDevolucao =  Calendar.getInstance();
        if (date.get(Calendar.DAY_OF_WEEK) == 7)
            dateDevolucao.add(Calendar.DATE, 2);
        else
            dateDevolucao.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String saida = df.format(dateDevolucao.getTime());
        return saida;
    }
    
    public String tipoLocacao(){
        String tipo = "Simple";
        if (date.get(Calendar.DAY_OF_WEEK) == 7)
            tipo = "Especial";
       
        return tipo;
    }
    
    public String formatarDate(Date date){
        Date data = date;
        DateFormat df = DateFormat.getInstance();
        String saida = df.format(data);

        return "ddd";
    }
    
}
