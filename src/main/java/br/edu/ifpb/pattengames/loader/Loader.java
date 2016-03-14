/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.Enum.TipoLocacao;
import br.edu.ifpb.pattengames.dao.JogoDaoIf;
import br.edu.ifpb.pattengames.dao.ReservaDao;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.entidades.LocacaoComum;
import br.edu.ifpb.pattengames.entidades.Reserva;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import br.edu.ifpb.pattengames.exception.MultaException;
import java.text.ParseException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.LocacaoFavtoy;
import br.edu.ifpb.pattengames.model.CadastrarMultas;
import br.edu.ifpb.pattengames.model.CadastroLocacaoBo;
import br.edu.ifpb.pattengames.model.DevolucaoBo;
import br.edu.ifpb.pattengames.model.Notificarcao;
import br.edu.ifpb.pattengames.model.ReservarJogoBo;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author José
 */
public class Loader {
//certo

    public static void main(String[] args) throws ParseException, LocacaoExistenteException, MultaException {
         Cliente a = DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorId(4);
        Jogo jogo = DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao().buscaPorId(9);
        
      //  Locacao l = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().buscaPorId(35);
        Locacao l = LocacaoFavtoy.createFactory(LocacaoFavtoy.LOCACAO).criarLocacao();
      l.setCliente(a);
       l.setJogo(jogo);
       l.setId(53);
       //c.setTipo(TipoLocacao.COMUM.name());
    //   l.setDataDevolucao(LocalDate.of(2016, Month.MARCH, 10));
        CadastroLocacaoBo dd = new CadastroLocacaoBo();
        ReservarJogoBo ee = new ReservarJogoBo();
       // boolean rrr = ee.reservaJogo(a, jogo);
       // dd.cadastrar(l);
        Notificarcao re = Notificarcao.getInstancia();
        //re.notificarClientes(jogo);
         System.err.println("====================== ");
         //List<Reserva> reservas = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao().buscarJogo(jogo.getNome());
       //  System.err.println("cff "+reservas.get(0).getJogo());
//        LocalDate re = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().buscaPorId(42).getDataDevolucao();
      //  CadastrarMultas calMulta = new CadastrarMultas();
       // calMulta.calMulta(l);
     // LocalDate  dataDevolucao = LocalDate.of(2016, Month.MARCH, 11);
       // int diasAtraso = (int) dataDevolucao.until(LocalDate.now(), ChronoUnit.DAYS);
       // System.err.println("aa============ "+l.getJogo().getNome() );
       DevolucaoBo s = new DevolucaoBo();
      
        System.err.println("devolver "+s.devolucao(l));
        // boolean re = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao().add(new Reserva(a, jogo));
        // System.err.println("reservado "+re);
        
    }

}
