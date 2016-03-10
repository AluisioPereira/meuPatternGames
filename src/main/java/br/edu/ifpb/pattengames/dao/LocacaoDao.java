/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.conexao.Conexao;
import br.edu.ifpb.pattengames.conexao.ConexaoIF;
import br.edu.ifpb.pattengames.conexao.DataBaseException;
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.LocacaoFavtoy;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class LocacaoDao implements LocacaoDaoIF {

    private ConexaoIF conn = null;
    private PreparedStatement stat = null;

    @Override
    public boolean add(Locacao locacao) {
        boolean result = false;
        String sql = "INSERT INTO LOCACAO(idCliente, idjogo, datalocacao, datadevolucao, tipo) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new Conexao();
            stat = conn.getConnection().prepareStatement(sql);
            stat.setInt(1, locacao.getCliente().getId());
            stat.setInt(2, locacao.getJogo().getId());
            stat.setDate(3, Date.valueOf(locacao.getDataLocacao()));
            stat.setDate(4, Date.valueOf(locacao.getDataDevolucao()));
            stat.setString(5, locacao.getTipo());
            if (stat.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            Logger.getLogger(LocacaoDao.class.getName()).log(Level.SEVERE, null, e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(stat);
            } catch (DataBaseException ex) {
                Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public boolean remover(Locacao locacao) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM LOCACAO WHERE id = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, locacao.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    public Locacao buscaPorIdCliente(int id) {
        PreparedStatement pst;
        Locacao locacao = null;
        String consulta = "SELECT * FROM LOCACAO WHERE id = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                locacao = montarLocacao(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return locacao;

    }

    @Override
    public Locacao buscaPorIdCliente(String nome) {
        PreparedStatement pst;
        Locacao locacao = null;
        String consulta = "SELECT * FROM LOCACAO WHERE idcliente = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorNome(nome).getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                locacao = montarLocacao(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return locacao;
    }

    @Override
    public Locacao buscaPorId(int id) {
        PreparedStatement pst;
        Locacao locacao = null;
        String consulta = "SELECT * FROM LOCACAO WHERE id = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                locacao = montarLocacao(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return locacao;
    }

  

    @Override
    public Locacao buscaPorIdJogo(int idcliente) {
          PreparedStatement pst;
        Locacao locacao = null;
        String consulta = "SELECT * FROM LOCACAO WHERE idjogo = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, idcliente);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                locacao = montarLocacao(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return locacao;

    }

    private Locacao montarLocacao(ResultSet rs) throws SQLException {

        Locacao l = LocacaoFavtoy.createFactory(LocacaoFavtoy.LOCACAO).criarLocacao();
        l.setCliente(DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorId(Integer.parseInt(rs.getString("idcliente"))));
        l.setJogo(DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao().buscaPorId(Integer.parseInt(rs.getString("idjogo"))));
        l.setDataLocacao(rs.getDate("datalocacao").toLocalDate());
        l.setDataLocacao(rs.getDate("datadevolucao").toLocalDate());
        l.setTipo(rs.getString("tipo"));
        System.err.println("1--1-1-1--1-" + rs.getDate("datalocacao"));
        return l;
    }

}
