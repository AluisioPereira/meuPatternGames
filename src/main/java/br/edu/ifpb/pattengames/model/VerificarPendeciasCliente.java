/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author José
 */
public class VerificarPendeciasCliente {
    public static boolean  execute(Integer idCliente){
        List<BigDecimal> isMulta = DaoFactory.createFactory(DaoFactory.DAO_BD).criaMultaDao().buscarCliente(idCliente);
        return  ! isMulta.isEmpty();
        
    }
    
}
