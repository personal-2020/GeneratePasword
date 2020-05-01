/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.services.CreatePaswword;
import GeneratorPassword.GeneratorPassword.services.GeneratorNumbersServices;
import GeneratorPassword.GeneratorPassword.services.OpeprateNumerate;
import GeneratorPassword.GeneratorPassword.services.PasswordException;
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
    
    /**
     * 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/nnum")
    public ResponseEntity<?> getNewNumbers() {
        numero=pd.getNumero();
        if(gn.getNumeros().size()==0){
            gn.gellAllNum(numero);               
        }else{
            gn.resetNumeros();
            gn.gellAllNum(pd.getNumero());               
        }
        return new ResponseEntity<>(gn.getNumeros(), HttpStatus.ACCEPTED);
    }        
        
    /**
     * Esta funcion convierte los numeros de una base en otra.
     */    
    @RequestMapping(method = RequestMethod.GET, path = "/change")
    public ResponseEntity<?> changeBaseNum() {
        numeros = gn.getNumeros();
        if(numerosS.isEmpty()){
            gn.conversNumb(numeros);        
        }else{
            numerosS.clear();
            gn.conversNumb(numeros);
        }
        numerosS=gn.getNumberConvertido();
        return new ResponseEntity<>(numerosS, HttpStatus.ACCEPTED);
    }
    
    /**
     * Esta funcion retorna las frases despues de las 1 suma.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/sentencesFinal")
    public ResponseEntity<?> haveManySenteces() {
        op.clearSentences();
        if(op.getSentence().isEmpty()){
            op.SeparateNumber(numerosS);
        }else{
            op.clearSentence();
            op.SeparateNumber(numerosS);
        }
        List<List<String>> v=op.getListL();
        return new ResponseEntity<>(op.getSentenceOperateNumerate(), HttpStatus.ACCEPTED);
    }           
    
    /**
     * Esta funcion realiza la suma de las frases y genera nuevas frases mas complejas.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/frsCont")
    public ResponseEntity<?> haveFewSenteces() throws PasswordException {
        List<String> temp=op.getSentence();        
        if(temp.isEmpty()){
            System.out.println("NO puede generarse, no hay frases para procesar.");
            throw new PasswordException("NO puede generarse, no hay frases para procesar.");
        }else{
            arregloPreFinal=op.getFinalFrase(temp);            
        }        
        return new ResponseEntity<>(arregloPreFinal, HttpStatus.ACCEPTED);
    }           
    
    /**
     * Esta funcion genera las frases finales que generaran las contraseñas.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/final")
    public ResponseEntity<?> havefinal() {
        List<String> temp=crp.paswords(arregloPreFinal);
        return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
    }           
    
}
