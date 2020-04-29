/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.persistence.impl.Diccionario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author cefar-dico
 */
@Service
public class OperateDictionarieStub implements OperateDictionarie {

    private static List<String> letraEmergencia=new ArrayList<String>();
    
    private Diccionario dictionario = new Diccionario();

    private List<String> contraseñas = new ArrayList<String>();

    private List<String> arregloAyuda = new ArrayList<String>();

    public void setArregloAyuda(List<String> arregloAyudav) {
        this.arregloAyuda = arregloAyuda;
    }

    public List<String> getArregloAyuda() {
        return arregloAyuda;
    }

    /**
     * Funcion que genera las contraseñas: La contraseña, que se deben guiar por
     * las siguientes reglas: Si hay solo 2 letras en la frase se pasa a
     * "Arreglo ayuda" Si queda aun letras suficientes para generar una
     * contraseña se usan, por el contrario se desechan. UNa contraseña apta
     * tiene almenos 3 palabras separaradas por un numeor, si no cumple con esto
     * se desecha. En caso de no haber letras de ayuda "arreglo de ayuda", se
     * ignora el hecho y se continua con la frase. En este caso la contraseña
     * debe mantener 3 palabras
     *
     * @param arregloFinal
     * @param arregloAyuda
     * @return
     */
    @Override
    public List<String> getPaswword(List<String> arregloFinal) {
        List<List<String>> arreglosf = conversFraseToArray(arregloFinal);

        String letra = "L";

        //for (List<String> ft : arreglosf) {
        for(int ft=0;ft<arreglosf.size();ft++){
            String contraseña = "";
            List<String> temp = arreglosf.get(ft);
            boolean paso = false;
            int si = 0;
            int p = 0;
           while (temp.size() > 0) {
                if (p > temp.size()) {
                    p = 0;
                    si++;
                }
                if (si > 0) {//AQUI SE BUSA LA LETRA O NUMERO Q SE NECESITA
                    boolean noesta = true;
                    si = 0;
                    for (int g = 0; g < arregloAyuda.size(); g++) {
                        String qqq = arregloAyuda.get(g);
                        if (!isNumeric(qqq) && letra.equals("L") && noesta) {
                            try {
                                String a = dictionario.getLetra(qqq);
                                arregloAyuda.remove(g);
                                letra="N";
                                contraseña = contraseña.concat(a);
                                noesta = false;
                            } catch (PasswordException ex) {
                                Logger.getLogger(OperateDictionarieStub.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if (isNumeric(qqq) && letra.equals("N") && noesta) {

                                arregloAyuda.remove(g);
                                letra="L";
                                contraseña = contraseña.concat(qqq);
                                noesta = false;

                        }
                    }
                    if(!noesta){
                        if(letra.equals("L")){
                            int k=(int) (Math.random() * letraEmergencia.size());
                            String h=letraEmergencia.get(k);
                            letra="N";
                            contraseña = contraseña.concat(h);                                                
                        }else if(letra.equals("N")){
                            int k=(int) (Math.random() * 10);                            
                            contraseña = contraseña.concat(String.valueOf(k));
                        }   
                    }
                }
                if (p < temp.size()) {
                    if (!isNumeric(temp.get(p)) & letra.equals("L")) {
                        try {//Para saber si es letra
                            String a = dictionario.getLetra(temp.get(p));
                            contraseña = contraseña.concat(a);
                            letra = "N";                            
                            temp.remove(p);
                            if(p>0){
                                p--;
                            }                                                        
                            paso = true;
                        } catch (PasswordException ex) {
                            Logger.getLogger(OperateDictionarieStub.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (isNumeric(temp.get(p)) & letra.equals("N")) {
                        letra = "L";                        
                        contraseña = contraseña.concat(temp.get(p));                        
                        temp.remove(p);
                        
                        if(p>0){
                            p--;
                        }
                        paso = true;
                    } else {
                        paso = false;
                        p++;
                    }

                }else if(p>temp.size()){
                    p=0;
                
                
                }else{
                    p++;
                }

            }
            contraseñas.add(contraseña);
        }
        return contraseñas;
    }

    @Override
    public void getListHelp(List<String> arregloA) {
        //for(String ft: arregloAyuda){            
        for (int ae = 0; ae < arregloA.size(); ae++) {
            String ft = arregloA.get(ae);
            for (int y = 0; y < ft.length(); y++) {
                arregloAyuda.add(String.valueOf(ft.charAt(y)));

            }
        }
    }

    @Override
    public List<List<String>> conversFraseToArray(List<String> arregloIn) {
        List<List<String>> arregloOut = new ArrayList<List<String>>();
        for (String i : arregloIn) {
            List<String> temp = new ArrayList<String>();
            for (int y = 0; y < i.length(); y++) {
                temp.add(String.valueOf(i.charAt(y)));
            }
            arregloOut.add(temp);
        }
        return arregloOut;
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    static{
    
        letraEmergencia.add("A");
        letraEmergencia.add("B");
        letraEmergencia.add("C");
        letraEmergencia.add("D");
        letraEmergencia.add("E");
        letraEmergencia.add("F");
    
    
    }
}
