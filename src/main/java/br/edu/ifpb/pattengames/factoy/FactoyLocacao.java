/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.factoy;

import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.entidades.LocacaoComum;
import br.edu.ifpb.pattengames.entidades.LocacaoEspecial;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author José
 */
public class FactoyLocacao implements FactoyLocacaoIF {
    private  LocalDate hoje = LocalDate.now();

    @Override
    public Locacao   criarLocacao() {
        DayOfWeek diaDaSemana = hoje.getDayOfWeek();
        if (diaDaSemana == DayOfWeek.FRIDAY || diaDaSemana == DayOfWeek.SATURDAY || diaDaSemana == DayOfWeek.SUNDAY) {
            return new LocacaoEspecial();
        }
        return new LocacaoComum();
    }

}
