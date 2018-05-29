/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.impl;

import ADT_Project.adt.Queue;

/**
 *
 * @author Nurtas
 * @param <T> type
 */
public class ArrayQueue <T> implements Queue <T>{
    private T[] values;
    private int front,back,size;
    
    
    public ArrayQueue(){
        values = (T[]) new Object[10];
        front = 0;
        back = 0;
        size = 0;
    }
    
    @Override
    public void enqueue(T value) {
        values[back] = value;
        back++;
        back%=values.length;
        size++;
        
        
        if(back == front){
            T[] newval = (T[]) new Object[size*2];
            for(int i=front;i<size;i++){
                newval[i-front] = values[i];
            }
            System.arraycopy(values, 0, newval, size-front, back);
            values = newval;
            front = 0;
            back = size;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if(front == back){
            throw new Exception("The queue is empty!");
        }
        T res = values[front];
        values[front] = null;
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
        values =(T[]) new Object[10];
        front = 0;
        back = 0;
        size = 0;
    }
    
    @Override
    public String toString(){
        String res = "front[ ";
        for(int i=0;i<size;i++){
            if(i+front<values.length)res += values[i+front] + " ";
            else res += values[i+front-values.length] + " ";
        }
        res += " ] end";
        
        return res;
    }
}
