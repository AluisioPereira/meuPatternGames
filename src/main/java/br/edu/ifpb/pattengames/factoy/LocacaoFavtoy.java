/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.factoy;

import static br.edu.ifpb.pattengames.factoy.DaoFactory.DAO_BD;

/**
 *
 * @author José
 */
public class LocacaoFavtoy {
     public static final int LOCACAO = 0;

    public static FactoyLocacaoIF createFactory(int factoryType) {
        if (factoryType == DAO_BD) {
            return new FactoyLocacao();
           
       
    }
         return null;
}
}
