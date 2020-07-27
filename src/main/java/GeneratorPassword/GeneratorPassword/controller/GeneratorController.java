/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.model.Matriz;
import GeneratorPassword.GeneratorPassword.model.Tupla;
import GeneratorPassword.GeneratorPassword.services.GeneratorNumbersServices;
import GeneratorPassword.GeneratorPassword.services.PasswordException;
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
    private GeneratorNumbersServices gn;//List<List<Tupla>> matDib = new ArrayList<List<Tupla>>();
    private String numero;

    /**
     * Esta funcion representa la forma grafica de la matriz.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/pintar")
    public ResponseEntity<?> pintarMa() {
        return new ResponseEntity<>(pd.paintMatrs(), HttpStatus.ACCEPTED);
    }

    /**
     * Esta funcion genea un numero aleatorio.
     */    
    @RequestMapping(method = RequestMethod.GET, path = "/r")
    public ResponseEntity<?> getRandom() {
        return new ResponseEntity<>(pd.getNumRandom(), HttpStatus.ACCEPTED);
    }

    
    /**
     * Esta funcion trae una nueva posicion de la matriz
     */
    @RequestMapping(method = RequestMethod.GET, path = "/pos")
    public ResponseEntity<?> getPos() {                
        return new ResponseEntity<>(pd.getNewPosition(), HttpStatus.ACCEPTED);
    }    
    
    /**
     * Esta funcion regresa si la posicion pasada como parametro a sido visitada o no.
     * @param id1   Es un entero que representa la fila de la matriz.
     * @param id2    Es un entero que representa la fila de la matriz.    
     */
    @RequestMapping(method = RequestMethod.GET, path = "/es/{id1}/{id2}")
    public ResponseEntity<?> getTRue(@PathVariable Integer id1,@PathVariable Integer id2) {        
        return new ResponseEntity<>(pd.esta(new Tupla(id1,id2)), HttpStatus.ACCEPTED);
    }
    
    /**
     * Este metodo informa las posiciones libres que quedan en la matriz.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/vi")
    public ResponseEntity<?> vi() {
        return new ResponseEntity<>(pd.getVisitados(), HttpStatus.ACCEPTED);
    }       
    
    /**
     * Este metodo regresa el numero de 20 cifras,
     */
    @RequestMapping(method = RequestMethod.GET, path = "/gnum")//Este es---
    public ResponseEntity<?> allNUm() throws PasswordException {
        pd.generateNewMatriz();
        pd.GenerateRandom();       
        numero=pd.numberOfMatriz();    
        if(numero.equals("")){
            numero="Matriz sin llenar, rellenela antes de solicitar el numero.";
            throw new PasswordException("Matriz sin llenar, rellenela antes de solicitar el numero.");
        }        
        return new ResponseEntity<>(numero, HttpStatus.ACCEPTED);
    }           
    
}
