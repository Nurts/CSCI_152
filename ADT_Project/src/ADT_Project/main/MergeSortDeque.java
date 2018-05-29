/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Deque;
import ADT_Project.impl.LinkedListDeque;
import java.util.Random;

/**
 *
 * @author Nurtas
 */
public class MergeSortDeque {
    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
	Deque<Integer> ans = new LinkedListDeque();
        while(d1.getSize()>0 || d2.getSize()>0){
            if(d2.getSize() == 0)ans.pushToBack(d1.popFromFront());
            else if(d1.getSize() == 0)ans.pushToBack(d2.popFromFront());
            else{
                int f = d1.popFromFront(),s = d2.popFromFront();
                if(f < s){
                    ans.pushToBack(f);
                    d2.pushToFront(s);
                }
                else {
                    ans.pushToBack(s);
                    d1.pushToFront(f);
                }
            }
        }
        return ans;
    } 


    public static Deque<Integer> mergeSort(Deque<Integer> deq) throws Exception{
        if(deq.getSize()<2)return deq;
        
        Deque<Integer> part1 = new LinkedListDeque();
        while(deq.getSize() > part1.getSize()){
            part1.pushToBack(deq.popFromFront());
        }
        
        part1 = mergeSort(part1);
        deq = mergeSort(deq);
        
        return merge(part1,deq);
    }
    
    public static void main(String args[]){
        Deque<Integer> deq = new LinkedListDeque();
        Random rand = new Random();
        
        for(int i=0;i<20;i++){
            deq.pushToFront(rand.nextInt(50));
        }
        System.out.println(deq);
        try {
            deq = mergeSort(deq);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(deq);
        
    }
}