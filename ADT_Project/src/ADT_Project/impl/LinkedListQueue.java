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
 * @param <T>
 */
public class LinkedListQueue <T> implements Queue <T>{
    private Node <T> front, back;
    private int size;
    
    public LinkedListQueue(){
        back = null;
        front = null;
        size = 0;
    }
    
    @Override
    public void enqueue(T value) {
        if(size == 0){
            front = new Node(value);
            back = front;
        }
        else {
            back.setLink(new Node(value));
            back = back.getLink();
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0)throw new Exception("The sorted queue is empty!");
        T res = front.getValue();
        front = front.getLink();
        size--;
        if(size == 0){
            back = null;
        }
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        back = null;
        front = null;
        size = 0;
    }
    
    private String findStr(Node <T> nd){
        if(nd == null)return "";
        else return nd.toString() + " " + findStr(nd.getLink());
    }
    
    @Override
    public String toString(){
        return "front [ " + findStr(front) + " ] back";
    }
}
