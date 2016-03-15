/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.factoy;

import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.dao.JogoDaoIf;
import br.edu.ifpb.pattengames.dao.LocacaoDaoIF;
import br.edu.ifpb.pattengames.dao.MultaDaoIf;
import br.edu.ifpb.pattengames.dao.ReservasDaoIf;

/**
 *
 * @author José
 */
public interface DaoFactoryIF {

    public ClienteDaoIf criaClienteDao();

    public JogoDaoIf criaJogoDao();

    public LocacaoDaoIF criaLocacaoDao();

    public ReservasDaoIf criaReservaDao();

    public MultaDaoIf criaMultaDao();

}
