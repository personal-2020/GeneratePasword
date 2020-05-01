/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author laboratorio
 */

public interface GeneratorNumbersServices {
    
    public List<String> getNumberConvertido();
    public void conversNumb(List<BigInteger> numero);
    public List<String> separetaNumbers();
    public String conversNumbers(BigInteger numero, Integer base);
    public void gellAllNum(String numero) ;
    public List<BigInteger> getNumeros();
    public void resetNumeros();

}
