/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.dao.JogoDaoIf;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;
import java.util.List;

/**
 *
 * @author José
 */
public class BoscaJogoBo {

    public BoscaJogoBo() {
    }

    private JogoDaoIf JogoDao = null;
    private DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);

    public Jogo buscarPorId(Integer id) {
        JogoDao = factory.criaJogoDao();
        return JogoDao.buscaPorId(id);
    }

    public Jogo buscarPorMome(String nome) {
        JogoDao = factory.criaJogoDao();
        return JogoDao.buscaPorNome(nome);
    }

    public List<Jogo> buscarTodos() {
        JogoDao = factory.criaJogoDao();
        return JogoDao.buscarTodos();

    }

}
