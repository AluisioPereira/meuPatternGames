/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.exception;

import java.lang.reflect.Executable;

/**
 *
 * @author José
 */
public class EmailExistenteException extends Exception{

    public EmailExistenteException() {
        super("O email informado já existe");
    }
    
}
