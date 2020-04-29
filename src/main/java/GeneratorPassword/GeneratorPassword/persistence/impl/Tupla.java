/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence.impl;

/**
 *
 * @author Cefar -- Dicomatico
 */
import java.util.Objects;

public class Tupla<T1, T2> {
    
    T1 o1;
    T2 o2;

    /**
     * 
     */
    public Tupla(){}
    
    /**
     * 
     * @param o1
     * @param o2 
     */
    public Tupla(T1 o1, T2 o2) {
        super();
        this.o1 = o1;
        this.o2 = o2;
    }
    
    /**
     * 
     * @return 
     */
    public T1 getElem1() {
        return o1;
    }

    /**
     * 
     * @return 
     */
    public T2 getElem2() {
        return o2;
    }
    
    /**
     * 
     * @param o1 
     */
    public void setElem1(T1 o1){
        this.o1=o1;   
    }
    
    /**
     * 
     * @param o2 
     */
    public void setElem2(T2 o2){
        this.o2=o2;   
    }
    
    /**+
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o1);
        hash = 17 * hash + Objects.hashCode(this.o2);
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
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
