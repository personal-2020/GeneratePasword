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
public interface CreatePaswword {
    
    public List<String> paswords(List<String> frase)throws PasswordException, Exception ;
    public List<String> getArregloAyuda()throws PasswordException, Exception ;
    public List<String> getArregloFinal()throws PasswordException, Exception ;
    
}
