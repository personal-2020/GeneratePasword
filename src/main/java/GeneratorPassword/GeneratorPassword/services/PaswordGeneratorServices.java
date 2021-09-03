/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.services;

import Generatorpassword.Generatorpassword.model.Matriz;
import Generatorpassword.Generatorpassword.model.Tupla;
import java.util.List;



/**
 *
 * @author Cefar -- Dicomatico
 */
public interface PaswordGeneratorServices {

    public Matriz getMatrizz();
    public void GenerateRandom();
    public List<Tupla> posibilitis(Tupla position); 
    public String paintMatrs();
    public Tupla getNewPosition();
    public Integer getNumRandom();
    public String numberOfMatriz();
    public Boolean esta(Tupla pos);
    public String getNumeroFinal();    
    public List<Tupla> getVisitados();    
    public String getNumero();
    public void setNumero(String numero);
    public void generateNewMatriz();
    
}
