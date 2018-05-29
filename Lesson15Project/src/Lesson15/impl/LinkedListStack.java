/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson15.impl;

import Lesson15.adt.Stack;

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class LinkedListStack <T> implements Stack <T>{
    private Node<T> top;
    private int size;
    
    public LinkedListStack(){
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T value) {
        Node<T> nd = new Node(value);
        nd.setLink(top);
        top = nd;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if(size == 0)throw new Exception("The Stack is empty!");
        T res = top.getValue();
        top = top.getLink();
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    private String findStr(Node <T> nd){
        if(nd == null)return "";
        else return findStr(nd.getLink())+ " "+ nd.toString();
    }
    
    @Override
    public String toString(){
        return "bottom [" + findStr(top) + " ] top";
    }
    
}
