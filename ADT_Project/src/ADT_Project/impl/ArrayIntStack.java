/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.impl;

import ADT_Project.adt.IntStack;

/**
 *
 * @author Nurtas
 */
public class ArrayIntStack implements IntStack{
    private int[] values;
    private int size;
    
    public ArrayIntStack(){
        size = 0;
        values = new int[10];
    }
    
    @Override
    public void push(int value) {
        values[size] = value;
        size++;
        if(size == values.length){
            int[] newval = new int[size*2];
            System.arraycopy(values, 0, newval, 0, size);
            values = newval;
        }
    }

    @Override
    public int pop() throws Exception {
        if(size == 0)throw new Exception("The stack is empty!");
        int res =  values[size-1];
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
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
