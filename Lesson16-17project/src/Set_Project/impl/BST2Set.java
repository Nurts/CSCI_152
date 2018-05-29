package Set_Project.impl;

import Set_Project.adt.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class BST2Set<T extends Comparable> implements Set<T> {
    private OnOffTreeNode<T> root;
    private int size;
    
    public BST2Set(){
        root = null;
        size = 0;
    }
    
    @Override
    public void add(T value) {
        OnOffTreeNode<T> nd = new OnOffTreeNode(value);
        if(root == null)root = nd;
        else{
            OnOffTreeNode<T> res = nodeFinder(value, root);
            if(value.equals(res.getValue())){
                if(res.isActive())return;
                else res.switchOn();
            }
            else if(value.compareTo(res.getValue()) <= 0)res.setLeft(nd);
            else res.setRight(nd);
        }
        size++;
    }
    
    private OnOffTreeNode<T> nodeFinder(T value, OnOffTreeNode<T> cur){
        if(value.equals(cur.getValue()))return cur;
        else if(value.compareTo(cur.getValue()) <= 0){
            if(cur.getLeft() == null)return cur;
            else return nodeFinder(value, cur.getLeft());
        }
        else{
            if(cur.getRight() == null)return cur;
            else return nodeFinder(value, cur.getRight());
        }
    }
    
    @Override
    public boolean contains(T value) {
        return value.equals(nodeFinder(value, root).getValue());
    }
    
    @Override
    public boolean remove(T value) {
        OnOffTreeNode<T> x = root;
        while(x != null && !value.equals(x.getValue())){
            if(value.compareTo(x.getValue()) <= 0)x = x.getLeft();
            else x = x.getRight();
        }
        if(x == null || !x.isActive())return false;
        x.switchOff();
        size--;
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0)throw new Exception("The Set is Empty!");
        else return removeActive(root);
    }
    
    private T removeActive(OnOffTreeNode<T> x){
        if(x == null)return null;
        else{
            T t = removeActive(x.getLeft());
            if(t != null)return t;
            else if(x.isActive()) {
        	x.switchOff();
        	size--;
        	return x.getValue();
            }
            else return removeActive(x.getRight());
        }
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        return toStringHelper(root);
    }
    
    private String toStringHelper(OnOffTreeNode<T> nd){
        if(nd == null)return "";
        String s = toStringHelper(nd.getLeft());
        if(nd.isActive())s += nd.toString() + " ";
        s += toStringHelper(nd.getRight());
        return s;
    }

    
}
