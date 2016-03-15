/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.factoy.DaoFactory;

/**
 *
 * @author José
 */
public class AlteraSateJogo {
    public static boolean AlteraSateJogo(Jogo jogo){
        jogo.devolver();
        return  DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao().alterar(jogo);
    }
    
}
