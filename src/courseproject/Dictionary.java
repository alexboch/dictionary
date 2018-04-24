/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.Collections;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.lang.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**
 *
 * @author Александр
 */
@XmlRootElement
public class Dictionary {
    
    private HashMap<String,HashSet<String>> _dict=new HashMap<String,HashSet<String>>();
    
     @XmlJavaTypeAdapter(DictAdapter.class)
    public HashMap<String,HashSet<String>> getDict(){
        return _dict;
    }
    
    @XmlElement
    public void setDict(HashMap<String,HashSet<String>> value){
        _dict=value;
    }
    
    public void addWord(String word,Collection<String> meanings){
        if(meanings.size()<1){
            throw new IllegalArgumentException("Word must have at least one meaning!");
        }
        _dict.put(word, new HashSet(meanings));
    }
    
    public HashSet<String> getMeaning(String word){
        if(_dict.containsKey(word)){
            return _dict.get(word);
        }
        return null;
    }
    
    public void addMeaning(String word, String meaning){
        if(!_dict.containsKey(word)){
            _dict.put(word, new HashSet<String>());
        }
        _dict.get(word).add(meaning);
    }

}
