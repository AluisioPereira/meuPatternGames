/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author José
 */
public class MultaAtrasoLocacaoComum implements CalculaMultaIF {

    @Override
    public BigDecimal calcularMulta(String dataLocacao) {
       
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
          System.err.println("dias "+(diasAtraso / 86400000L));
        if ((diasAtraso / 86400000L) > 0) {
            return new BigDecimal(((diasAtraso / 86400000L) * 1) + 3);
        }
        return BigDecimal.ZERO;
    }

}
