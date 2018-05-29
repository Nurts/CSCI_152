/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastLesson.impl;

import LastLesson.adt.Stack;
import java.util.ArrayList;


/**
 *
 * @author Nurtas
 * @param <T> type
 */
public class ArrayListStack<T> implements Stack<T>{
    private ArrayList<T> values;
    
    public ArrayListStack(){
        values = new ArrayList();
    }
    
    @Override
    public void push(T value) {
        values.add(value);
    }

    @Override
    public T pop() throws Exception {
        if(values.size() == 0)throw new Exception("The stack is empty!");
        return values.remove(values.size()-1);
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public String toString(){
        return "bottom" + values.toString() + "top";
    }
    
}
