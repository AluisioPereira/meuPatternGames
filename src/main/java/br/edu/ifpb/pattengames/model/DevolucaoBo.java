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
            System.err.println("pa 1");
            resultado = AlteraSateJogo.AlteraSateJogo(locacao.getJogo());
            System.err.println("pa 2 " + resultado);
            long atraso = locacao.getDataDevolucao().until(LocalDate.now(), ChronoUnit.DAYS);
            if ( atraso > 0) {

                calMulta = new CadastrarMultas();
                System.err.println("pa 2 " + resultado);
                resultado = calMulta.calMulta(locacao);
            }
            System.err.println("client de"+locacao.getCliente());
            Notificarcao notificacao = null;
            if (resultado) {
                System.err.println("entrou no if not");
                notificacao = Notificarcao.getInstancia();
                 notificacao.notificarClientes(locacao.getJogo());
            }
           

        }
        return resultado;
    }
}
