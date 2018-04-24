/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;

/**
 *
 * @author Александр
 */
public class Distances {
    /*
    Вычисляет расстояние Левенштейна по алгоритму Вагнера-Фишера
    */
    public static double Levenshtein(String s1,String s2){
        final double insertionCost=1;
        final double deletionCost=1;
        final double mismatchCost=1;
        int n=s2.length();
        int m=s1.length();
        double[][] d=new double[m+1][n+1];
        d[0][0]=0;
        
        for(int j=1;j<=n;j++){
            d[0][j]=d[0][j-1]+insertionCost;
        }
        for(int i=1;i<=m;i++){
            d[i][0]=d[i-1][0]+deletionCost;
        }
        for (int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
                double min=d[i-1][j]+deletionCost;//Удаление
                double ins=d[i][j-1]+insertionCost;//Вставка
                if (ins<min) min=ins;
                double cost=(s1.charAt(i-1)==s2.charAt(j-1))?0:mismatchCost;//замена
                double matchDist=d[i-1][j-1]+cost;
                if(matchDist<min){
                    min=matchDist;
                }
                d[i][j]=min;
            }
        }
        return d[m][n];
    }
}
