/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.contole.ControladorCLiente;
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
import br.edu.ifpb.pattengames.model.*;
import br.edu.ifpb.pattengames.model.BuscaClienteBo;
import br.edu.ifpb.pattengames.model.CadastroLocacaoBo;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
          BuscaJogoBo bo = new BuscaJogoBo();
        List<Jogo> ca = bo.buscarTodos();
        Reserva r = new Reserva(dao.buscaPorId(4),bo.buscarPorMome("FIFA 14") );
        ReservasDaoIf d = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao();
        // List<Reserva> xx = d.buscarEmailCliente(dao.buscaPorEmail("joseifpb2015@gmail.com").getEmail());
        ControladorCLiente   boc = new ControladorCLiente();
       Cliente cs = boc.buscaPorId(35);
     //   DaoFactory.createFactory(DaoFactory.DAO_BD).
        MultaDaoIf multa =new MultaDao();
        List<BigDecimal> c = multa.buscarCliente(37);
        
       
       // for(Reserva c: xx)
            System.err.println(c);
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