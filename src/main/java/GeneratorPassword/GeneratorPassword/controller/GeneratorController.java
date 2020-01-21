/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.model.Matriz;
import GeneratorPassword.GeneratorPassword.persistence.impl.Tupla;
import GeneratorPassword.GeneratorPassword.services.GeneratorNumbersServices;
import GeneratorPassword.GeneratorPassword.services.PasswordGeneratorStub;
import GeneratorPassword.GeneratorPassword.services.PaswordGeneratorServices;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cefar -- Dicomatico
 */
@RestController
@RequestMapping(value = "/")
public class GeneratorController {

    @Autowired
    private PaswordGeneratorServices pd;
    
    @Autowired
    private GeneratorNumbersServices gn;
    
    
    List<List<Tupla>> matDib = new ArrayList<List<Tupla>>();

    Tupla posInit = new Tupla(1, 1);
    Matriz m = new Matriz(4, 5, posInit);
    private String numero;
    
    

    @RequestMapping(method = RequestMethod.GET, path = "/p1")
    public ResponseEntity<?> genFirtsMatris() {
        
        System.out.println("tamañano matris: columnas " + m.getColumns() + " filas: " + m.getRows());
        
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pintar")
    public ResponseEntity<?> pintarMa() {

        pd.paintMatrs();
        return new ResponseEntity<>(pd.paintMatrs(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/r")
    public ResponseEntity<?> getRandom() {

        return new ResponseEntity<>(pd.getNumRandom(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/prueba")
    public ResponseEntity<?> getprueba() {
        System.out.println("que es m:"+m.getMartis());
        pd.GenerateRandom(m);
        Tupla k=new Tupla(1,1);
        List<Tupla> t=pd.posibilitis(k);
        for(Tupla f:t){
            System.out.println("Las nuevas posibilidades son: "+f.getElem1()+" : y : "+f.getElem2());
        
        }
        
        
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/pos")
    public ResponseEntity<?> getPos() {
                
        return new ResponseEntity<>(pd.getNewPosition(), HttpStatus.ACCEPTED);
    }    
    
    @RequestMapping(method = RequestMethod.GET, path = "/es/{id1}/{id2}")
    public ResponseEntity<?> getTRue(@PathVariable Integer id1,@PathVariable Integer id2) {
        
        return new ResponseEntity<>(pd.esta(new Tupla(id1,id2)), HttpStatus.ACCEPTED);
    }

    //Gnerator of number the 20 cifres
    @RequestMapping(method = RequestMethod.GET, path = "/numero")
    public ResponseEntity<?> getNumber() {
        
        numero=pd.numberOfMatriz();
        return new ResponseEntity<>(numero, HttpStatus.ACCEPTED);
    }    
}
