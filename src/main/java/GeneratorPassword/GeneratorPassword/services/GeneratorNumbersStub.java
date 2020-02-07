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
/**
 *
 * @author laboratorio
 */
@Service
public class GeneratorNumbersStub implements GeneratorNumbersServices {

    public List<BigInteger> numeros = new ArrayList<BigInteger>();
    public GeneratorNumbersStub(){}
    
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
    public BigInteger conversNumbers(BigInteger numero, Integer base){
       
                // Your code here!
        
        //BigInteger numero=new BigInteger("1000000000000");
        
        
        

        //long num=numero;
        //int bas=base;
        BigInteger mod=BigInteger.ONE;
        BigInteger cant=BigInteger.ONE;
        
        BigInteger t=BigInteger.ONE;
        
        BigInteger resp=BigInteger.ZERO;
        System.out.println("como va resp in"+resp);
        
        
        while(numero.compareTo(BigInteger.valueOf(base))>=0){
            System.out.println("Base : "+base);
            System.out.println("que numero se va trabajando: "+numero);
            mod=numero.mod(BigInteger.valueOf(base));
            
            System.out.println("que arroja el mod: "+mod);
            System.out.println("que arroja el el div: "+numero.divide(BigInteger.valueOf(base)));
            numero=numero.divide(BigInteger.valueOf(base));            

            
            t=t.multiply(mod);
            t=t.multiply(cant);
            System.out.println("como va t :"+t);
            System.out.println("que es resp antes de sumar  :"+resp);
            
            //resp=resp.add(resp);
            resp=resp.add(t);
            t=BigInteger.ONE;
            
            //

            //n=n.add(BigInteger.valueOf(resp+mod*cant));
            cant=cant.multiply(BigInteger.valueOf(10));
            
            System.out.println("va quedando : "+resp);
        }
        t=BigInteger.ONE;
        //System.out.println("miresmos resp: "+resp+" - que es num: "+num+"- que es cant: "+cant);
        //long m=mod*cant;
        System.out.println("que es cant : "+cant);
        t=t.multiply(numero);
        t=t.multiply(cant);
        System.out.println("que resp antes : "+resp);
        
        //resp=resp.add(resp);
        resp=resp.add(t);
        
        
        
        System.out.println("XXXXXXXX"+resp);
        
        
        return resp;
    }
}
