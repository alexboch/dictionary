/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;

import java.io.*;
import java.util.*;

import javax.xml.bind.*;

/**
 *Синглтон с методами для записи и чтения словаря с помощью JAXB
 * @author Александр
 */
public class XmlHelper {

    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private static volatile XmlHelper instance;
    
    private XmlHelper() throws JAXBException {
        context = JAXBContext.newInstance(Dictionary.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        unmarshaller = context.createUnmarshaller();
    }

    public static XmlHelper getInstance() throws JAXBException {
        XmlHelper localInstance=instance;
        if(localInstance==null){
            synchronized(XmlHelper.class){
                localInstance=instance;
                if(localInstance==null){
                    instance=new XmlHelper();
                }
            }
        }
        return instance;
    }

    public void WriteXml(Dictionary obj, OutputStream os) throws JAXBException {
        marshaller.marshal(obj, os);
    }

    public Dictionary LoadFromXml(File f)throws JAXBException{
        return (Dictionary) unmarshaller.unmarshal(f);
    }
    
    public Dictionary LoadFromXml(InputStream is) throws JAXBException {
        return (Dictionary) unmarshaller.unmarshal(is);
    }
}
