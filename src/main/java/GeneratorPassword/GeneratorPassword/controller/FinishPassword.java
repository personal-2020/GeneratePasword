/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.services.CreatePaswword;
import GeneratorPassword.GeneratorPassword.services.OperateDictionarie;
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
 * @author cefar-dico
 */
@RestController
@RequestMapping(value = "/getPassword")
public class FinishPassword {
    
    @Autowired
    private OperateDictionarie od;
    
    @Autowired
    private CreatePaswword crp;
    
    private ArrayList<String> contraseñas=new ArrayList<String>();
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/gt")
    public ResponseEntity<?> getPassword() {
        
        String contraseña;        
        
        List<String> as=crp.getArregloAyuda();
        
        od.getListHelp(as);
        if(contraseñas.isEmpty()){ 
            contraseñas=(ArrayList<String>) od.getPaswword(crp.getArregloFinal());
            System.out.println("lista de contraseñas : "+contraseñas.toString());
            contraseña=contraseñas.get(0);        
            contraseñas.remove(0);
        }else{
            contraseña=contraseñas.get(0);        
            contraseñas.remove(0);
        }       
        return new ResponseEntity<>(contraseña, HttpStatus.ACCEPTED);
    }        

    
    
    
}

