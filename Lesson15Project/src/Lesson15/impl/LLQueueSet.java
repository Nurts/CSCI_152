/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson15.impl;

import Lesson15.adt.Queue;
import Lesson15.adt.Set;

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class LLQueueSet <T> implements Set <T>{
    private Queue <T> queue;
    
    public LLQueueSet(){
        queue = new LinkedListQueue();
    }
    
    @Override
    public void add(T value) {
        if(!contains(value))queue.enqueue(value);
    }

    @Override
    public boolean contains(T value) {
        for(int i=0;i<queue.getSize();i++){
            T cur = null;
            try{
                cur =  queue.dequeue();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            queue.enqueue(cur);
            if(value.equals(cur)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        for(int i=0;i<queue.getSize();i++){
            T cur = null;
            try{
                cur =  queue.dequeue();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            if(value.equals(cur))return true;
            queue.enqueue(cur);
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(queue.getSize() == 0)throw new Exception("The set is empty!");
        return queue.dequeue();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }
    
    @Override
    public String toString(){
        String res = queue.toString();
        return res.substring(5, res.length() - 5);
    }
    
}
