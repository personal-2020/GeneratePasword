/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author laboratorio
 */
@Service
public class GeneratorNumbersStub implements GeneratorNumbersServices {

    public List<BigInteger> numeros = new ArrayList<BigInteger>();

    public GeneratorNumbersStub() {
    }

    @Override
    public void gellAllNum(String numero) {
        int num = 0;
        int a = 0;
        int b = 5;
        while (num < 4) {
            numeros.add(BigInteger.valueOf(Integer.parseInt(numero.substring(a, b))));
            a = b;
            b = b + 5;
            num++;
        }
    }

    @Override
    public List<BigInteger> getNumeros() {
        return numeros;
    }

    @Override
    public List<String> separetaNumbers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigInteger conversNumbers(BigInteger numero, Integer base) {
        List<String> prueba1 = new ArrayList<>();

        String prueba = "";
        BigInteger mod = BigInteger.ONE;
        BigInteger cant = BigInteger.ONE;
        BigInteger t = BigInteger.ONE;
        BigInteger resp = BigInteger.ZERO;
        //System.out.println("como va resp in"+resp);

        while (numero.compareTo(BigInteger.valueOf(base)) >= 0) {//System.out.println("Base : "+base);//System.out.println("que numero se va trabajando: "+numero);
            mod = numero.mod(BigInteger.valueOf(base));//System.out.println("que arroja el mod: "+mod);  //System.out.println("que arroja el el div: "+numero.divide(BigInteger.valueOf(base)));

            numero = numero.divide(BigInteger.valueOf(base));
            t = t.multiply(mod);
            //prueba=prueba.concat(t.toString());
            System.out.println("que se adiciona : "+t.toString());
            prueba1.add(t.toString());
            t = t.multiply(cant);//System.out.println("como va t :"+t);//System.out.println("que es resp antes de sumar  :"+resp);
            resp = resp.add(t);

            t = BigInteger.ONE;
            cant = cant.multiply(BigInteger.valueOf(10));  //System.out.println("va quedando : "+resp);
        }
        t = BigInteger.ONE;//System.out.println("que es cant : "+cant);
        //prueba=prueba.concat(numero.toString());
        //prueba1.add(numero.toString());
  
        for (int i = prueba1.size()-1; i >=0; i--) {
            String k=prueba1.get(i);
            prueba=prueba.concat(k);
        }

        t = t.multiply(numero);
        t = t.multiply(cant);
        System.out.println("que resp antes : " + resp);
        System.out.println("que numero antes : " + prueba);
        resp = resp.add(t);
        return resp;
    }
}
