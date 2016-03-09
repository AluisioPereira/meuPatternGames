/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.Enum;

/**
 *
 * @author José
 * dddd
 */
public enum TipoLocacao {
     COMUN("comum") ,ESPECIAL("especial");
    
    public String id;
    
    TipoLocacao(String papel){
        id = papel;
    }
}
