/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.com.caelum.stella.validation.InvalidStateException;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.exception.EmailExistenteException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;

/**
 *
 * @author José
 */
public class CadastroClienteBO {

    public boolean cadastrar(Cliente cliente) throws EmailExistenteException {
//        if (verificarDadosUsuario(cliente)){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().add(cliente);
//        }
//        return false;
    }

    private boolean verificarDadosUsuario(Cliente cliente) throws EmailExistenteException {
        boolean result = true;

        if (cliente == null) {
            return false;
        }

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            return false;
        }

        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            return false;
        }

        if (cliente.getCPF() == null) {
            return false;
        }

        DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);
        Cliente usuarioEmail = factory.criaClienteDao().buscaPorEmail(cliente.getEmail());
        if (usuarioEmail != null) {
            throw new EmailExistenteException();
        }

        return result;
    }

}
