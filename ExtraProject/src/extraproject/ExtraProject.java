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
public class ExtraProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] vert = new int[n];
        int[] hors = new int[n];
        
        for(int i=0;i<n;i++){
            hors[i] = cin.nextInt();
            vert[i] = cin.nextInt();
        }
        
        boolean[] used = new boolean[n];
        int ans = -1;
        for(int i=0;i<n;i++){
            if(!used[i]){
                dfs(vert,hors,used, i);
                ans++;
            }
        }
        
        System.out.println(ans);
    }

    private static void dfs(int[] vert, int[] hors, boolean[] used, int x) {
        used[x] = true;
        for(int i=0;i<vert.length;i++){
            if( (vert[i] == vert[x] || hors[i] == hors[x]) && !used[i]){
               dfs(vert,hors,used,i);
            }
        }
    }
    
}
