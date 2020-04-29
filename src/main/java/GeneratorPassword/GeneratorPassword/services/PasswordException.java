/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

/**
 *
 * @author Cefar -- Dicomatico
 */
public class PasswordException extends Exception{
    
    /**
     * 
     * @param message
     * @param cause 
     */
    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param message 
     */
    public PasswordException(String message){
        super(message);
    }
    
}
