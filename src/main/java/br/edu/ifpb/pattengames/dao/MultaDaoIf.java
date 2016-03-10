/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public interface MultaDaoIf {

    public boolean add(Integer idCliente, BigDecimal multa);

    public boolean remover(Integer idCliente);

    public Map buscaCliente(Integer idCliente);

}
