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
import java.util.List;

/**
 *
 * @author José
 */
public class Notificarcao {

    public static Notificarcao instancia;

    private Notificarcao() {

    }

    public void notificarClientes(Jogo jogo) {
        List<Reserva> reservas = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao().buscarJogo(jogo.getNome());
        if (reservas.isEmpty()) {
            return;
        }
        for (int i=0; i < reservas.size();i++) {
            reservas.get(i).getCliente().update(jogo);
           // c.update(jogo);
        }
    }

    public static Notificarcao getInstancia() {
        if (instancia == null) {
            instancia = new Notificarcao();
        }
        return instancia;
    }

}
