/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.time.LocalDate;

/**
 *
 * @author José
 */
public class DevolucaoBo {

    public boolean devolucao(Locacao locacao) {
        boolean resultado = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().remover(locacao);
        CadastrarMultas calMulta = null;
        if (resultado) {
            
            resultado = AlteraSateJogo.AlteraSateJogo(locacao.getJogo());
            
            if (locacao.getDataDevolucao().compareTo(LocalDate.now()) > 0) {
                
                calMulta = new CadastrarMultas();
                resultado = calMulta.calMulta(locacao);
            }

        }
        return resultado;
    }
}
