/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.model;

/**
 *
 * @author Cefar -- Dicomatico
 */
import java.util.Objects;

public class Tupla<T1, T2> {
    
    T1 o1;
    T2 o2;

    /**
     * Constructor vacio.
     */
    public Tupla(){}
    
    /**
     * Constructor con dos parametros de Objetos.
     * @param o1    Objeto de cualquier tipo.
     * @param o2    Objeto de cualquier tipo.
     */
    public Tupla(T1 o1, T2 o2) {
        super();
        this.o1 = o1;
        this.o2 = o2;
    }
    
    /**
     * Devuelve el elemento de tipo T1. (El tipo de objeto determinado 
     * por el usuario)
     * @return o1
     */
    public T1 getElem1() {
        return o1;
    }

    /**
     * Devuelve el elemento de tipo T1. (El tipo de objeto determinado 
     * por el usuario)
     * @return o2
     */
    public T2 getElem2() {
        return o2;
    }
    
    /**
     * Establece un elemento de tipo t1.(Designado por el usuario)
     * @param o1 Objeto de tipo T1(Determinado por el usuario).
     */
    public void setElem1(T1 o1){
        this.o1=o1;   
    }
    
    /**
     * Establece un elemento de tipo t1.(Designado por el usuario)
     * @param o2 Objeto de tipo T1(Determinado por el usuario).
     */
    public void setElem2(T2 o2){
        this.o2=o2;   
    }
    
    /**+
     * Retorna un numero que es el numero has del objeto.
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o1);
        hash = 17 * hash + Objects.hashCode(this.o2);
        return hash;
    }

    /**
     * Esta funcion informa si un objetro es igual-
     * @param obj Objeto de tipo Objeto
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tupla<?, ?> other = (Tupla<?, ?>) obj;
        if (!Objects.equals(this.o1, other.o1)) {
            return false;
        }
        if (!Objects.equals(this.o2, other.o2)) {
            return false;
        }
        return true;
    }
        
}
