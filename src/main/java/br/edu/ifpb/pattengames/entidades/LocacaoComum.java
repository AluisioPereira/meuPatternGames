/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import br.edu.ifpb.pattengames.Enum.TipoLocacao;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author José
 */
public class LocacaoComum extends Locacao {

    public LocacaoComum() {
        this.setTipo(TipoLocacao.COMUN.name());
        setDataLocacao(LocalDate.now());
        setDataDevolucao(dataDevolver());
    }

    @Override
    public LocalDate dataDevolver() {
        LocalDate hoje = LocalDate.now();
        LocalDate devolucao = hoje.plusDays(1) ;
         
        return devolucao;
    }

}
