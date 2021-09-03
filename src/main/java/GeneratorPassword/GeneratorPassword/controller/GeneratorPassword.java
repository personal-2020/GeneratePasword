/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.controller;

import Generatorpassword.Generatorpassword.services.CreatePaswword;
import Generatorpassword.Generatorpassword.services.GeneratorNumbersServices;
import Generatorpassword.Generatorpassword.services.OpeprateNumerate;
import Generatorpassword.Generatorpassword.services.PasswordException;
import Generatorpassword.Generatorpassword.services.PaswordGeneratorServices;
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
    
    @Autowired
    private OpeprateNumerate op;
        
    @Autowired
    private CreatePaswword crp;
    
    private String numero;
    
    private List<BigInteger> numeros=new ArrayList<BigInteger>();
    private List<String> numerosS=new ArrayList<String>();
    
    private List<String> sentenceFinal=new ArrayList<String>();
    
    private List<String> arregloPreFinal=new ArrayList<String>();
    private List<String> arregloFinal=new ArrayList<String>();
    private List<String> arregloAyuda=new ArrayList<String>();
    
    private List<String> temp=new ArrayList<String>();
    
    /**
     * 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/nnum")
    public ResponseEntity<?> getNewNumbers() throws PasswordException {
        try{
        numero=pd.getNumero();
        if(gn.getNumeros().size()==0){
            gn.gellAllNum(numero);               
        }else{
            gn.resetNumeros();
            gn.gellAllNum(pd.getNumero());               
        }
        return new ResponseEntity<>(gn.getNumeros(), HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            throw new PasswordException("Excepcion generando numeros: " + ex.getMessage());
        }
    }        
        
    /**
     * Esta funcion convierte los numeros de una base en otra.
     */    
    @RequestMapping(method = RequestMethod.GET, path = "/change")
    public ResponseEntity<?> changeBaseNum() throws PasswordException, Exception {
        try{
        numeros = gn.getNumeros();
        if(numerosS.isEmpty()){
            gn.conversNumb(numeros);        
        }else{
            numerosS.clear();
            gn.conversNumb(numeros);
        }
        numerosS=gn.getNumberConvertido();
        return new ResponseEntity<>(numerosS, HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            throw new PasswordException("Excepcion entrgnado cambio de base: " + ex.getMessage());
        }
    }
    
    /**
     * Esta funcion retorna las frases despues de las 1 suma.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/sentencesFinal")
    public ResponseEntity<?> haveManySenteces() throws PasswordException {
        try{
        op.clearSentences();
        if(op.getSentence().isEmpty()){
            op.SeparateNumber(numerosS);
        }else{
            op.clearSentence();
            op.SeparateNumber(numerosS);
        }
        List<List<String>> v=op.getListL();
        return new ResponseEntity<>(op.getSentenceOperateNumerate(), HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            throw new PasswordException("Excepcion sumando frasees: " + ex.getMessage());
        }
    }           
    
    /**
     * Esta funcion realiza la suma de las frases y genera nuevas frases mas complejas.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/frsCont")
    public ResponseEntity<?> haveFewSenteces() throws PasswordException {
        try{
        List<String> temp=op.getSentence();        
        if(temp.isEmpty()){
            System.out.println("NO puede generarse, no hay frases para procesar.");
            throw new PasswordException("NO puede generarse, no hay frases para procesar.");
        }else{
            arregloPreFinal=op.getFinalFrase(temp);            
        }        
        return new ResponseEntity<>(arregloPreFinal, HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            throw new PasswordException("Excepcion generando frases complejas: " + ex.getMessage());
        }
    }           
    
    /**
     * Esta funcion genera las frases finales que generaran las contraseñas.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/final")
    public ResponseEntity<?> havefinal() throws PasswordException, Exception {
        try{
        if(temp.isEmpty()){
            temp=crp.paswords(arregloPreFinal);
        }
        //RECORDAR REVISAR ESTA FUNCION PARA RECODIFICACION
        //REVISAR FUNCIONES GENERATEPassword(/final) y fiinishpassword pare recodificacion
        return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            throw new PasswordException("Excepcion generando frases finales: " + ex.getMessage());
        }
    }           
    
}
