/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author José
 * d
 */
public class DevolucaoBo {

    public boolean devolucao(Locacao locacao) {
        boolean resultado = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().remover(locacao);
        CadastrarMultas calMulta = null;
        if (resultado) {
            System.err.println("lod "+locacao.getTipo());
        
            resultado = AlteraSateJogo.AlteraSateJogo(locacao.getJogo());
            int at = diasDeAtraso(locacao.getDataDevolucao());
            System.err.println("ssssss"+locacao.getDataDevolucao()+" dia"+at);
            if ( at > 0) {
                System.err.println("if lo"+locacao.getTipo());
                System.err.println("multa  lklkk");
                calMulta = new CadastrarMultas();
                resultado = calMulta.calMulta(locacao);
            }
            Notificarcao notificacao = null;
            if (resultado) {
                notificacao = Notificarcao.getInstancia();
                 notificacao.notificarClientes(locacao.getJogo());
            }
           

        }
        return resultado;
    }
    private int diasDeAtraso(LocalDate data) {

        return (int) LocalDate.now().until(data, ChronoUnit.DAYS);

    }
}
