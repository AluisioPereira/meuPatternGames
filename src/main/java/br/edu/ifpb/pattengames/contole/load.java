/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.contole;

/**
 *
 * @author Zilderlan
 */
public class load {
    
    public static void main(String args[]){
        ControleDatas c = new ControleDatas();
        System.out.println("Cadastro: " + c.dataCadastro());
        System.out.println("Devolução: " + c.dataDevolucao());
        System.out.println("Tipo: " + c.tipoLocacao());
        
    }
    
}
