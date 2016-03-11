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
import br.edu.ifpb.pattengames.entidades.LocacaoComum;
import br.edu.ifpb.pattengames.entidades.Reserva;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import br.edu.ifpb.pattengames.exception.MultaException;
import java.text.ParseException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.LocacaoFavtoy;
import br.edu.ifpb.pattengames.model.*;
import br.edu.ifpb.pattengames.model.BuscaClienteBo;
import br.edu.ifpb.pattengames.model.CadastroLocacaoBo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class Loader {
//certo

    public static void main(String[] args) throws ParseException, LocacaoExistenteException {
        Cliente c = DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorId(3);
        System.err.println("cliente "+ c);
        
    }

}
