/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.SortedQueue;
import ADT_Project.impl.LinkedListSortedQueue;
import ADT_Project.impl.Student;

/**
 *
 * @author Nurtas
 */
public class TestingSortedQueue {
    public static void dequeueTimes(int val, SortedQueue srq){
        try{
           for(int i=0;i<val;i++){
               srq.dequeue();
           }
        }catch(Exception ex){
           System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String args[]){
        SortedQueue<Integer> srq = new LinkedListSortedQueue();
        for(int i=90;i>=10;i-=10){
            srq.insert(i);
        }
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        dequeueTimes(3,srq);
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        for(int i=100;i<=900;i+=100){
            srq.insert(i);
        }
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        dequeueTimes(4,srq);
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        for(int i=5;i<=915;i+=10){
            srq.insert(i);
        }
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        dequeueTimes(srq.getSize(),srq);
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        srq.insert(45);
        srq.insert(65);
        srq.insert(15);
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        srq.clear();
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        srq.insert(12);
        srq.insert(42);
        srq.insert(32);
        srq.insert(32);
        System.out.println(srq + "\nSize: " + srq.getSize());
        
        SortedQueue<Student> studQue = new LinkedListSortedQueue();
        
        System.out.println("\nTest with Student Class --------------------------------------");
        studQue.insert(new Student(12, "Nurtas"));
        studQue.insert(new Student(21, "Adam"));
        studQue.insert(new Student(13, "Ben"));
        System.out.println(studQue + "\nSize: " + studQue.getSize());
        dequeueTimes(1,studQue);
        System.out.println(studQue + "\nSize: " + studQue.getSize());
        
        
    }
    
    
}
