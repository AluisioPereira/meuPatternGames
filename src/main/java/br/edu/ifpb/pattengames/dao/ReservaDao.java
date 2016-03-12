/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.conexao.Conexao;
import br.edu.ifpb.pattengames.conexao.ConexaoIF;
import br.edu.ifpb.pattengames.conexao.DataBaseException;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Reserva;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class ReservaDao implements ReservasDaoIf {

    private ConexaoIF conn = null;
    private PreparedStatement stat = null;

    @Override
    public List<Reserva> buscarJogo(String nomeJogo) {
        PreparedStatement pst;
        List<Reserva> reserva = null;
        String consulta = "SELECT * FROM RESERVARJOGO WHERE nomejogo = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setString(1, nomeJogo);
            ResultSet rs = pst.executeQuery();
            reserva = new ArrayList<>();
            while (rs.next()) {
                reserva.add(montarLocacao(rs)) ;
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserva;

    }

    @Override
    public List<Reserva> buscarEmailCliente(String email) {
        PreparedStatement pst;
        List<Reserva> reserva = null;
        String consulta = "SELECT * FROM RESERVARJOGO WHERE emailCliente = ?";

        try {
            reserva = new ArrayList<Reserva>();
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
          if (rs.next()) {
                Reserva x = montarLocacao(rs);
                System.err.println("wwwwwww"+x.getCliente());
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserva;

    }

    @Override
    public List<Reserva> buscarTodas() {
        PreparedStatement pst;
        List<Reserva> reserva = null;
        String consulta = "SELECT * FROM RESERVARJOGO ";

        try {
            reserva = new ArrayList<>();
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                reserva.add(montarLocacao(rs));
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserva;

    }

    @Override
    public boolean add(Reserva reserva) {
        boolean result = false;
        String sql = "INSERT INTO reservarjogo(emailcliente,nomejogo) VALUES(?, ?)";
        try {
            conn = new Conexao();
            stat = conn.getConnection().prepareStatement(sql);
            stat.setString(1, reserva.getCliente().getEmail());
            stat.setString(2, reserva.getJogo().getNome());
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
    public boolean remover(Reserva reseva) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM reservarjogo WHERE id = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, reseva.getId());
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

    private Reserva montarLocacao(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
        Cliente c = DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorCPF(rs.getString("emailcliente"));
        Jogo j = DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao().buscaPorNome(rs.getString("nomejogo"));
        reserva.setCliente(c);
        reserva.setJogo(j);
        reserva.setId(rs.getInt("id"));
        return reserva;
    }

}
