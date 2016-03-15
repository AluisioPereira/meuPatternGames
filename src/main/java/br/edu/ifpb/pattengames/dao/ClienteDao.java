/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.conexao.ConexaoIF;
import br.edu.ifpb.pattengames.conexao.DataBaseException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpb.pattengames.conexao.Conexao;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José
 */
public class ClienteDao implements ClienteDaoIf {

    private ConexaoIF conn;

    @Override
    public boolean add(Cliente cliente) {
        // certo
        boolean result = false;
        PreparedStatement stat = null;
        String sql = "INSERT INTO CLIENTE (nome,cpf, email)"
                + "VALUES(?, ?, ?)";
        try {
            conn = new Conexao();
            stat = conn.getConnection().prepareStatement(sql);
            stat.setString(1, cliente.getNome());
            stat.setString(2, cliente.getCPF());
            stat.setString(3, cliente.getEmail());
            if (stat.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(stat);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return result;
    }

    @Override
    public boolean remover(Cliente cliente) {
        // certo
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM Cliente WHERE id = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public Cliente buscaPorNome(String nome) {
        // certo
        Cliente cliente = null;
        PreparedStatement pst;
        String consulta = "SELECT * FROM cliente WHERE nome = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = montarCliente(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    @Override
    // certo
    public Cliente buscaPorId(int id) {
        Cliente cliente = null;
        PreparedStatement pst;
        String consulta = "SELECT * FROM cliente WHERE id = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = montarCliente(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    public Cliente buscaPorEmail(String email) {
        // certo
        Cliente cliente = null;
        PreparedStatement pst;
        String consulta = "SELECT * FROM cliente WHERE email = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = montarCliente(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    @Override
    public boolean alterar(Cliente cliente) {
        //certo
        boolean result = false;
        PreparedStatement stat = null;
        try {
            conn = new Conexao();
            String sql = "UPDATE cliente SET nome = ?, email = ?"
                    + "WHERE cpf = ?";
            stat = conn.getConnection().prepareStatement(sql);
            stat.setString(1, cliente.getNome());
            stat.setString(2, cliente.getEmail());
            stat.setString(3, cliente.getCPF());
            if (stat.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Cliente buscaPorCPF(String cpf) {
        Cliente cliente = null;
        PreparedStatement pst;
        String consulta = "SELECT * FROM cliente WHERE cpf = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = montarCliente(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;

    }

    @Override
    public List<Cliente> buscarTodos(){
        List<Cliente> lista = new ArrayList<>();

        PreparedStatement pst = null;

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement("SELECT * FROM Cliente");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(montarCliente(rs));
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private Cliente montarCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getInt("id"));
        c.setNome(rs.getString("nome"));
        c.setEmail(rs.getString("email"));
        c.setCPF(rs.getString("cpf"));
        return c;
    }

   @Override
    public boolean remover(String cpf) {
        // certo
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM Cliente WHERE cpf = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

}
