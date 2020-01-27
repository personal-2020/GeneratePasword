/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author laboratorio
 */
@Service
public class GeneratorNumbersStub implements GeneratorNumbersServices {

    public List<Integer> numeros = new ArrayList<Integer>();
    public GeneratorNumbersStub(){}
    
    @Override
    public void gellAllNum(String numero) {
        int num = 0;
        int a = 0;
        int b = 5;
        while (num < 4) {
            numeros.add(Integer.parseInt(numero.substring(a, b)));
            a = b;
            b = b + 5;
            num++;
        }
    }
    @Override
    public List<Integer> getNumeros() {
        return numeros;
    }
    
    @Override
    public List<String> separetaNumbers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String conversNumbers(Integer numero, Integer base) {
        String respuesta="";
        int ba=base;
        int num=numero;
        while(ba<=16){
            while(num>=base){
                respuesta+=String.valueOf(num%base); 
                num=num /base;
            }
            if(num<base){
                respuesta+=String.valueOf(num);
            }
            base*=2;
        }        
        return respuesta;
    }
}
