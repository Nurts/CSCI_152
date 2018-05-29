/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson15.impl;

import Lesson15.adt.Set;

/**
 *
 * @author Nurtas
 */
public class TestingLLStackSet {
    public static void main(String[] args){
        Set <Student> studSet = new LLStackSet();
        
        try {
            studSet.removeAny();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(200800001, "Dan"));
        studSet.add( new Student(200900001, "Wayne"));
        studSet.add( new Student(200900002, "Ben"));
        studSet.add( new Student(201100001, "Platzman"));
        studSet.add( new Student(200802011, "Andrew"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.remove(new Student(200802011, "Andrew"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.remove(new Student(201533275, "Nurtas"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(200800001, "Dan"));
        studSet.add( new Student(200900001, "Wayne"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(201902011, "Britanny"));
        studSet.add( new Student(200802009, "Dave"));
        studSet.add( new Student(201533275, "Nurtas"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        try {
            System.out.println("Removed -- " + studSet.removeAny());
            System.out.println("Removed -- " + studSet.removeAny());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.clear();
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
        
        studSet.add( new Student(200800001, "Dan"));
        studSet.add( new Student(200900001, "Wayne"));
        
        System.out.println(studSet + "\nSize: " + studSet.getSize());
    }
}
