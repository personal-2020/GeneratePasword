/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import java.util.List;

/**
 *
 * @author lanosce
 */
public interface OpeprateNumerate {
    
    
    public List<String> getSentenceOperateNumerate();
//    public void SeparateNumber(List<String> frase);
    public void SeparateNumber(String frase);
    public void SeparateNumber(List<String> frase);
    public List<List<String>> getListL();
    public void clearSentences();
    public void clearSentence();
    public List<String> getSentence();
    public List<String> getFinalFrase(List<String> frase);        
    
}
