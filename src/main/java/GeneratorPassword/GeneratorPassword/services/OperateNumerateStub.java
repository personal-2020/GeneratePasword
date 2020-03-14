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
    public void SeparateNumber(String frase) {
        List<String> temp = new ArrayList<String>();
        temp.clear();
        for (int i = 0; i < frase.length(); i++) {
            temp.add(String.valueOf(frase.charAt(i)));
        }
        sentencesOfPasword.add(temp);
    }

    @Override
    public void SeparateNumber(List<String> frase) {
        for (String gr: frase ) {
            List<String> temp = new ArrayList<String>();
            temp.clear();            
            for (int i = 0; i < gr.length(); i++) {
                temp.add(String.valueOf(gr.charAt(i)));
            }
            sentencesOfPasword.add(temp);            
        }
    }
   @Override
    public List<List<String>> getListL() {
        return sentencesOfPasword;
    }
   @Override
    public void clearSentences() {
        sentencesOfPasword.clear();
    }
       @Override
    public void clearSentence() {
        sentences.clear();
    }
    public List<String> getSentence(){
        return sentences;
    }
    
}
