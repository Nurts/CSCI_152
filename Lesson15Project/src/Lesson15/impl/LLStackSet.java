/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson15.impl;

import Lesson15.adt.Set;
import Lesson15.adt.Stack;
/**
 *
 * @author Nurtas
 * @param <T>
 */
public class LLStackSet <T> implements Set <T>{
    private Stack <T> stack;
    
    public LLStackSet(){
        stack = new LinkedListStack();
    }
    @Override
    public void add(T value) {
        if(!contains(value))stack.push(value);
    }
    /**
     * if value is in stack it puts it to the top
     * @param value
     * @return 
     */
    @Override
    public boolean contains(T value) {
        Stack<T> newst = new LinkedListStack();
        boolean ans = false;
        T dupl = null;
        while(stack.getSize()>0){
            T cur = null;
            try {
               cur = stack.pop();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
            if(value.equals(cur)){
                ans = true;
                dupl = cur;
            }
            else newst.push(cur);
        }
        if(ans)newst.push(dupl);
        stack = newst;
        return ans;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            try {
                stack.pop();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return true;
        }
        else return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(getSize() == 0)throw new Exception("The set is empty!");
        return stack.pop();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public void clear() {
        stack.clear();
    }
    
    @Override
    public String toString(){
        String res = stack.toString();
        return res.substring(7, res.length() - 4);
    }
}
