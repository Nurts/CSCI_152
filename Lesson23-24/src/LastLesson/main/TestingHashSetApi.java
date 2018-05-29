/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastLesson.main;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nurtas
 */
public class TestingHashSetApi {
    public static void main (String[] args){
        Set<Integer> bst = new HashSet();
        bst.add(5);
        bst.add(12);
        bst.add(3);
        bst.add(6);
        bst.add(14);
        bst.add(2);
        bst.add(-6);
        bst.add(8);
        bst.add(0);
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        bst.add(14);
        bst.add(-6);
        bst.add(5);
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        
        System.out.println("Is Set Contains 12 : " + bst.contains(12));
        System.out.println("Is Set Contains 7 : " + bst.contains(7));
        System.out.println("Is Set Contains 2 : " + bst.contains(2));
        System.out.println("Is Set Contains -8 : " + bst.contains(-8));
        System.out.println("Is Set Contains 5 : " + bst.contains(5));
        
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        
        bst.remove(0);
        bst.remove(6);
        bst.remove(3);
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        
        bst.add(6);
        bst.add(13);
        bst.add(99);
        bst.add(11);
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        
        bst.remove(5);
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        
        bst.clear();
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
        
        bst.add(55);
        bst.add(24);
        bst.add(78);
        bst.add(51);
        System.out.println("Set: " + bst + "\nSize: " + bst.size());
    }
}
