/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Reserva;
import java.util.List;

/**
 *
 * @author José
 */
public interface ReservasDaoIf {

   

    public List<Reserva> buscarJogo(String nomeJogo);

    public List<Reserva> buscarEmailCliente(String email);

    public List<Reserva> buscarTodas();

    public boolean add(Reserva reserva);

    public boolean remover(Reserva reseva);

}
