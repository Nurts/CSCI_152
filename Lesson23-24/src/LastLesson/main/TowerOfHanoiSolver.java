/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastLesson.main;

import LastLesson.impl.TowerOfHanoi;


/**
 *
 * @author Nurtas
 */
public class TowerOfHanoiSolver {
    public static void main(String[] str){
        int n = 4;
        TowerOfHanoi tower = new TowerOfHanoi(n);
        try {
            moveTower(tower, n, 0, 2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Number of Moves: " + tower.getNumMoves());//(2^n)-1
        System.out.println(tower);
        
    }
    public static void moveTower(TowerOfHanoi tower, int n, int from, int to) throws Exception{
        if(n == 1)tower.moveDisc(from, to);
        else{
            int temp = 3 - (from + to);
            moveTower(tower, n-1, from, temp);
            tower.moveDisc(from, to);
            moveTower(tower, n-1, temp, to);
            
        }
    }
    
}
