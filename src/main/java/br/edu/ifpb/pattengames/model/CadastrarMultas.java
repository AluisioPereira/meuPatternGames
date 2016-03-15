/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.Enum.TipoLocacao;
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.entidades.MultaAtrasoLocacaoComum;
import br.edu.ifpb.pattengames.entidades.MultaAtrasoLocacaoEspecial;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author José
 */
public class CadastrarMultas {

    public boolean calMulta(Locacao locacao) {
        BigDecimal multa;
        if (TipoLocacao.COMUM.name()==locacao.getTipo() ) {
            System.err.println("losssss "+locacao.getTipo());
              MultaAtrasoLocacaoComum locComum = new MultaAtrasoLocacaoComum();
            multa = locComum.calcularMulta(locacao.getDataLocacao());
        } else {
            System.err.println("lo especial  "+locacao.getTipo());
           MultaAtrasoLocacaoEspecial locEspecial = new MultaAtrasoLocacaoEspecial();
            multa = locEspecial.calcularMulta(locacao.getDataDevolucao());
            
        }

        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMultaDao().add(locacao.getCliente().getId(), multa);

    }

   

}
