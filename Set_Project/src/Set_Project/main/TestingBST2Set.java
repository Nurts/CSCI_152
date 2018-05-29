/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.Set;
import Set_Project.impl.BST2Set;

/**
 *
 * @author Nurtas
 */
public class TestingBST2Set {
    public static void main (String[] args){
        Set<Integer> bst = new BST2Set();
        bst.add(5);
        bst.add(12);
        bst.add(3);
        bst.add(6);
        bst.add(14);
        bst.add(2);
        bst.add(-6);
        bst.add(8);
        bst.add(0);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        bst.add(14);
        bst.add(-6);
        bst.add(5);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        System.out.println("Is Set Contains 12 : " + bst.contains(12));
        System.out.println("Is Set Contains 7 : " + bst.contains(7));
        System.out.println("Is Set Contains 2 : " + bst.contains(2));
        System.out.println("Is Set Contains -8 : " + bst.contains(-8));
        System.out.println("Is Set Contains 5 : " + bst.contains(5));
        
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        bst.remove(0);
        bst.remove(6);
        bst.remove(3);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        bst.add(6);
        bst.add(13);
        bst.add(99);
        bst.add(11);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        bst.remove(5);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        try {
            System.out.println("Removed: " + bst.removeAny());
            System.out.println("Removed: " + bst.removeAny());
            System.out.println("Removed: " + bst.removeAny());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        bst.clear();
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        bst.add(55);
        bst.add(24);
        bst.add(78);
        bst.add(51);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
    }
}
