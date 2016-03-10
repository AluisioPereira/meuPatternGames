/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.contole;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.exception.EmailExistenteException;
import br.edu.ifpb.pattengames.model.AtualizarClienteBO;
import br.edu.ifpb.pattengames.model.BuscaClienteBo;
import br.edu.ifpb.pattengames.model.CadastroClienteBO;
import br.edu.ifpb.pattengames.model.RemoverClienteBO;
import java.util.List;

/**
 *
 * @author José
 */
public class ControladorCLiente {

    private CadastroClienteBO cadastroClienteBO = null;
    private BuscaClienteBo buscaCliente = null;
    private AtualizarClienteBO atualizarClienteBO = null;
    private RemoverClienteBO removerClienteBO = null;

    public ControladorCLiente() {
    }

    public boolean add(Cliente cliente) throws EmailExistenteException {
        if (cadastroClienteBO == null) {
            cadastroClienteBO = new CadastroClienteBO();
        }

        return cadastroClienteBO.cadastrar(cliente);
    }

    public boolean remover(Cliente cliente) {
        if (removerClienteBO == null) {
            removerClienteBO = new RemoverClienteBO();
        }
        return removerClienteBO.remover(cliente);
    }

    public Cliente buscaPorNome(String nome) {
        if (buscaCliente == null) {
            buscaCliente = new BuscaClienteBo();
        }

        return buscaCliente.buscarPorNome(nome);
    }

    public Cliente buscaPorId(int id) {
        if (buscaCliente == null) {
            buscaCliente = new BuscaClienteBo();
        }

        return buscaCliente.buscarPorId(id);
    }

    public Cliente buscarPorEmail(String email) {
        if (buscaCliente == null) {
            buscaCliente = new BuscaClienteBo();
        }

        return buscaCliente.buscarPorEmail(email);
    }

    public Cliente buscarPorCPF(String cpf) {
        if (buscaCliente == null) {
            buscaCliente = new BuscaClienteBo();
        }

        return buscaCliente.buscarPorCPF(cpf);
    }

    public List<Cliente> buscarTodos() {
        if (buscaCliente == null) {
            buscaCliente = new BuscaClienteBo();
        }

        return buscaCliente.buscarTodos();
    }

    public boolean atualizar(Cliente cliente) throws EmailExistenteException {
        if (atualizarClienteBO == null) {
            atualizarClienteBO = new AtualizarClienteBO();
        }
        return atualizarClienteBO.atualizar(cliente);
    }

}
