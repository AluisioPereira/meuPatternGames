/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author José
 */
public class MultaAtrasoLocacaoComum implements CalculaMultaIF {

    @Override
    public BigDecimal calcularMulta(LocalDate dataDevolucao) {
        int diasAtraso = (int) LocalDate.now().until(dataDevolucao, ChronoUnit.DAYS);
    if(diasAtraso  > 0){
        System.err.println("to aqui");
        return new BigDecimal(diasAtraso).multiply(BigDecimal.valueOf(1)).add(BigDecimal.valueOf(3));
       
    }
    return BigDecimal.ZERO;

    }

}
