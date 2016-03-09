/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;
import java.util.List;

/**
 *
 * @author José
 */
public class BuscaClienteBo {

    public BuscaClienteBo() {
    }
    

    private ClienteDaoIf Clientedao = null;
    private DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);

    public Cliente buscarPorId(Integer id) {
        Clientedao = factory.criaClienteDao();
        return Clientedao.buscaPorId(id);
    }

    public Cliente buscarPorEmail(String email) {
        Clientedao = factory.criaClienteDao();
        return Clientedao.buscaPorEmail(email);
    }

    public Cliente buscarPorCPF(String cpf) {
        Clientedao = factory.criaClienteDao();
        return Clientedao.buscaPorCPF(cpf);
    }

    public List<Cliente> buscarTodos() {
        Clientedao = factory.criaClienteDao();
        return Clientedao.buscarTodos();

    }
}
