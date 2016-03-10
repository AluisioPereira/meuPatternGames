/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.exception;

import java.time.LocalDate;

/**
 *
 * @author José
 */
public class LocacaoExistenteException extends Exception{

    public LocacaoExistenteException() {
        super("jogo já locado ");
    }
    
}
