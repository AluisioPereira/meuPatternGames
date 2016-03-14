/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Reserva;
import br.edu.ifpb.pattengames.factoy.DaoFactory;

/**
 *
 * @author José
 */
public class ReservarJogoBo {
    public boolean reservaJogo(Cliente cliente, Jogo jogo){
     return DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao().add(new Reserva(cliente, jogo));
    }
    
}
