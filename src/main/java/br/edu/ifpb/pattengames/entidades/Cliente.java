/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import br.edu.ifpb.pattengames.model.EnviarEmail;
import observadorDeJogo.Observer;

/**
 *
 * @author José
 */
public class Cliente implements Observer<Jogo> {
    
    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    private String nome;

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    private String CPF;

    /**
     * Get the value of CPF
     *
     * @return the value of CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * Set the value of CPF
     *
     * @param CPF new value of CPF
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", CPF=" + CPF + '}';
    }
    
    @Override
    public void update(Jogo object) {
        System.err.println("enter cli"+this.getEmail());
        EnviarEmail email = new EnviarEmail();
        email.enviarEmail(this, object);
        
    }
    
}
