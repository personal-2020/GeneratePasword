/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.model.Diccionario;
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

    private static List<String> letraEmergencia = new ArrayList<String>();

    private Diccionario dictionario = new Diccionario();

    private List<String> contraseñas = new ArrayList<String>();

    private List<String> arregloAyuda = new ArrayList<String>();

    /**
     * Restablece el arreglo de ayuda.
     *
     * @param arregloAyudav Lista de tipo String
     */
    public void setArregloAyuda(List<String> arregloAyudav) {
        this.arregloAyuda = arregloAyuda;
    }

    /**
     * Devuelve el arreglo ayuda.
     *
     * @return arregloAyuda
     */
    public List<String> getArregloAyuda() {
        return arregloAyuda;
    }
    /**
     * Esta funcion retorna solo una contraseña de la lista de contraseñas 
     * o indica que se debe generar una nueva lista.    
     * @param arrFinal  Arreglo que contiene las frases finales para generar la 
     * contraseña.
     * @return  respuesta
     */

    public String getContrasena(List<String> arrFinal) throws PasswordException {
        String respuesta="";
        try{
        if (contraseñas.isEmpty()) {
            contraseñas = (ArrayList<String>) this.getPaswword(arrFinal);
            if (contraseñas.size() > 0) {
                System.out.println("lista de contraseñas : " + contraseñas.toString());
                respuesta = contraseñas.get(0);
                contraseñas.remove(0);
            }

        } else {
            respuesta = contraseñas.get(0);
            contraseñas.remove(0);
        }

        return respuesta;
        }catch (Exception ex) {
            throw new PasswordException("Excepcion entregando Contraseña: " + ex.getMessage());
        }
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
     * @return contraseñas
     */
    @Override
    public List<String> getPaswword(List<String> arregloFinal) throws PasswordException{
        List<List<String>> arreglosf = conversFraseToArray(arregloFinal);
        String letra = "L";
        try{
            for (int ft = 0; ft < arreglosf.size(); ft++) {
                String contraseña = "";
                List<String> temp = arreglosf.get(ft);
                boolean paso = false;
                int si = 0;
                int p = 0;
                int pp = 0;
                while (temp.size() > 0) {
                    if (p >= temp.size()) {
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
                                    letra = "N";
                                    contraseña = contraseña.concat(a);
                                    noesta = false;
                                } catch (PasswordException ex) {
                                    Logger.getLogger(OperateDictionarieStub.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else if (isNumeric(qqq) && letra.equals("N") && noesta) {
                                arregloAyuda.remove(g);
                                letra = "L";
                                contraseña = contraseña.concat(qqq);
                                noesta = false;
                            }
                        }
                        if (!noesta || pp >= 2) {
                            pp = 0;
                            if (letra.equals("L")) {
                                int k = (int) (Math.random() * letraEmergencia.size());
                                String h = letraEmergencia.get(k);
                                letra = "N";
                                contraseña = contraseña.concat(h);
                                temp.remove(0);
                            } else if (letra.equals("N")) {
                                int k = (int) (Math.random() * letraEmergencia.size());
                                contraseña = contraseña.concat(String.valueOf(k));
                                temp.remove(0);
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
                                if (p > 0) {
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
                            if (p > 0) {
                                p--;
                            }
                            paso = true;
                        } else {
                            paso = false;
                            p++;
                            pp++;
                        }
                    } else if (p > temp.size()) {
                        p = 0;
                    } else {
                        p++;
                        pp++;
                    }
                }
                contraseñas.add(contraseña);
            }
            return contraseñas;
        }catch (Exception ex) {
            throw new PasswordException("Excepcion Generando Contraseña: " + ex.getMessage());
        }
    }

    /**
     * Esta funcion genera el arreglo ayuda.
     *
     * @param arregloA Arreglo que contiene todos los carrecteres que serviran
     * de ayuda.
     */
    @Override
    public void getListHelp(List<String> arregloA) {
        for (int ae = 0; ae < arregloA.size(); ae++) {
            String ft = arregloA.get(ae);
            for (int y = 0; y < ft.length(); y++) {
                arregloAyuda.add(String.valueOf(ft.charAt(y)));
            }
        }
    }

    /**
     * Esta funcion convierte la frase del arreglo a lista.
     *
     * @param arregloIn Arreglo con la frase completa.
     * @return arregloOut
     */
    @Override
    public List<List<String>> conversFraseToArray(List<String> arregloIn)throws PasswordException {
        List<List<String>> arregloOut = new ArrayList<List<String>>();
        try{
            for (String i : arregloIn) {
                List<String> temp = new ArrayList<String>();
                for (int y = 0; y < i.length(); y++) {
                    temp.add(String.valueOf(i.charAt(y)));
                }
                arregloOut.add(temp);
            }
            return arregloOut;
        }catch (Exception ex) {
            throw new PasswordException("Excepcion convirtiendo Frase: " + ex.getMessage());
        }
    }

    /**
     * Esta funcion regresa si el string es o no numero.
     *
     * @param cadena String representa un caracter numero o letra.
     */
    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    static {
        letraEmergencia.add("A");
        letraEmergencia.add("B");
        letraEmergencia.add("C");
        letraEmergencia.add("D");
        letraEmergencia.add("E");
        letraEmergencia.add("F");
    }
}
