/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.contole;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.exception.EmailExistenteException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zilderlan
 */
@WebServlet(name = "AtualizarCliente", urlPatterns = {"/atualizarcliente"})
public class AtualizarCliente extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ControladorCLiente controle = new ControladorCLiente();
        boolean result = false;
        response.sendRedirect("cadastroCliente.jsp");
        Cliente clienteAtualizado = controle.buscarPorCPF(request.getParameter("cpf"));
//        out.println(clienteAtualizado.toString());
        if (clienteAtualizado != null) {
            clienteAtualizado = atualizarInfo(clienteAtualizado, request);
            out.println("Chamei esse");
        }

        try {
            result = controle.atualizar(clienteAtualizado);
        } catch (EmailExistenteException ex) {
            Logger.getLogger(ServletAtualizarCliente.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("clienteAtualizado", result);
        }
        if (result) {
            request.setAttribute("clienteAtualizado", result);
        }
//        request.getRequestDispatcher("AtualizarCliente").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private Cliente atualizarInfo(Cliente cliente, HttpServletRequest request) {
        cliente.setEmail(request.getParameter("email"));
        cliente.setNome(request.getParameter("nome"));
        
        return cliente;
    }

}
