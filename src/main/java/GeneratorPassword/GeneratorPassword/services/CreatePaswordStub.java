/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author cefar-dico
 */
@Service
public class CreatePaswordStub implements CreatePaswword{

    
    private List<String> arregloAyuda = new ArrayList<String>();
    
    private List<String> arregloFinal =  new ArrayList<String>();
    
    @Override
    public List<String> getArregloAyuda(){
        return arregloAyuda;
    }
    @Override
    public List<String> getArregloFinal(){
        return arregloFinal;
    }   
    /**
     * Funcion que genera las contraseñas:
     * 
     *La contraseña, que se deben guiar por las siguientes reglas:
            *Si hay solo 2 letras en la frase se pasa a "Arreglo ayuda"
            *Si queda aun letras suficientes para generar una contraseña se usan, 
                por el contrario se desechan.
            * UNa contraseña apta tiene almenos 3 palabras separaradas por un numeor, 
                 si no cumple con esto se desecha.
            * En caso de no haber letras de ayuda  "arreglo de ayuda", 
                se ignora el hecho y se continua con la frase. En este caso la 
                contraseña debe mantener 3 palabras
     * @param frase
     * @return 
     */
    @Override
    public List<String> paswords(List<String> frase) {
        
        //Analizando si se debe agergar al vector ayuda....
        for(int i =0; i<frase.size();i++){
            int nn=0;
            int nl=0;
            String g=frase.get(i);
             for(int y=0;y<g.length();y++){
                if(isNumeric(String.valueOf(g.charAt(y)))){
                    nn++;
                }else{
                    nl++;
                }                
            }
            if( nn-nl>2){
                arregloAyuda.add(g);
                //frase.remove(i);
            }else{
                arregloFinal.add(g);
            }                         
        }                             
        return arregloFinal;       
    }
        
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }

}
