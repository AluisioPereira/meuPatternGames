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
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class MultaDao implements MultaDaoIf {

    private ConexaoIF conn = null;
    private PreparedStatement stat = null;

    @Override
    public boolean add(Integer idCliente, BigDecimal multa) {
        boolean result = false;
        String sql = "INSERT INTO MULTA(idCliente, multa) VALUES(?, ?)";
        try {
            conn = new Conexao();
            stat = conn.getConnection().prepareStatement(sql);
            stat.setInt(1, idCliente);
            stat.setDouble(2, Double.parseDouble(String.valueOf(multa)));

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
    public boolean remover(Integer idCliente) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM multa WHERE idcliente = ?";
            ps = conn.getConnection().prepareStatement(sql);

            ps.setInt(1, idCliente);
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

    @Override
    public List<BigDecimal> buscarCliente(Integer idCliente) {
        PreparedStatement pst;

        String consulta = "SELECT * FROM MULTA WHERE idcliente = ?";
         List<BigDecimal> resultado = new ArrayList<>();
        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, idCliente);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorId(rs.getInt("idcliente"));
                BigDecimal multa = new BigDecimal(rs.getDouble("multa"), MathContext.UNLIMITED);
                resultado.add(multa);
                
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

}
