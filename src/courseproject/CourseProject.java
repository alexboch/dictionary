/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Александр
 */
public class CourseProject {

    final static String dictionaryFileName = "dictionary.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);//для ввода с консоли
        File f = new File(dictionaryFileName);
        Dictionary dict = new Dictionary();
        if (f.exists()) {//Если файл словаря существует, то загрузить словарь
            try {
                dict = XmlHelper.getInstance().LoadFromXml(f);
            } catch (JAXBException ex) {
                Logger.getLogger(CourseProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (true) {//Цикл пользовательского ввода
            System.out.println("1-add word, 2-search word, 3-save changes, 4-exit");
            try {
                int x = scan.nextInt();
                scan.nextLine();

                switch (x) {
                    case 1://добавление слова
                        System.out.print("Enter word:");
                        String newWord = scan.nextLine();
                        System.out.print("Enter word meanings, enter empty string to exit:");
                        ArrayList<String> meanings = new ArrayList<String>();
                        while (true) {
                            String meaning = scan.nextLine();
                            if (meaning.equals("")) {
                                break;
                            }
                            meanings.add(meaning);
                        }
                        dict.addWord(newWord, meanings);
                        break;
                    case 2://найти слово в словаре
                        System.out.println("Enter word:");
                        String word = scan.nextLine();
                        HashSet<String> ms = dict.getMeaning(word);
                        if (ms != null) {
                            System.out.println("Meanings:");
                            for (String m : ms) {
                                System.out.println(m);
                            }
                        } else {
                            System.out.println("Word not found in dictionary!");
                        }
                        break;
                    case 3: {
                        try {
                            //запись словаря в файл
                            XmlHelper.getInstance().WriteXml(dict, new FileOutputStream(dictionaryFileName));
                        } catch (JAXBException ex) {
                            Logger.getLogger(CourseProject.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(CourseProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }

                    case 4:
                        System.exit(0);
                }

            } catch (InputMismatchException exc) {
                System.out.println("Wrong input!");
                scan.nextLine();
            }
        }
    }
}
