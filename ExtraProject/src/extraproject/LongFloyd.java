/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraproject;

import java.util.Scanner;

/**
 *
 * @author Nurtas
 */
public class LongFloyd {
     public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] a = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                a[i][j] = cin.nextInt();
            }
        }
        
        int first = cin.nextInt(), last = cin.nextInt();
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(a[i][j] + a[j][k] > a[i][j]){
                        a[i][j] = a[i][j] + a[j][k];
                    }
                }
            }
        }
        System.out.print(a[first][last]);
     }
        
}
