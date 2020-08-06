/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.model.ColaDinamica;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author laboratorio
 */
@Service
public class GeneratorNumbersStub implements GeneratorNumbersServices {

    public List<BigInteger> numeros = new ArrayList<BigInteger>();
    public List<String> numerosConvertidos=new ArrayList<String>();
    
    /**
     * Constructor vacio.
     */
    public GeneratorNumbersStub() {}

    /**
     * Esta funcionj genera los primeros 4 nuemros a partir del numero inicial 
     * generado por el  recorrido del caballo.
     * @param numero String que representa el numero inicial de 20 cifras.
     */
    @Override
    public void gellAllNum(String numero) throws PasswordException, Exception {
        try{
        int num = 0;
        int a = 0;
        int b = 5;
        while (num < 4) {
            numeros.add(BigInteger.valueOf(Integer.parseInt(numero.substring(a, b))));
            a = b;
            b = b + 5;
            num++;}
    }catch (Exception ex) {
            throw new PasswordException("Excepcion Generando numeros: " + ex.getMessage());
        }
        
        
    }

    /**
     * Estableve el numero converitdo
     * @param numerosConvertidos Variable de los numeros convertidos.
     */
    public void setNumverCovertido(List<String> numerosConvertidos)throws PasswordException, Exception {
        this.numerosConvertidos=numerosConvertidos;    
    }
    
    /**
     * Retorna una ista de los numeros convertidos.
     * @return numerosConvertidos
     */
    @Override
    public List<String> getNumberConvertido()throws PasswordException, Exception {
        return numerosConvertidos;
    }
    
    /**
     * Retorna una lista de los numeros de gran tamaño.
     * @return numeros Lista de numeros de tipo BigInteger.
     */
    @Override
    public List<BigInteger> getNumeros()throws PasswordException, Exception  {
        return numeros;
    }
    
    /**
     * Esta funcion convierte un numero de una base 10 a otra.
     * @param numero    Numero de tipo Big integer en base 10.
     * @param base      Numero de tipo integer que representa 
     * la base a cambiar el numero.
     * return res  string que contiene el numero convertido
     */
    @Override
    public String conversNumbers(BigInteger numero, Integer base) throws PasswordException, Exception {
        try{
        List<String> prueba1 = new ArrayList<>();
        List<String> prueba2 = new ArrayList<>();
        String prueba = "";
        BigInteger mod = BigInteger.ONE;
        BigInteger cant = BigInteger.ONE;
        BigInteger t = BigInteger.ONE;
        BigInteger resp = BigInteger.ZERO; 
        while (numero.compareTo(BigInteger.valueOf(base)) >= 0) {
            mod = numero.mod(BigInteger.valueOf(base));
            numero = numero.divide(BigInteger.valueOf(base));
            t = t.multiply(mod); 
            prueba1.add(t.toString());
            t = t.multiply(cant);
            resp = resp.add(t);
            t = BigInteger.ONE;
            cant = cant.multiply(BigInteger.valueOf(10));  
        }        
        t = BigInteger.ONE;
        prueba1.add(numero.toString());
        Collections.reverse(prueba1);
        t = t.multiply(numero);
        t = t.multiply(cant);
        String res = "";
        prueba2=getNumInCorrectBase(prueba1);
        for (int q = 0; q < prueba1.size(); q++) {
            String d = prueba2.get(q);
            res = res.concat(d);
        }
        return res;
        }catch (Exception ex) {
            throw new PasswordException("Excepcion Convirtierndo numeros: " + ex.getMessage());
        }
        
    }
    
    /**
     * Convierte los numeros en base 10 a base hexadecimal
     * @param numero Lista de numeros tipo String.
     * @return respuesta
     */
    public List<String> getNumInCorrectBase(List<String> numero) throws PasswordException, Exception {
        try{
        List<String> respuesta = new ArrayList<String>();
        for (int i = 0; i < numero.size(); i++) {
            Integer temporal= Integer.valueOf(numero.get(i));
            switch (temporal) {
                case 10:
                    respuesta.add("A");
                    break;
                case 11:
                    respuesta.add("B");
                    break;
                case 12:
                    respuesta.add("C");
                    break;
                case 13:
                    respuesta.add("D");
                    break;
                case 14:
                    respuesta.add("E");
                    break;
                case 15:
                    respuesta.add("F");
                    break;
                default:
                    respuesta.add(numero.get(i));
            }
        }
        return respuesta;        
        }catch (Exception ex) {
            throw new PasswordException("Excepcion Base Correcta: " + ex.getMessage());
        }
    }

    /**
     * Esta funcion convierte el numero de tipo Biginteger a tipo String
     * @param numero Lista de Numeros de tipo BigInteger que contiene 
     * los numeros convertidos.
     */
    @Override
    public void conversNumb(List<BigInteger> numero) throws PasswordException, Exception {
        try{
        int base=2;
        for (int i = 0; i < numeros.size(); i++) {
            BigInteger temp = numeros.get(i);
            String h="";
            while (base <= 16) {
                if(base==16){
                    h=conversNumbers(temp, base);
                    base = base * 2;
                }else{
                    temp = new BigInteger(conversNumbers(temp, base));
                    base = base * 2;
                }                               
            }
            if(base>=16){
                numerosConvertidos.add(h);
            }else{
                numerosConvertidos.add(temp.toString());
            }                        
            base = 2;
            base = base * 2;
        }
        }catch (Exception ex) {
            throw new PasswordException("Excepcion Convirtiendo numeros: " + ex.getMessage());
        }
    }
    
    /**
     * Funcion que limpia la lista de numeros
     */
    @Override
    public void resetNumeros()throws PasswordException, Exception {
        numeros.clear();
    }
        
}
