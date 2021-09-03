/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.controller;
//
import Generatorpassword.Generatorpassword.model.Contrasena;
//import GeneratorPassword.GeneratorPassword.persistence.MongoDB;
import Generatorpassword.Generatorpassword.services.CreatePaswword;
import Generatorpassword.Generatorpassword.services.GeneratorNumbersServices;
import Generatorpassword.Generatorpassword.services.OpeprateNumerate;
import Generatorpassword.Generatorpassword.services.OperateDictionarie;
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

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author cefar-dico
 */
@RestController
@RequestMapping(value = "/getPassword")
@CrossOrigin(origins = "localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST})
public class FinishPassword {

    @Autowired
    private PaswordGeneratorServices pd;

    @Autowired
    private GeneratorNumbersServices gn;

    @Autowired
    private OpeprateNumerate op;

    @Autowired
    private OperateDictionarie od;

    @Autowired
    private CreatePaswword crp;

    //@Autowired
    //private MongoDB mng;

    private ArrayList<String> contraseñas = new ArrayList<String>();

    /**
     * Esta funcion genera la contraseña final.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/gt")
    //@GetMapping("/getPassword/gt")
    public ResponseEntity<?> getPassword() throws PasswordException {
    //public ResponseEntity<?> getPassword() {
        String contraseña = "";
        try {

            List<String> as = crp.getArregloAyuda();
            od.getListHelp(as);
            if (contraseñas.isEmpty()) {
                contraseñas = (ArrayList<String>) od.getPaswword(crp.getArregloFinal());
                System.out.println("lista de contraseñas : " + contraseñas.toString());
                contraseña = contraseñas.get(0);
                contraseñas.remove(0);
            } else {
                contraseña = contraseñas.get(0);
                contraseñas.remove(0);
            }
        } catch (Exception ex) {
            throw new PasswordException("Excepcion Creando Contraseña: " + ex.getMessage());
        }
        return new ResponseEntity<>("hola", HttpStatus.ACCEPTED);
    }

    /**
     * Esta funcion retorna de manera rapida una contraseña y la coteja con la
     * base de datos para ver si ya fue generada antes.
     *
     * @return contrasena
     * @throws PasswordException
     * @throws Exception
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, path = "/gtn")
//    //@CrossOrigin(origins = "http://localhost:4200")
//    //@GetMapping("/getPassword/gtn")
    //public ResponseEntity<?> getPasswordNew() throws PasswordException, Exception {
    public Contrasena getPasswordNew() throws PasswordException, Exception {
        Contrasena contrasenas;
        try {////Primer paso generar el numero cada vez que entra

            String contraseña = "";
            boolean temporal = true;
            while (temporal) {
                while (od.getSizeListContrasen()) {
                    pd.generateNewMatriz();
                    pd.GenerateRandom();
                    String numero = pd.numberOfMatriz();
                    //// SEGUNDO PASO 
                    if (gn.getNumeros().size() == 0) {
                        gn.gellAllNum(numero);
                    } else {
                        gn.resetNumeros();
                        gn.gellAllNum(pd.getNumero());
                    }
                    //Tercer Paso
                    List<BigInteger> numeros = new ArrayList<BigInteger>();
                    List<String> numerosS = new ArrayList<String>();
                    numeros = gn.getNumeros();
                    if (numerosS.isEmpty()) {
                        gn.conversNumb(numeros);
                    } else {
                        numerosS.clear();
                        gn.conversNumb(numeros);
                    }
                    numerosS = gn.getNumberConvertido();
                    //4 Cuarto paso
                    op.clearSentences();
                    if (op.getSentence().isEmpty()) {
                        op.SeparateNumber(numerosS);
                    } else {
                        op.clearSentence();
                        op.SeparateNumber(numerosS);
                    }
                    List<List<String>> v = op.getListL();
                    op.getSentenceOperateNumerate();
                    //5 paso
                    List<String> arregloPreFinal = new ArrayList<String>();
                    List<String> temp = op.getSentence();
                    if (temp.isEmpty()) {
                        System.out.println("NO puede generarse, no hay frases para procesar.");
                        throw new PasswordException("NO puede generarse, no hay frases para procesar.");
                    } else {
                        arregloPreFinal = op.getFinalFrase(temp);
                    }
                    //6Paso 
                    List<String> temp1 = new ArrayList<String>();
                    if (temp1.isEmpty()) {
                        temp1 = crp.paswords(arregloPreFinal);
                    }
                    //7 paso                   
                    List<String> as = crp.getArregloAyuda();
                    od.getListHelp(as);
                    contraseña = od.getContrasena(crp.getArregloFinal());
                }
                if (!od.getSizeListContrasen()) {
                    contraseña = od.getContrasena(crp.getArregloFinal());
                }
                //8Paso, entrega de contraseña
                Contrasena cn = new Contrasena(contraseña);
                //if (!mng.isHereOrNot(cn.toString())) {
                if (true) {
                    //mng.insertData(new Contrasena(contraseña).toString());
                    temporal = false;
                }
            }
            contrasenas = new Contrasena(contraseña);

            //return new ResponseEntity<>(contrasenas.toString(), HttpStatus.ACCEPTED);
            return contrasenas;
            //return new Contrasena("hola",0);
        } catch (Exception ex) {
            throw new PasswordException("Excepcion Generacion Contraseñas : " + ex.getMessage());
        }
    }

}
