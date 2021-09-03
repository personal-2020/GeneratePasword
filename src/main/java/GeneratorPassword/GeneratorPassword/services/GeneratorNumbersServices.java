/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.services;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author laboratorio
 */

public interface GeneratorNumbersServices {
    
    public List<String> getNumberConvertido()throws PasswordException, Exception ;
    public void conversNumb(List<BigInteger> numero)throws PasswordException, Exception ;
    public String conversNumbers(BigInteger numero, Integer base)throws PasswordException, Exception ;
    public void gellAllNum(String numero)throws PasswordException, Exception  ;
    public List<BigInteger> getNumeros()throws PasswordException, Exception ;
    public void resetNumeros()throws PasswordException, Exception ;

}
