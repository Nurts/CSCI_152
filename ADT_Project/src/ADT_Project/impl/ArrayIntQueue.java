/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.impl;

import ADT_Project.adt.IntQueue;

/**
 *
 * @author Nurtas
 */
public class ArrayIntQueue implements IntQueue{
    private int[] values;
    private int front,back,size;
    
    
    public ArrayIntQueue(){
        values = new int[10];
        front = 0;
        back = 0;
        size = 0;
    }
    
    @Override
    public void enqueue(int value) {
        values[back] = value;
        back++;
        back%=values.length;
        size++;
        
        
        if(back == front){
            int[] newval = new int[size*2];
            for(int i=front;i<size;i++){
                newval[i-front] = values[i];
            }
            for(int i=0;i<back;i++){
                newval[size-front+i] = values[i];
            }
            values = newval;
            front = 0;
            back = size;
        }
    }

    @Override
    public int dequeue() throws Exception {
        if(front == back){
            throw new Exception("The queue is empty!");
        }
        int res = values[front];
        front++;
        front%=values.length;
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = 0;
        back = 0;
        size = 0;
    }
    
    @Override
    public String toString(){
        String res = "front[ ";
        for(int i=0;i<size;i++){
            if(i+front<values.length)res += values[i+front] + " ";
            else res += values[i-(values.length-front)] + " ";
        }
        res += " ] end";
        
        return res;
    }
}
