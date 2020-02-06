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
    public Long conversNumbers(long numero, Integer base) {
        BigInteger n = BigInteger.ZERO;
        BigInteger n0 = BigInteger.ZERO;
        String respuesta="";
        long num=numero;
        int bas=base;
        long mod=1;
        long cant=1;
        long resp=0;
        while(num>=base){
            System.out.println("que numero se va trabajando: "+num);
            mod=num%bas;
            System.out.println("que arroja el mod: "+mod);
            num=num/bas;            
            resp=resp+mod*cant;
            
            //big integer
            n0=n0.add(BigInteger.valueOf(mod));
            n0=n0.multiply(BigInteger.valueOf(cant));
            n=n.add(BigInteger.valueOf(resp));
            //
            n=n.add(n0);
            //long m=mod*cant;
            n0 = BigInteger.ZERO;
            //n=n.add(BigInteger.valueOf(resp+mod*cant));
            System.out.println("cmo va el resultado BIG: "+n);
            System.out.println("cmo va el resultado: "+resp);
            cant=cant*10;
        }
        //System.out.println("miresmos resp: "+resp+" - que es num: "+num+"- que es cant: "+cant);
        //long m=mod*cant;
        resp=resp+num*cant;
       
        //n=n.add(BigInteger.valueOf(resp+mod*cant));
        cant=1;
        System.out.println("miremos respuesta q sale :"+resp);
        System.out.println("miremos el biginteger : "+n);
        //return String.valueOf( resp);
        return resp;
 
    }
}
