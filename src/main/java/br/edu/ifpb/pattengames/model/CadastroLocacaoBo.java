/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.dao.ClienteDao;
import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.dao.JogoDaoIf;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import br.edu.ifpb.pattengames.exception.MultaException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;

/**
 *
 * @author José
 */
public class CadastroLocacaoBo {

    public CadastroLocacaoBo() {
    }

    public boolean cadastrar(Locacao locacao) throws LocacaoExistenteException, MultaException {
        DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);

        if (locacao.getDataDevolucao() == null) {
            return false;
        }
        if (locacao.getDataLocacao() == null) {
            return false;
        }
        if (locacao.getJogo() == null) {
            return false;
        }
        if (locacao.getCliente() == null) {
            return false;
        }
        if (locacao.getTipo() == null) {
            return false;
        }
        if (VerificarPendeciasCliente.execute(locacao.getCliente().getId())) {
            throw new MultaException();
        }
        Locacao locacaoExistente = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().buscaPorIdJogo(locacao.getJogo().getId());
        if (locacaoExistente != null) {
            throw new LocacaoExistenteException();

        }
        if (factory.criaLocacaoDao().add(locacao)) {
            ClienteDaoIf dao = new ClienteDao();
            JogoDaoIf dj = DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao();
            Jogo j = dj.buscaPorId(locacao.getJogo().getId());
            j.alugado();
            return dj.alterar(j);
        }
        return false;
    }
}
