/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.Enum.TipoLocacao;
import br.edu.ifpb.pattengames.dao.JogoDaoIf;
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
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author José
 */
public class Loader {
//certo

    public static void main(String[] args) throws ParseException, LocacaoExistenteException, MultaException {
         Cliente a = DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorId(4);
        Jogo j = DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao().buscaPorId(9);
        
       // Locacao c = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().buscaPorId(35);
        Locacao c = new LocacaoComum();
      c.setCliente(a);
       c.setJogo(j);
       c.setId(50);
       //c.setTipo(TipoLocacao.COMUM.name());
    //   c.setDataDevolucao(LocalDate.of(2016, Month.MARCH, 10));
        CadastroLocacaoBo dd = new CadastroLocacaoBo();
        //dd.cadastrar(c);
//        LocalDate re = DaoFactory.createFactory(DaoFactory.DAO_BD).criaLocacaoDao().buscaPorId(42).getDataDevolucao();
      //  CadastrarMultas calMulta = new CadastrarMultas();
       // calMulta.calMulta(c);
     // LocalDate  dataDevolucao = LocalDate.of(2016, Month.MARCH, 11);
       // int diasAtraso = (int) dataDevolucao.until(LocalDate.now(), ChronoUnit.DAYS);
      //  System.err.println("aa============ "+diasAtraso );
       DevolucaoBo s = new DevolucaoBo();
      
        System.err.println("devolver "+s.devolucao(c));
        // boolean re = DaoFactory.createFactory(DaoFactory.DAO_BD).criaReservaDao().add(new Reserva(a, j));
        // System.err.println("reservado "+re);
        
    }

}
