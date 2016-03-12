/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author José
 */
public class MultaAtrasoLocacaoEspecial implements CalculaMultaIF {

    @Override
    public BigDecimal calcularMulta(LocalDate dataDevolucao) {
         
      int diasAtraso = (int) dataDevolucao.until(LocalDate.now(), ChronoUnit.DAYS);
    if(diasAtraso  > 0){
        return new BigDecimal((diasAtraso *3) +(3));
       
    }
     return BigDecimal.ZERO;

   
    }

}
