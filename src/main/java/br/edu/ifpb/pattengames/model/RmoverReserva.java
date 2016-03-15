/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Reserva;
import br.edu.ifpb.pattengames.factoy.DaoFactory;

/**
 *
 * @author José
 */
public class RmoverReserva {
    public boolean removerReserva(Reserva reserva){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao().remover(reserva);
    }
}
