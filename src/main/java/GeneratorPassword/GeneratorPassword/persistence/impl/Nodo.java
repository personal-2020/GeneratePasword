/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence.impl;

/**
 *
 * @author lanosce
 */
public class Nodo<T> {//Atributos
    private T elemento;
    private Nodo<T> anterior;
    private Nodo<T> siguiente; //Apunta al siguiente nodo
     
    /**
     * 
     * @param elemento
     * @param siguiente
     * @param anterior 
     */
    public Nodo(T elemento, Nodo<T> siguiente, Nodo<T> anterior){
        this.elemento = elemento;
        this.anterior=anterior;
        this.siguiente = siguiente;
    }
 
    //Metodos
    /**
     * 
     * @return 
     */
    public T getElemento() {
        return elemento;
    }
 
    /**
     * 
     * @return 
     */
    public Nodo<T> getAnterior(){
        return anterior;    
    }
    
    /**
     * 
     * @param anterior 
     */
    public void setAnterior(Nodo<T> anterior){
        this.anterior=anterior;    
    }
    
    /**
     * 
     * @param elemento 
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    
    /**
     * 
     * @return 
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    
    /**
     * 
     * @param siguiente 
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return elemento+"\n";
    }  
    
}
