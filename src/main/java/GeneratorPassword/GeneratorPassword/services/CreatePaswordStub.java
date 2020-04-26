/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.util.List;

/**
 *
 * @author cefar-dico
 */
public class CreatePaswordStub implements CreatePaswword{

    
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
    public String paswords(List<String> frase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
