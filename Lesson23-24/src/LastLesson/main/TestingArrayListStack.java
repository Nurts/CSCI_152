/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastLesson.main;

import LastLesson.adt.Stack;
import LastLesson.impl.ArrayListStack;

/**
 *
 * @author Nurtas
 */
public class TestingArrayListStack {
    public static void main(String[] args){
        Stack<Integer> stack = new ArrayListStack();
        try{
            stack.pop();
        }catch(Exception ex){
            System.out.println("Exception! " + ex.getMessage());
        }
        
        for(int i=0;i<12;i++){
            stack.push(i);
        }
        
        System.out.println(stack + "\nSize: " + stack.getSize());
        
        try{
            stack.pop();
            stack.pop();
            stack.pop();
        }catch(Exception ex){
            System.out.println("Exception! " + ex.getMessage());
        }
        
        System.out.println(stack + "\nSize: " + stack.getSize());
        
        stack.clear();
        
        System.out.println(stack + "\nSize: " + stack.getSize());
        
        for(int i=0;i<22;i++){
            stack.push(i);
        }
        
        System.out.println(stack + "\nSize: " + stack.getSize());
    }
}
