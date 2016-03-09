/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.dao.*;
import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.entidades.Reserva;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import java.text.ParseException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.LocacaoFavtoy;
import br.edu.ifpb.pattengames.model.BoscaJogoBo;
import br.edu.ifpb.pattengames.model.BuscaClienteBo;
import br.edu.ifpb.pattengames.model.CadastroLocacaoBo;
import java.util.List;

/**
 *
 * @author José
 */
public class Loader {
//certo
    public static void main(String[] args) throws ParseException, LocacaoExistenteException {
//        Cliente c = new Cliente();
//        c.setCPF("132.353.411-21");
//        c.setNome("josé ferreira vieira");
//        c.setEmail("joseferreira@gmail.com");
//        c.setId(1);
        ClienteDaoIf dao = new ClienteDao();
        ReservasDaoIf dj = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao();
          BoscaJogoBo bo = new BoscaJogoBo();
        List<Jogo> ca = bo.buscarTodos();
        Reserva r = new Reserva(dao.buscaPorId(4),bo.buscarPorMome("FIFA 14") );
        ReservasDaoIf d = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao();
        List<Reserva> xx = d.buscarEmailCliente(dao.buscaPorEmail("joseifpb2015@gmail.com").getEmail());
        
       
        for(Reserva c: xx)
            System.err.println("lista   "+c.getCliente());
//        j.alugado();
//        boolean f = dj.altera
        //System.out.println("resut "+j.getEstado()+"devolver "+f);
//        CadastroLocacaoBo bo = new CadastroLocacaoBo();
//        Locacao l = LocacaoFavtoy.createFactory(LocacaoFavtoy.LOCACAO).criarLocacao();
//        
//        l.setCliente(dao.buscaPorId(37));
//        System.err.println(l.getCliente());
//        l.setJogo(j);
//        boolean xx = bo.cadastrar(l);
//        System.err.println("cadastro "+xx);
//        //dao.add(c);
//      
    }

}