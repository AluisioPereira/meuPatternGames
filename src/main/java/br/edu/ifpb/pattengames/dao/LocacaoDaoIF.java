/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Locacao;

/**
 *
 * @author José
 */
public interface LocacaoDaoIF {

    public boolean add(Locacao locacao);

    public boolean remover(Locacao locacao);

    public Locacao buscaPorIdCliente(String nome);

    public Locacao buscaPorId(int id);

    public Locacao buscaPorIdJogo(int idcliente);

    public Locacao buscaPorIdCliente(int id);

}
