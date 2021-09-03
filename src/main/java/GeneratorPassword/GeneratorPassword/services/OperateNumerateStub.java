/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author lanosce
 */
@Service
public class OperateNumerateStub implements OpeprateNumerate {

    private List<String> sentences = new ArrayList<String>();
    private List<List<String>> sentencesOfPasword = new ArrayList<List<String>>();
    List<String> temporal = new ArrayList<String>();//Se creara 2 array mas, uno con lasfrases de menor de longitud 5 y otro con las frases restantes.
    private List<String> sentecesGreather = new ArrayList<String>();
    private List<String> sentecesMinors = new ArrayList<String>();

    /**
     * Esta funcion realiza la suma de las 4 frases inicialmente generadas.
     *
     * @return sentences
     */
    @Override
    public List<String> getSentenceOperateNumerate() throws PasswordException {
        try {
            int tam = 0;// Your code here!
            if (sentencesOfPasword.get(0).size() > tam) {
                tam = sentencesOfPasword.get(0).size();
            }
            if (sentencesOfPasword.get(1).size() > tam) {
                tam = sentencesOfPasword.get(1).size();
            }
            if (sentencesOfPasword.get(2).size() > tam) {
                tam = sentencesOfPasword.get(2).size();
            }
            if (sentencesOfPasword.get(3).size() > tam) {
                tam = sentencesOfPasword.get(3).size();
            }
            for (int i = 0; i < tam; i++) {
                if (i < sentencesOfPasword.get(0).size()) {
                    if (sentences.isEmpty()) {
                        sentences.add(sentencesOfPasword.get(0).get(i));
                    } else {
                        if (i < sentences.size()) {
                            if (sentences.get(i) == null) {
                                sentences.add(sentencesOfPasword.get(0).get(i));
                            } else {
                                String h = sentences.get(i);
                                sentences.set(i, h + sentencesOfPasword.get(0).get(i));
                            }
                        } else {
                            sentences.add(sentencesOfPasword.get(0).get(i));
                        }
                    }
                }
                if (i < sentencesOfPasword.get(1).size()) {
                    if (sentences.isEmpty()) {
                        sentences.add(sentencesOfPasword.get(1).get(i));
                    } else {
                        if (i < sentences.size()) {
                            if (sentences.get(i) == null) {
                                sentences.add(sentencesOfPasword.get(1).get(i));
                            } else {
                                String h = sentences.get(i);
                                sentences.set(i, h + sentencesOfPasword.get(1).get(i));
                            }
                        } else {
                            sentences.add(sentencesOfPasword.get(1).get(i));
                        }
                    }
                }
                if (i < sentencesOfPasword.get(2).size()) {
                    if (sentences.isEmpty()) {
                        sentences.add(sentencesOfPasword.get(2).get(i));
                    } else {
                        if (i < sentences.size()) {
                            if (sentences.get(i) == "") {
                                sentences.add(sentencesOfPasword.get(2).get(i));
                            } else {
                                String h = sentences.get(i);
                                sentences.set(i, h + sentencesOfPasword.get(2).get(i));
                            }
                        } else {
                            sentences.add(sentencesOfPasword.get(2).get(i));
                        }
                    }
                }
                if (i < sentencesOfPasword.get(3).size()) {
                    if (sentences.isEmpty()) {
                        sentences.add(sentencesOfPasword.get(3).get(i));
                    } else {
                        if (i < sentences.size()) {
                            if (sentences.get(i) == "") {
                                sentences.add(sentencesOfPasword.get(3).get(i));
                            } else {
                                String h = sentences.get(i);
                                sentences.set(i, h + sentencesOfPasword.get(3).get(i));
                            }
                        } else {
                            sentences.add(sentencesOfPasword.get(3).get(i));
                        }
                    }
                }
            }
            return sentences;
        } catch (Exception ex) {
            throw new PasswordException("Excepcion Generando Sentencias  : " + ex.getMessage());
        }
    }

    /**
     * Esta funcion cambia la frase de tipo string a tipo lista.
     *
     * @param frase String que contiene las frases a convertir.
     */
    @Override
    public void SeparateNumber(String frase) {
        List<String> temp = new ArrayList<String>();
        temp.clear();
        for (int i = 0; i < frase.length(); i++) {
            temp.add(String.valueOf(frase.charAt(i)));
        }
        sentencesOfPasword.add(temp);
    }

    /**
     * Esta funcion cambia un conjunto de frases de tipo string a tipo lista.
     *
     * @param frase Lista de String que contiene las frases a convertir.
     */
    @Override
    public void SeparateNumber(List<String> frase) {
        for (String gr : frase) {
            List<String> temp = new ArrayList<String>();
            temp.clear();
            for (int i = 0; i < gr.length(); i++) {
                temp.add(String.valueOf(gr.charAt(i)));
            }
            sentencesOfPasword.add(temp);
        }
    }

    /**
     * Retorna una lista de lista de tipo Syting que contiene las sentencias de
     * la contraseña.
     *
     * @return sentencesOfPasword
     */
    @Override
    public List<List<String>> getListL() {
        return sentencesOfPasword;
    }

    /**
     * +
     * Limpia las sentencias de las contraseñas.
     */
    @Override
    public void clearSentences() {
        sentencesOfPasword.clear();
    }

    /**
     * Limpia la lista de las oraciones.
     */
    @Override
    public void clearSentence() {
        sentences.clear();
    }

    /**
     * Retoirna la lista de las horaciones.
     *
     * @return sentences
     */
    @Override
    public List<String> getSentence() {
        return sentences;
    }

    /**
     * FUncion para generar las frases finales q seran usadas para generar
     *
     * @param frase Lista de tipo String q contiene las frases que seran las
     * sentencias finales.
     * @return answer
     */
    @Override
    public List<String> getFinalFrase(List<String> frase) throws PasswordException {
        try {
            List<String> answer = new ArrayList<>(); //Porcederemos a separar las frases ammayores de las menores        
            for (int i = 0; i < frase.size(); i++) {
                String h = frase.get(i);
                if (h.length() < 3) {
                    sentecesMinors.add(h);
                } else {
                    sentecesGreather.add(h);
                }
            }//Se agregaran las frases pequeñas a las grandes.                
            int sg = 0;
            int sm = 0;
            while (sentecesGreather.size() > 0 && sentecesMinors.size() > 0) {
                sg = (int) (Math.random() * sentecesGreather.size());
                sm = (int) (Math.random() * sentecesMinors.size());//Aqui seleccionamos a ambos candidatos y procedemos a agregarlos
                String sgs = sentecesGreather.get(sg);
                String sms = sentecesMinors.get(sm);
                String n = sgs.concat(sms);
                answer.add(n);
                sentecesGreather.remove(sg);
                sentecesMinors.remove(sm);//Se revisa que en caso(mas seguro) de quedar frases en "sentecesMinors" se            
            }//genere una nueva apartir de lo que alli allá.
            String l = "";
            for (int i = 0; i < sentecesMinors.size(); i++) {
                String q = sentecesMinors.get(i);
                l = l.concat(q);
            }
            sentecesMinors.clear();
            if (l.length() > 3) {
                answer.add(l);
            } else {//BUscaremos la frase mas pequeña y le agegaremos losobrante, en el caso q este sea muy peuqño
                int y = 999;
                int indice = 0;
                for (int u = 0; u < answer.size(); u++) {
                    String t = answer.get(u);
                    if (t.length() < y) {
                        indice = u;
                        y = t.length();
                    }
                }//Ya habiendo obtenido el indice de la frase mas corta de las frases finales
                String j = answer.get(indice);
                j = j.concat(l);
                answer.set(indice, j);
                j = "";
            }
            l = "";
            return answer;
        } catch (Exception ex) {
            throw new PasswordException("Excepcion Generando Sentencias  : " + ex.getMessage());
        }
    }
}
