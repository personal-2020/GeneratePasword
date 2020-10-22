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
public interface OperateDictionarie {
            
    public List<String> getPaswword(List<String> arregloFinal) throws PasswordException;
    
    public void getListHelp(List<String> arregloAyuda) throws PasswordException;
    
    public List<List<String>> conversFraseToArray(List<String> arregloIn) throws PasswordException;
    
    public void setArregloAyuda(List<String> arregloAyudav) throws PasswordException;
    
    public List<String> getArregloAyuda() throws PasswordException;
    
    public String getContrasena(List<String> arregloFinal) throws PasswordException;
    
    public Boolean getSizeListContrasen() throws PasswordException;
    
}
