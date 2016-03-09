/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import br.edu.ifpb.pattengames.Enum.TipoLocacao;
import br.edu.ifpb.pattengames.model.DevolucaoBo;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author José
 */
public class LocacaoEspecial extends Locacao {

    public LocacaoEspecial() {
        this.setTipo(TipoLocacao.ESPECIAL.name());
        this.setDataLocacao(LocalDate.now());
        this.setDataDevolucao(dataDevolver());

    }

    @Override
    public LocalDate dataDevolver() {
          LocalDate hoje = LocalDate.now();
        LocalDate devolucao = null ;
         
        DayOfWeek diaDaSemana = hoje.getDayOfWeek();
        switch (diaDaSemana) {
            case FRIDAY:
                devolucao = hoje.plusDays(3);
                break;
            case SATURDAY:
                devolucao = hoje.plusDays(2);
                break;
            case SUNDAY:
                devolucao = hoje.plusDays(1);
                break;
           
            default:
                 System.out.println("Este não é um dia válido!");
         }
      
        return devolucao;
    }

}
