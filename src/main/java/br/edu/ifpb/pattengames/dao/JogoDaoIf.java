/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Jogo;
import java.util.List;

/**
 *
 * @author José
 */
public interface JogoDaoIf {

    public boolean add(Jogo jogo);

    public boolean remover(Jogo jogo);

    public Jogo buscaPorNome(String nome);

    public Jogo buscaPorId(int id);

    public boolean alterar(Jogo jogo);

    public List<Jogo> buscarTodos();

}
