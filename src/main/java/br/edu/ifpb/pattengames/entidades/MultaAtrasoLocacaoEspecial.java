/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author José
 */
public class MultaAtrasoLocacaoEspecial implements CalculaMulta {

    @Override
    public BigDecimal calcularMulta(String dataLocacao) {
        // Dando um exemplo: quantos dias se passam desde 07/09/1822 até 05/06/2006?
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = null;
        try {
            d1 = df.parse(dataLocacao);
        } catch (java.text.ParseException ex) {

        }
        Date d2 = new Date();// tual
        System.out.println("dataatual " + d2);
        long diasAtraso = (d2.getTime() - d1.getTime());
        System.err.println("dias " + (diasAtraso / 86400000L));
        if ((diasAtraso / 86400000L) > 0) {
            return new BigDecimal(((diasAtraso / 86400000L) * 3) + 3);
        }
        return BigDecimal.ZERO;
    }

}
