/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import br.edu.ifpb.pattengames.state.Alugado;
import br.edu.ifpb.pattengames.state.Disponivel;
import br.edu.ifpb.pattengames.state.StateIF;
import java.util.LinkedList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import observadorDeJogo.Observable;
import observadorDeJogo.Observer;

/**
 *
 * @author José
 */
public class Jogo implements Observable<Cliente>{
    	private List<Observer<Cliente>> observadores;
    
    private int id;
    private StateIF estado;
    private String nome;

    public Jogo() {
        this.estado = new Disponivel();
        this.observadores = new LinkedList<Observer<Cliente>>();
    }
    

    /**
     * Get the value of estado
     *
     * @return the value of estado
     */
    public StateIF getEstado() {
        return estado;
    }

    /**
     * Set the value of estado
     *
     * @param estado new value of estado
     */
    public void setEstado(StateIF estado) {
        this.estado = estado;
    }


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
    

    
    public void alugado(){
        this.estado = estado.alugado();
    }

    
    public void devolver(){
        this.estado = estado.devolver();
    }

   @Override
	public void addObserver(Observer newObserver) {
		this.observadores.add(newObserver);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observadores.remove(observer);
	}
	
	public void addChamada(Cliente cliente) {
		notifyObservers(cliente);
	}

	@Override
	public void notifyObservers(Cliente object) {
		for (Observer observer : observadores) {
			observer.update(object);
		}
	}

    
}
