/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Deque;
import ADT_Project.impl.LinkedListDeque;

/**
 *
 * @author Nurtas
 */
public class TestingDeque {
    
    public static void popbackTimes(int val, Deque d){
        try{
            for(int i=0;i<val;i++){
                d.popFromBack();
                System.out.println(d + "\nSize: " + d.getSize());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void popfrontTimes(int val, Deque d){
        try{
            for(int i=0;i<val;i++){
                d.popFromFront();
                System.out.println(d + "\nSize: " + d.getSize());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String args[]){
        Deque<Integer> deque = new LinkedListDeque();
        
        popbackTimes(1,deque);
        popfrontTimes(1,deque);
        
        System.out.println(deque + "\nSize: " + deque.getSize());
        
        for(int i=0;i<5;i++){
            deque.pushToFront(i);
            System.out.println(deque + "\nSize: " + deque.getSize());
        }
        
        popfrontTimes(5,deque);
        
        for(int i=0;i<6;i++){
            deque.pushToFront(i);
            System.out.println(deque + "\nSize: " + deque.getSize());
        }
        
        popbackTimes(6,deque);
        
        for(int i=0;i<7;i++){
            deque.pushToBack(i);
            System.out.println(deque + "\nSize: " + deque.getSize());
        }
        
        popbackTimes(7,deque);
        
        for(int i=0;i<8;i++){
            deque.pushToBack(i);
            System.out.println(deque + "\nSize: " + deque.getSize());
        }
        
        popfrontTimes(8,deque);
        
        for(int i=0;i<10;i++){
            deque.pushToFront(i);
            deque.pushToBack(i);
            System.out.println(deque + "\nSize: " + deque.getSize());
        }
        
        for(int i=0;i<8;i++){
            try{
                deque.popFromBack();
                deque.popFromFront();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(deque + "\nSize: " + deque.getSize());
        }
        
        deque.clear();
        System.out.println(deque + "\nSize: " + deque.getSize());
        
        for(int i=0;i<3;i++){
            deque.pushToFront(i);
            deque.pushToFront(i);
            deque.pushToBack(i);
        }
        System.out.println(deque + "\nSize: " + deque.getSize());
    }
}
