/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;
import java.util.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 *
 * @author Александр
 */
public class DictAdapter extends XmlAdapter<DictElement[],HashMap<String,HashSet<String>>> {

    @Override
    public HashMap<String, HashSet<String>> unmarshal(DictElement[] v) throws Exception {
        HashMap<String,HashSet<String>> hm=new HashMap<String,HashSet<String>>();
        for(DictElement de:v){//Цикл по всем эл-там массива
            HashSet<String> hs=new HashSet<String>();
            hs.addAll(Arrays.asList(de.Meanings)); //Добавить все значения
            hm.put(de.Word,hs);//Добавление в словарь
        }
        return hm;
    }

    @Override
    public DictElement[] marshal(HashMap<String, HashSet<String>> v) throws Exception {
        DictElement[] elements=new DictElement[v.size()];
        int i=0;
        for(String key:v.keySet()){
            
            HashSet<String> hs=v.get(key);
            String[] strArr=hs.toArray(new String[hs.size()]);
            DictElement dt=new DictElement(key,strArr);
            elements[i]=dt;
            i++;
        }
        return elements;
    }
    
}
