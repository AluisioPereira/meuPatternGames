/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.factoy.DaoFactory;

/**
 *
 * @author José
 */
public class ExclurClienteBo {
    public  boolean excluirCliente(Cliente Cliente){
        
      return DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().remover(Cliente);
    
    
}
    
        
    
}
