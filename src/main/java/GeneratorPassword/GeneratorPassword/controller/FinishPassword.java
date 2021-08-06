/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.controller;

import GeneratorPassword.GeneratorPassword.model.Contrasena;
import GeneratorPassword.GeneratorPassword.persistence.MongoDB;
import GeneratorPassword.GeneratorPassword.services.CreatePaswword;
import GeneratorPassword.GeneratorPassword.services.GeneratorNumbersServices;
import GeneratorPassword.GeneratorPassword.services.OpeprateNumerate;
import GeneratorPassword.GeneratorPassword.services.OperateDictionarie;
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

import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author cefar-dico
 */
@RestController
@RequestMapping(value = "/getPassword")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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

    @Autowired
    private MongoDB mng;

    private ArrayList<String> contraseñas = new ArrayList<String>();

    /**
     * Esta funcion genera la contraseña final.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/gt")
    public ResponseEntity<?> getPassword() throws PasswordException {
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
        return new ResponseEntity<>(contraseña, HttpStatus.ACCEPTED);
    }

    /**
     * Esta funcion retorna de manera rapida una contraseña y la coteja con la
     * base de datos para ver si ya fue generada antes.
     *
     * @return contrasena
     * @throws PasswordException
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, path = "/gtn")
    public ResponseEntity<?> getPasswordNew() throws PasswordException, Exception {
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
                if(!od.getSizeListContrasen()){
                    contraseña = od.getContrasena(crp.getArregloFinal());                
                }
                //8Paso, entrega de contraseña
                Contrasena cn = new Contrasena(contraseña);
                if (!mng.isHereOrNot(cn.toString())) {
                    mng.insertData(new Contrasena(contraseña).toString());
                    temporal = false;
                }
            }
            contrasenas=new Contrasena(contraseña, 0);
            return new ResponseEntity<>(contrasenas.toString(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            throw new PasswordException("Excepcion Generacion Contraseñas : " + ex.getMessage());
        }
    }

}
