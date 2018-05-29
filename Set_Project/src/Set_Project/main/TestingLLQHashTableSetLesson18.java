/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.Set;
import Set_Project.impl.LLQHashTableSet;

/**
 *
 * @author Nurtas
 */
public class TestingLLQHashTableSetLesson18 {
    public static void main(String[] args){
        Set<Integer> set = new LLQHashTableSet(10);
        
        try{
            set.removeAny();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println(set + "\nSize: " + set.getSize());
        
        for(int i=1;i<=20;i++){
            set.add(i);
        }
        System.out.println(set + "\nSize: " + set.getSize());
        
        for(int i=2;i<=20;i+=2){
            set.remove(i);
        }
        System.out.println(set + "\nSize: " + set.getSize());
        
        System.out.println("Removing 10: " + set.remove(10));
        System.out.println("Removing 100: " + set.remove(100));
        System.out.println(set + "\nSize: " + set.getSize());
        
        for(int i=1;i<=30;i++){
            set.add(i);
        }
        System.out.println(set + "\nSize: " + set.getSize());
        
        try{
            System.out.print("Removed: ");
            for(int i=0;i<10;i++){
                System.out.print(set.removeAny() + " ");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("\n" + set + "\nSize: " + set.getSize());
        
        set.clear();
        
        System.out.println(set + "\nSize: " + set.getSize());
        
        for(int i=51;i<=79;i+=2){
            set.add(i);
        }
        System.out.println(set + "\nSize: " + set.getSize());
    }
}
