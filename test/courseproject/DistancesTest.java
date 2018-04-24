/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Александр
 */
public class DistancesTest {
    
    public DistancesTest() {
    }
    
   

    /**
     * Test of Levenshtein method, of class Distances.
     */
    @Test
    public void testLevenshtein() {
        System.out.println("Levenshtein");
        String s1 = "строка";
        String s2 = "стока";
        double expResult = 1.0;
        
        double result = Distances.Levenshtein(s1, s2);
        assertEquals(expResult, result,0.0);
        String[][] arr=new String[][]{{"собака","сока"},
            {"",""},
            {"слово","слово"},
            {"сока","собака"},
            {"сл","слово"}
            
        };
        double[] targetDistances=new double[]{2,0,0,2,3};
        for(int i=0;i<arr.length;i++){
            s1=arr[i][0];
            s2=arr[i][1];
            double d=Distances.Levenshtein(s1, s2);
            assertEquals(d,targetDistances[i],0.0);
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
