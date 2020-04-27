/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.persistence.impl.Diccionario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author cefar-dico
 */
@Service
public class OperateDictionarieStub implements OperateDictionarie {
    
    private Diccionario dictionario=new Diccionario();

    private List<String> contraseñas=new ArrayList<String>();
    
    private List<String> arregloAyuda=new ArrayList<String>();
    
    
    /**
     * Funcion que genera las contraseñas:     
     *La contraseña, que se deben guiar por las siguientes reglas:
            *Si hay solo 2 letras en la frase se pasa a "Arreglo ayuda"
            *Si queda aun letras suficientes para generar una contraseña se usan, 
                por el contrario se desechan.
            * UNa contraseña apta tiene almenos 3 palabras separaradas por un numeor, 
                 si no cumple con esto se desecha.
            * En caso de no haber letras de ayuda  "arreglo de ayuda", 
                se ignora el hecho y se continua con la frase. En este caso la 
                contraseña debe mantener 3 palabras

     * @param arregloFinal
     * @param arregloAyuda
     * @return 
     */
    
    @Override
    public List<String> getPaswword(List<String> arregloFinal) {
        
        
        for(String ft: arregloFinal){
            String contraseña="";
            for(int y=0;y<ft.length();y++){
                
                if(2<3){
                    
                    
                }
            }


        }
        
        
        
        return null;
    }
    
    @Override
    public void getListHelp(List<String> arregloAyuda){                
        for(String ft: arregloAyuda){            
            for(int y=0;y<ft.length();y++){
                arregloAyuda.add(String.valueOf(ft.charAt(y)));
                
            }                
        }        
    }
    
    
}
