/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.model;


import GeneratorPassword.GeneratorPassword.persistence.impl.Tupla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cefar -- Dicomatico
 */
public class Hourse {
    
    private List<Tupla> movements;
    private Tupla postInitial;
    
    /**
     * Constructor vacio de objeto tipo caballo.
     */
    public Hourse(){
        movements=new ArrayList<Tupla>();
        postInitial=new Tupla(1, 2);
        mov();
    }
    
    /**
     * Constructor con dos parametros que indica la posicion de inicio del caballo.
     * @param column    Entero que indica la columna de la posicion incial.
     * @param rows      Entero que indica la fila de la posicion inicial
     */
    public Hourse(Integer  column,Integer rows ){
        movements=new ArrayList<Tupla>();
        postInitial=new Tupla(column, rows);
        mov();
    }
    
    /**
     * Establece lel valor de la posicion inicial.
     * @param postInitial Tupla que representa la posicion inicial.
     */
    public void setPostInitial(Tupla postInitial){
        this.postInitial=postInitial;
    }
 
    /**
     * Regressa la posicion inicial del caballo.
     * @return postInitial
     */
    public Tupla getPosInitial(){
        return postInitial;
    }
    
    /**
     * Retorna la lista de movimientos del caballo.
     * @return movements
     */
    public List<Tupla> getMovements(){
        return movements;
    }
    
    /**
     * Esta funcion contiene los 
     */
    private void mov(){// C y F
        movements.add(new Tupla(1, -2));
        movements.add(new Tupla(2, -1));
        movements.add(new Tupla(1, -2));
        movements.add(new Tupla(2, 1));
        movements.add(new Tupla(1, 2));
        movements.add(new Tupla(-1, 2));
        movements.add(new Tupla(-2, 1));
        movements.add(new Tupla(-2, -1));
        movements.add(new Tupla(-1, -2));          
    }
    
}
