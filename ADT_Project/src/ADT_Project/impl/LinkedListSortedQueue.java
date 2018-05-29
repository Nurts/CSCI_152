/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.impl;

import ADT_Project.adt.SortedQueue;

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class LinkedListSortedQueue <T extends Comparable> implements SortedQueue <T> {
    private Node<T> front;
    private int size;
    
    public LinkedListSortedQueue(){
        front = null;
        size = 0;
    }
    
    private void findPlace(Node<T> nd, Node<T> cur){
        if(cur.getLink() == null){
            cur.setLink(nd);
        }
        else if(nd.getValue().compareTo(cur.getValue()) >= 0 &&
                nd.getValue().compareTo(cur.getLink().getValue()) <=0 ){
            
            nd.setLink(cur.getLink());
            cur.setLink(nd);
        }
        else findPlace(nd, cur.getLink());
    }
    
    @Override
    public void insert(T value) {
        Node<T> nd = new Node(value);
        if(size == 0)front = nd;
        else {
            if(value.compareTo(front.getValue()) <= 0){
                nd.setLink(front);
                front = nd;
            }
            else findPlace(nd,front);
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0)throw new Exception("The queue is empty!");
        T res = front.getValue();
        front = front.getLink();
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
        front = null;
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
