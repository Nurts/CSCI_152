/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Queue;
import ADT_Project.adt.Stack;
import ADT_Project.impl.LinkedListQueue;
import ADT_Project.impl.LinkedListStack;

/**
 *
 * @author Nurtas
 */
public class TestClass {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]){
//        Stack <Integer> stack = new LinkedListStack();
//        try{
//            stack.pop();
//        }catch(Exception ex){
//            System.out.println("Exception! " + ex.getMessage());
//        }
//        
//        for(int i=0;i<12;i++){
//            stack.push(i);
//        }
//        
//        System.out.println(stack + "\nSize: " + stack.getSize());
//        
//        try{
//            stack.pop();
//            stack.pop();
//            stack.pop();
//        }catch(Exception ex){
//            System.out.println("Exception! " + ex.getMessage());
//        }
//        
//        System.out.println(stack + "\nSize: " + stack.getSize());
//        
//        stack.clear();
//        
//        System.out.println(stack + "\nSize: " + stack.getSize());
//        
//        for(int i=0;i<22;i++){
//            stack.push(i);
//        }
//        
//        System.out.println(stack + "\nSize: " + stack.getSize());
//        
        
        //QUEUE
        Queue<Integer> queue = new LinkedListQueue();
        System.out.println("Queue Test -------------------------------------------------------");
        try{
            queue.dequeue();
        }catch(Exception ex){
            System.out.println("Exception! " + ex.getMessage());
        }
        
        for(int i=0;i<8;i++){
            queue.enqueue(i);
        }
        System.out.println(queue.toString() + "\nSize: " + queue.getSize());
        
        try{
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        }catch(Exception ex){
            System.out.println("Exception! " + ex.getMessage());
        }
        System.out.println(queue.toString() + "\nSize: " + queue.getSize());
        
        for(int i=0;i<9;i++){
            queue.enqueue(i);
            queue.enqueue(i);
            try{
                queue.dequeue();
                queue.dequeue();
            }catch(Exception ex){
                System.out.println("Exception! " + ex.getMessage());
            }
            System.out.println(queue.toString() + "\nSize: " + queue.getSize());
        }
        
        queue.clear();
        System.out.println(queue.toString() + "\nSize: " + queue.getSize());
        
        for(int i=0;i<22;i++){
            queue.enqueue(i);
        }
        System.out.println(queue.toString() + "\nSize: " + queue.getSize());
    }
    
}
