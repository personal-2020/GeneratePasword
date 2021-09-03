/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.util.Objects.hash;
//import org.springframework.data.annotation.Id;

/**
 *
 * @author DicoAdmin
 */
public class Contrasena {
  
    //@Id
    private String contrasena;
    

    public Contrasena() {
    }
//    public Contrasena( String contrasena) throws NoSuchAlgorithmException {
//        this.contrasena = Hash(contrasena);        
//    }
    public Contrasena( String contrasena){
        this.contrasena = contrasena;        
    }

//    public String getHash() {
//        return contrasena;
//    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

//    public void setHash(String contrasena) {
//        this.contrasena = contrasena;
//    }

    public String Hash(String contrasena) throws NoSuchAlgorithmException{
        byte[] bytesDelMensaje = contrasena.getBytes();
        MessageDigest resumenDelMensaje = MessageDigest.getInstance("MD5");
        byte[] bytesDelResumen = resumenDelMensaje.digest(bytesDelMensaje);
        BigInteger resumenNumero = new BigInteger(1, bytesDelResumen);
        String resumen = resumenNumero.toString(16);
        return resumen;
    }
    @Override
    public String toString() {
        return "Contrasena{" + "con=" + getContrasena() + "}";
    }
    
}
