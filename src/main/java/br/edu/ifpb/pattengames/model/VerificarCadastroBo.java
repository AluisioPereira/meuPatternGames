/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author José
 */
public class VerificarCadastroBo {

    private final static Pattern EXPRESSAO_REGULAR_CPF = Pattern.compile("^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");

    public static final Pattern REGEX_EMAIL_VALIDO = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static Map<String, String> execute(Cliente cliente) {

        Map<String, String> resultado = new HashMap<>();

        if (cliente == null) {
            return null;
        }

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            resultado.put("nome", "Informe seu nome.");
        } else if (!cliente.getNome().matches("[A-Za-zÀ-ú0-9 ]+")) {
            resultado.put("nome", "Nome não pode conter caracteres especiais (% - $ _ # @, por exemplo).");
        }

        if (cliente.getEmail() == null
                || cliente.getEmail().trim().isEmpty()
                || !REGEX_EMAIL_VALIDO.matcher(cliente.getEmail()).find()) {
            resultado.put("email", "Informe um email válido.");
        } else {
            DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);
            Cliente usuarioEmail = factory.criaClienteDao().buscaPorEmail(cliente.getEmail());
            if (usuarioEmail != null) {
                resultado.put("emailJaExiste", "Já existe um usuário cadastro com este email informado.");
            }
        }
        //---------------------------------------------------------------------------------------------------

        if (cliente == null) {
            return null;
        }

        if (cliente.getCPF() == null
                || cliente.getEmail().trim().isEmpty()
                || !EXPRESSAO_REGULAR_CPF.matcher(cliente.getEmail()).find()) {
            resultado.put("cpf", "Informe um CPF válido.");
        } else {
            DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);
            Cliente usuarioCPF = factory.criaClienteDao().buscaPorEmail(cliente.getEmail());
            if (usuarioCPF != null) {
                resultado.put("emailJaExiste", "Já existe um usuário cadastro com este CPF informado.");
            }
        }

        if (resultado.isEmpty()) {
            resultado.put("passou", "true");
        } else {
            resultado.put("passou", "false");
        }

        return resultado;
    }

}
