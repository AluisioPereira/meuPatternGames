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
        int diasAtraso = (int) dataDevolucao.until(LocalDate.now(), ChronoUnit.DAYS);
    if(diasAtraso  > 0){
        return new BigDecimal((diasAtraso *1) +3);
       
    }
    return BigDecimal.ZERO;

    }

}
