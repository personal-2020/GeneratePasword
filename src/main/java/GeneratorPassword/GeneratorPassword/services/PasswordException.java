/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.services;

/**
 *
 * @author Cefar -- Dicomatico
 */
public class PasswordException extends Exception{
    
    /**
     * Esta funcion genera una excepcion.
     * @param message Un String que representa el mensaje de la excepcion.
     * @param cause    Representa la causa de la excepcion.
     */
    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Esta funcion genera una excepcion.
     * @param message Un String que representa el mensaje de la excepcion.
     */
    public PasswordException(String message){
        super(message);
    }
    
}
