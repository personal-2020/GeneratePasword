/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.model;

/**
 *
 * @author lanosce
 */
public class Nodo<T> {//Atributos
    private T elemento;
    private Nodo<T> anterior;
    private Nodo<T> siguiente; //Apunta al siguiente nodo
     
    /**
     * Constructor de Nodo.
     * @param elemento  Elemento de tipo Objeto.
     * @param siguiente El Siguiente nodo de tipo Nodo<T>
     * @param anterior El Siguiente nodo de tipo Nodo<T>
     */
    public Nodo(T elemento, Nodo<T> siguiente, Nodo<T> anterior){
        this.elemento = elemento;
        this.anterior=anterior;
        this.siguiente = siguiente;
    }
 
    /**
     * Retorna el elemento de tipo T.
     * @return elemento
     */
    public T getElemento() {
        return elemento;
    }
 
    /**
     * Retorna el elemento anterior de Tipo Nodo<T>
     * @return anterior
     */
    public Nodo<T> getAnterior(){
        return anterior;    
    }
    
    /**
     * Establece el objeto Anterior.
     * @param anterior Objeto de tipo Nodo<T>
     */
    public void setAnterior(Nodo<T> anterior){
        this.anterior=anterior;    
    }
    
    /**
     * Establece el elemento de tipo T.
     * @param elemento De tipo T.
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    
    /**
     * Retorna el elemento siguiente
     * @return siguiente
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el elemento siguiente.
     * @param siguiente 
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Funciones que representa el elemento en string.
     * @return 
     */
    @Override
    public String toString() {
        return elemento+"\n";
    }  
    
}
