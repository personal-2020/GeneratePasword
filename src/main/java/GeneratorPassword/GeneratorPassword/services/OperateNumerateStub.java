/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author lanosce
 */
@Service
public class OperateNumerateStub implements OpeprateNumerate {

    private List<String> sentences = new ArrayList<String>();

    private List<List<String>> sentencesOfPasword = new ArrayList<List<String>>();

    List<String> temporal = new ArrayList<String>();

    @Override
    public List<String> getSentenceOperateNumerate() {
        int tam = 0;// Your code here!
        int max = 0;
        int min = 0;

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
    }

    @Override
    //public void SeparateNumber(List<String> frase) {
    public void SeparateNumber(String frase) {
        List<String>h=new ArrayList<String>();
//        List<String> temporal = new ArrayList<String>();
        System.out.println("que frase es: " + frase);
        String g = "";
//        for (String frList: frase ) {
        for (int i = 0; i < frase.length(); i++) {
            g = String.valueOf(frase.charAt(i));
            System.out.println("que arroja: " + g);
            temporal.add(g);
            System.out.println("que guarda temporal: " + g);
            System.out.println("como termina temporal : " + temporal);

        }
        h=temporal;
        sentencesOfPasword.add(h);
        System.out.println("como termina el arreglo final 1: " + sentencesOfPasword);
        temporal.clear();
        System.out.println("como termina el arreglo final 2: " + sentencesOfPasword);
//        }
    }

    public List<List<String>> getListL() {
        return sentencesOfPasword;
    }
    
    public void clearSentence(){
        sentencesOfPasword.clear();
    }
}
