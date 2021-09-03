/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generatorpassword.Generatorpassword.services;

import java.util.List;

/**
 *
 * @author lanosce
 */
public interface OpeprateNumerate {
    
    
    public List<String> getSentenceOperateNumerate() throws PasswordException;
//    public void SeparateNumber(List<String> frase);
    public void SeparateNumber(String frase) throws PasswordException;
    public void SeparateNumber(List<String> frase) throws PasswordException;
    public List<List<String>> getListL() throws PasswordException;
    public void clearSentences() throws PasswordException;
    public void clearSentence() throws PasswordException;
    public List<String> getSentence() throws PasswordException;
    public List<String> getFinalFrase(List<String> frase) throws PasswordException;       
    
}
