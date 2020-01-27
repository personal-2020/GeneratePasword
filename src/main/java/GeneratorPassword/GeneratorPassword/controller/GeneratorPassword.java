/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.services.GeneratorNumbersServices;
import GeneratorPassword.GeneratorPassword.services.PaswordGeneratorServices;
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
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/nnum")
    public ResponseEntity<?> getNewNumbers() {
        numero=pd.getNumero();
        System.out.println("ESTE ES EL NUEVO NUMERO"+numero);
        gn.gellAllNum(numero);       
        return new ResponseEntity<>(gn.getNumeros(), HttpStatus.ACCEPTED);
    }        
    
    
    
}
