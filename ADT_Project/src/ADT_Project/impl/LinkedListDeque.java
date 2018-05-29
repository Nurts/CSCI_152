/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.impl;

import ADT_Project.adt.Deque;

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class LinkedListDeque <T> implements Deque <T>{
    
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    int size;
    
    public LinkedListDeque(){
        size = 0;
        front = null;
        back = null;
    }
    
    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode nd = new DoublyLinkedNode(value);
        nd.setNext(front);
        if(size > 0)front.setPrevious(nd);
        else back = nd;
        front = nd;
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode nd = new DoublyLinkedNode(value);
        nd.setPrevious(back);
        if(size > 0)back.setNext(nd);
        else front = nd;
        back = nd;
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        if(size == 0)throw new Exception("The deque is empty!");
        T res = front.getValue();
        front = front.getNext();
        if(front != null)front.setPrevious(null);
        else if(size == 1)back = null;
        size--;
        return res;
    }

    @Override
    public T popFromBack() throws Exception {
        if(size == 0)throw new Exception("The deque is empty!");
        T res = back.getValue();
        back = back.getPrevious();
        if(back != null)back.setNext(null);
        else if(size == 1)front = null;
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
    private String findStr(DoublyLinkedNode <T> nd){
        if(nd == null)return "";
        else return nd.toString() + " " + findStr(nd.getNext());
    }
    
    @Override
    public String toString(){
        return "front [ " + findStr(front) + "] back";
    }
}
