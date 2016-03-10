/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.contole;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.exception.EmailExistenteException;
import br.edu.ifpb.pattengames.model.BuscaClienteBo;
import br.edu.ifpb.pattengames.model.CadastroClienteBO;
import br.edu.ifpb.pattengames.model.ValidaCPF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
@WebServlet(name = "ServletCadastroCliente", urlPatterns = {"/ServletCadastroCliente"})
public class ServletCadastroCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmailExistenteException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
//        response.getWriter().flush();
        PrintWriter out = response.getWriter();
        //  out.print("passou 1"+request.getParameter("cpf"));
        Cliente cliente = montarUsuario(request);
        out.print("passou 2 " + cliente.toString());

   //     Map<String, String> resultadoVerificacao = VerificarCadastroBo.execute(cliente);
        // out.print("vvvv"+resultadoVerificacao.get("cpf"));
        boolean resultadoCadastro = false;
// resultadoVerificacao.get("passou").equals("true"
        if (cliente != null) {

            try {
                ControladorCLiente   boCadastro = new ControladorCLiente();
                
                boolean cc = resultadoCadastro = boCadastro.add(cliente);
                out.print("cadastrou " + cc);
            } catch (EmailExistenteException ex) {
                Logger.getLogger(ServletCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            } finally {
                if (resultadoCadastro) {
//                    Integer idCriado = DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuarioDAO().buscarPorEmail(usuario.getEmail()).getId();
                    Integer idCriado = new BuscaClienteBo().buscarPorEmail(cliente.getEmail()).getId();
                    cliente.setId(idCriado);
                    sessao.setAttribute("usuario", cliente);
                    request.getRequestDispatcher("pagina adequado");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (EmailExistenteException ex) {
            Logger.getLogger(ServletCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (EmailExistenteException ex) {
            Logger.getLogger(ServletCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Cliente montarUsuario(HttpServletRequest request) {

        Cliente cliente = new Cliente();
        if (request.getParameter("nome") != null) {
            cliente.setNome(request.getParameter("nome"));
        }
        if (request.getParameter("email") != null) {
            cliente.setEmail(request.getParameter("email"));
        }
        ValidaCPF ValidaCPF = new ValidaCPF();
        if (ValidaCPF.validaCPF(request.getParameter("cpf"))) {
            cliente.setCPF(request.getParameter("cpf"));
        }
        return cliente;
    }

}
