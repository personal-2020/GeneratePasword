/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.services.GeneratorNumbersServices;
import GeneratorPassword.GeneratorPassword.services.PaswordGeneratorServices;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laboratorio
 */


@RestController
@RequestMapping(value = "/pass")

public class GeneratorPassword {
 
    @Autowired
    private PaswordGeneratorServices pd;
    
    @Autowired
    private GeneratorNumbersServices gn;
    
    private String numero;
    
    private List<BigInteger> numeros=new ArrayList<BigInteger>();
    private List<String> numerosS=new ArrayList<String>();
    
    @RequestMapping(method = RequestMethod.GET, path = "/nnum")
    public ResponseEntity<?> getNewNumbers() {
        numero=pd.getNumero();
        System.out.println("ESTE ES EL NUEVO NUMERO"+numero);
        gn.gellAllNum(numero);       
        return new ResponseEntity<>(gn.getNumeros(), HttpStatus.ACCEPTED);
    }        
    
        @RequestMapping(method = RequestMethod.GET, path = "/change")
    public ResponseEntity<?> changeBaseNum() {
        numeros = gn.getNumeros();
        int base=2;
        for (int i = 0; i < numeros.size(); i++) {
            BigInteger temp = numeros.get(i);
            while (base <= 16) {
                System.out.println("base : " + base);
                System.out.println("numero : " + temp);
                temp = gn.conversNumbers(temp, base);
                base = base * 2;
            }
            numerosS.add(temp.toString());
            base = 2;
            base = base * 2;
        }

        return new ResponseEntity<>(numerosS, HttpStatus.ACCEPTED);
    }

    
}
