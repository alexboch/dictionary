/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;

import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author Александр
 */
public class DictElement {
    @XmlElement
    public String Word;
    @XmlElement
    public String[] Meanings;
    private DictElement(){}
    
    public DictElement(String word,String[] meanings){
        Word=word;
        Meanings=meanings;
    }
}
