/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastLesson.impl;

import LastLesson.adt.Stack;


/**
 *
 * @author Nurtas
 * @param <T> type
 */
public class ArrayStack <T> implements Stack <T>{
    private T[] values;
    private int size;
    
    public ArrayStack(){
        size = 0;
        values =(T[]) new Object[10];
    }
    
    @Override
    public void push(T value) {
        values[size] = value;
        size++;
        if(size == values.length){
            T[] newval =(T[]) new Object[size*2];
            System.arraycopy(values, 0, newval, 0, size);
            values = newval;
        }
    }

    @Override
    public T pop() throws Exception {
        if(size == 0)throw new Exception("The stack is empty!");
        T res =  values[size-1];
        values[size-1] = null;
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
        size = 0;
    }

    @Override
    public String toString(){
        String res = "bottom[ ";
        for(int i=0;i<size-1;i++){
            res += values[i] + ", ";
        }
        if(size > 0)res += values[size-1];
        res += " ] top";
        
        return res;
    }
    
}
