/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.state;


import java.io.Serializable;

/**
 *
 * @author José
 */
public class Disponivel implements StateIF, Serializable {

    @Override
    public StateIF alugado() {
        return new Alugado();
    }

    @Override
    public StateIF devolver() {
       
        return this;
    }
}
