/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.persistence.impl.ColaDinamica;
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
     * 
     * 
     */
    public GeneratorNumbersStub() {}

    /**
     * 
     * @param numero 
     */
    @Override
    public void gellAllNum(String numero) {
        int num = 0;
        int a = 0;
        int b = 5;
        while (num < 4) {
            numeros.add(BigInteger.valueOf(Integer.parseInt(numero.substring(a, b))));
            a = b;
            b = b + 5;
            num++;}
    }

    /**
     * 
     * @param numerosConvertidos 
     */
    public void setNumverCovertido(List<String> numerosConvertidos){
        this.numerosConvertidos=numerosConvertidos;    
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<String> getNumberConvertido(){
        return numerosConvertidos;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<BigInteger> getNumeros() {
        return numeros;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<String> separetaNumbers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param numero 
     */
    public void getNumberBaseCorrect(String[] numero) {
        String[] num = numero;//return "";
    }
    
    /**
     * 
     * @param numero
     * @param base
     * @return 
     */
    @Override
    public String conversNumbers(BigInteger numero, Integer base) {
        List<String> prueba1 = new ArrayList<>();
        List<String> prueba2 = new ArrayList<>();
        String prueba = "";
        BigInteger mod = BigInteger.ONE;
        BigInteger cant = BigInteger.ONE;
        BigInteger t = BigInteger.ONE;
        BigInteger resp = BigInteger.ZERO; //System.out.println("como va resp in"+resp);
        while (numero.compareTo(BigInteger.valueOf(base)) >= 0) {//System.out.println("Base : "+base);//System.out.println("que numero se va trabajando: "+numero);
            mod = numero.mod(BigInteger.valueOf(base));//System.out.println("que arroja el mod: "+mod);  //System.out.println("que arroja el el div: "+numero.divide(BigInteger.valueOf(base)));
            numero = numero.divide(BigInteger.valueOf(base));
            t = t.multiply(mod); //System.out.println("que se adiciona : " + t.toString());
            prueba1.add(t.toString());
            t = t.multiply(cant);//System.out.println("como va t :"+t);//System.out.println("que es resp antes de sumar  :"+resp);
            resp = resp.add(t);
            t = BigInteger.ONE;
            cant = cant.multiply(BigInteger.valueOf(10));  //System.out.println("va quedando : "+resp);
        }        
        t = BigInteger.ONE;//System.out.println("que es cant : "+cant);
        prueba1.add(numero.toString());
        Collections.reverse(prueba1);
        t = t.multiply(numero);
        t = t.multiply(cant);
        String res = "";
        prueba2=getNumInCorrectBase(prueba1);
        for (int q = 0; q < prueba1.size(); q++) {//System.out.println("que vemos : "+prueba2.get(q));
            String d = prueba2.get(q);
            res = res.concat(d);
        }//System.out.println("mirar la res lista: " + res); //resp = resp.add(t);
        return res;
    }
    
    /**
     * 
     * @param numero
     * @return 
     */
    public List<String> getNumInCorrectBase(List<String> numero) {
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
        }//System.out.println("que regresa: " + respuesta);
        return respuesta;        
    }

    /**
     * 
     * @param numero 
     */
    @Override
    public void conversNumb(List<BigInteger> numero) {
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
    }
    
    /**
     * 
     */
    @Override
    public void resetNumeros(){
        numeros.clear();
    }
        
}
