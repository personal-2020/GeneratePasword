/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence.impl;

import GeneratorPassword.GeneratorPassword.services.PasswordException;

/**
 *  
 * @author lanosce
 * @param <T>
 */
public class ColaDinamica<T> {
    
    private Nodo<T> primero;//Atributos
    private Nodo<T> anterior;
    private Nodo<T> ultimo;
    private int tamanio;
 
    /**
     * Constructor vacio de Cola Dinamica.
     */
    public ColaDinamica() {
        primero = null;
        anterior=null;
        ultimo = null;
        tamanio = 0;
    }
 
    /**
     * Indica si la cola esta vacia
     * @return primero
     */
    public boolean isEmpty() {
        return primero == null;
    }
 
    /**
     * Indica el tamaño de la cola
     * @return tamanio
     */
    public int size() {
        return tamanio;
    }
 
    /**
     * Devuelve el primer elemento en la cola
     * @return primero.getElemento()
     */
    public T primero() {
        if (isEmpty()) {
            return null;
        }
        return primero.getElemento();
    }
 
    /**
     * Elimina y devuelve el primer elemento de la cola
     * @return elemento
     */
    public T dequeue() { 
        if (isEmpty()) {
            return null;
        } 
        T elemento = primero.getElemento();
        Nodo<T> aux = primero.getSiguiente();
        primero = null; 
        primero = aux;
        tamanio--;
        if (isEmpty()) {
            ultimo = null;
        }
        return elemento;
    }

    /**
     * Esta funcion es un constructor que define un elemento T con referencia a su ultimo nodo.
     * @return elemento
     */
    public T def(){    
        if (isEmpty()) {
            return null;
        }        
        T elemento = ultimo.getElemento();
        ultimo.setAnterior(ultimo.getAnterior());
        Nodo<T> aux = ultimo.getSiguiente();        
        ultimo=aux;
        if(isEmpty()){
            primero=null;
        }       
        return elemento;    
    }

    /**
     * Añade un nuevo elemento a la cola
     * @param elemento Elemento que sera agregada a la cola.
     * @return aux.getElemento()
     */
    public T enqueue(T elemento) { 
        Nodo<T> aux = new Nodo(elemento, null, null); 
        if (isEmpty()) {
            primero = aux;
            anterior=aux;
            ultimo = aux;
        } else {
            if (size() == 1) {
                anterior.setAnterior(aux);
                primero.setSiguiente(aux);                
            } else {                
                ultimo.setSiguiente(aux);
                anterior.setAnterior(ultimo);
            }
            ultimo = aux;
        } 
        tamanio++;
        return aux.getElemento(); 
    }
 
    /**
     * Muestra el contenido
     * @return cadena
     */
    public String toString() {
        if (isEmpty()) {
            return "La lista esta vacia";
        } else {
            String cadena = "";
            Nodo<T> aux = primero;
            while (aux != null) {
                cadena += aux;
                aux = aux.getSiguiente();
            } 
            return cadena;
        }
    }      
    
}
