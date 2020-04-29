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
     * 
     */
    public Hourse(){
        movements=new ArrayList<Tupla>();
        postInitial=new Tupla(1, 2);
        mov();
    }
    
    /**
     * 
     * @param column
     * @param rows 
     */
    public Hourse(Integer  column,Integer rows ){
        movements=new ArrayList<Tupla>();
        postInitial=new Tupla(column, rows);
        mov();
    }
    
    /**
     * 
     * @param postInitial 
     */
    public void setPostInitial(Tupla postInitial){
        this.postInitial=postInitial;
    }
 
    /**
     * 
     * @return 
     */
    public Tupla getPosInitial(){
        return postInitial;
    }
    
    /**
     * 
     * @return 
     */
    public List<Tupla> getMovements(){
        return movements;
    }
    
    /**
     * 
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
