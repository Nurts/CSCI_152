/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Set;
import ADT_Project.impl.BSTSet;
import ADT_Project.impl.Student;

/**
 *
 * @author Nurtas
 */
public class TestingAddBSTSet {
    public static void main(String[] args){
        Set<Integer> bst = new BSTSet();
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
        
        bst.clear();
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        bst.add(55);
        bst.add(24);
        bst.add(78);
        bst.add(51);
        System.out.println("Set: " + bst + "\nSize: " + bst.getSize());
        
        Set <Student> studSet = new BSTSet();
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(200800001, "Dan"));
        studSet.add( new Student(200900001, "Wayne"));
        studSet.add( new Student(200900002, "Ben"));
        studSet.add( new Student(201100001, "Platzman"));
        studSet.add( new Student(200802011, "Andrew"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());   
        
        studSet.add( new Student(200800001, "Dan"));
        studSet.add( new Student(200900001, "Wayne"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(201902011, "Britanny"));
        studSet.add( new Student(200802009, "Dave"));
        studSet.add( new Student(201533275, "Dave"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.clear();
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(200800001, "Dan"));
        studSet.add( new Student(200900001, "Wayne"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
    }
}
